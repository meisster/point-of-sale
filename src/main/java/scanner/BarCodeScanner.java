package scanner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BarCodeScanner {

    private Map<Long, BigDecimal> receipt = new HashMap<>();

    public static BarCodeScanner INSTANCE = null;

    public static BarCodeScanner getInstance(){
        if(INSTANCE == null)
            return new BarCodeScanner();
        return INSTANCE;
    }

    public void ScanProduct(Long productID){

    }
}
