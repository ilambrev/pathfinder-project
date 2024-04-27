package bg.softuni.pathfinderproject.service;

import bg.softuni.pathfinderproject.model.entity.CategoryEntity;
import bg.softuni.pathfinderproject.model.enums.CategoryNameEnum;

public interface CategoryService {

    CategoryEntity getCategoryByName(CategoryNameEnum name);
}