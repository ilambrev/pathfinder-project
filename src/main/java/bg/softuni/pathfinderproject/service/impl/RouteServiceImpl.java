package bg.softuni.pathfinderproject.service.impl;

import bg.softuni.pathfinderproject.exception.RouteNotFoundException;
import bg.softuni.pathfinderproject.model.dto.RouteCreateDTO;
import bg.softuni.pathfinderproject.model.dto.RouteDTO;
import bg.softuni.pathfinderproject.model.dto.RouteDetailsDTO;
import bg.softuni.pathfinderproject.model.entity.CategoryEntity;
import bg.softuni.pathfinderproject.model.entity.PictureEntity;
import bg.softuni.pathfinderproject.model.entity.RouteEntity;
import bg.softuni.pathfinderproject.model.entity.UserEntity;
import bg.softuni.pathfinderproject.model.enums.CategoryNameEnum;
import bg.softuni.pathfinderproject.repository.RouteRepository;
import bg.softuni.pathfinderproject.service.CategoryService;
import bg.softuni.pathfinderproject.service.RouteService;
import bg.softuni.pathfinderproject.service.UserService;
import bg.softuni.pathfinderproject.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CurrentUser currentUser;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, UserService userService, CategoryService categoryService, CurrentUser currentUser) {
        this.routeRepository = routeRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.currentUser = currentUser;
    }

    @Override
    public List<RouteDTO> getAllRoutes() {

        List<RouteEntity> routes = this.routeRepository.findAll();

        return routes.stream().map(this::routeMapper).toList();
    }

    @Override
    public boolean createRoute(RouteCreateDTO routeCreateDTO) throws IOException {

        UserEntity author = this.userService.getUserByUsername(this.currentUser.getUsername());

        String videoUrl = routeCreateDTO.getVideoUrl();

        if (videoUrl.length() > 11) {
            videoUrl = videoUrl.substring(videoUrl.length() - 11);
        }

        RouteEntity route = new RouteEntity()
                .setDescription(routeCreateDTO.getDescription())
                .setGpxCoordinates(new String(routeCreateDTO.getGpxCoordinates().getBytes(), StandardCharsets.UTF_8).trim())
                .setLevel(routeCreateDTO.getLevel())
                .setName(routeCreateDTO.getName())
                .setVideoUrl(videoUrl)
                .setAuthor(author)
                .setCategories(this.categoryService.getCategoriesByName(routeCreateDTO.getCategories()));

        this.routeRepository.save(route);

        return true;
    }

    @Override
    public RouteEntity getRouteById(Long id) {
        return this.routeRepository.findById(id).orElseThrow(() -> new RouteNotFoundException("Route with id: " + id + "not found!"));
    }

    @Override
    public RouteDetailsDTO getRouteDetailsById(Long id) {
        Optional<RouteEntity> routeOptional = this.routeRepository.findById(id);

        RouteEntity route = new RouteEntity();

        if (routeOptional.isPresent()) {
            route = routeOptional.get();
        }

        return new RouteDetailsDTO()
                .setId(route.getId())
                .setName(route.getName())
                .setTotalDistance(1)
                .setAuthorName(route.getAuthor().getFullName())
                .setLevel(route.getLevel())
                .setVideoUrl(route.getVideoUrl())
                .setDescription(route.getDescription())
                .setPictures(route.getPictures().stream().map(PictureEntity::getUrl).toList());
    }

    @Override
    public List<RouteDTO> getRoutesByCategory(CategoryNameEnum categoryName) {
        CategoryEntity category = this.categoryService.getCategoryByName(categoryName);

        List<RouteEntity> routes = this.routeRepository.findAllByCategoriesContaining(category);

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