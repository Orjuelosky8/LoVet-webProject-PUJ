package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Mascota {
    
    private String nombre;
    private String raza;
    private int edad;
    private String imagen;
    private int permanencia;
    private int altura;
    private int peso;
    private String antecedentes;
    private String estado;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Cliente cliente;

    public Mascota( Long id, String nombre, String raza, int edad, String imagen, int permanencia, int altura, int peso, String antecedentes, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.imagen = imagen;
        this.permanencia = permanencia;
        this.altura = altura;
        this.peso = peso;
        this.antecedentes = antecedentes;
        this.estado = estado;
    }

    public Mascota( String nombre, String raza, int edad, String imagen, int permanencia, int altura, int peso, String antecedentes, String estado) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.imagen = imagen;
        this.permanencia = permanencia;
        this.altura = altura;
        this.peso = peso;
        this.antecedentes = antecedentes;
        this.estado = estado;
    }

    

    public Mascota() {
        
    }

    public int getPermanencia() {
        return permanencia;
    }


    public void setPermanencia(int permanencia) {
        this.permanencia = permanencia;
    }


    public int getAltura() {
        return altura;
    }


    public void setAltura(int altura) {
        this.altura = altura;
    }


    public int getPeso() {
        return peso;
    }


    public void setPeso(int peso) {
        this.peso = peso;
    }


    public String getAntecedentes() {
        return antecedentes;
    }


    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}

    


