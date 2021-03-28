package pv260.solid.dip.original;

import java.io.IOException;
import java.net.URL;

public interface WeatherForecast {
    public double findTomorrowsAverageTemperature() throws IOException;

    public double findTomorrowsTemperatureAroundLunch() throws IOException;

}