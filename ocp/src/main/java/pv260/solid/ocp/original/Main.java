package pv260.solid.ocp.original;

import java.nio.file.Paths;
import java.util.Date;
import static pv260.solid.ocp.original.PersistenceType.CSV;
import static pv260.solid.ocp.original.PersistenceType.XML;

public class Main {

    public static void main(String[] args) {
        Comment comment = new Comment("My comment",
                                      "This is interesting...",
                                      new Date(),
                                      "Pepa Zdepa");
        new Persistence(XML, Paths.get("/home/minh/Documents/muni/X.semestr/PV260/seminar2/comments.xml")).persist(comment);
        new Persistence(CSV, Paths.get("/home/minh/Documents/muni/X.semestr/PV260/seminar2/comments.csv")).persist(comment);
    }
}
