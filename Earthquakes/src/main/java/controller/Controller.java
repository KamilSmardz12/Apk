package controller;


import data.DataGeneratorFactory;
import domain.EarthquakeParameters;
import domain.ParametersToGenerateUrl;
import domain.Results;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static calculator.RadiusCalculator.calculateRadius;
import static calculator.UnitsCalculator.convertMinutesToFraction;


public class Controller {

    public List<Results> start(BigDecimal latitude, BigDecimal longitude) {
//        BigDecimal latitude = BigDecimal.valueOf(-73.935242);
//        BigDecimal longitude = BigDecimal.valueOf(40.730610);
        BigDecimal maxRadius = BigDecimal.valueOf(500);

        List<EarthquakeParameters> parameters = new DataGeneratorFactory()
                .generate(ParametersToGenerateUrl.builder()
//                        .format(ApiDataFormat.CSV.getValue())
//                        .starttime(DateCalculator.getMonthBefore())
//                        .endtime(DateCalculator.getTodayDate())
                        .latitude(latitude)
                        .longitude(longitude)
                        .maxradius(maxRadius)
                        .build());

        EarthquakeParameters mainPlace = EarthquakeParameters.builder()
                .longitude(convertMinutesToFraction(longitude))
                .latitude(convertMinutesToFraction(latitude))
                .build();

        return createResults(parameters, mainPlace);
    }

    private List<Results> createResults(List<EarthquakeParameters> parameters, EarthquakeParameters mainPlace) {
        List<Results> results = new ArrayList<>();
        parameters.forEach(p -> {
            results.add(Results.builder()
                    .latitude(p.getLatitude().doubleValue())
                    .longitude(p.getLongitude().doubleValue())
                    .distance(calculateRadius(mainPlace, p).doubleValue())
                    .build());
        });
        List<Results> resultPlaces = sort(results);
        setNumberPlaces(resultPlaces);
        return resultPlaces;
    }

    private List<Results> sort(List<Results> results) {
        return results.stream()
                .sorted(Comparator.comparing(Results::getDistance))
                .collect(Collectors.toList());
    }

    private void setNumberPlaces(List<Results> places) {
        int number = 0;
        for (Results place : places)
            place.setPlace("Point number " + ++number);
    }
}
