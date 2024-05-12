package com.example.demo.service;

import com.example.demo.model.Veterinario;
import com.example.demo.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public Veterinario saveVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    public List<Veterinario> getAllVeterinarios() {
        return veterinarioRepository.findAll();
    }

    public Veterinario getVeterinarioById(Long id) {
        return veterinarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));
    }

    public Veterinario updateVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    public void deleteVeterinario(Long id) {
        veterinarioRepository.deleteById(id);
    }
}