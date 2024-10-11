package com.sportspeople.main.repository;

import org.springframework.data.repository.CrudRepository;
import com.sportspeople.main.models.Medal;

public interface MedalsRepository extends CrudRepository<Medal, Integer> {

}