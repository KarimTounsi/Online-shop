package pl.coderslab.project.order;

import pl.coderslab.project.user.User;

import java.util.List;

public interface OrderService {

    void saveOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderByID(Long id);

    List<Order> getOrdersByUserUsername(String userName);

}
