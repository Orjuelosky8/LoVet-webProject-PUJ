package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Mascota;
import com.example.demo.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    MascotaRepository repo;

    @Override
    public Mascota SearchById(int id) {
        return repo.findById(id);
    }

    @Override
    public Collection<Mascota> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
    }

    @Override
    public void update(Mascota mascota) {
        // TODO Auto-generated method stub
        repo.update(mascota);
    }

    @Override
    public void add(Mascota mascota) {
        // TODO Auto-generated method stub
        repo.add(mascota);
    }
    
}