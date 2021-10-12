package at.cb.testingcms.controller;

import at.cb.testingcms.model.Article;
import at.cb.testingcms.service.ArticleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/{slug}/")
    public String displayArticleGet(
            @PathVariable String slug,
            Model model
    ){
        // Article anhand von Slug laden
        Article article = articleService.getArticleBySlug(slug);
        // Article im Model hinterlegen
        model.addAttribute("article", article);
        return "article";
    }
}
