import product.Product;
import product.ProductDatabase;
import scanner.BarCodeScanner;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Product makaron = new Product("Makaron", IdGenerator.nextID(), 15);
        Product lasagne = new Product("Lasagne", IdGenerator.nextID(), 10);
        ProductDatabase.getINSTANCE().addProduct(makaron, lasagne);
        BarCodeScanner.getInstance().scanProduct(makaron.getID());
        BarCodeScanner.getInstance().scanProduct(lasagne.getID());
        BarCodeScanner.getInstance().scanProduct(makaron.getID());
        BarCodeScanner.getInstance().getReceipt();
    }
}
