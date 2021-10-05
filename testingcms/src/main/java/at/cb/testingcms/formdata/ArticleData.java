package at.cb.testingcms.formdata;

import at.cb.testingcms.model.Article;
import at.cb.testingcms.model.Category;
import at.cb.testingcms.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleData {
    private int id;
    @NotBlank
    @Length(min = 1, max = 200)
    private String title;
    @NotBlank
    private String content;
    @NotNull(message = "Datum muss eingetragen sein")
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime publicationDate;
    private boolean published;
    @NotBlank
    @Length(min = 1, max = 200)
    private String slug;
    @NotNull
    private User author;
    private List<Category> categories;

    public void set(Article a){
        id = a.getId();
        title = a.getTitle();
        content = a.getContent();
        publicationDate = a.getPublicationDate();
        published = a.isPublished();
        slug = a.getSlug();
        author = a.getAuthor();
        categories = a.getCategories();
    }
}
