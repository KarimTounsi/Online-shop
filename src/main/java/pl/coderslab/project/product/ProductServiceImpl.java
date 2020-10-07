package pl.coderslab.project.product;

import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import pl.coderslab.project.category.Category;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    public List<Product> findProductsByNameIsStartingWithName(String name) {
        return productRepository.findProductsByNameIsStartingWith(name);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
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
           Product product = productRepository.findById(id).get();
            Hibernate.initialize(product.getImages());
            return product;
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

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllByOrderByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Product> getAllByOrderByPriceDesc() {
        return productRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Product> getAllByOrderByNameAsc() {
        return productRepository.findAllByOrderByNameAsc();
    }

    @Override
    public List<Product> getAllByOrderByNameDsc() {
        return productRepository.findAllByOrderByNameDesc();
    }

    @Override
    public List<Product> getProductsByNameIsStartingWithOrderByPriceAsc(String name) {
        return productRepository.findProductsByNameIsStartingWithOrderByPriceAsc(name);
    }

    @Override
    public List<Product> getProductsByNameIsStartingWithOrderByPriceDesc(String name) {
        return productRepository.findProductsByNameIsStartingWithOrderByPriceDesc(name);
    }

    @Override
    public List<Product> getProductsByNameIsStartingWithOrderByNameAsc(String name) {
        return productRepository.findProductsByNameIsStartingWithOrderByNameAsc(name);
    }

    @Override
    public List<Product> getProductsByNameIsStartingWithOrderByNameDesc(String name) {
        return productRepository.findProductsByNameIsStartingWithOrderByNameDesc(name);
    }

    @Override
    public List<Product> getProductsByCategoryOrderByPriceAsc(Category category) {
        return productRepository.findProductsByCategoryOrderByPriceAsc(category);
    }

    @Override
    public List<Product> getProductsByCategoryOrderByPriceDesc(Category category) {
        return productRepository.findProductsByCategoryOrderByPriceDesc(category);
    }

    @Override
    public List<Product> getProductsByCategoryOrderByNameAsc(Category category) {
        return productRepository.findProductsByCategoryOrderByNameAsc(category);
    }

    @Override
    public List<Product> getProductsByCategoryOrderByNameDesc(Category category) {
        return productRepository.findProductsByCategoryOrderByNameDesc(category);
    }

    @Override
    public List<Product> getLastSixProducts() {
        return productRepository.findAllByOrderByIdDesc().stream().limit(6).collect(Collectors.toList());
    }


}
