package at.cb.cms.formdata;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class RegistrationData {
    @Length(min = 2, max = 100)
    private String name;
    @Email
    @NotEmpty
    private String email;
    @Length(min = 6)
    private String password;
}
