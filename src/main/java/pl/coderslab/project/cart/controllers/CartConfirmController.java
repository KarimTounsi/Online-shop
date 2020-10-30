package pl.coderslab.project.cart.controllers;

import freemarker.template.TemplateException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.address.entity.Address;
import pl.coderslab.project.address.service.AddressService;
import pl.coderslab.project.cart.service.CartService;
import pl.coderslab.project.exception.NotEnoughProductsInStockException;
import pl.coderslab.project.order.entity.Order;
import pl.coderslab.project.order.service.OrderService;
import pl.coderslab.project.product.service.ProductService;
import pl.coderslab.project.user.service.UserService;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class CartConfirmController {


    private final CartService cartService;
    private final UserService userService;
    private final OrderService orderService;
    private final AddressService addressService;

    @GetMapping("/cart/confirm")
    public String cart(Model model, BigDecimal transport, Principal principal) {
        model.addAttribute("cart", cartService.getProductsInCart());
        model.addAttribute("cartSum", cartService.getTotal());
        model.addAttribute("transport", transport);
        model.addAttribute("user", userService.findByUserName(principal.getName()));
        model.addAttribute("address", new Address());
        return "cart/cart-confirm";
    }

    @PostMapping("/cart/confirm")
    public String cartConfirm(@Valid Address address, BindingResult bindingResult, Principal principal, BigDecimal transport, BigDecimal sum, String paymentMethod) throws MessagingException, IOException, TemplateException {
        if (bindingResult.hasErrors()) {
            return "cart/cart-confirm";
        }
        addressService.saveAddress(address);
        Order order = new Order();
        order.setAddress(address);
        order.setUser(userService.findByUserName(principal.getName()));
        order.setProducts(cartService.getProductsInCart());
        order.setTransportPrice(transport);
        if (transport.equals(BigDecimal.valueOf(14))) {
            order.setTransportType("Inpost");
        } else if (transport.equals(BigDecimal.valueOf(16.5))) {
            order.setTransportType("Inpost Kurier");
        } else if (transport.equals(BigDecimal.valueOf(17))) {
            order.setTransportType("DPD kurier");
        }
        order.setOrderSum(sum);
        order.setPaymentMethod(paymentMethod);
        order.setRealized(false);
        orderService.saveOrder(order);
        cartService.sendToClientMail(order);
        cartService.sendToAdminMail(order);
        return "redirect:/cart/confirm/checkout";
    }

    @GetMapping("/cart/confirm/checkout")
    public String cartConfirmCheckout() throws NotEnoughProductsInStockException, MessagingException, IOException, TemplateException {
        cartService.checkout();
        return "redirect:/user/orders";
    }


}
