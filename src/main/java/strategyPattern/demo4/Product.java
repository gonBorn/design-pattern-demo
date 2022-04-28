package strategyPattern.demo4;

import java.math.BigDecimal;

public class Product {
    private BigDecimal price;

    private SaleStrategy saleStrategy;

    public Product(SaleStrategy saleStrategy) {
        this.saleStrategy = saleStrategy;
    }

    public void setSaleStrategy(SaleStrategy saleStrategy) {
        this.saleStrategy = saleStrategy;
    }

    public BigDecimal salePrice() {
        return saleStrategy.calculatePrice(price);
    }
}
