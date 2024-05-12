package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.HomeWorkRepository;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    HomeWorkRepository homeWorkRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Pnemos una semilla para los datos random
        Random random = new Random(42);

        //Generacion de estudiantes

        for (int i = 1; i <= 123; i++) {
            Cliente cliente = new Cliente(
                i + "Pepe",                 // userNameaaa
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
        Random random2 = new Random();
        
        for (Mascota mascota : mascotas) {
            if (!clientes.isEmpty()) {
                // Asignar a un cliente aleatorio o dejar sin asignar
                // if (random.nextBoolean()) { // Decisión aleatoria de asignar o no
                    Cliente clienteAleatorio = clientes.get(random2.nextInt(clientes.size()));
                    mascota.setCliente(clienteAleatorio);
                    clienteAleatorio.getMascotas().add(mascota);
                // }
            }
            mascotaRepository.save(mascota);
        }

        /* Just for knowing wich clients have dogs and how many */
        // for (Cliente cliente : clientes) {
        //     System.out.println("- Numero de mascotas cliente #"+cliente.getId()+": "+cliente.getMascotas().size());
        // }

        //Generacion de estudiantes
        studentRepository.save(new Student("Sebastian Angarita","Sistemas",3,"juseanto@javeriana.edu.co"));
        studentRepository.save(new Student("Margarita Mendoza","Filosofia",2,"margarita@javeriana.edu.co"));
        studentRepository.save(new Student("Pedro Claver","Matematicas",3,"pedro@javeriana.edu.co"));
        studentRepository.save(new Student("Camilo Cabra","Sistemas",8,"Camilo@javeriana.edu.co"));
        studentRepository.save(new Student("Alejandro Herrera","Sociologia",8,"Alejandro@javeriana.edu.co"));

    
        //Generacion de tareas
        homeWorkRepository.save(new HomeWork("Ejericios ecuaciones", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Ejericios mate", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Ejericios sociales", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Ejericios filosofia", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Proyecto final", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Ejericios ecuaciones 2", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Ejericios mate 2", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Ejericios sociales 2", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Ejericios filosofia 2", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Proyecto final 2", "Terminar taller"));

        //Generacion profesores
        teacherRepository.save(new Teacher("Anabel"));
        teacherRepository.save(new Teacher("Pavlich"));
        teacherRepository.save(new Teacher("Bustacara"));

        //Generacion de cursos
        courseRepository.save(new Course("BASES DE DATOS"));
        courseRepository.save(new Course("ESTRUCTURAS DE DATOS"));
        courseRepository.save(new Course("CIENCIAS BASISCAS"));
        courseRepository.save(new Course("CALCULO DIFERENCIAL"));
        courseRepository.save(new Course("CALCULO INTEGRAL"));
        courseRepository.save(new Course("CALCULO MULTIVARIABLE"));

        //Asignacion de tareas a estudiantes
        int CANTIDAD_ESTUDIANTES = 5;
        for(HomeWork homeWork: homeWorkRepository.findAll()){
            int randomNum = random.nextInt(1, CANTIDAD_ESTUDIANTES + 1);
            Long search = Long.valueOf(randomNum);
            Student student = studentRepository.findById(search).get();
            homeWork.setEstudiante(student);
        }

        //Asignacion de profesores y estudiantes a cursos
        int CANTIDAD_PROFESORES = 3;
        for(Course course: courseRepository.findAll()){
            int id_profesor = random.nextInt(1, CANTIDAD_PROFESORES + 1);
            int id_estudiante = random.nextInt(1, CANTIDAD_ESTUDIANTES + 1);
            Student student = studentRepository.findById(Long.valueOf(id_estudiante)).get();
            Teacher teacher = teacherRepository.findById(Long.valueOf(id_profesor)).get();
            course.setStudent(student);
            course.setTeacher(teacher);
        }

        
        

    }

}
