package pl.coderslab.project.order.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.cart.service.CartService;
import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.category.service.CategoryService;
import pl.coderslab.project.order.entity.Order;
import pl.coderslab.project.order.service.OrderService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user/orders")
@AllArgsConstructor
public class OrdersUserController {

    private final  OrderService orderService;
    private final  CategoryService categoryService;
    private final  CartService cartService;

    @GetMapping
    public String viewAllOrders() {
        return "order/view-user-orders";
    }


    @ModelAttribute("userOrders")
    public List<Order> getAll(Principal principal) {
        return orderService.getOrdersByUserUsername(principal.getName());
    }


    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }


    @ModelAttribute("ProductsInCart")
    public int ProductsInCart() {
        return cartService.getAmountProductsInCart();
    }


}
