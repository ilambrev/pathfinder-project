package bg.softuni.pathfinderproject.repository;

import bg.softuni.pathfinderproject.model.entity.CategoryEntity;
import bg.softuni.pathfinderproject.model.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    List<CategoryEntity> findByNameIn(List<CategoryNameEnum> categories);

    CategoryEntity findFirstByName(CategoryNameEnum category);
}