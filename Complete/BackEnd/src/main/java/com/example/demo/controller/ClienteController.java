package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @Autowired
    MascotaService mascotaService;

    @GetMapping("/all")
    @Operation(summary = "Listar todos los clientes")
    public List<Cliente> mostrarClientes() {
        return clienteService.SearchAll();
    }

    // http://youtube.com/video/rock/canal/pepito/fecha/2022
    // http://youtube.com?video=rock&canal=pepito&fecha=2022

    // http://localhost:8090/mascota/find/1
    @GetMapping("/find/{id}")
    public Cliente mostrarInfoCliente2(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.SearchById(id);
        return cliente;
    }

    // http://localhost:8090/mascota/find?id=1
    @GetMapping("/find")
    public Cliente mostrarInfoCliente(@RequestParam("id") Long id) {

        Cliente cliente = clienteService.SearchById(id);

        return cliente;
    }

    @PostMapping("/add")
    public void agregarCliente(@RequestBody Cliente Cliente){
        clienteService.add(Cliente);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarCliente(@PathVariable("id") Long id){
        clienteService.deleteById(id);
    }


    @PostMapping("/update/{id}")
    public void actualizarCliente(@RequestBody Cliente Cliente, @PathVariable("id") int id){
        clienteService.update(Cliente);
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
    
    // @GetMapping("/mascotas/{id}")
    // public String mostrarMascotasCliente(Model model, @PathVariable("id") Long identificacion, Cliente cliente) {
    //     model.addAttribute("mascotas", mascotaService.SearchByCliente(cliente));

    //     return "mostrar_mascotas_cliente";
    // }

    @GetMapping("/mascotas/{id}")
    public String mostrarMascotasCliente(Model model, @PathVariable("id") Long identificacion) {
        Cliente cliente = clienteService.SearchById(identificacion);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            model.addAttribute("mascotas", cliente.getMascotas());
            // model.addAttribute("id", identificacion); // Asegúrate de pasar el ID del cliente a la vista
        } else {
            return "paginaErrorMascotaNotfound";
        }
        return "mostrar_mascotas_cliente";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        Cliente cliente = new Cliente( "", "", "", "", "", "", "");

        model.addAttribute("cliente", cliente);
        return "Login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String password, RedirectAttributes redirectAttributes) {
        Cliente cliente = clienteService.SearchByUserName(userName);

        if (cliente != null && cliente.getPassword().equals(password)) {
            redirectAttributes.addAttribute("id", cliente.getId());
            return "redirect:/clientes/mascotas/{id}";
        } else {
            // No es necesario el uso de model aquí, RedirectAttributes puede manejar esto.
            redirectAttributes.addFlashAttribute("error", "Usuario o contraseña incorrectos");
            return "redirect:/clientes/login"; // Asegúrate de tener una ruta mapeada para "/login" que muestre la página de login.
        }
    }
    
}
