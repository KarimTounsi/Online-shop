package pl.coderslab.project.cart;

import pl.coderslab.project.cart.exception.NotEnoughProductsInStockException;
import pl.coderslab.project.product.Product;
import pl.coderslab.project.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final ProductRepository productRepository;

    private Map<Product, Integer> products = new HashMap<>();



    @Override
    public void addProduct(Product product) throws NotEnoughProductsInStockException {

        if (products.containsKey(product)) {

            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);

        }
        if (product.getQuantity() < products.get(product)){
            throw new NotEnoughProductsInStockException(product);}
    }



    @Override
    public void removeProduct(Product product) {

            products.remove(product);

    }

    @Override
    public void subtractProduct(Product product) {
        if (products.containsKey(product)) {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1) {
                products.remove(product);
            }
        }
    }


    @Override
    public void checkout() throws NotEnoughProductsInStockException {
        Product product;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            product = productRepository.getOne(entry.getKey().getId());
            if (product.getQuantity() < entry.getValue())
                throw new NotEnoughProductsInStockException(product);
            entry.getKey().setQuantity(product.getQuantity() - entry.getValue());
        }
        productRepository.saveAll(products.keySet());
        productRepository.flush();
        products.clear();
    }



    @Override
    public Map<Product, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }



    @Override
    public BigDecimal getTotal() {
        return products.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public int getAmountProductsInCart() {
            return products.size();

    }


}
