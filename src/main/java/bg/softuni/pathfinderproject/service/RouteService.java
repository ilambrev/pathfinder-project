package bg.softuni.pathfinderproject.service;

import bg.softuni.pathfinderproject.model.dto.RouteCreateDTO;
import bg.softuni.pathfinderproject.model.dto.RouteDTO;
import bg.softuni.pathfinderproject.model.dto.RouteDetailsDTO;
import bg.softuni.pathfinderproject.model.entity.RouteEntity;
import bg.softuni.pathfinderproject.model.enums.CategoryNameEnum;

import java.io.IOException;
import java.util.List;

public interface RouteService {

    List<RouteDTO> getAllRoutes();

    boolean createRoute(RouteCreateDTO routeCreateDTO) throws IOException;

    RouteEntity getRouteById(Long id);

    RouteDetailsDTO getRouteDetailsById(Long id);

    List<RouteDTO> getRoutesByCategory(CategoryNameEnum categoryName);
}