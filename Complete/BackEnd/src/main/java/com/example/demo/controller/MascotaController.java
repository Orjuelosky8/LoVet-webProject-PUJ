package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

import com.example.demo.model.Mascota;
import com.example.demo.service.MascotaService;

@RestController
@RequestMapping("/mascotas")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {
    
    @Autowired
    MascotaService mascotaService;

    @GetMapping("/all")
    @Operation(summary = "Encuentra todos los Mascotas")
    public List<Mascota> mostrarMascotas() {
        return mascotaService.SearchAll();
    }

    // http://youtube.com/video/rock/canal/pepito/fecha/2022
    //http://youtube.com?video=rock&canal=pepito&fecha=2022

    // http://localhost:8090/mascota/find/1
    // http://localhost:8080/Mascota/find/1
    @GetMapping("/find/{id}")
    public Mascota mostrarInfoMascotas2(@PathVariable("id") Long id) {
        Mascota mascota = mascotaService.SearchById(id);
        return mascota;
    }

        // http://localhost:8090/mascota/find?id=1
    @GetMapping("/find")
    public Mascota mostrarInfoMascota(@RequestParam("id") Long id) {

        Mascota mascota = mascotaService.SearchById(id);

        return mascota;
    }



    @PostMapping("/add")
    public void agregarMascota(@RequestBody Mascota mascota){
        mascotaService.add(mascota);
    }

    //http://localhost:8090/delete/1
    @DeleteMapping("/delete/{id}")
    public void eliminarMascota(@PathVariable("id") Long id){
        mascotaService.deleteById(id);
    }

    @PostMapping("/update/{id}")
    public void actualizarMascota(@RequestBody Mascota mascota, @PathVariable("id") int id){
        mascotaService.update(mascota);
    }

}
