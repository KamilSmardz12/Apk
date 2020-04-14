package data;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class UserData {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal maxRadius;
    private String startTime;
    private String endTime;
}
