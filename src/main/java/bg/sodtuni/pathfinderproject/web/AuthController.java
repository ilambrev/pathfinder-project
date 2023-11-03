package bg.sodtuni.pathfinderproject.web;

import bg.sodtuni.pathfinderproject.model.dto.UserRegistrationDTO;
import bg.sodtuni.pathfinderproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String loadRegisterForm(Model model) {

        if (!model.containsAttribute("userRegistrationDTO")) {
            model.addAttribute("userRegistrationDTO", new UserRegistrationDTO());
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(UserRegistrationDTO userRegistrationDTO) {

        this.userService.registerUser(userRegistrationDTO);

        return "redirect: /users/login";
    }

}