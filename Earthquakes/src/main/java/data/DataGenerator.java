package data;


import controller.BufferReaderCreator;
import domain.EarthquakeParameters;
import domain.ParametersToGenerateUrl;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    private static final String DELIMITER = ",";
    List<EarthquakeParameters> earthquakeParameters;
    private ParametersToGenerateUrl parameters;
    private String generatedUrl;

    public DataGenerator(ParametersToGenerateUrl parameters) {
        this.parameters = parameters;
        generatedUrl = new UrlGenerator(parameters)
                .getGeneratedUrl();
    }

    public List<EarthquakeParameters> generateData() {
        String inputLine;
        try (BufferedReader bufferedReader = new BufferReaderCreator().createBufferReader(generatedUrl)) {
            earthquakeParameters = new ArrayList<>();
            while ((inputLine = bufferedReader.readLine()) != null) {
                String[] splitedData = inputLine.split(DELIMITER);
                if (isNotCorrectData(splitedData))
                    continue;
                earthquakeParameters.add(EarthquakeParameters.builder()
                        .time(LocalDateTime.ofInstant(Instant.parse(splitedData[0]), ZoneOffset.UTC))
                        .latitude(new BigDecimal(splitedData[1]))
                        .longitude(new BigDecimal(splitedData[2]))
                        .depth(new BigDecimal(splitedData[3]))
                        .mag(new BigDecimal(splitedData[4]))
                        .update(LocalDateTime.ofInstant(Instant.parse(splitedData[12]), ZoneOffset.UTC))
                        .place(splitedData[13])
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return earthquakeParameters;
    }

    private boolean isNotCorrectData(String[] splitedData) {
        return splitedData[0].equals("time");
    }
}
