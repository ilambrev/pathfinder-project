package bg.softuni.pathfinderproject.web;

import bg.softuni.pathfinderproject.model.dto.PictureCreateDTO;
import bg.softuni.pathfinderproject.model.dto.RouteCreateDTO;
import bg.softuni.pathfinderproject.model.enums.CategoryNameEnum;
import bg.softuni.pathfinderproject.model.enums.RouteLevelEnum;
import bg.softuni.pathfinderproject.service.PictureService;
import bg.softuni.pathfinderproject.service.RouteService;
import bg.softuni.pathfinderproject.util.CurrentUser;
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
    private final PictureService pictureService;
    private final CurrentUser currentUser;

    @Autowired
    public RouteController(RouteService routeService, PictureService pictureService, CurrentUser currentUser) {
        this.routeService = routeService;
        this.pictureService = pictureService;
        this.currentUser = currentUser;
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
        model.addAttribute("routeDetails", this.routeService.getRouteDetailsById(id));

        return "route-details";
    }

    @PostMapping("/details/{id}/picture/add")
//    @PostMapping("/details/{id}")
    public String addPictureToRoute(@PathVariable("id") Long routeId, PictureCreateDTO pictureCreateDTO) {
        this.pictureService.addPictureToRoute(pictureCreateDTO, routeId);

        return "redirect:/routes/details/{id}";
    }

    @GetMapping("/pedestrian")
    public String showPedestrianRoutes(Model model) {
        model.addAttribute("pedestrianRoutes", this.routeService.getRoutesByCategory(CategoryNameEnum.PEDESTRIAN));

        return "pedestrian";
    }

    @GetMapping("/bicycle")
    public String showBicycleRoutes(Model model) {
        model.addAttribute("bicycleRoutes", this.routeService.getRoutesByCategory(CategoryNameEnum.BICYCLE));

        return "bicycle";
    }

    @GetMapping("/motorcycle")
    public String showMotorcycleRoutes(Model model) {
        model.addAttribute("motorcycleRoutes", this.routeService.getRoutesByCategory(CategoryNameEnum.MOTORCYCLE));

        return "motorcycle";
    }

    @GetMapping("/car")
    public String showCarRoutes(Model model) {
        model.addAttribute("carRoutes", this.routeService.getRoutesByCategory(CategoryNameEnum.CAR));

        return "car";
    }
}