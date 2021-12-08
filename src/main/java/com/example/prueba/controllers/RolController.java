package com.example.prueba.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.prueba.models.RolModel;
import com.example.prueba.services.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/rol")
public class RolController {
    @Autowired
    RolService rolService;

    @GetMapping()
    public ArrayList<RolModel> obtenerRoles(){
        return rolService.obtenerRoles();
    }
}