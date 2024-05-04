package bg.softuni.pathfinderproject.service.impl;

import bg.softuni.pathfinderproject.model.dto.PictureCreateDTO;
import bg.softuni.pathfinderproject.model.entity.PictureEntity;
import bg.softuni.pathfinderproject.model.entity.RouteEntity;
import bg.softuni.pathfinderproject.model.entity.UserEntity;
import bg.softuni.pathfinderproject.repository.PictureRepository;
import bg.softuni.pathfinderproject.service.PictureService;
import bg.softuni.pathfinderproject.service.RouteService;
import bg.softuni.pathfinderproject.service.UserService;
import bg.softuni.pathfinderproject.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final RouteService routeService;
    private final UserService userService;
    private final CurrentUser currentUser;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, RouteService routeService, UserService userService, CurrentUser currentUser) {
        this.pictureRepository = pictureRepository;
        this.routeService = routeService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public boolean addPictureToRoute(PictureCreateDTO pictureCreateDTO, Long routeId) {
        RouteEntity route = routeService.getRouteById(routeId);
        UserEntity author = userService.getUserByUsername(currentUser.getUsername());

        PictureEntity picture = new PictureEntity()
                .setTitle(route.getName())
                .setUrl(pictureCreateDTO.getPictureUrl())
                .setAuthor(author)
                .setRoute(route);

        this.pictureRepository.save(picture);

        return true;
    }
}