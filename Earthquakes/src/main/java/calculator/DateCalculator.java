package calculator;

import java.time.LocalDate;

public class DateCalculator {
    private static LocalDate now = LocalDate.now();

    public static String getTodayDate() {
        return now.toString();
    }

    public static String getMonthBefore() {
        return now.minusMonths(1).toString();
    }

}
