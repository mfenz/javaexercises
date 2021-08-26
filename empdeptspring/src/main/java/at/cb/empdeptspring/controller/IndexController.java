package at.cb.empdeptspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // http://localhost/  <-- Index

    @GetMapping("/")
    public String getIndex(){
        System.out.println("Ich bin in der Methode getIndex()");
        return "index";
    }

}
