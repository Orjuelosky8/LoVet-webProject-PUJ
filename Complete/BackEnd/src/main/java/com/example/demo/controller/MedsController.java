package com.example.demo.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Medicamento;
import com.example.demo.service.MedicamentoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/medicamentos")
@CrossOrigin(origins = "http://localhost:4200") // Ajusta según sea necesario para tus necesidades de CORS
public class MedsController {
    private final MedicamentoService medicamentoService;
    private static final Logger logger = LoggerFactory.getLogger(MedsController.class);

    public MedsController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping("/cargar")
    public ResponseEntity<String> cargarDatos() {
        logger.debug("\n\n ***   Iniciando la carga de datos...");
        try {
            medicamentoService.saveMedsToDatabase();
            logger.debug("\n\n ***   Datos cargados exitosamente.");
            return ResponseEntity.ok("Datos cargados exitosamente");
        } catch (Exception e) {
            logger.error("\n\n ***   Error al cargar datos", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al cargar datos: " + e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Medicamento>> listarMedicamentos() {
        medicamentoService.saveMedsToDatabase();
        logger.debug("\n\n ***   Recuperando la lista de medicamentos...");
        List<Medicamento> meds = medicamentoService.getMeds();
        logger.debug("\n\n ***   Medicamentos recuperados correctamente.");
        return ResponseEntity.status(HttpStatus.OK).body(meds);
    }
}
