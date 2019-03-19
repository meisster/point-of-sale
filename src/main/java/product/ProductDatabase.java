package product;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Data
@NoArgsConstructor
public class ProductDatabase {

    private static ProductDatabase INSTANCE = new ProductDatabase();

    public Map<Long, Product> productList = new HashMap<>();

    public static ProductDatabase getINSTANCE(){
        return INSTANCE;
    }

    public Optional<Product> getProduct(Long productID){
        return Optional.ofNullable(productList.getOrDefault(productID, null));
    }

    public void addProduct(Product... products){
        for (Product product : products) {
            productList.putIfAbsent(product.getID(), product);
        }
    }

    public int getSize(){
        return productList.size();
    }
}
