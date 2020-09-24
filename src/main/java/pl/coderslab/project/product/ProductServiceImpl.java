package pl.coderslab.project.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.project.category.Category;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    public List<Product> findProductsByNameIsStartingWithName(String name) {
        return productRepository.findProductsByNameIsStartingWith(name);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> productsByCategory(Category category) {
      return   productRepository.findProductsByCategory(category);
    }
}
