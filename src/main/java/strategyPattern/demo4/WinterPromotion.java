package strategyPattern.demo4;

import java.math.BigDecimal;

public class WinterPromotion implements SaleStrategy {
    @Override
    public void printStrategy() {
        System.out.println("20% discount");
    }

    @Override
    public BigDecimal calculatePrice(BigDecimal price) {
        return price.multiply(BigDecimal.valueOf(0.2));
    }
}
