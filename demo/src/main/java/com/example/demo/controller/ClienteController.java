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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String mostrarInfoCliente(Model model, @PathVariable("id") Long identificacion) {
        Cliente cliente = clienteService.SearchById(identificacion);

        if (cliente != null) {
            model.addAttribute("cliente", clienteService.SearchById(identificacion));
        } else {
            //throw new NotFoundException(identificacion);
        }
        return "mostrar_cliente";
    }

    // http://localhost:8090/mascota/find?id=1
    @GetMapping("/find")
    public String mostrarInfoCliente2(Model model, @RequestParam("id") Long identificacion) {

        model.addAttribute("cliente", clienteService.SearchById(identificacion));
        return "mostrar_cliente";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {
        Cliente cliente = new Cliente( "", "", "", "", "", "", "");

        model.addAttribute("cliente", cliente);

        return "crear_cliente";
    }

    @PostMapping("/agregar")
    public String agregarEstudiante(@ModelAttribute("cliente") Cliente cliente) {

        clienteService.add(cliente);
        return "redirect:/clientes/all";
    }

    @GetMapping("/delete/{id}")
    public String borrarCliente(@PathVariable("id") Long identificacion) {
        clienteService.deleteById(identificacion);
        return "redirect:/clientes/all";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.SearchById(id));
        return "modificar_cliente";
    }

    @PostMapping("/update/{id}")
    public String updateCliente(@PathVariable("id") Long identificacion, @ModelAttribute("clientexx") Cliente cliente) {

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
    
    // @GetMapping("/mascotas/{id}")
    // public String mostrarMascotasCliente(Model model, @PathVariable("id") Long identificacion, Cliente cliente) {
    //     model.addAttribute("mascotas", mascotaService.SearchByCliente(cliente));

    //     return "mostrar_mascotas_cliente";
    // }

    @GetMapping("/mascotas/{id}")
    public String mostrarMascotasCliente(Model model, @PathVariable("id") Long identificacion) {
        Cliente cliente = clienteService.SearchById(identificacion);
        if (cliente != null) {
            model.addAttribute("mascotas", cliente.getMascotas());
            model.addAttribute("id", identificacion); // Asegúrate de pasar el ID del cliente a la vista
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
