package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UnitsCalculator {
    public static BigDecimal convertMinutesToFraction(BigDecimal value) {
        BigDecimal fractionalPart = value.remainder(BigDecimal.ONE);
        BigDecimal whole = value.subtract(fractionalPart);
        BigDecimal convertedFractionalPart = fractionalPart
                .divide(BigDecimal.valueOf(6), 7, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(10));

        return whole.add(convertedFractionalPart);
    }

    public static double degreesToRadians(BigDecimal value) {
        return value.multiply(BigDecimal.valueOf(Math.PI)).divide(BigDecimal.valueOf(180), 10, RoundingMode.HALF_UP).doubleValue();
    }

    public static double radiansToDegrees(BigDecimal value) {
        return 1 / degreesToRadians(value);
    }
}
