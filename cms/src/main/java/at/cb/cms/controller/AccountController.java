package at.cb.cms.controller;

import at.cb.cms.formdata.RegistrationData;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @GetMapping("/register")
    public String registerGet(RegistrationData registrationData){
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(
            RegistrationData registrationData,
            BindingResult bindingResult
    ){
        System.out.println(registrationData);
        return "register";
    }

}
