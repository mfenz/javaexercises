package at.cb.testingcms.service;

import at.cb.testingcms.formdata.ArticleData;
import at.cb.testingcms.model.Article;
import at.cb.testingcms.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article create(ArticleData data){
        checkArticleTitle(data.getTitle());
        checkArticleSlug(data.getSlug());
        checkPublicationDate(data.getPublicationDate());

        Article article = new Article(0, data.getTitle(), data.getContent(), data.getPublicationDate(),
                data.isPublished(), data.getSlug(), data.getCategories(), data.getAuthor());

        article = articleRepository.save(article);

        return article;
    }

    private void checkArticleTitle(String title){
        if(title == null || title.isBlank() || title.length() > 200){
            throw new ServiceException("Der Titel muss zwischen 1 und 200 Zeichen sein");
        }
    }

    private void checkArticleSlug(String slug){
        if(slug == null || slug.isBlank() || slug.length() > 200){
            throw new ServiceException("Der Slug muss zwischen 1 und 200 Zeichen sein");
        }
        if(slug.contains("/")){
            throw new ServiceException("Slug darf keinen Slash enthalten");
        }
        if(articleRepository.findBySlug(slug).isPresent()){
            throw new ServiceException("Slug wird bereits verwendet");
        }
    }

    private void checkPublicationDate(LocalDateTime date){
        if(date == null){
            throw new ServiceException("Datum muss eingegeben werden");
        }
    }

    public List<Article> getPublishedArticles(){
        List<Article> articles = articleRepository
                .findAll()
                .stream()
                .filter(article -> article.isPublished())
                .sorted((a1, a2) -> a2.getPublicationDate().compareTo(a1.getPublicationDate()))
                .collect(Collectors.toList());
        return articles;
    }

    public Article getArticleBySlug(String slug){
        Article article = articleRepository
                .findBySlug(slug)
                .orElseThrow(() -> new ServiceException("Artikel nicht gefunden"));
        if(!article.isPublished()){
            throw new ServiceException("Artikel nicht gefunden");
        }
        return article;
    }

    public List<Article> getArticles(){
        return articleRepository.findAll()
                .stream()
                .sorted((Article o1, Article o2) -> o2.getPublicationDate().compareTo(o1.getPublicationDate()))
                .collect(Collectors.toList());
    }

}
