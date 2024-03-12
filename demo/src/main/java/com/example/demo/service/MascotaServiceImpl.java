package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @SuppressWarnings("null")
    @Override
    public Page<Mascota> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @SuppressWarnings("null")
    @Override
    public void deleteById(Long id) {
        Optional<Mascota> mascotaOptional = repo.findById(id);
        if (mascotaOptional.isPresent()) {
            Mascota mascota = mascotaOptional.get();
            mascota.setEstado("Inactivo");
            repo.save(mascota);
        } else {
            System.out.println("Mascota no encontrada con ID: " + id);
        }
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
