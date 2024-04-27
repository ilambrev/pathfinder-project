package bg.softuni.pathfinderproject.service;

import bg.softuni.pathfinderproject.model.dto.RouteCreateDTO;
import bg.softuni.pathfinderproject.model.dto.RouteDTO;

import java.io.IOException;
import java.util.List;

public interface RouteService {

    List<RouteDTO> getAllRoutes();

    boolean createRoute(RouteCreateDTO routeCreateDTO) throws IOException;
}