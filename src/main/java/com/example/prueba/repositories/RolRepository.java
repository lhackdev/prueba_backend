package com.example.prueba.repositories;

import java.util.ArrayList;

import com.example.prueba.models.RolModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository<RolModel, Long> {
}