package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Admin {
    private String userName;
    private String password;
    private String correoElectronico;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String telefonoAux;


    @Id
    @GeneratedValue
    private Long id;

    
    public Admin(Long id, String userName, String password, String correoElectronico, String nombres, String apellidos,
            String telefono, String telefonoAux) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.correoElectronico = correoElectronico;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.telefonoAux = telefonoAux;
    }

    public Admin( String userName, String password, String correoElectronico, String nombres, String apellidos,
            String telefono, String telefonoAux) {
        this.userName = userName;
        this.password = password;
        this.correoElectronico = correoElectronico;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.telefonoAux = telefonoAux;
    }

    public Admin() {
        
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
}
