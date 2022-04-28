package strategyPattern.demo4;

import java.math.BigDecimal;

public interface SaleStrategy {
    void printStrategy();

    BigDecimal calculatePrice(BigDecimal price);
}
