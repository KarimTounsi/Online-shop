package pl.coderslab.project.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/all")
@AllArgsConstructor
public class viewAllProductsController {

    ProductRepository productRepository;

    @ModelAttribute("products")
    public List<Product> getAll() {
        return productRepository.findAll();
    }


    @GetMapping
    public String viewProducts() {
        return "view-all-products";
    }

}
