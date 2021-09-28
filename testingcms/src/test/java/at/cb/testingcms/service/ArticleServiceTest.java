package at.cb.testingcms.service;

import at.cb.testingcms.formdata.ArticleData;
import at.cb.testingcms.model.Article;
import at.cb.testingcms.model.User;
import at.cb.testingcms.repository.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ArticleServiceTest {

    private ArticleService articleService;
    private ArticleRepository articleRepository;

    private User manfred = new User(1, "manfred@email.com", "12345678", "Manfred", List.of());

    private Article derErste = new Article(1, "Der Erste", "Ich bin der erste Artikel", LocalDateTime.of(2021, 1, 1, 12, 0), true, "der-erste", List.of(), manfred);
    private Article derZweite = new Article(2, "Der Zweite", "Ich bin der zweite Artikel", LocalDateTime.of(2021, 2, 1, 12, 0), true, "der-zweite", List.of(), manfred);
    private Article derDritte = new Article(2, "Der Dritte", "Ich bin der dritte Artikel", LocalDateTime.of(2021, 3, 1, 12, 0), false, "der-dritte", List.of(), manfred);

    @BeforeEach
    public void initBeforeEach(){
        articleRepository = Mockito.mock(ArticleRepository.class);
        Mockito.when(articleRepository.save(Mockito.any(Article.class)))
                .then(AdditionalAnswers.returnsFirstArg());
        articleService = new ArticleService(articleRepository);
    }

    @Test
    public void wennArtikelTitelLeerServiceException(){
        ArticleData data = new ArticleData(
                0, "", "A", LocalDateTime.now(),
                true, "a",manfred, List.of());
        ServiceException serviceException = catchThrowableOfType(
                () -> articleService.create(data),
                ServiceException.class);

        assertThat(serviceException).hasMessage("Der Titel muss zwischen 1 und 200 Zeichen sein");
    }

    @Test
    public void wennArtikelTitelMehrAls200ZeichenDannServiceException(){
        ArticleData data = new ArticleData(
                0, "ajflakjsfdlakjsflakjsflakjsdflakjfdlajksdlkfjaljfkdasfasdfasdfasdfaskfjslkdfjafsidslkdfjsldfkjowiejlskdfjsdfkjwoijlskdjfiwolksjdfksljdfiwoksdfsdfsfdwefwefsdfwefwesdfwefsdfwefsdfw4iodflksdfjklsfdkjsdfkldfksjdfks", "A", LocalDateTime.now(),
                true, "a",manfred, List.of());
        ServiceException serviceException = catchThrowableOfType(
                () -> articleService.create(data),
                ServiceException.class);

        assertThat(serviceException).hasMessage("Der Titel muss zwischen 1 und 200 Zeichen sein");
    }

    @Test
    public void wennSlugLeerDannServiceException(){
        ArticleData data = new ArticleData(
                0, "A", "A", LocalDateTime.now(),
                true, "", manfred, List.of());
        ServiceException serviceException = catchThrowableOfType(
                () -> articleService.create(data),
                ServiceException.class);
        assertThat(serviceException).hasMessage("Der Slug muss zwischen 1 und 200 Zeichen sein");
    }

    @Test
    public void wennSlugMehrAls200ZeichenDannServiceException(){
        ArticleData data = new ArticleData(
                0, "A", "A", LocalDateTime.now(),
                true, "ajflakjsfdlakjsflakjsflakjsdflakjfdlajksdlkfjaljfkdasfasdfasdfasdfaskfjslkdfjafsidslkdfjsldfkjowiejlskdfjsdfkjwoijlskdjfiwolksjdfksljdfiwoksdfsdfsfdwefwefsdfwefwesdfwefsdfwefsdfw4iodflksdfjklsfdkjsdfkldfksjdfks", manfred, List.of());
        ServiceException serviceException = catchThrowableOfType(
                () -> articleService.create(data),
                ServiceException.class);
        assertThat(serviceException).hasMessage("Der Slug muss zwischen 1 und 200 Zeichen sein");
    }

    @Test
    public void wennSlugSlashEnthaeltDannServiceException(){
        ArticleData data = new ArticleData(
                0, "A", "A", LocalDateTime.now(),
                true, "abc/ad", manfred, List.of());
        ServiceException serviceException = catchThrowableOfType(
                () -> articleService.create(data),
                ServiceException.class);
        assertThat(serviceException).hasMessage("Slug darf keinen Slash enthalten");
    }

    @Test
    public void wennSlugBereitsVerwendetDannServiceException(){
        Mockito.doReturn(Optional.of(new Article()))
                .when(articleRepository).findBySlug("abc");

        ArticleData data = new ArticleData(
                0, "A", "A", LocalDateTime.now(),
                true, "abc", manfred, List.of());
        ServiceException serviceException = catchThrowableOfType(
                () -> articleService.create(data),
                ServiceException.class);
        assertThat(serviceException).hasMessage("Slug wird bereits verwendet");
    }

    @Test
    public void wennPublicationDateNullDannServiceException(){
        ArticleData data = new ArticleData(
                0, "A", "A", null,
                true, "abc", manfred, List.of());
        ServiceException serviceException = catchThrowableOfType(
                () -> articleService.create(data),
                ServiceException.class);
        assertThat(serviceException).hasMessage("Datum muss eingegeben werden");
    }

    @Test
    public void titelMussMitEingabeUebereinstimmen(){
        ArticleData data = new ArticleData(
                0, "A", "A", LocalDateTime.now(),
                true, "abc", manfred, List.of());
        Article article = articleService.create(data);
        assertEquals("A", article.getTitle());
    }

    @Test
    public void homePageArticlesMustBePublishedAndOrderedByPublicationDate(){
        Mockito.doReturn(List.of(derErste, derZweite, derDritte))
                .when(articleRepository).findAll();

        List<Article> articles = articleService.getPublishedArticles();
        List<String> articleTitles = articles.stream()
                .map(article -> article.getTitle())
                /*.map(article -> {
                    return article.getTitle();
                })*/
                .collect(Collectors.toList());

        assertEquals(List.of("Der Zweite", "Der Erste"), articleTitles);
    }

    @Test
    public void wennArtikelMitSlugNichtGefundenDannServiceException(){
        Mockito.doReturn(Optional.empty())
                .when(articleRepository).findBySlug("ich-bin-nicht-da");
        ServiceException serviceException = catchThrowableOfType(
                () -> articleService.getArticleBySlug("ich-bin-nicht-da"),
                ServiceException.class);
        assertThat(serviceException).hasMessage("Artikel nicht gefunden");
    }

    @Test
    public void wennArtikelMitSlugNichtVeroeffentlichtDannServiceException(){
        Mockito.doReturn(Optional.of(derDritte))
                .when(articleRepository).findBySlug("ich-bin-nicht-veroeffentlicht");
        ServiceException serviceException = catchThrowableOfType(
                () -> articleService.getArticleBySlug("ich-bin-nicht-veroeffentlicht"),
                ServiceException.class);
        assertThat(serviceException).hasMessage("Artikel nicht gefunden");
    }

}