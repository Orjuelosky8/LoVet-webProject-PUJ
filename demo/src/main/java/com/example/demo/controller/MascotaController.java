package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.errorHandling.NotFoundException;
import com.example.demo.model.Mascota;
import com.example.demo.service.MascotaService;

@RequestMapping("/mascotas")
@Controller
public class MascotaController {
    
    @Autowired
    MascotaService mascotaService;

    @GetMapping("/all")
    public String mostrarMascotas(Model model){
        model.addAttribute("mascotas", mascotaService.SearchAll());
        return "mostrar_todas_mascotas";
    }

    // http://youtube.com/video/rock/canal/pepito/fecha/2022
    //http://youtube.com?video=rock&canal=pepito&fecha=2022

    // http://localhost:8090/mascota/find/1
    @GetMapping("/find/{id}")
    public String mostrarInfoMascota(Model model, @PathVariable("id") int identificacion){
        Mascota mascota = mascotaService.SearchById(identificacion);

        if(mascota!=null){
            model.addAttribute("mascota", mascotaService.SearchById(identificacion));
        }else{
            throw new NotFoundException(identificacion);
        }
        return "mostrar_mascota";
    }

        // http://localhost:8090/mascota/find?id=1
    @GetMapping("/find")
    public String mostrarInfoMascota2(Model model, @RequestParam("id") int identificacion){

        model.addAttribute("mascota", mascotaService.SearchById(identificacion));
        return "mostrar_mascota";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        
        Mascota mascota = new Mascota( 0, "", "", 0, "", 0, 0, 0, "");

        model.addAttribute("mascota", mascota);

        return "crear_mascota";
    }


    @PostMapping("/agregar")
    public String agregarEstudiante(@ModelAttribute("mascota") Mascota mascota) {

        mascotaService.add(mascota);
        return "redirect:/mascotas/all";
    }

    @GetMapping("/delete/{id}")
    public String borrarMascota(@PathVariable("id") int identificacion) {
        mascotaService.deleteById(identificacion);
        return "redirect:/mascotas/all";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "modificar_mascota";
    }

    @PostMapping("/update/{id}")
    public String updateMascota(@PathVariable("id") int identificacion, @ModelAttribute("mascotaxx") Mascota mascota) {

        mascotaService.update(mascota);
        return "redirect:/mascotas/all";
    }

}
