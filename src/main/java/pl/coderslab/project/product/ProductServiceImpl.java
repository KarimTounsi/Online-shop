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
        return productRepository.findProductsByCategory(category);
    }

    @Override
    public Product getProductById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}
