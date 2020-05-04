package servlets;

import model.Location;
import service.WeatherData;
import service.WeatherService;
import service.WeatherServiceFacatory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static service.Constants.*;

@WebServlet(urlPatterns = "/DisplayWeather")
public class DisplayWeather extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WeatherService service = WeatherServiceFacatory.getWeatherDataService();
        WeatherData data = service.getWeatherData(
                new Location(
                        request.getParameter(CITY.getValue()),
                        request.getParameter(COUNTRY.getValue())
                )
        );

        setAtrubutes(request, data);

        RequestDispatcher dispatcher = request.getRequestDispatcher("wd.jsp");
        dispatcher.forward(request, response);
    }

    private void setAtrubutes(HttpServletRequest request, WeatherData data) {
        String city = request.getParameter(CITY.getValue());
        String country = request.getParameter(COUNTRY.getValue());
        String humidity = data.getHumidity().getValue() + data.getHumidity().getUnit();
        String pressure = data.getPressure().getValue() + data.getPressure().getUnit();
        String temperature = data.getTemperature().getValue() + "°C";
        String lastUpdate = data.getLastUpdate().getValue();

        request.setAttribute(CITY.getValue(), city);
        request.setAttribute(COUNTRY.getValue(), country);
        request.setAttribute(HUMIDITY.getValue(), humidity);
        request.setAttribute(PRESSURE.getValue(), pressure);
        request.setAttribute(TEMPERATURE.getValue(), temperature);
        request.setAttribute(LAST_UPDATE.getValue(), lastUpdate);
    }
}

