package bg.softuni.pathfinderproject.service;

import bg.softuni.pathfinderproject.model.entity.CategoryEntity;
import bg.softuni.pathfinderproject.model.enums.CategoryNameEnum;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> getCategoriesByName(List<CategoryNameEnum> categories);
}