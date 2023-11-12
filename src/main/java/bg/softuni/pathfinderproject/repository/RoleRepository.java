package bg.softuni.pathfinderproject.repository;

import bg.softuni.pathfinderproject.model.entity.RoleEntity;
import bg.softuni.pathfinderproject.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByName(RoleEnum roleName);

}