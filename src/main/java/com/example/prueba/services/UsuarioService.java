package com.example.prueba.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.prueba.models.UsuarioModel;
import com.example.prueba.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }


    public UsuarioModel obtenerPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }


    public UsuarioModel actualizarUsuario(UsuarioModel usuario, Long id) {
        UsuarioModel userFind;
        userFind = usuarioRepository.findById(id).orElse(null);
        if(userFind != null){
            userFind.setNombre(usuario.getNombre());
            userFind.setEstado(usuario.getEstado());
            userFind.setRol(usuario.getRol());
        }else{
            return null;
        }
        return usuarioRepository.save(userFind);
    }
    
    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public ArrayList<UsuarioModel> obtenerUsuariosContentNombre(String query){
        return (ArrayList<UsuarioModel>) usuarioRepository.findByNombreContaining(query);
    }
    
}