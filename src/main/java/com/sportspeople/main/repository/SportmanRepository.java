package com.sportspeople.main.repository;

import org.springframework.data.repository.CrudRepository;
import com.sportspeople.main.models.SportMan;

public interface SportmanRepository extends CrudRepository<SportMan, Integer> {

}