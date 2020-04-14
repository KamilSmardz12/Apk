
import controller.Controller;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
                BigDecimal latitude = BigDecimal.valueOf(-73.935242);
        BigDecimal longitude = BigDecimal.valueOf(40.730610);
        System.out.println(controller.start(latitude, longitude));
    }
}