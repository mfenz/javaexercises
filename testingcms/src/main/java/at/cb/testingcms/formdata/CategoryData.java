package at.cb.testingcms.formdata;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class CategoryData {
    private int id;
    @NotBlank
    @Length(min = 1, max = 50)
    private String name;
}
