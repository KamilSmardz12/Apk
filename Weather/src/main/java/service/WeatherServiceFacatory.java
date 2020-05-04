package service;

public class WeatherServiceFacatory {
    public static WeatherService getWeatherDataService() {
        return new WeatherService();
    }
}
