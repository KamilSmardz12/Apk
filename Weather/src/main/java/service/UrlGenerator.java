package service;

import model.Location;

public class UrlGenerator {
    private static final String APP_ID = "5fa7571c03889c663963c41593c4124d";

    public static String generate(Location location) {
        return "http://api.openweathermap.org/data/2.5/weather?q="
                + location.getCity() + ","
                + location.getCountry()
                + "&units=" + location.getUNIT()
                + "&mode=xml&APPID=" + APP_ID;
    }
}
