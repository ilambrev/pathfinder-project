package bg.softuni.pathfinderproject.model.dto;

import bg.softuni.pathfinderproject.model.enums.CategoryNameEnum;
import bg.softuni.pathfinderproject.model.enums.RouteLevelEnum;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class RouteCreateDTO {

    private String name;

    private String description;

    private MultipartFile gpxCoordinates;

    private RouteLevelEnum level;

    private String videoUrl;

    private List<CategoryNameEnum> categories;

    public RouteCreateDTO() {
        this.categories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public RouteCreateDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteCreateDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteCreateDTO setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public RouteLevelEnum getLevel() {
        return level;
    }

    public RouteCreateDTO setLevel(RouteLevelEnum level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteCreateDTO setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public List<CategoryNameEnum> getCategories() {
        return categories;
    }

    public RouteCreateDTO setCategories(List<CategoryNameEnum> categories) {
        this.categories = categories;
        return this;
    }
}