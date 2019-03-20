package product;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductDatabaseTest {

    private static ProductDatabase productDatabase;

    @BeforeClass
    public static void setup(){
        productDatabase = new ProductDatabase();
    }

    @Test
    public void addProductTest() {
        productDatabase.addProduct(new Product("a", 100000L, 15));
        Assert.assertEquals("Failed to add a product!", 1, productDatabase.getSize());
    }


}