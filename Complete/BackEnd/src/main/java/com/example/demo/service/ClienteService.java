package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Cliente;

public interface ClienteService {
    
    public Cliente SearchById(Long id);

    public List<Cliente> SearchAll();

    public void deleteById(Long id);

    public void update(Cliente cliente);

    public void add(Cliente cliente);

    public Cliente SearchByUserName(String userName);

    
}
