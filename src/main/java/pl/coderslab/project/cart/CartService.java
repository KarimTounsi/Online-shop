package pl.coderslab.project.cart;



import pl.coderslab.project.cart.exception.NotEnoughProductsInStockException;
import pl.coderslab.project.product.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface CartService {

    void addProduct(Product product)throws NotEnoughProductsInStockException;

    void removeProduct(Product product);
    void subtractProduct(Product product);

    Map<Product, Integer> getProductsInCart();


    BigDecimal getTotal();
}
