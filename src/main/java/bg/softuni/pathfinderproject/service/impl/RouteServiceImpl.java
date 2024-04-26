package bg.softuni.pathfinderproject.service.impl;

import bg.softuni.pathfinderproject.model.dto.RouteDTO;
import bg.softuni.pathfinderproject.model.entity.RouteEntity;
import bg.softuni.pathfinderproject.repository.RouteRepository;
import bg.softuni.pathfinderproject.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<RouteDTO> getAllRoutes() {

        List<RouteEntity> routes = this.routeRepository.findAll();

        return routes.stream().map(this::routeMapper).toList();
    }

    private RouteDTO routeMapper(RouteEntity routeEntity) {
        return new RouteDTO()
                .setPictureUrl(routeEntity.getPictureUrl())
                .setName(routeEntity.getName())
                .setDescription(routeEntity.getDescription())
                .setId(routeEntity.getId());
    }

}