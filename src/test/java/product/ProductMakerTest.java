package product;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductMakerTest {

    @Test
    public void getProduct() {
        ProductMaker productMaker = new ProductMaker();
        productMaker.buildProductPrice(BigDecimal.ONE);
        productMaker.buildProductID(123L);
        productMaker.buildProductName("asd");
        assertNotNull(productMaker.getProduct());
    }
}