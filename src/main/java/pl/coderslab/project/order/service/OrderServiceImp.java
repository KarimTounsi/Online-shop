package pl.coderslab.project.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.project.order.entity.Order;
import pl.coderslab.project.order.repository.OrderRepository;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class OrderServiceImp implements OrderService {

    OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderByID(Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public List<Order> getOrdersByUserUsername(String userName) {
        return orderRepository.findOrdersByUserUsername(userName);
    }

}
