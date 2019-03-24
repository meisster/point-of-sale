package product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ProductMakerParameterizedTest {

    private String name;

    private long ID;

    private BigDecimal price;

    public ProductMakerParameterizedTest(String name, long ID, BigDecimal price) {
        this.name = name;
        this.ID = ID;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"asd", 123L, null},
                {"asd", 0L, BigDecimal.ONE},
                {null, 123L, BigDecimal.ONE}
        });
    }

    @Test
    public void getProductNullTest(){
        ProductMaker productMaker = new ProductMaker();
        productMaker.buildProductPrice(price);
        productMaker.buildProductID(ID);
        productMaker.buildProductName(name);
        assertNull(productMaker.getProduct());
    }

}