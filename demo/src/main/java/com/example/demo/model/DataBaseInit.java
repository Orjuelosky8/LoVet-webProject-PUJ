package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.MascotaRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DataBaseInit implements ApplicationRunner {

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @SuppressWarnings("null")
    @Override
    public void run(ApplicationArguments args) throws Exception {
         /* CLIENTES */
        for (int i = 1; i <= 123; i++) {
            Cliente cliente = new Cliente(
                i + "Pepe",                 // userName
                i + "password" + i + (i+1),                // password
                "pepe123" + i + "@example.com", // correoElectronico
                "Pepe" + i,                  // nombres
                "Gonzalez" + i,                // apellidos
                "90000" + i,                   // telefono
                "80000" + i                    // telefonoAux
            );
            clienteRepository.save(cliente);
        }


        String[] razas = {"Terrier", "Beagle", "Schnauzer", "Pitbull", "Golden", "Chihuahua", "Labrador", "Dálmata", "Boxer", "Bulldog"};
        String[] problemas = {"Higiene bucal", "Displasia de cadera", "Glandulas oculares", "Sarna de la piel", "Rotura de pata izquierda posterior", "Ingesta de plásticos", "Alergias", "Problemas de corazón", "Ansiedad", "Sobrepeso"};

        // Generar mascotas sin asignarlas todavía
        List<Mascota> mascotas = new ArrayList<>();
        for (int i = 1; i <= 140; i++) {
            Mascota mascota = new Mascota(
                "Perrito" + i,                                          // nombre
                razas[i % razas.length],                                // raza
                i * 2,                                                  // edad
                "https://img.freepik.com/fotos-premium/lindo-perro-posando-aislado-sobre-fondo-hermoso_639785-1155.jpg" /*+ i + ".jpg"*/,              // imagen
                i,                                                      // permanencia
                10 + i,                                                 // altura
                5 + i * 2,                                              // peso
                problemas[i % problemas.length]                         // antecedentes
            );
            mascotas.add(mascota);
        }

        // Asignar mascotas a clientes de manera aleatoria
        List<Cliente> clientes = clienteRepository.findAll();
        Random random = new Random();
        
        for (Mascota mascota : mascotas) {
            if (!clientes.isEmpty()) {
                // Asignar a un cliente aleatorio o dejar sin asignar
                // if (random.nextBoolean()) { // Decisión aleatoria de asignar o no
                    Cliente clienteAleatorio = clientes.get(random.nextInt(clientes.size()));
                    mascota.setCliente(clienteAleatorio);
                    clienteAleatorio.getMascotas().add(mascota);
                // }
            }
            mascotaRepository.save(mascota);
        }

        /* Just for knowing wich clients have dogs and how many */
        for (Cliente cliente : clientes) {
            System.out.println("- Numero de mascotas cliente #"+cliente.getId()+": "+cliente.getMascotas().size());
        }
    }
}
