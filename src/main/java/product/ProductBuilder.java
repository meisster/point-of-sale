package product;

import java.math.BigDecimal;

public interface ProductBuilder {

    void buildProductName(String name);

    void buildProductPrice(BigDecimal price);

    void buildProductID(Long ID);

    Product getProduct();
}
