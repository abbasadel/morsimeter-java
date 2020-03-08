package com.tahrirsquad.morsimeter.repositories;

import com.tahrirsquad.morsimeter.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
