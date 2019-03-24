package product;

import lombok.Data;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;

@Data
public class ProductDatabase {

    public Map<Long, Product> productList = new HashMap<>();

    private static class ProductHelper {
        private static ProductDatabase INSTANCE = new ProductDatabase();
    }

    public static ProductDatabase getINSTANCE() {
        return ProductHelper.INSTANCE;
    }

    public void initializeDatabase() {
        try {
            Object object = new JSONParser().parse(new FileReader("src/products.json"));
            JSONArray jsonArray = (JSONArray) object;

            for (Object o : jsonArray) {
                ProductMaker productMaker = new ProductMaker();
                JSONObject line = (JSONObject) o;
                productMaker.buildProductName((String) line.get("name"));
                productMaker.buildProductID((Long) line.get("id"));
                productMaker.buildProductPrice(BigDecimal.valueOf(Double.parseDouble(line.get("price").toString())));
                this.addProduct(productMaker.getProduct());
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public Optional<Product> getProduct(Long productID) {
        return Optional.ofNullable(productList.getOrDefault(productID, null));
    }

    private void addProduct(Product... products) {
        Arrays.stream(products)
              .filter(Objects::nonNull)
              .forEach(product -> productList.putIfAbsent(product.getID(), product));
    }

    public Product getRandomProduct(){
        List<Product> values = new ArrayList<>(productList.values());
        return values.get(new Random().nextInt(values.size()-1));
    }


}
