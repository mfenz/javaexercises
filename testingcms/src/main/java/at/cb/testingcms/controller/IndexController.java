package at.cb.testingcms.controller;

import at.cb.testingcms.model.Article;
import at.cb.testingcms.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final ArticleService articleService;


    @GetMapping("/")
    public String displayIndexGet(
            Model model
    )
    {
        // Artikel laden
        List<Article> articles = articleService.getPublishedArticles();
        // Artikel zum Model hinzufügen
        model.addAttribute("articles", articles);
        // Welches Template verwendet wird
        return "index";
    }
}
