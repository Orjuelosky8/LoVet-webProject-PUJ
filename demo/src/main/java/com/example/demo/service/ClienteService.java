package com.example.demo.service;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;

public interface ClienteService {
    
    public Cliente SearchById(Long id);

    public Cliente findByCedula(Long cedula);

    // public Cliente SearchByCedula(Long cedula);

    public Collection<Cliente> SearchAll();

    public Page<Cliente> findAll(Pageable pageable);

    public void deleteById(Long id);

    public void update(Cliente cliente);

    public void add(Cliente cliente);

    public Cliente SearchByUserName(String userName);

    
}
