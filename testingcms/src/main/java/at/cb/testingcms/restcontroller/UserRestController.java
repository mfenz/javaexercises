package at.cb.testingcms.restcontroller;

import at.cb.testingcms.model.User;
import at.cb.testingcms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("")
    public List<User> getUsers(){
        // User laden
        List<User> users = userService.getUsers();

        return users;
    }

    @GetMapping("/{id}")
    public User getUser(
            @PathVariable int id
    ){
        // User mit der ID laden
        User user = userService.getUser(id);
        return user;
    }

}
