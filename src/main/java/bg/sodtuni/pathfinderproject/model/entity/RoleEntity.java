package bg.sodtuni.pathfinderproject.model.entity;

import bg.sodtuni.pathfinderproject.model.enums.RoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private RoleEnum name;

    public RoleEntity() {

    }

    public RoleEnum getName() {
        return name;
    }

    public RoleEntity setName(RoleEnum name) {
        this.name = name;
        return this;
    }

}