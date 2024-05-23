package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Admin {

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    @Column(name = "NAME")
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
}
