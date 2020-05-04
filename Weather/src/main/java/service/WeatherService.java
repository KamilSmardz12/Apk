package service;

import model.Location;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService   {

    private WeatherData weatherData = new WeatherData();

    public WeatherData getWeatherData(Location location) {
        try {
            URL url = new URL(UrlGenerator.generate(location));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.connect();
            InputStream in = connection.getInputStream();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(in);

            weatherData.setAllWeatherDataByTagNames(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherData;
    }
}
