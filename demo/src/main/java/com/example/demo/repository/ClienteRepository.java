package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long>{

    Cliente findByUserName(String userName);
    

} 