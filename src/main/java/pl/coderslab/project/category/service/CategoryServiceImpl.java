package pl.coderslab.project.category.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.category.repository.CategoryRepository;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void saveCategories(List<Category> list) {
categoryRepository.saveAll(list);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAllByStatusTrue();
    }


    @Override
    public List<Category> getAllSorted() {
        return categoryRepository.findAllByStatusTrue().stream().sorted(Comparator.comparing(Category::getId)).
                collect(Collectors.toList());
    }

    @Override
    public Category getById(Long id) {
        if (categoryRepository.findById(id).isPresent()) {
            return categoryRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteAllCategories() {
        categoryRepository.deleteAll();
    }

    @Override
    public List<Category> getAllByStatus(boolean status) {
        return categoryRepository.findAllByStatus(status);
    }


}
