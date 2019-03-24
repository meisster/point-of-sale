package product;

import java.math.BigDecimal;

public class ProductMaker implements ProductBuilder{
    private Product product;

    public ProductMaker(){
        this.product = new Product();
    }

    @Override
    public void buildProductName(String name) {
        product.setName(name);
    }

    @Override
    public void buildProductPrice(BigDecimal price) {
        product.setPrice(price);
    }

    @Override
    public void buildProductID(Long ID) {
        product.setID(ID);
    }

    @Override
    public Product getProduct() {
        if (product.getName() == null || product.getPrice() == null || product.getID() == null)
            return null;
        return product;
    }
}
