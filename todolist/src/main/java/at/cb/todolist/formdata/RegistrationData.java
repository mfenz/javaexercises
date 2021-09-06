package at.cb.todolist.formdata;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
public class RegistrationData {
    @Length(min = 5)
    @Email
    private String email;
    @Length(min = 6)
    private String password;
    @Length(min = 1, max = 30)
    private String name;

    public RegistrationData() {
    }
}
