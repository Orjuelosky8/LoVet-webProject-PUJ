package com.example.demo.controller;

import com.example.demo.model.Veterinario;
import com.example.demo.service.VeterinarioService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @PostMapping
    public Veterinario addVeterinario(@RequestBody Veterinario veterinario) {
        return veterinarioService.saveVeterinario(veterinario);
    }

    @GetMapping
    @Operation(summary = "Listar todos los veterinarios")
    public List<Veterinario> getAllVeterinarios() {
        return veterinarioService.getAllVeterinarios();
    }

    @GetMapping("/{id}")
    public Veterinario getVeterinarioById(@PathVariable Long id) {
        return veterinarioService.getVeterinarioById(id);
    }

    @PutMapping("/{id}")
    public Veterinario updateVeterinario(@RequestBody Veterinario veterinario, @PathVariable Long id) {
        veterinario.setId(id);
        return veterinarioService.updateVeterinario(veterinario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVeterinario(@PathVariable Long id) {
        veterinarioService.deleteVeterinario(id);
        return ResponseEntity.ok("Veterinario eliminado con éxito");
    }
}
