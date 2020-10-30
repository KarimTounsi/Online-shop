package pl.coderslab.project.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.project.order.entity.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {


    List<Order> findOrdersByUserUsername(String userName);

}
