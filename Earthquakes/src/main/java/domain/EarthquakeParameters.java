package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class EarthquakeParameters {
    private LocalDateTime time;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal depth;
    private BigDecimal mag;
    private LocalDateTime update;
    private String place;
}
