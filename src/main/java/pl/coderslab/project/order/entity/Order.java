package pl.coderslab.project.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.project.address.entity.Address;
import pl.coderslab.project.product.entity.Product;
import pl.coderslab.project.user.entity.User;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private LocalDateTime created;

    @ManyToOne
    private User user;

    @OneToOne
    private Address address;

    @CollectionTable(name = "order_products")
    @ElementCollection
    private Map<Product, Integer> products = new HashMap<>();

    private String transportType;

    private BigDecimal transportPrice;

    private BigDecimal orderSum;

    private String paymentMethod;

    private boolean isRealized;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }


}
