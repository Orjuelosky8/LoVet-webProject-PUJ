package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;
import com.example.demo.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    MascotaRepository repo;

    @Override
    public Mascota SearchById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Collection<Mascota> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
    }

    @Override
    public void update(Mascota mascota) {
        // TODO Auto-generated method stub
        repo.save(mascota);
    }

    @Override
    public void add(Mascota mascota) {
        // TODO Auto-generated method stub
        repo.save(mascota);
    }

    @Override
    public Mascota SearchByCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        return repo.searchByCliente(cliente).get(4);

    
    }
}
