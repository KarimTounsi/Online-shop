package pl.coderslab.project.cart;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.project.address.Address;
import pl.coderslab.project.address.AddressService;
import pl.coderslab.project.cart.exception.NotEnoughProductsInStockException;
import pl.coderslab.project.order.Order;
import pl.coderslab.project.order.OrderService;
import pl.coderslab.project.product.Product;
import pl.coderslab.project.product.ProductService;
import pl.coderslab.project.user.UserService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class CartConfirmController {

    ProductService productService;
    CartService cartService;
    UserService userService;
    OrderService orderService;
    AddressService addressService;

    @GetMapping("/cart/confirm")
    public String cart(Model model, BigDecimal transport, Principal principal) {
        model.addAttribute("cart", cartService.getProductsInCart());
        model.addAttribute("cartSum", cartService.getTotal());
        model.addAttribute("transport", transport);
        model.addAttribute("user", userService.findByUserName(principal.getName()));
        model.addAttribute("address", new Address());
        return "cart-confirm";
    }

    @PostMapping("/cart/confirm")
    public String cartConfirm(@Valid Address address, BindingResult bindingResult, Principal principal, BigDecimal transport,BigDecimal sum, String paymentMethod ) {
        if (bindingResult.hasErrors()) {
            return "cart-confirm";
        }
        addressService.saveAddress(address);
        Order order = new Order();
        order.setAddress(address);
        order.setUser(userService.findByUserName(principal.getName()));
        order.setProducts(cartService.getProductsInCart());
        order.setTransportPrice(transport);
        if (transport.equals(BigDecimal.valueOf(14))){
            order.setTransportType("Inpost");
        } else if (transport.equals(BigDecimal.valueOf(16.5))){
            order.setTransportType("Inpost Kurier");
        } else if (transport.equals(BigDecimal.valueOf(17))){
            order.setTransportType("DPD kurier");
        }
        order.setOrderSum(sum);
        order.setPaymentMethod(paymentMethod);
        order.setRealized(false);
        orderService.saveOrder(order);
        return "redirect:/cart/confirm/checkout";
    }

    @GetMapping("/cart/confirm/checkout")
    public String cartConfirmCheckout( ) throws NotEnoughProductsInStockException {

        cartService.checkout();

        return "redirect:/";
    }


}
