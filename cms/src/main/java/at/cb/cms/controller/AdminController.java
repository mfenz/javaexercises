package at.cb.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// /admin/

@Controller
@RequestMapping("/admin/") // alle Methoden beginnen mit /admin/ beim Link
public class AdminController {

    // Abrufbar unter /admin/
    @GetMapping("")
    public String adminOverviewGet(){
        return "admin/admin_index";
    }

    //  /admin/createarticle
    @GetMapping("createarticle")
    public String createArticleGet(){
        return "";
    }

}
