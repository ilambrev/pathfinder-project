package bg.sodtuni.pathfinderproject.model.entity;

import bg.sodtuni.pathfinderproject.model.enums.CategoryNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private CategoryNameEnum name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public CategoryEntity() {

    }

    public CategoryNameEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }

}