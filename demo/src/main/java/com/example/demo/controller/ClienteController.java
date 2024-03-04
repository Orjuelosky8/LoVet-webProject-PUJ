package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;

@RequestMapping("/clientes")
@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @Autowired
    MascotaService mascotaService;

    @GetMapping("/all")
    public String mostrarClientes(Model model) {
        model.addAttribute("clientes", clienteService.SearchAll());
        return "mostrar_todos_clientes";
    }

    // http://youtube.com/video/rock/canal/pepito/fecha/2022
    // http://youtube.com?video=rock&canal=pepito&fecha=2022

    // http://localhost:8090/mascota/find/1
    @GetMapping("/find/{id}")
    public String mostrarInfoCliente(Model model, @PathVariable("id") int identificacion) {
        Cliente cliente = clienteService.SearchById(identificacion);

        if (cliente != null) {
            model.addAttribute("cliente", clienteService.SearchById(identificacion));
        } else {
            throw new NotFoundException(identificacion);
        }
        return "mostrar_cliente";
    }

    // http://localhost:8090/mascota/find?id=1
    @GetMapping("/find")
    public String mostrarInfoCliente2(Model model, @RequestParam("id") int identificacion) {

        model.addAttribute("cliente", clienteService.SearchById(identificacion));
        return "mostrar_cliente";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        Cliente cliente = new Cliente(1, "", "", "", "", "", "", "", new ArrayList<>());

        model.addAttribute("cliente", cliente);

        return "crear_cliente";
    }

    @PostMapping("/agregar")
    public String agregarEstudiante(@ModelAttribute("cliente") Cliente cliente) {

        clienteService.add(cliente);
        return "redirect:/clientes/all";
    }

    @GetMapping("/delete/{id}")
    public String borrarCliente(@PathVariable("id") int identificacion) {
        clienteService.deleteById(identificacion);
        return "redirect:/clientes/all";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("cliente", clienteService.SearchById(id));
        return "modificar_cliente";
    }

    @PostMapping("/update/{id}")
    public String updateCliente(@PathVariable("id") int identificacion, @ModelAttribute("clientexx") Cliente cliente) {

        clienteService.update(cliente);
        return "redirect:/clientes/all";
    }

    // @GetMapping("/{id}/mascotas")
    // public String mostrarMascotasCliente(Model model, @PathVariable("id") int
    // identificacion){
    // Cliente cliente = clienteService.SearchById(identificacion);
    // List<Integer> mascotas = cliente.getIdMascotas();
    // for (Integer mascota : mascotas) {
    // model.addAttribute("mascota", mascota);
    // }
    // return "mostrar_mascotas_cliente";
    // }
    @GetMapping("/mascotas/{id}")
    public String mostrarMascotasCliente(Model model, @PathVariable("id") int identificacion) {
        Cliente cliente = clienteService.SearchById(identificacion);
        List<Integer> mascotasIds = cliente.getIdMascotas();
        List<Mascota> mascotas = new ArrayList<>(); 

        // Itera sobre los IDs de las mascotas y busca cada mascota por su ID
        for (Integer mascotaId : mascotasIds) {
            Mascota mascota = mascotaService.SearchById(mascotaId);
            mascotas.add(mascota); 
        }

        model.addAttribute("mascotas", mascotas);

        return "mostrar_mascotas_cliente";
    }

}
