package scanner;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class BarCodeScannerParameterizedTest {

    @BeforeClass


    @Parameterized.Parameters
    public static Collection<Object[]> testScan(){
        return Arrays.asList(new Object[][]{
                {0L, -1},
                {1234L, 0},

        });
    }

    @Test
    public void scanProduct() {

    }

    @Test
    public void getTotalSum() {
    }
}
