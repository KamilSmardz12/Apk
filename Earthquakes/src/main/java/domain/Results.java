package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Results {
    private Double latitude;
    private Double longitude;
    private Double distance;
    @Setter
    private String place;
}
