package at.cb.testingcms.service;

import at.cb.testingcms.model.Category;
import at.cb.testingcms.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category createCategory(String name){
        checkCategoryName(name);

        if(categoryRepository.findByName(name).isPresent()){
            throw new ServiceException("Diese Kategorie existiert bereits");
        }

        Category category = new Category(name);

        category = categoryRepository.save(category);

        return category;
    }

    private void checkCategoryName(String name){
        if(name == null || name.isBlank()){
            throw new ServiceException("Kategorie-Name eingeben");
        }
        if(name.length() > 50){
            throw new ServiceException("Der Name muss zwischen 1 und 50 Zeichen sein");
        }
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
