package at.cb.testingcms.formdata;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
public class LoginData {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
