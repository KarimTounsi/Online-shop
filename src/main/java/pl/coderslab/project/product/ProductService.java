package pl.coderslab.project.product;



import pl.coderslab.project.category.Category;

import java.util.List;

public interface ProductService {

   List <Product> findProductsByNameIsStartingWithName(String name);

   void saveProduct(Product product);

   List <Product> productsByCategory(Category category);

   Product getProductById(Long id);

   void deleteProductById(Long id);

   void deleteAllProducts();

}
