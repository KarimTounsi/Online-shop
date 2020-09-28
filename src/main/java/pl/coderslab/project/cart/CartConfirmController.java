package pl.coderslab.project.cart;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.project.cart.exception.NotEnoughProductsInStockException;
import pl.coderslab.project.product.Product;
import pl.coderslab.project.product.ProductService;
import pl.coderslab.project.user.UserService;

import java.math.BigDecimal;
import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class CartConfirmController {

    ProductService productService;
    CartService cartService;
    UserService userService;

    @GetMapping("/cart/confirm")
    public String cart(Model model, BigDecimal transport, Principal principal) {
        model.addAttribute("cart",cartService.getProductsInCart());
        model.addAttribute("cartSum",cartService.getTotal());
        model.addAttribute("transport",transport);
        model.addAttribute("user",userService.findByUserName(principal.getName()));
        return "cart-confirm";
    }



}
