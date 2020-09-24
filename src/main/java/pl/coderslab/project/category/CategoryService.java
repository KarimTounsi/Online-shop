package pl.coderslab.project.category;

import java.util.List;

public interface CategoryService {

 void saveCategory(Category category);

 List<Category> getAll();

 List<Category> getAllSorted();

 Category getById(Long id );
}
