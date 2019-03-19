package product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Product {

    String name;

    Long ID;

    BigDecimal price;

    public Product(String newName, Long newID, float newPrice){
        this.name = newName;
        this.ID = newID;
        this.price = BigDecimal.valueOf(newPrice);
    }

}
