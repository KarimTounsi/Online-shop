package pl.coderslab.project.cart.exception;


import pl.coderslab.project.product.Product;

public class NotEnoughProductsInStockException extends Exception {

    private static final String DEFAULT_MESSAGE = "Za mało produktów w magazynie";

    public NotEnoughProductsInStockException() {
        super(DEFAULT_MESSAGE);
    }

    public NotEnoughProductsInStockException(Product product) {
        super(String.format("Za mało produktów %s w magazynie. Zostało tylko %d", product.getName(), product.getQuantity()));
    }

}
