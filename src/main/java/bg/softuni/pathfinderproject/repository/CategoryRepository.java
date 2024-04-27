package bg.softuni.pathfinderproject.repository;

import bg.softuni.pathfinderproject.model.entity.CategoryEntity;
import bg.softuni.pathfinderproject.model.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    CategoryEntity getFirstByName(CategoryNameEnum name);
}