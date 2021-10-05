package at.cb.testingcms.controller;

import at.cb.testingcms.formdata.ArticleData;
import at.cb.testingcms.model.Article;
import at.cb.testingcms.model.Category;
import at.cb.testingcms.model.User;
import at.cb.testingcms.service.ArticleService;
import at.cb.testingcms.service.CategoryService;
import at.cb.testingcms.service.ServiceException;
import at.cb.testingcms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/articles") // URL Präfix
@RequiredArgsConstructor
public class AdminArticleController {

    private final UserService userService;
    private final CategoryService categoryService;
    private final ArticleService articleService;

    // /admin/articles
    @GetMapping("")
    public String displayArticlesGet(
            Model model
    ){
        // Alle Artikel laden
        List<Article> articles = articleService.getArticles();
        // Artikel zum model hinzufügen
        model.addAttribute("articles", articles);
        return "admin/articles";
    }

    // /admin/articles/create
    @GetMapping("/create")
    public String createArticleGet(
            ArticleData articleData,
            Model model
    ){
        // User laden
        List<User> users = userService.getUsers();
        // User im Model hinterlegen
        model.addAttribute("users", users);

        // Kategorien laden
        List<Category> categories = categoryService.getCategories();
        // Kategorien im Model hinterlegen
        model.addAttribute("categories", categories);

        return "admin/article";
    }

    @PostMapping("/save")
    public String createArticlePost(
            @Valid ArticleData articleData,
            BindingResult bindingResult,
            Model model
    ){
        // Gibt es Fehler?
        if(bindingResult.hasErrors()){
            return createArticleGet(articleData, model);
        }

        try {
            if(articleData.getId() == 0){
                // Artikel erstellen
                Article article = articleService.create(articleData);
                // Bei Erfolg: Redirect auf Artikel-Übersichtsseite des Admins
                return "redirect:/admin/articles?articlecreated=true&articleid=" + article.getId();
            } else {
                // Artikel bearbeiten
                Article article = articleService.editArticle(articleData);
                return "redirect:/admin/articles?articleupdated=true&articleid=" + article.getId();
            }

        } catch (ServiceException e){
            bindingResult.reject("article_error", e.getMessage());
            return createArticleGet(articleData, model);
        }
    }

    @GetMapping("/{id}")
    public String displayArticleEditGet(
            @PathVariable int id,
            ArticleData articleData,
            Model model
    ){
        Article article = articleService.getArticle(id);
        System.out.println(article);
        if(articleData.getId() == 0){

        }
        articleData.set(article);
        System.out.println(articleData);
        return createArticleGet(articleData, model);
    }

    //@PostMapping("")

}
