package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    private String userName;
    private String password;
    private String especialidad;
    private Long numeroContacto;
    private String correo;

    @JsonIgnore
    @OneToMany(mappedBy = "veterinario")
    private Set<Tratamiento> tratamientos = new HashSet<>();

    
    
    public Veterinario(Long id, String nombres, String apellidos, String userName, String password, String especialidad,
            Long numeroContacto, String correo, Set<Tratamiento> tratamientos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.userName = userName;
        this.password = password;
        this.especialidad = especialidad;
        this.numeroContacto = numeroContacto;
        this.correo = correo;
        this.tratamientos = tratamientos;
    }    

    public Veterinario(String nombres, String apellidos, String userName, String password, String especialidad,
            Long numeroContacto, String correo, Set<Tratamiento> tratamientos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.userName = userName;
        this.password = password;
        this.especialidad = especialidad;
        this.numeroContacto = numeroContacto;
        this.correo = correo;
        this.tratamientos = tratamientos;
    }

    public Veterinario(Long id, String nombres, String apellidos, String especialidad, Long numeroContacto, String correo, Set<Tratamiento> tratamientos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.numeroContacto = numeroContacto;
        this.correo = correo;
        this.tratamientos = tratamientos;
    }

    public Veterinario(Long id, String nombres, String apellidos, String especialidad, Long numeroContacto,
            String correo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.numeroContacto = numeroContacto;
        this.correo = correo;
    }

    public Veterinario(String nombres, String apellidos, String especialidad, Long numeroContacto,
            String correo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.numeroContacto = numeroContacto;
        this.correo = correo;
    }


    public Veterinario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Long getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(Long numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Set<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(Set<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

}
