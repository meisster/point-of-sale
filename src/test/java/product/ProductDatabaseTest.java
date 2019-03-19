package product;


import org.junit.Assert;
import org.junit.Test;

public class ProductDatabaseTest {

    @Test
    public void addProductTest() {
        ProductDatabase productDatabase = new ProductDatabase();
        productDatabase.addProduct(new Product("a", 100000L, 15));
        Assert.assertEquals(1, productDatabase.getSize());
    }

}