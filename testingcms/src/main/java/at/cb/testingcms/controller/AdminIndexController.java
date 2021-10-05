package at.cb.testingcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminIndexController {

    // URL: /admin/
    @GetMapping("/")
    public String displayAdminIndexGet(){
        return "admin/index";
    }

}
