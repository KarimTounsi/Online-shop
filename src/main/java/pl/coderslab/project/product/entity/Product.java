package pl.coderslab.project.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.dbImage.entity.DbImage;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name", nullable = false)
    @Length(min = 3, message = "*Name must have at least 3 characters")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity", nullable = false)
    @Min(value = 0, message = "*Quantity has to be non negative number")
    private Integer quantity;

    @Column(name = "price", nullable = false)
    @DecimalMin(value = "0.00", message = "*Price has to be non negative number")
    private BigDecimal price;

    @ManyToOne
    Category category;

    @OneToMany
    @Column(nullable = true)
    @JoinTable(name = "product_images")
    protected Set<DbImage> images;

    private boolean status;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return
                "Id = " + id +
                ", Nazwa = " + name +
                ", Opis = " + description  +
                ", Dostępna ilość w magazynie = " + quantity +
                ", Cena = " + price +
                "Ilość ";
    }
}
