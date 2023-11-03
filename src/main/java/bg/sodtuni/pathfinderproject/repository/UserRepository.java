package bg.sodtuni.pathfinderproject.repository;

import bg.sodtuni.pathfinderproject.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {



}