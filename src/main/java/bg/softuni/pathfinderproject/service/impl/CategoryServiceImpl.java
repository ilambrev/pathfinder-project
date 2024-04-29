package bg.softuni.pathfinderproject.service.impl;

import bg.softuni.pathfinderproject.model.entity.CategoryEntity;
import bg.softuni.pathfinderproject.model.enums.CategoryNameEnum;
import bg.softuni.pathfinderproject.repository.CategoryRepository;
import bg.softuni.pathfinderproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryEntity> getCategoriesByName(List<CategoryNameEnum> categories) {
        return this.categoryRepository.findByNameIn(categories);
    }

    @Override
    public CategoryEntity getCategoryByName(CategoryNameEnum category) {
        return  this.categoryRepository.findFirstByName(category);
    }
}