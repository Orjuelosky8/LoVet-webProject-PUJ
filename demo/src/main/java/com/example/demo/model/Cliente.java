package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Cliente {
    private String userName;
    private String password;
    private String correoElectronico;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String telefonoAux;
    private String estado;


    @Id
    @GeneratedValue
    private Long id;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mascota> mascotas = new ArrayList<>();

    
    public Cliente(Long id, String userName, String password, String correoElectronico, String nombres, String apellidos,
            String telefono, String telefonoAux, String estado) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.correoElectronico = correoElectronico;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.telefonoAux = telefonoAux;
        this.estado = estado;
    }

    public Cliente( String userName, String password, String correoElectronico, String nombres, String apellidos,
            String telefono, String telefonoAux, String estado) {
        this.userName = userName;
        this.password = password;
        this.correoElectronico = correoElectronico;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.telefonoAux = telefonoAux;
        this.estado = estado;
    }

    public Cliente() {
        
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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


    public String getCorreoElectronico() {
        return correoElectronico;
    }


    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getTelefonoAux() {
        return telefonoAux;
    }


    public void setTelefonoAux(String telefonoAux) {
        this.telefonoAux = telefonoAux;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
