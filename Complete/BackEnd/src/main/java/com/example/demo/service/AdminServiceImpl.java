package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository repo;
    
    @Override
    public Admin SearchById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Admin SearchByUserName(String userName) {
        return repo.findByUserName(userName);
    }
    

    @Override
    public List<Admin> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Admin admin) {
        repo.save(admin);
    }

    @Override
    public void add(Admin admin) {
        repo.save(admin);
    }
}
