package pl.coderslab.project.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
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
