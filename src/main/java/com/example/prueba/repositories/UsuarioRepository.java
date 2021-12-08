package com.example.prueba.repositories;

import java.util.ArrayList;

import com.example.prueba.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    public abstract UsuarioModel findByNombre(String nombre);

    @Query(value = "select u.* from usuario u inner join rol r on u.id_rol = r.id_rol where u.nombre like %:query% or r.nombre like %:query%", nativeQuery = true)
    ArrayList<UsuarioModel> findByNombreContaining(@Param("query") String query);

}