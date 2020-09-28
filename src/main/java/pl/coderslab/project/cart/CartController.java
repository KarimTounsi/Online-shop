package pl.coderslab.project.cart;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.cart.exception.NotEnoughProductsInStockException;
import pl.coderslab.project.product.Product;
import pl.coderslab.project.product.ProductService;



@Controller
@RequestMapping
@AllArgsConstructor
public class CartController {

    ProductService productService;
    CartService cartService;

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("cart",cartService.getProductsInCart());
        model.addAttribute("cartSum",cartService.getTotal());
        return "cart";
    }


    @PostMapping("/product/add/cart")
    public String productAddToCart( Long id ) throws NotEnoughProductsInStockException {
           Product product = productService.getProductById(id);
       cartService.addProduct(product);
        return "redirect:/cart";
    }

    @PostMapping("/product/subtract/cart")
    public String productSubtractFromCart( Long id ) {
        Product product = productService.getProductById(id);
        cartService.subtractProduct(product);
        return "redirect:/cart";
    }

    @PostMapping("/product/remove/cart")
    public String productRemoveFromCart( Long id ) {
        Product product = productService.getProductById(id);
        cartService.removeProduct(product);
        return "redirect:/cart";
    }

}
