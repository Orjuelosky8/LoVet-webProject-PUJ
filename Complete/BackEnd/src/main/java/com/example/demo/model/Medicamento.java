package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Medicamento {
    private String nombre;
    private String laboratorio;
    private String descripcion;
    private String clasificacion;
    private Double precio;
    private String dosis;
    private Integer stock;
    private String indicacionesAdicionales;

    @Id
    @GeneratedValue
    private Long id;
    
    

    public Medicamento(String nombre, String laboratorio, String descripcion, String clasificacion, Double precio, String dosis,
            Integer stock, Long id, String indicacionesAdicionales) {
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.descripcion = descripcion;
        this.clasificacion = clasificacion;
        this.precio = precio;
        this.dosis = dosis;
        this.stock = stock;
        this.id = id;
        this.indicacionesAdicionales = indicacionesAdicionales;
    }

    public Medicamento() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getIndicacionesAdicionales() {
        return indicacionesAdicionales;
    }

    public void setIndicacionesAdicionales(String indicacionesAdicionales) {
        this.indicacionesAdicionales = indicacionesAdicionales;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }


}
