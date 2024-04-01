package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class LandingController {

    @GetMapping("/Inicio")
    public String inicio(){
        return "landingPage";
    }

    @GetMapping("/Experiencias")
    public String experiencias(){
        return "PaginaExperiencias";
    }

    @GetMapping("/Personal")
    public String personal(){
        return "PaginaPersonal";
    }

    @GetMapping("/Servicios")
    public String servicios(){
        return "PaginaServicios";
    }

}
