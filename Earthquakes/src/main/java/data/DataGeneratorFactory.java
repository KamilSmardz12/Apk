package data;

import domain.EarthquakeParameters;
import domain.ParametersToGenerateUrl;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class DataGeneratorFactory {

    public List<EarthquakeParameters> generate(ParametersToGenerateUrl parameters) {
        return new DataGenerator(parameters).generateData();
    }
}
