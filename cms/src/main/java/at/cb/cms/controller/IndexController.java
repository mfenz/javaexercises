package at.cb.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    /**
     * Methode definieren die auf die Eingabe von / reagiert
     */

    // Wenn GET-Requests für "/" aufgerufen werden, wird diese Methode aufgerufen
    @GetMapping("/")
    public String indexGet(){
        // Leite die Anfrage an Thymeleaf Template Engine weiter
        // und verwende die Datei index.html
        return "index";
    }
}
