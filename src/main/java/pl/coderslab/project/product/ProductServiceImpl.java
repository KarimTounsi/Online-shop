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
    public List<Product> getProductsByNameContaining(String name) {
        return productRepository.findProductsByStatusTrueAndNameContaining(name);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllByStatus(boolean status) {
        return productRepository.findAllByStatus(status);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> productsByCategory(Category category) {
        return productRepository.findProductsByStatusTrueAndCategory(category);
    }

    @Override
    public Product getProductById(Long id) {

        if (productRepository.findById(id).isPresent()) {
           Product product = productRepository.findById(id).get();
            Hibernate.initialize(product.getImages());
            return product ;
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
    public void saveAllProducts(List<Product> list) {
        productRepository.saveAll(list);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllByOrderByPriceAsc() {
        return productRepository.findAllByStatusTrueOrderByPriceAsc();
    }

    @Override
    public List<Product> getAllByOrderByPriceDesc() {
        return productRepository.findAllByStatusTrueOrderByPriceDesc();
    }

    @Override
    public List<Product> getAllByOrderByNameAsc() {
        return productRepository.findAllByStatusTrueOrderByNameAsc();
    }

    @Override
    public List<Product> getAllByOrderByNameDsc() {
        return productRepository.findAllByStatusTrueOrderByNameDesc();
    }

    @Override
    public List<Product> getProductsByNameIsStartingWithOrderByPriceAsc(String name) {
        return productRepository.findProductsByStatusTrueAndNameIsStartingWithOrderByPriceAsc(name);
    }

    @Override
    public List<Product> getProductsByNameIsStartingWithOrderByPriceDesc(String name) {
        return productRepository.findProductsByStatusTrueAndNameIsStartingWithOrderByPriceDesc(name);
    }

    @Override
    public List<Product> getProductsByNameIsStartingWithOrderByNameAsc(String name) {
        return productRepository.findProductsByStatusTrueAndNameIsStartingWithOrderByNameAsc(name);
    }

    @Override
    public List<Product> getProductsByNameIsStartingWithOrderByNameDesc(String name) {
        return productRepository.findProductsByStatusTrueAndNameIsStartingWithOrderByNameDesc(name);
    }

    @Override
    public List<Product> getProductsByCategoryOrderByPriceAsc(Category category) {
        return productRepository.findProductsByStatusTrueAndCategoryOrderByPriceAsc(category);
    }

    @Override
    public List<Product> getProductsByCategoryOrderByPriceDesc(Category category) {
        return productRepository.findProductsByStatusTrueAndCategoryOrderByPriceDesc(category);
    }

    @Override
    public List<Product> getProductsByCategoryOrderByNameAsc(Category category) {
        return productRepository.findProductsByStatusTrueAndCategoryOrderByNameAsc(category);
    }

    @Override
    public List<Product> getProductsByCategoryOrderByNameDesc(Category category) {
        return productRepository.findProductsByStatusTrueAndCategoryOrderByNameDesc(category);
    }

    @Override
    public List<Product> getLastSixProducts() {
        return productRepository.findAllByStatusTrueOrderByIdDesc().stream().limit(6).collect(Collectors.toList());
    }


}
