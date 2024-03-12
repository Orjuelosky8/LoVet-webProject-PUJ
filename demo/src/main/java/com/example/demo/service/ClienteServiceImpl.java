package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository repo;

    @Override
    public Cliente SearchById(Long id) {
        return repo.findById(id).get();
    }

    // @Override
    // public Cliente SearchByCedula(Long cedula) {
    //     return repo.findByCedula(cedula).get();
    // }

    @Override
    public Cliente findByCedula(Long cedula) {
        return repo.findByCedula(cedula);
    }

    @Override
    public Cliente SearchByUserName(String userName) {
        return repo.findByUserName(userName);
    }

    @Override
    public Collection<Cliente> SearchAll() {
        return repo.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        // Encuentra el cliente por ID
        Optional<Cliente> clienteOptional = repo.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            // Cambia el estado a inactivo
            cliente.setEstado("Inactivo");
            // Guarda el cliente modificado en la base de datos
            repo.save(cliente);
        } else {
            // Manejo de la situación donde el cliente no se encuentra, opcional
            System.out.println("Cliente no encontrado con ID: " + id);
        }
    }

    @Override
    public void update(Cliente cliente) {
        repo.save(cliente);
    }

    @Override
    public void add(Cliente cliente) {
        repo.save(cliente);
    }

}
