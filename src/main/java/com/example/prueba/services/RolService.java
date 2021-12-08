package com.example.prueba.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.prueba.models.RolModel;
import com.example.prueba.repositories.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    @Autowired
    RolRepository rolRepository;
    
    public ArrayList<RolModel> obtenerRoles(){
        return (ArrayList<RolModel>) rolRepository.findAll();
    }
}