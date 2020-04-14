package calculator;


import domain.EarthquakeParameters;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static calculator.UnitsCalculator.degreesToRadians;


public class RadiusCalculator {
    public static BigDecimal calculateRadius(EarthquakeParameters yourPlace, EarthquakeParameters remotePlace) {
        BigDecimal yourPlaceLatitude = yourPlace.getLatitude();
        BigDecimal yourPlaceLongitude = yourPlace.getLongitude();
        BigDecimal distantPlaceLongitude = remotePlace.getLatitude();
        BigDecimal distantPlaceLatitude = remotePlace.getLongitude();

        return BigDecimal.valueOf(Math.toDegrees(
                Math.acos(
                        Math.sin(degreesToRadians(yourPlaceLatitude)) * Math.sin(degreesToRadians(distantPlaceLatitude))
                                + Math.cos(degreesToRadians(yourPlaceLatitude)) * Math.cos(degreesToRadians(distantPlaceLatitude))
                                * Math.cos(degreesToRadians(distantPlaceLongitude.subtract(yourPlaceLongitude))))) * 111.1)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
