package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Veterinario;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByUserName(username);
        if (cliente != null) {
            return new org.springframework.security.core.userdetails.User(
                cliente.getUserName(), cliente.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_CLIENTE"));
        }
        Veterinario veterinario = veterinarioRepository.findByUserName(username);
        if (veterinario != null) {
            return new org.springframework.security.core.userdetails.User(
                veterinario.getUserName(), veterinario.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_VETERINARIO"));
        }
        throw new UsernameNotFoundException("Usuario no encontrado: " + username);
    }
}
