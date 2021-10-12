package at.cb.testingcms.controller;

import at.cb.testingcms.formdata.CategoryData;
import at.cb.testingcms.model.Category;
import at.cb.testingcms.service.CategoryService;
import at.cb.testingcms.service.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/categories")
public class AdminCategoryController {
    private final CategoryService categoryService;

    @GetMapping("/create")
    public String createCategoryGet(
            CategoryData categoryData,
            Model model
    ) {
        // Alle Kategorien laden um sie ebenfalls darzustellen
        List<Category> categories = categoryService.getCategories();
        // Kategorien im Model speichern
        model.addAttribute("categories", categories);
        return "admin/category";
    }

    @PostMapping("/save")
    public String createCategoryPost(
            @Valid CategoryData categoryData,
            BindingResult bindingResult,
            Model model
    ) {
        if(bindingResult.hasErrors()){
            return createCategoryGet(categoryData, model);
        }
        try {
            Category category = categoryService.createCategory(categoryData.getName());
            // Bei Erfolg: Weiterleitung
            return "redirect:/admin/categories/create";
        } catch (ServiceException e){
            bindingResult.reject("category_error", e.getMessage());
            return createCategoryGet(categoryData, model);
        }
    }
}
