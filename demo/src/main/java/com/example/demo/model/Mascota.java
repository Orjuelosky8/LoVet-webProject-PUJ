package com.example.demo.model;

public class Mascota {
    
    private int id;
    private String nombre;
    private String raza;
    private int edad;
    private String imagen;
    private int permanencia;
    private int altura;
    private int peso;
    private String antecedentes;


    public Mascota( int id, String nombre, String raza, int edad, String imagen, int permanencia, int altura, int peso, String antecedentes) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.imagen = imagen;
        this.permanencia = permanencia;
        this.altura = altura;
        this.peso = peso;
        this.antecedentes = antecedentes;
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    
        
}

    


