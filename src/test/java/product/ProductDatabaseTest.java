package product;


import org.junit.Assert;
import org.junit.Test;

public class ProductDatabaseTest {

    @Test
    public void addProductTest() {
        ProductDatabase productDatabase = new ProductDatabase();
        productDatabase.addProduct(new Product(1000000L));
        Assert.assertEquals(1, productDatabase.getSize());
    }

}