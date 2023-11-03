package bg.sodtuni.pathfinderproject.repository;

import bg.sodtuni.pathfinderproject.model.entity.RoleEntity;
import bg.sodtuni.pathfinderproject.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByName(RoleEnum roleName);

}