package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Tratamiento;
import com.example.demo.repository.TratamientoRepository;

@Service
public class TratamientoService {
    @Autowired
    private TratamientoRepository tratamientoRepository;

    public Tratamiento saveTratamiento(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    public List<Tratamiento> getAllTratamientos() {
        return tratamientoRepository.findAll();
    }

    public Tratamiento getTratamientoById(Long id) {
        return tratamientoRepository.findById(id).orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));
    }

    public Tratamiento updateTratamiento(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    public void deleteTratamiento(Long id) {
        tratamientoRepository.deleteById(id);
    }
}
