package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Admin;

public interface AdminService {

    public Admin SearchById(Long id);

    public List<Admin> SearchAll();

    public void deleteById(Long id);

    public void update(Admin admin);

    public void add(Admin admin);

    public Admin SearchByUserName(String userName);
}
