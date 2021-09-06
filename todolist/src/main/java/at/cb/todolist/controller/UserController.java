package at.cb.todolist.controller;

import at.cb.todolist.formdata.RegistrationData;
import at.cb.todolist.model.User;
import at.cb.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String displayRegistrationGet(
            RegistrationData registrationData
    ){
        // Template "registration" zurückgeben
        return "registration";
    }

    @PostMapping("/registration")
    public String displayRegistrationPost(
            @Valid RegistrationData registrationData, // Daten des Formulars
            BindingResult bindingResult // Fehler (Validierung)
    ){
        if(bindingResult.hasErrors()){
            return displayRegistrationGet(registrationData);
        }

        // Registrierung durchführen
        User user = userService.createUser(registrationData);

        return "redirect:/";
    }
}
