package at.cb.testingcms.formdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationData {
    @Email
    @NotBlank
    @Length(max = 300)
    private String email;
    @Length(min = 6, max = 40)
    @NotBlank
    private String password;
    @Length(min = 1, max = 100)
    @NotBlank
    private String name;
}
