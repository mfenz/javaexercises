package at.cb.cms.controller;

import at.cb.cms.formdata.RegistrationData;
import at.cb.cms.model.User;
import at.cb.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AccountController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerGet(RegistrationData registrationData){
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(
            @Valid RegistrationData registrationData,
            BindingResult bindingResult // enthält Fehler (falls es welche gibt)
    ){
        // Gibt es Fehler?
        if(bindingResult.hasErrors()){
            // Wenn ja --> Registrierungs-Formular neu anzeigen
            return registerGet(registrationData);
        }

        // wenn nein --> Registrierung durchführen
        User user = userService.createAccount(registrationData);

        // Auf die Login-Seite weiterleiten
        return "redirect:/login";
    }

}
