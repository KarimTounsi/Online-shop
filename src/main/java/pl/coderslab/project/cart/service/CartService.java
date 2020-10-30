package pl.coderslab.project.cart.service;



import freemarker.template.TemplateException;
import pl.coderslab.project.exception.NotEnoughProductsInStockException;
import pl.coderslab.project.order.entity.Order;
import pl.coderslab.project.product.entity.Product;

import javax.mail.MessagingException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public interface CartService {

    void addProduct(Product product)throws NotEnoughProductsInStockException;

    void removeProduct(Product product);

    void subtractProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotal();

    int getAmountProductsInCart();

    public void sendToClientMail(Order order) throws MessagingException, IOException, TemplateException ;
    public void sendToAdminMail(Order order) throws MessagingException, IOException, TemplateException ;
}
