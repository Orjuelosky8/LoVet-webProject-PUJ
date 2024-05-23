package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Admin;

public interface AdminService {
    Admin SearchById(Long id);
    Admin SearchByUserName(String userName);
    // Admin SearchByCorreo(String correo); // Añadir este método
    List<Admin> SearchAll();
    void deleteById(Long id);
    void update(Admin admin);
    void add(Admin admin);
}
