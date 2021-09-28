package at.cb.testingcms.repository;

import at.cb.testingcms.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Optional<Article> findBySlug(String slug);
}
