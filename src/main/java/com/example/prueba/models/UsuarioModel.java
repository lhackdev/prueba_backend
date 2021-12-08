package com.example.prueba.models;

import javax.persistence.*;
import com.example.prueba.models.RolModel;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_usuario;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RolModel rol;

    private String nombre;
    private Character estado;

    public Long getId() {
        return id_usuario;
    }

    public void setId(Long id) {
        this.id_usuario = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public RolModel getRol() {
        return rol;
    }

    public void setRol(RolModel rol) {
        this.rol = rol;
    }
    
}