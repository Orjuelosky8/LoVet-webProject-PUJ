package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.model.Cliente;
import com.example.demo.model.Veterinario;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.VeterinarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.AuthorityUtils;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private VeterinarioRepository veterinarioRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Cliente cliente = clienteRepository.findByUserName(username);
        if (cliente != null) {
            System.out.println("************************************************************CLIENTEEE: " + username);
            return new org.springframework.security.core.userdetails.User(
                cliente.getUserName(), cliente.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_CLIENTE"));
        }
        Veterinario veterinario = veterinarioRepository.findByUserName(username);
        if (veterinario != null) {
            System.out.println("************************************************************VETERINARIOOO: " + username);
            return new org.springframework.security.core.userdetails.User(
                veterinario.getUserName(), veterinario.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_VETERINARIO"));
        }
        Admin admin = adminRepository.findByUserName(username);
        if (admin != null) {
            System.out.println("************************************************************ADMIN: " + username);
            return new org.springframework.security.core.userdetails.User(
                admin.getUserName(), admin.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
        }
        throw new UsernameNotFoundException("Usuario no encontrado: " + username);
    }
}
