package data;

import controller.BufferReaderCreator;
import domain.ApiMethod;
import domain.ParametersToGenerateUrl;
import lombok.Getter;

import java.io.BufferedReader;
import java.math.BigDecimal;

public class UrlGenerator {

    @Getter
    private String generatedUrl;

    public UrlGenerator(ParametersToGenerateUrl parameters) {
        calculateRadiusToGetEnourhtEarthquakes(parameters);
        generatedUrl = generateURL(parameters);
    }

    private ParametersToGenerateUrl calculateRadiusToGetEnourhtEarthquakes(ParametersToGenerateUrl parameters) {
        parameters.setMethodToDownloadData(ApiMethod.COUNT.getValue());
        String url = generateURL(parameters);
        String inputLine;
        BigDecimal valueToIncreaseRadius= BigDecimal.valueOf(100);
        try {
            BufferedReader bufferedReader = new BufferReaderCreator().createBufferReader(url);
            while ((inputLine = bufferedReader.readLine()) != null) {
                if (Integer.parseInt(inputLine) < 10) {
                    parameters.setMaxradius(parameters.getMaxradius().add(valueToIncreaseRadius));
                    valueToIncreaseRadius =valueToIncreaseRadius.multiply(BigDecimal.valueOf(2));
                    url = generateURL(parameters);
                    bufferedReader = new BufferReaderCreator().createBufferReader(url);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        parameters.setMethodToDownloadData(ApiMethod.QUERY.getValue());
        return parameters;
    }

    private String generateURL(ParametersToGenerateUrl parameters) {
        return "https://earthquake.usgs.gov/fdsnws/event/1/"
                + parameters.getMethodToDownloadData()
                + "?format=" + parameters.getFormat()
                + "&latitude=" + parameters.getLatitude()
                + "&longitude=" + parameters.getLongitude()
                + "&maxradiuskm=" + parameters.getMaxradius()
                + "&starttime=" + parameters.getStartTime()
                + "&endtime=" + parameters.getEndTime();
    }
}
