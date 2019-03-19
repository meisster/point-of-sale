package product;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
class ProductDatabase {

    Map<Product, Long> productList = new HashMap<>();

    void addProduct(Product product){
        productList.putIfAbsent(product, product.getID());
    }

    int getSize(){
        return productList.size();
    }
}
