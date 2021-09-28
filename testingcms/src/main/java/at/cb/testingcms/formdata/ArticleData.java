package at.cb.testingcms.formdata;

import at.cb.testingcms.model.Category;
import at.cb.testingcms.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleData {
    private int id;
    private String title;
    private String content;
    private LocalDateTime publicationDate;
    private boolean published;
    private String slug;
    private User author;
    private List<Category> categories;
}
