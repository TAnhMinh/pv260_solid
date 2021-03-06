package pv260.solid.ocp.original;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import static org.jdom2.output.Format.getPrettyFormat;
import org.jdom2.output.XMLOutputter;

public class Persistence {

    private PersistenceType type;

    private Path file;

    /**
     * @param type how the records will be stored
     * @param file if this is the file records will be persisted to
     */
    public Persistence(PersistenceType type,
                       Path file) {
        this.type = type;
        this.file = file;
    }

    public void persist(Comment comment) {
        switch (type) {
            case CSV :
                persistCsv(comment);
                break;
            case XML :
                persistXml(comment);
                break;
            default :
                throw new IllegalStateException("Unsupported persistence method: " + comment);
        }
    }

    private void persistCsv(Comment comment) {
        try (BufferedWriter writer = Files.newBufferedWriter(file,
                                                             UTF_8,
                                                             CREATE,
                                                             APPEND,
                                                             WRITE)) {
            writer.append(formatCsv(comment));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String formatCsv(Comment comment) {
        return comment.getAuthor() + ", " + comment.getEntered() + ", " + comment.getHeadline() + ", "
                + comment.getText() + System.lineSeparator();
    }

    private void persistXml(Comment comment) {
        try {
            if (!Files.exists(file)) {
                prepareEmptyXml();
            }
            Document doc = new SAXBuilder().build(file.toFile());
            appendComment(comment,
                          doc);
            writeXml(doc);
        } catch (IOException | JDOMException e) {
            throw new RuntimeException(e);
        }
    }

    private void prepareEmptyXml() throws IOException {
        Document doc = new Document(new Element("comments"));
        XMLOutputter xmlOut = new XMLOutputter();
        try (Writer w = Files.newBufferedWriter(file)) {
            xmlOut.output(doc,
                          w);
        }
    }

    private void appendComment(Comment commentData,
                               Document doc) {
        Element commentElement = new Element("comment");
        commentElement.addContent(new Element("author").setText(commentData.getAuthor()));
        commentElement.addContent(new Element("entered").setText(String.valueOf(commentData.getEntered()
                                                                                           .getTime())));
        commentElement.addContent(new Element("headline").setText(commentData.getHeadline()));
        commentElement.addContent(new Element("text").setText(commentData.getText()));
        doc.getRootElement()
           .addContent(commentElement);
    }

    private void writeXml(Document doc) throws IOException {
        XMLOutputter xmlOut = new XMLOutputter();
        xmlOut.setFormat(getPrettyFormat());
        try (Writer w = Files.newBufferedWriter(file)) {
            xmlOut.output(doc,
                          w);
        }
    }

}
