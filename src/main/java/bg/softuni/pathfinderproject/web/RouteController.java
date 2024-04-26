package bg.softuni.pathfinderproject.web;

import bg.softuni.pathfinderproject.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public String showAllRoutes(Model model) {
        model.addAttribute("routes", this.routeService.getAllRoutes());
        return "routes";
    }
}