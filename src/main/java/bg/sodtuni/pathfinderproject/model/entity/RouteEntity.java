package bg.sodtuni.pathfinderproject.model.entity;

import bg.sodtuni.pathfinderproject.model.enums.RouteLevelEnum;
import jakarta.persistence.*;

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

    public RouteEntity() {

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

}