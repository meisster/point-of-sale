package product;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductDatabaseTest {


    @Test
    public void initializeDatabaseText() {
        ProductDatabase.getINSTANCE().initializeDatabase();
        Assert.assertEquals(1000, ProductDatabase.getINSTANCE().getProductList().size());
    }

    @Test
    public void getRandomProductTest() {
        Assert.assertNotNull("Null object!", ProductDatabase.getINSTANCE().getRandomProduct());
    }
}