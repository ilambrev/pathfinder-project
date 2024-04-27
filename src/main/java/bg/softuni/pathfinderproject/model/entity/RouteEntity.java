package bg.softuni.pathfinderproject.model.entity;

import bg.softuni.pathfinderproject.model.enums.RouteLevelEnum;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
public class RouteEntity extends BaseEntity {

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private RouteLevelEnum level;

    @Column(name = "name")
    private String name;

    @Column(name = "video_url")
    private String videoUrl;

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private UserEntity author;

    @ManyToMany(targetEntity = CategoryEntity.class, fetch = FetchType.EAGER)
    @JoinTable(name = "routes_categories", joinColumns = @JoinColumn(name = "route_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private List<CategoryEntity> categories;

    @OneToMany(targetEntity = PictureEntity.class, mappedBy = "route", fetch = FetchType.EAGER)
    private List<PictureEntity> pictures;

    public RouteEntity() {
        this.categories = new ArrayList<>();
        this.pictures = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public RouteEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteEntity setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public RouteLevelEnum getLevel() {
        return level;
    }

    public RouteEntity setLevel(RouteLevelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteEntity setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public RouteEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public RouteEntity setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
        return this;
    }

    public List<PictureEntity> getPictures() {
        return pictures;
    }

    public RouteEntity setPictures(List<PictureEntity> pictures) {
        this.pictures = pictures;
        return this;
    }

    public String getPictureUrl() {
        return this.pictures.isEmpty() ? "" : this.pictures.get(0).getUrl();
    }
}