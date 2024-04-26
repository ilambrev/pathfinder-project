package bg.softuni.pathfinderproject.repository;

import bg.softuni.pathfinderproject.model.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {

}