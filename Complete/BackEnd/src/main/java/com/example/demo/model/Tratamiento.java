package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Temporal(TemporalType.DATE)
    // private Date fechaInicio;

    // @Temporal(TemporalType.DATE)
    // private Date fechaFin;

    private String titulo, descripcion, estado;

    //@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    //@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;

    //@JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "tratamiento_medicamento",
        joinColumns = @JoinColumn(name = "tratamiento_id"),
        inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private Set<Medicamento> medicamentos = new HashSet<>();

    public Tratamiento(Long id, String titulo, String descripcion, String estado,
            Mascota mascota, Veterinario veterinario, Set<Medicamento> medicamentos) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.mascota = mascota;
        this.veterinario = veterinario;
        this.medicamentos = medicamentos;
    }

    

    public Tratamiento(Long id, String titulo, String descripcion, String estado, Mascota mascota,
        Veterinario veterinario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.mascota = mascota;
        this.veterinario = veterinario;
    }
    public Tratamiento(String titulo, String descripcion, String estado, Mascota mascota,
        Veterinario veterinario) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.mascota = mascota;
        this.veterinario = veterinario;
    }



    public Tratamiento() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Set<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Set<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

}
