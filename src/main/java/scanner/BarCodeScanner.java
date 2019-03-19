package scanner;

import output.LCDDisplay;
import output.Printer;
import product.Product;
import product.ProductDatabase;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class BarCodeScanner {

    private static BarCodeScanner INSTANCE = null;
    private Map<Product, BigDecimal> receipt = new HashMap<>();

    public static BarCodeScanner getInstance() {
        if (INSTANCE == null)
            INSTANCE = new BarCodeScanner();
        return INSTANCE;
    }

    public void scanProduct(Long productID) {
        if (productID != 0) {
            Optional<Product> scannedProduct = ProductDatabase.getINSTANCE().getProduct(productID);
            if (scannedProduct.isPresent()) {
                receipt.computeIfPresent(scannedProduct.get(), (k, v) -> v.add(BigDecimal.ONE));
                receipt.putIfAbsent(scannedProduct.get(), BigDecimal.ONE);
                LCDDisplay.getInstance().print(scannedProduct.get().getName()
                                                       + " added with price: "
                                                       + scannedProduct.get().getPrice()
                                                       + "$");
            } else {
                LCDDisplay.getInstance().print("Product not found");
            }
        } else {
            LCDDisplay.getInstance().print("Invalid bar-code");
        }
    }

    public void getReceipt() {
        Printer.getInstance().print("*******************");
        Printer.getInstance().print("******RECEIPT******");
        receipt.forEach((k, v) -> Printer.getInstance().print(k.getName() + " X " + v.intValue()));
        int totalSum =
                receipt.entrySet().stream()
                       .mapToInt(e -> e.getValue().intValue()*e.getKey().getPrice().intValue())
                       .sum();
        Printer.getInstance().print("TOTAL SUM: " + totalSum + "$");
        Printer.getInstance().print("******RECEIPT******");
        Printer.getInstance().print("*******************");
        LCDDisplay.getInstance().print("TOTAL SUM: " + totalSum + "$");
        receipt = new HashMap<>();
    }
}
