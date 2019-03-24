package scanner;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import product.ProductDatabase;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BarCodeScannerParameterizedTest {

    private long ID;

    private long status;

    public BarCodeScannerParameterizedTest(long ID, long status) {
        this.ID = ID;
        this.status = status;
    }

    @BeforeClass
    public static void setup() {
        ProductDatabase.getINSTANCE().initializeDatabase();
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10000L, -1},
                {725558L, 1},
                {123456L, 0}
        });
    }

    @Test
    public void scanProduct() {
        Assert.assertEquals(BarCodeScanner.getInstance().scanProduct(ID), status);
    }

}
