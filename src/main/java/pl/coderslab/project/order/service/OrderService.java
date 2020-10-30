package pl.coderslab.project.order.service;

import pl.coderslab.project.order.entity.Order;

import java.util.List;

public interface OrderService {

    void saveOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderByID(Long id);

    List<Order> getOrdersByUserUsername(String userName);

}
