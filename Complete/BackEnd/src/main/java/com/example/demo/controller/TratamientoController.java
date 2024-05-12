package com.example.demo.controller;

import com.example.demo.model.Tratamiento;
import com.example.demo.service.TratamientoService;

import io.swagger.v3.oas.annotations.Operation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tratamientos")
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    private static final Logger logger = LoggerFactory.getLogger(MedsController.class);

    @PostMapping
    public Tratamiento addTratamiento(@RequestBody Tratamiento tratamiento) {
        logger.debug("\n\n   CARGANDO TRATAMIENTO. *******************************************************");
        return tratamientoService.saveTratamiento(tratamiento);
    }

    @GetMapping
    @Operation(summary = "Listar todos los tratamientos")
    public List<Tratamiento> getAllTratamientos() {
        logger.debug("\n\n AAAAAAAAAAAAAAAAAAAAAAAAAAA " + tratamientoService.getTratamientoById(1L).getMascota().getNombre());
        return tratamientoService.getAllTratamientos();
    }

    @GetMapping("/{id}")
    public Tratamiento getTratamientoById(@PathVariable Long id) {
        return tratamientoService.getTratamientoById(id);
    }

    @PutMapping("/{id}")
    public Tratamiento updateTratamiento(@RequestBody Tratamiento tratamiento, @PathVariable Long id) {
        tratamiento.setId(id);
        return tratamientoService.updateTratamiento(tratamiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTratamiento(@PathVariable Long id) {
        tratamientoService.deleteTratamiento(id);
        return ResponseEntity.ok("Tratamiento eliminado con éxito");
    }
}
