package bg.softuni.pathfinderproject.web;

import bg.softuni.pathfinderproject.model.dto.UserLoginDTO;
import bg.softuni.pathfinderproject.model.dto.UserRegistrationDTO;
import bg.softuni.pathfinderproject.service.UserService;
import bg.softuni.pathfinderproject.util.CurrentUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class AuthController {

    private final UserService userService;
    private final CurrentUser currentUser;

    @Autowired
    public AuthController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping("/register")
    public String loadRegisterForm(Model model) {

        if (!model.containsAttribute("userRegistrationDTO")) {
            model.addAttribute("userRegistrationDTO", new UserRegistrationDTO());
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegistrationDTO userRegistrationDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO", bindingResult);

            return "redirect:/users/register";
        }

        this.userService.registerUser(userRegistrationDTO);

        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String loadLoginForm(Model model) {

        if (!model.containsAttribute("userLoginDTO")) {
            model.addAttribute("userLoginDTO", new UserLoginDTO());
        }

        if (!model.containsAttribute("badCredentials")) {
            model.addAttribute("badCredentials", false);
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginUser(UserLoginDTO userLoginDTO, RedirectAttributes redirectAttributes) {

        if (!this.userService.loginUser(userLoginDTO)) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);

            return "redirect:/users/login";
        }

        return "redirect:/home";
    }

    @PostMapping("/logout")
    public String logout() {
        this.userService.logOutUser();

        return "redirect:/";
    }

    @GetMapping("/profile")
    public String showProfile() {

        return "/profile";
    }

}