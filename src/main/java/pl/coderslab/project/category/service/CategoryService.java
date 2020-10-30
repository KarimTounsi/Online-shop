package pl.coderslab.project.category.service;

import pl.coderslab.project.category.entity.Category;

import java.util.List;

public interface CategoryService {

 void saveCategory(Category category);
 void saveCategories(List <Category> list);

 List<Category> getAll();

 List<Category> getAllSorted();

 Category getById(Long id);

 void deleteCategoryById(Long id);

 void deleteAllCategories();

 List<Category> getAllByStatus(boolean status);


}
