package servlets;

import Model.Location;
import Service.WeatherData;
import Service.WeatherServiceFacatory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/DisplayWeather")
public class DisplayWeather extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String city = request.getParameter("city");
        String country = request.getParameter("country");

        IWeatherService service = WeatherServiceFacatory.getWeatherDataService("OPEN");
        WeatherData data = service.getWeatherData(new Location(city, country));

        String humidity = data.getHumidity().getValue() + data.getHumidity().getUnit();
        String pressure = data.getPressure().getValue() + data.getPressure().getUnit();
        String temperature = data.getTemperature().getValue() + "°C";
        String lastUpdate = data.getLastUpdate().getValue();

        request.setAttribute("city", city);
        request.setAttribute("country", country);
        request.setAttribute("humidity", humidity);
        request.setAttribute("pressure", pressure);
        request.setAttribute("temperature", temperature);
        request.setAttribute("lastUpdate", lastUpdate);

        RequestDispatcher dispatcher = request.getRequestDispatcher("wd.jsp");
        dispatcher.forward(request, response);
    }
}

