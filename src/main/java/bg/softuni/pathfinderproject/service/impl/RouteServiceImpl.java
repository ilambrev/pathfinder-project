package bg.softuni.pathfinderproject.service.impl;

import bg.softuni.pathfinderproject.model.dto.RouteCreateDTO;
import bg.softuni.pathfinderproject.model.dto.RouteDTO;
import bg.softuni.pathfinderproject.model.entity.RouteEntity;
import bg.softuni.pathfinderproject.model.entity.UserEntity;
import bg.softuni.pathfinderproject.repository.RouteRepository;
import bg.softuni.pathfinderproject.service.RouteService;
import bg.softuni.pathfinderproject.service.UserService;
import bg.softuni.pathfinderproject.util.CurrentUser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final UserService userService;
    private final CurrentUser currentUser;

    public RouteServiceImpl(RouteRepository routeRepository, UserService userService, CurrentUser currentUser) {
        this.routeRepository = routeRepository;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public List<RouteDTO> getAllRoutes() {

        List<RouteEntity> routes = this.routeRepository.findAll();

        return routes.stream().map(this::routeMapper).toList();
    }

    @Override
    public boolean createRoute(RouteCreateDTO routeCreateDTO) throws IOException {

        Optional<UserEntity> authorOptional = this.userService.getUserById(this.currentUser.getId());

        UserEntity author = new UserEntity();

        if (authorOptional.isPresent()) {
            author = authorOptional.get();
        }

        RouteEntity route = new RouteEntity()
                .setDescription(routeCreateDTO.getDescription())
                .setGpxCoordinates(new String(routeCreateDTO.getGpxCoordinates().getBytes(), StandardCharsets.UTF_8).trim())
                .setLevel(routeCreateDTO.getLevel())
                .setName(routeCreateDTO.getName())
                .setVideoUrl(routeCreateDTO.getVideoUrl().replace("https://www.youtube.com/watch?v=", ""))
                .setAuthor(author);

        this.routeRepository.save(route);

        return true;
    }

    private RouteDTO routeMapper(RouteEntity routeEntity) {
        return new RouteDTO()
                .setPictureUrl(routeEntity.getPictureUrl())
                .setName(routeEntity.getName())
                .setDescription(routeEntity.getDescription())
                .setId(routeEntity.getId());
    }

}