package com.example.prueba.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.prueba.models.UsuarioModel;
import com.example.prueba.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario, HttpServletResponse response){
        UsuarioModel user = this.usuarioService.obtenerPorNombre(usuario.getNombre());
        if (user != null) {
            response.setStatus(419);
            return user;
        }
        response.setStatus(200);
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping( path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @PutMapping( path = "/{id}")
    public UsuarioModel actualizarUsuario(@PathVariable("id") Long id, @RequestBody UsuarioModel usuario, HttpServletResponse response){
        return this.usuarioService.actualizarUsuario(usuario, id);       
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuariosContentNombre(@RequestParam("nombre") String nombre){
        return this.usuarioService.obtenerUsuariosContentNombre(nombre);
    }

    @DeleteMapping( path = "/{id}")
    public void eliminarPorId(@PathVariable("id") Long id, HttpServletResponse response){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            response.setStatus(200);
        }else{
            response.setStatus(400);
        }
    }

}