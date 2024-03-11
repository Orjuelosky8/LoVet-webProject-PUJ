package com.example.demo.service;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;

public interface MascotaService {
    
    public Mascota SearchById(Long id);

    public Collection<Mascota> SearchAll();

    public Page<Mascota> findAll(Pageable pageable);
    
    public void deleteById(Long id);

    public void update(Mascota mascota);

    public void add(Mascota mascota);

    public Mascota SearchByCliente(Cliente cliente);

}
