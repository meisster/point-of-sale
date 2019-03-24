import product.Product;
import product.ProductDatabase;
import scanner.BarCodeScanner;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ProductDatabase.getINSTANCE().initializeDatabase();
        Menu.start();
    }
}
