package bg.sodtuni.pathfinderproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String loggedOutIndex() {

        return "index";
    }

    @GetMapping("/home")
    public String loggedInIndex() {

        return "index";
    }

}