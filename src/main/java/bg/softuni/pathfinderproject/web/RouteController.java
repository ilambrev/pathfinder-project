package bg.softuni.pathfinderproject.web;

import bg.softuni.pathfinderproject.model.dto.RouteCreateDTO;
import bg.softuni.pathfinderproject.model.enums.CategoryNameEnum;
import bg.softuni.pathfinderproject.model.enums.RouteLevelEnum;
import bg.softuni.pathfinderproject.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

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

    @GetMapping("/add")
    public String addRoute(Model model) {
        model.addAttribute("routeLevels", RouteLevelEnum.values());
        model.addAttribute("routeCategories", CategoryNameEnum.values());
        return "add-route";
    }

    @PostMapping("/add")
    public String addRoute(RouteCreateDTO routeCreateDTO) throws IOException {
        this.routeService.createRoute(routeCreateDTO);
        return "redirect:/routes";
    }

    @GetMapping("/details/{id}")
    public String showRouteDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("routeDetails", this.routeService.getRouteById(id));

        return "route-details";
    }
}