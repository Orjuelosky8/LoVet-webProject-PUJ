package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.Cliente;

public interface ClienteService {
    
    public Cliente SearchById(int id);

    public Collection<Cliente> SearchAll();

    public void deleteById(int id);

    public void update(Cliente cliente);

    public void add(Cliente cliente);
}
