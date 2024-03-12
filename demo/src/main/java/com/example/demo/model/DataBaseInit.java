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
        for (int i = 1; i <= 100; i++) {
            Cliente cliente = new Cliente(
                i + "Pepe",                 // userName
                (long)i+1000,
                i + "password" + i + (i+1),                // password
                "pepe123" + i + "@example.com", // correoElectronico
                "Pepe" + i,                  // nombres
                "Gonzalez" + i,                // apellidos
                "90000" + i,                   // telefono
                "80000" + i,                    // telefonoAux
                "Activo"
            );
            clienteRepository.save(cliente);
        }

        String[] nombres  ={"Mico","Noa","Chispa","Nina","Rayo","Toby","Chiqui","Rocky","Plutón","Thor","Chico","Simba","Luna","Bruno","Lola","Nico","Coco","Bimba","Linda","Max",
        "Luke","Vito","Scooby","Simba","Lassie","Dug","Pongo","Máximo","Toby","Electra","Copito","Butkus","Marley","Sam","Perdita","Neo","Rambo","Valentín","Coco","Milo","Zero",
        "Balto","Spock","Arwen","Minnie","Max","Charlie","Fang","Yago","Pumba","Samantha"};


        String[] razas = {"Terrier", "Beagle", "Schnauzer", "Pitbull", "Golden", "Chihuahua", "Labrador", "Dálmata", "Boxer", 
        "Caniche", "Husky", "Poodle","Golden", "Pastor Alemaño", "Pomerania", "Chow chow", "Cocker Spaniel", "Shih Tzu", 
        "Pug", "Yorkshire", "Bulldog", "Bedlington", "Bichón", "Boston","Labrador", "Salchicha", "Fox Terrier", "Ainu", "Border Collie",
        "Shar Pei","Chihuahua", "Chesapeake", "Pit Bull", "Havanese", "Rottweiler", "Cavalier King", "Cane Corso", "Husky", "Poodle",
        "Dóberman", "Dogo Argentino", "Galgo", "Samoyedo"};
        String[] problemas = {"Higiene bucal", "Displasia de cadera", "Glandulas oculares", "Sarna de la piel", "Rotura de pata izquierda posterior", 
                "Ingesta de plásticos", "Alergias", "Problemas de corazón", "Ansiedad", "Sobrepeso", "Problemas de piel", "Problemas de oido",
                "Problemas de nariz", "Pulgas", "Mosca del establo", "Garrapatas", "Ácaros", "Tenias", "Gusanos", "Moquillo", "Hepatitis", "Parvovirosis",
                "Rabia", "Displasia de cadera", "Artrosis", "Reumatissmo", "Glaucoma", "Epilepsia", "Meningitis", "Cistitis", "Cáncer", "Diabetes",
                "Torsión gástrica", "Otitis",  "Diarrea"};

        String[] imagenes = {"https://img.freepik.com/fotos-premium/lindo-perro-posando-aislado-sobre-fondo-hermoso_639785-1155.jpg",
                "https://www.petdarling.com/wp-content/uploads/2016/07/perro-de-presa-canario-1.jpg", "https://www.petdarling.com/wp-content/uploads/2019/04/raza-spitz-japon%C3%A9s.jpg",
                "https://www.petdarling.com/wp-content/uploads/2019/05/raza-spaniel-breton.jpg", "https://www.petdarling.com/wp-content/uploads/2019/04/terrier-ruso.jpg",
                "https://www.petdarling.com/wp-content/uploads/2019/04/spitz-japon%C3%A9s.jpg", "https://www.petdarling.com/wp-content/uploads/2019/05/sarloos-perro-lobo.jpg",
                "https://www.petdarling.com/wp-content/uploads/2019/05/collie-barbudo-bearded-collie.jpg", "https://www.petdarling.com/wp-content/uploads/2019/07/collie-de-pelo-largo.jpg",
                "https://www.petdarling.com/wp-content/uploads/2019/09/perro-coton-de-tulear.jpg", "https://www.petdarling.com/wp-content/uploads/2019/09/perro-terrier-irland%C3%A9s.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2020/09/perro-azawakh.jpg", "https://www.petdarling.com/wp-content/uploads/2020/08/american-pitbull-terrier.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2015/05/raza-pug-carlino.jpg", "https://www.petdarling.com/wp-content/uploads/2015/03/husky-siberiano.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2014/08/perros-golden-retriever.jpg", "https://www.petdarling.com/wp-content/uploads/2014/08/boston-terrier-caracter%C3%ADsticas.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2015/10/perro-shiba-inu.jpg", "https://www.petdarling.com/wp-content/uploads/2017/12/perro-alabai-cachorro.jpg",
                "https://www.petdarling.com/wp-content/uploads/2017/02/boerboel-mastin-sudafricano.jpg", "https://www.petdarling.com/wp-content/uploads/2017/02/dogo-de-burdeos.jpg",
                "https://www.petdarling.com/wp-content/uploads/2017/06/Fox-terrier.jpg", "https://www.petdarling.com/wp-content/uploads/2018/06/airedale-terrier.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2018/12/terrier-de-norwich.jpg", "https://www.petdarling.com/wp-content/uploads/2018/06/setter-gordon.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2018/12/perro-chihuahua-de-pelo-largo.jpg", "https://www.petdarling.com/wp-content/uploads/2018/12/perdiguero-de-drente.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2019/01/bulldog-franc%C3%A9s-blue.jpg", "https://www.petdarling.com/wp-content/uploads/2018/12/Rat%C3%B3n-de-praga.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2018/08/Bull-terrier-blanco.jpg", "https://www.petdarling.com/wp-content/uploads/2018/08/mastin-del-pirineo.jpg}", 
                "https://www.petdarling.com/wp-content/uploads/2019/01/galgo-afgano.jpg", "https://www.petdarling.com/wp-content/uploads/2018/12/mastin-napolitano.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2018/12/pastor-ganadero-australiano.jpg", "https://www.petdarling.com/wp-content/uploads/2019/07/perro-sabueso-espa%C3%B1ol.jpg",
                "https://www.petdarling.com/wp-content/uploads/2019/05/terrier-escoces.jpg", "https://www.petdarling.com/wp-content/uploads/2019/05/vizsla-braco-h%C3%BAngaro.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2019/04/bulldog-americano.jpg", "https://www.petdarling.com/wp-content/uploads/2019/04/cachorro-perro-esquimal-americano.jpg",
                "https://www.petdarling.com/wp-content/uploads/2014/09/cachorro-bull-terrier-miniatura.jpg", "https://www.petdarling.com/wp-content/uploads/2015/01/perro-poodle-caniche.jpg",
                "https://www.petdarling.com/wp-content/uploads/2015/02/mast%C3%ADn-ingl%C3%A9s.jpg", "https://www.petdarling.com/wp-content/uploads/2015/02/Cachorro-weimaraner.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2017/02/pastor-belga.jpg", "https://www.petdarling.com/wp-content/uploads/2015/05/perros-pomerania.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2015/05/labrador-chocolate.jpg", "https://www.petdarling.com/wp-content/uploads/2015/06/dogo-argentino-1.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2016/01/perro-pincher-miniatura.jpg", "https://www.petdarling.com/wp-content/uploads/2015/08/raza-Bulldog-ingl%C3%A9s.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2015/08/el-pastor-aleman-blanco.jpg", "https://www.petdarling.com/wp-content/uploads/2015/12/perros-samoyedo.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2017/03/cocker-spaniel.jpg", "https://www.petdarling.com/wp-content/uploads/2017/03/dalmata.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2017/02/doberman.jpg", "https://www.petdarling.com/wp-content/uploads/2016/05/cane-corso-o-mastin-italiano.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2016/07/papillon-perro-1.jpg", "https://www.petdarling.com/wp-content/uploads/2016/07/pastor-belga-malinois.jpg", 
                "https://www.petdarling.com/wp-content/uploads/2017/10/podenco.jpg", "https://www.petdarling.com/wp-content/uploads/2017/01/corgi.jpg"};

        // Generar mascotas sin asignarlas todavía
        List<Mascota> mascotas = new ArrayList<>();
        for (int i = 1; i <= 140; i++) {
            Random generadorAleatorios = new Random();
            int edad = 1+generadorAleatorios.nextInt(14);
            int permanencia = 1+generadorAleatorios.nextInt(4);
            int altura = 15+generadorAleatorios.nextInt(35);

            Mascota mascota = new Mascota(
                nombres[i % nombres.length],                                          // nombre
                razas[i % razas.length],                                // raza
                edad,                                                  // edad
                imagenes[i % imagenes.length]/*+ i + ".jpg*/,              // imagen
                permanencia,                                                      // permanencia
                altura,                                                 // altura
                altura/2+1,                                              // peso
                problemas[i % problemas.length],                         // antecedentes
                "Activo"
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
