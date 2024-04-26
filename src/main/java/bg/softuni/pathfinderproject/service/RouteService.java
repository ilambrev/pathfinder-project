package bg.softuni.pathfinderproject.service;

import bg.softuni.pathfinderproject.model.dto.RouteDTO;

import java.util.List;

public interface RouteService {
    List<RouteDTO> getAllRoutes();
}