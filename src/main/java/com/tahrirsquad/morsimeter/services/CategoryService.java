package com.tahrirsquad.morsimeter.services;

import com.tahrirsquad.morsimeter.model.Category;
import com.tahrirsquad.morsimeter.model.PromiseStats;
import com.tahrirsquad.morsimeter.repositories.CategoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Map<Category, PromiseStats> categoryStats(){
        return this.findAll().stream()
                .collect(
                        Collectors.toMap(c -> c, c -> PromiseStats.create(c.getPromises()), (o, n) -> n,  TreeMap::new)
                );
    }
}
