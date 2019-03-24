package scanner;

import output.LCDDisplay;
import output.Printer;
import product.Product;
import product.ProductDatabase;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BarCodeScanner {

    private static BarCodeScanner INSTANCE = null;
    private Map<Product, BigDecimal> receipt = new HashMap<>();

    public static BarCodeScanner getInstance() {
        if (INSTANCE == null)
            INSTANCE = new BarCodeScanner();
        return INSTANCE;
    }

    public int scanProduct(Long productID) {

        if (String.valueOf(productID).matches("^[1-9][0-9]{5}")) {

            Optional<Product> scannedProduct = ProductDatabase.getINSTANCE().getProduct(productID);

            if (scannedProduct.isPresent()) {

                receipt.computeIfPresent(scannedProduct.get(), (k, v) -> v.add(BigDecimal.ONE));
                receipt.putIfAbsent(scannedProduct.get(), BigDecimal.ONE);
                LCDDisplay.getInstance().print(scannedProduct.get().getName()
                                                       + " added with price: "
                                                       + scannedProduct.get().getPrice()
                                                       + "$");
                return 1;
            } else {
                LCDDisplay.getInstance().print("Product not found");
                return 0;
            }
        } else {
            LCDDisplay.getInstance().print("Invalid bar-code");
            return -1;
        }
    }

    private double getTotalSum(){
        return receipt.entrySet().stream()
                      .mapToDouble(e -> e.getValue().doubleValue()*e.getKey().getPrice().doubleValue())
                      .sum();
    }

    private void clearReceipt(){
        receipt = new HashMap<>();
    }

    public void getReceipt() {

        Printer.getInstance().print("*******************",
                                    "******RECEIPT******");

        receipt.forEach((k, v) -> Printer.getInstance().print(k.getName() + " X " + v.intValue()));
        double totalSum = getTotalSum();

        Printer.getInstance().print(String.format("TOTAL SUM: %.2f$", totalSum),
                                    "******RECEIPT******",
                                    "*******************");
        LCDDisplay.getInstance().print(String.format("TOTAL SUM: %.2f$",totalSum));

        clearReceipt();
    }
}
