package docker.controller;

import docker.entity.User;
import docker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup.html";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        userService.save(user);
        return "registration_success";
    }

    /**
     * This
     * @param model will
     * @return list of users
     */
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userService.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }
}
