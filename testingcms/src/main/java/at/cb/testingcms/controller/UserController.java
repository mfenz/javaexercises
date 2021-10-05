package at.cb.testingcms.controller;

import at.cb.testingcms.formdata.LoginData;
import at.cb.testingcms.formdata.RegistrationData;
import at.cb.testingcms.model.User;
import at.cb.testingcms.service.ServiceException;
import at.cb.testingcms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String displayRegistrationGet(
            RegistrationData registrationData
    ){
        return "register"; // wie heißt unser HTML Template?
    }

    @PostMapping("/register")
    public String performRegistrationPost(
            @Valid RegistrationData registrationData,
            BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            return displayRegistrationGet(registrationData);
        }

        try {
            User user = userService.register(registrationData);
            return "redirect:/login?registered=true&userid=" + user.getId();
        } catch (ServiceException e){
            bindingResult.reject("registration_error", e.getMessage());
        }
        return displayRegistrationGet(registrationData);
    }

    @GetMapping("/login")
    public String displayLoginGet(
            LoginData loginData
    ){
        return "login";
    }

    @GetMapping("/logout")
    public String displayLogoutGet(){
        return "logout";
    }
}
