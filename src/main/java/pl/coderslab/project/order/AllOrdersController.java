package pl.coderslab.project.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.cart.CartService;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;


import java.util.List;

@Controller
@RequestMapping("/admin/orders/all")
@AllArgsConstructor
public class AllOrdersController {

    OrderService orderService;
    CategoryService categoryService;
    CartService cartService;

    @GetMapping
    public String viewAllOrders() {
        return "view-all-orders";
    }


    @ModelAttribute("orders")
    public List<Order> getAll() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public String ChangeIsRealized(boolean status, Long id) {

        Order order = orderService.getOrderByID(id);
        order.setRealized(status);
        orderService.saveOrder(order);

        return "redirect:/admin/orders/all";
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
