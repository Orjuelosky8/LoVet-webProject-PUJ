package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;

@Repository
public class ClienteRepository {
    private Map<Integer, Cliente> clientes = new HashMap<>();


    public ClienteRepository() {
        List<Integer> listaMascotas1 = new ArrayList<>(List.of(2, 3));
        List<Integer> listaMascotas2 = new ArrayList<>(List.of(4));
        List<Integer> listaMascotas3 = new ArrayList<>(List.of(1));
        List<Integer> listaMascotas4 = new ArrayList<>();
        clientes.put(1, new Cliente(1, "Pepe1234", "12Gonza34", "pepe1234@hot.com", "Pepe1", "Gonzalez1", "911", "123", listaMascotas1));
        clientes.put(2, new Cliente(2, "Pepe5", "12Gonza34", "pepe1234@hot.com", "Pepe2", "Gonzalez2", "911", "123", listaMascotas2));
        clientes.put(3, new Cliente(3, "Pepe6", "12Gonza34", "pepe1234@hot.com", "Pepe3", "Gonzalez3", "911", "123", listaMascotas3));
        clientes.put(4, new Cliente(4, "Pepe7", "12Gonza34", "pepe1234@hot.com", "Pepe4", "Gonzalez4", "911", "123", listaMascotas4));
    }


    public Cliente findById(int id){
        return clientes.get(id);
    }


    public Collection<Cliente> findAll(){
        return clientes.values();
    }


    public void deleteById(int id){
        clientes.remove(id);
    }


    public void update(Cliente cliente){
        clientes.put(cliente.getId(), cliente);
    }
    
    public void add(Cliente cliente){
        int tam = clientes.size();
        int lastId = clientes.get(tam).getId();
        cliente.setId(lastId+1);
        clientes.put(cliente.getId(), cliente);
    }
}