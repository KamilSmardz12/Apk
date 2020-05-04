import model.Location;
import service.WeatherData;
import service.WeatherService;
import service.WeatherServiceFacatory;

public class Main {

    public static void main(String[] args) {

        WeatherService service = WeatherServiceFacatory.getWeatherDataService();
        WeatherData data;
        try
        {
            data = service.getWeatherData(new Location("Kraków", "PL"));
            System.out.println("Temperatura w Krakowie: " + data.getTemperature().getValue());


            System.out.println("--------------------------------");
            data = service.getWeatherData(new Location("Rzeszów", "PL"));
            System.out.println("Temperatura w Rzeszowie: " + data.getTemperature().getValue());

            System.out.println("--------------------------------");
            data = service.getWeatherData(new Location("Sandomierz", "PL"));
            System.out.println("Temperatura w Sandomierzu: " + data.getTemperature().getValue());

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}