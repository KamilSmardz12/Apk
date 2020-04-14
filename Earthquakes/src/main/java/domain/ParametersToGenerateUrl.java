package domain;

import calculator.DateCalculator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Builder
@ToString
public class ParametersToGenerateUrl {
    @Setter
    private String methodToDownloadData;
    @Setter
    @Builder.Default()
    private String format = ApiDataFormat.CSV.getValue();
    private BigDecimal latitude;
    private BigDecimal longitude;
    @Setter
    private BigDecimal maxradius;
    @Builder.Default()
    private String startTime = DateCalculator.getMonthBefore();
    @Builder.Default()
    private String endTime = DateCalculator.getTodayDate();
}