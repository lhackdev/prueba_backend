package com.example.prueba.models;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class RolModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_rol;

    private String nombre;

    public Long getId() {
        return id_rol;
    }

    public void setId(Long id) {
        this.id_rol = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
}