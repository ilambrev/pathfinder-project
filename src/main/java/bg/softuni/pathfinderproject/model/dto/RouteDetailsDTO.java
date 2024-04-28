package bg.softuni.pathfinderproject.model.dto;

import bg.softuni.pathfinderproject.model.entity.PictureEntity;
import bg.softuni.pathfinderproject.model.enums.RouteLevelEnum;

import java.util.ArrayList;
import java.util.List;

public class RouteDetailsDTO {

    private String name;

    private String authorName;

    private String description;

    private int totalDistance;

    private RouteLevelEnum level;

    private String videoUrl;

    private List<String> pictures;

    public RouteDetailsDTO() {
        this.pictures = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public RouteDetailsDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public RouteDetailsDTO setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteDetailsDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public RouteDetailsDTO setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
        return this;
    }

    public RouteLevelEnum getLevel() {
        return level;
    }

    public RouteDetailsDTO setLevel(RouteLevelEnum level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteDetailsDTO setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public RouteDetailsDTO setPictures(List<String> pictures) {
        this.pictures = pictures;
        return this;
    }
}