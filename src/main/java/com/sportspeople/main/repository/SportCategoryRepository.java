package com.sportspeople.main.repository;

import org.springframework.data.repository.CrudRepository;
import com.sportspeople.main.models.SportCategory;

public interface SportCategoryRepository extends CrudRepository<SportCategory, Integer> {

}