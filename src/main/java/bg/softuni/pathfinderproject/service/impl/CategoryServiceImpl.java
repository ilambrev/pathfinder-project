package bg.softuni.pathfinderproject.service.impl;

import bg.softuni.pathfinderproject.model.entity.CategoryEntity;
import bg.softuni.pathfinderproject.model.enums.CategoryNameEnum;
import bg.softuni.pathfinderproject.repository.CategoryRepository;
import bg.softuni.pathfinderproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryEntity getCategoryByName(CategoryNameEnum name) {
        return this.categoryRepository.getFirstByName(name);
    }
}