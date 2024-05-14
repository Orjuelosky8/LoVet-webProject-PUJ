package com.example.demo.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.demo.repository.TratamientoRepository;
import com.example.demo.repository.VeterinarioRepository;
import com.example.demo.service.ExcelLoadService;
import com.example.demo.service.MedicamentoService;
import com.example.demo.repository.MedsRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

    //@Autowired
    //StudentRepository studentRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    //@Autowired
    //HomeWorkRepository homeWorkRepository;

    //@Autowired
    //TeacherRepository teacherRepository;

    //@Autowired
    //CourseRepository courseRepository;

    @Autowired
    MedsRepository medsRepository;

    @Autowired
    VeterinarioRepository veterinarioRepository;

    @Autowired
    TratamientoRepository tratamientoRepository;

    private static final Logger logger = LoggerFactory.getLogger(MedicamentoService.class);


    

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Pnemos una semilla para los datos random
        Random random = new Random(42);

        String[] nombrePersonas = {"Antonio", "Arturo", "Armando", "Alissa", "Ana", "Adán", "Azul", "Bárbara", "Bastidas", "Bartolomé", "Betzaida", "Betania", "Berta", "Bernarda", "Carlos", "Castillo", "Costa", "Celeste", "Cindy", "Cecilia", "Carmona", "Constantino", "Edgardo", "Fátima", "Florencia", "Fausto", "Fernando", "Francisco", "Franyer", "Gerardo", "Gustavo", "Gabriela", "González", "Guzmán", "Juan", "José", "Jacinto", "Juvenal", "Julián", "Juliana", "Jesús", "Julio", "Luis", "López", "Luisana", "Maria", "Marcos", "Mariana", "Montenegro", "Rodriguez", "Rosa", "Ricardo", "Rebeca", "Raúl", "Renata", "Roberto", "Roxana", "Ramón", "Rosario", "Rubén", "Rita", "Rafael", "Romina", "Rodrigo", "Regina", "Rolando", "Ruth", "Rogelio", "Rosita", "Rafaela", "Ricardina"};
        String[] apellidos = { "Garcia", "Gonzalez", "Rodriguez", "Fernández", "Lopez", "Martinez", "Sanchez", "Perez", "Gomez", "Martin", "Jiménez", "Ruiz", "Hernández", "Diaz", "Moreno", "Muñoz", "Álvarez", "Romero", "Alonso", "Gutiérrez", "Navarro", "Torres", "Domínguez", "Vázquez", "Ramos", "Gil", "Ramírez", "Serrano", "Blanco", "Molina", "Morales", "Suarez", "Ortega", "Delgado", "Castro", "Ortiz", "Rubio", "Cabrera", "Nieto", "Reyes", "Mendez", "Iglesias", "Guerrero", "Santos", "Castillo", "Cortés", "Lozano", "Peña", "Cano", "Prieto", "Cruz", "Calvo", "Gallego", "Herrera", "Marín", "Soto", "Mora", "Esteban", "Parra", "Bravo", "Aguilar", "Pascual", "Vega", "Campos", "Flores", "Vidal", "Carrasco", "Fuentes", "Caballero", "Diez", "Rey", "Núñez", "León", "Carrillo", "Merino", "Peinado", "Redondo", "Rojas", "Soria", "Rivas", "Paredes", "Crespo", "Bueno", "Galán", "Moya", "Villar", "Sanz", "Peralta"};

        for (int i = 1; i <= 123; i++) {
            Cliente cliente = new Cliente(
                nombrePersonas[i % nombrePersonas.length] + apellidos[i % apellidos.length],                 // userName
                nombrePersonas[i % nombrePersonas.length] + "password" + i + (i+1),                // password
                nombrePersonas[i % nombrePersonas.length] + i + "@example.com", // correoElectronico
                nombrePersonas[i % nombrePersonas.length],                  // nombres
                apellidos[i % apellidos.length],             // apellidos
                "90000" + i,                   // telefono
                "80000" + i                    // telefonoAux
            );
            clienteRepository.save(cliente);
        }
        Cliente cliente = new Cliente(
                "Joaquin", "Joaquin", "Joaquin", "Joaquin", "Joaquin", "1", "2"
            );
        clienteRepository.save(cliente);

        String[] imagenes = {"https://img.freepik.com/fotos-premium/lindo-perro-posando-aislado-sobre-fondo-hermoso_639785-1155.jpg",
        "https://www.zooplus.es/magazine/wp-content/uploads/2023/07/Bergamasco.jpg", "https://www.zooplus.es/magazine/wp-content/uploads/2023/05/Bedlington-terrier.jpeg",
    "https://www.zooplus.es/magazine/wp-content/uploads/2022/10/Beauceron.jpeg","https://www.zooplus.es/magazine/wp-content/uploads/2023/12/Beagle-harrier.jpg",
"https://www.zooplus.es/magazine/wp-content/uploads/2017/10/Beagle-1.jpeg","https://www.zooplus.es/magazine/wp-content/uploads/2024/03/Basset-leonado-de-Bretana-768x512.jpeg",
"https://www.zooplus.es/magazine/wp-content/uploads/2021/06/Basset-hound.jpg", "https://www.zooplus.es/magazine/wp-content/uploads/2023/04/Basenji.jpg",
"https://www.zooplus.es/magazine/wp-content/uploads/2023/06/Barbet-3.jpg", "https://www.zooplus.es/magazine/wp-content/uploads/2022/08/Bandog.jpg", "https://www.zooplus.es/magazine/perros/razas-de-perro/azawakh", 
"https://www.zooplus.es/magazine/wp-content/uploads/2020/07/American-Staffordshire-Terrier-Feldweg-768x512-1.jpg", "https://www.zooplus.es/magazine/wp-content/uploads/2021/05/American-bully.jpeg", "https://www.zooplus.es/magazine/wp-content/uploads/2019/11/akita-inu-768x512.jpg",
"https://www.zooplus.es/magazine/wp-content/uploads/2019/11/akita-inu-768x512.jpg", "https://www.zooplus.es/magazine/wp-content/uploads/2021/06/akita-americano-768x511.jpg",
"https://www.zooplus.es/magazine/wp-content/uploads/2021/12/Airedale-terrier-768x512.jpeg","https://www.zooplus.es/magazine/wp-content/uploads/2021/02/Boyero-de-Berna.jpg",
"https://www.zooplus.es/magazine/wp-content/uploads/2023/07/Boyero-de-Appenzell.jpeg", "https://www.zooplus.es/magazine/wp-content/uploads/2017/03/fotolia_102829193-768x512.jpg", 
"https://www.zooplus.es/magazine/wp-content/uploads/2021/06/Boston-terrier.jpg", "https://www.zooplus.es/magazine/wp-content/uploads/2023/05/Borzoi.jpg", "https://www.zooplus.es/magazine/wp-content/uploads/2023/05/Border-terrier.jpg",
"https://www.zooplus.es/magazine/wp-content/uploads/2019/07/border-collie-.jpeg", "https://www.zooplus.es/magazine/wp-content/uploads/2023/07/Bolonka-zwetna.jpeg",
"https://www.zooplus.es/magazine/wp-content/uploads/2021/07/Bolones-768x500.jpeg", "https://www.zooplus.es/magazine/wp-content/uploads/2023/01/Boerboel.jpg0 ","https://www.zooplus.es/magazine/wp-content/uploads/2020/05/Bobtail-o-antiguo-perro-de-pastor-ingles.jpg",
"https://www.zooplus.es/magazine/wp-content/uploads/2023/07/Bloodhound.jpg", "https://www.zooplus.es/magazine/wp-content/uploads/2023/07/Black-and-tan-coonhound.jpeg", "https://www.zooplus.es/magazine/wp-content/uploads/2020/01/bich%C3%B3n-maltes-768x510.jpeg"
,"https://www.zooplus.es/magazine/wp-content/uploads/2021/09/Bichon-habanero.jpg", "https://www.zooplus.es/magazine/wp-content/uploads/2020/08/Bich%C3%B3n-fris%C3%A9.jpg", "https://www.zooplus.es/magazine/wp-content/uploads/2021/11/Bernedoodle-768x512.jpeg", 
"https://www.zooplus.es/magazine/wp-content/uploads/2023/07/Berger-picard.jpeg", "https://www.zooplus.es/magazine/wp-content/uploads/2023/07/Bergamasco.jpg"};
        String[] nombrePerros = {"Max", "Luna", "Rocky", "Bella", "Coco", "Charlie", "Daisy", "Bailey", "Lucy", "Toby", "Sadie", "Milo", "Zoe", "Leo", "Ruby", "Rosie", "Oscar", "Chloe", "Riley", "Molly", "Bear", "Lola", "Buddy", "Stella", "Harley", "Gizmo", "Sophie", "Zeus", "Maggie", "Oliver", "Penny", "Winston", "Gracie", "Sammy", "Lucky", "Hazel", "Finn", "Cleo", "Rusty", "Nala"};
        String[] razas = {"Terrier", "Beagle", "Schnauzer", "Pitbull", "Golden", "Chihuahua", "Labrador", "Dálmata", "Bulldog",  "Jack Russell Terrier","Pastor Alemán", "Fox Terrier Toy", "Yorkshire Terrier", "Chihuahua", "Akita Inu", "Labrador Retriever", "Bulldog", "Bóxer", "Border Terrier", "Boyero de Berna", "Spitz Japonés", "Bichón Boloñés", "West Highland White Terrier (Westy)", "Cairn Terrier", "Skye Terrier"};
        String[] problemas = {"Higiene bucal", "Displasia de cadera", "Glandulas oculares", "Sarna de la piel", "Rotura de pata izquierda posterior", "Ingesta de plásticos", "Alergias", "Problemas de corazón", "Ansiedad", "Sobrepeso"
        , "Parvovirus", "Moquillo", "Hepatitis canina", "Leptospirosis", "Rabia", "Brucelosis", "Borreliosis canina", "Traqueobronquitis infecciosa", "Coronavirus", "Toxoplasmosis", "Otitis", "Conjuntivitis", "Alergias cutáneas", "Gastritis aguda", "Diarrea", "Leishmaniosis", "Insuficiencia renal", "Cálculos urinarios", "Artritis", "Displasia de cadera"};

        // Generar mascotas sin asignarlas todavía
        List<Mascota> mascotas = new ArrayList<>();
        for (int i = 1; i <= 140; i++) {
            Mascota mascota = new Mascota(
                nombrePerros[i % nombrePerros.length],                                          // nombre
                razas[i % razas.length],                                // raza
                random.nextInt(0, 16),
                imagenes[i % imagenes.length], /*+ i + ".jpg"*/            // imagen
                random.nextInt(0, 4),                                                      // permanencia
                10 + i,                                                 // altura
                5 + i * 2,     
                "Activo",                                         // peso
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
        
        //Cargando los Medicamentos desde el EXCEL
        List<Medicamento> list = ExcelLoadService.loadExcelFile();
        medsRepository.saveAll(list);
        

        // GENERACION DE VETERINARIOS
        for (int i = 1; i <= 123; i++) {
            Veterinario veterinario = new Veterinario(
                "Carlos" + i,
                "Gutierrez" + i,
                "CarlosUsername" + i,
                "CarlosPassword" + i,
                "Cirujano" + i,
                Long.parseLong("90000" + i),
                "bettervet" + i + "@lovet.com"
            );
            veterinarioRepository.save(veterinario);
        }
        
        /* 
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
*/
        
        
        List<Veterinario> veterinarios = veterinarioRepository.findAll();
        List<Mascota> pets = mascotaRepository.findAll();
        List<Medicamento> medicamentos = medsRepository.findAll();

        // Crear tratamientos
        for (int i = 0; i < 4; i++) {  // Ejemplo: Crear 10 tratamientos
            Tratamiento tratamiento = new Tratamiento(
                "Tratamiento " + i,
                "Descripción del tratamiento " + i,
                "Activo",
                pets.get(i % pets.size()),  // Asignar mascota de manera cíclica
                veterinarios.get(i % veterinarios.size())  // Asignar veterinario de manera cíclica
            );
            
            // Asignar medicamentos (puedes asignar múltiples medicamentos a un tratamiento)
            tratamiento.getMedicamentos().add(medicamentos.get(i % medicamentos.size()));
            if (i % 2 == 0) {  // Cada segundo tratamiento, añadir un segundo medicamento
                tratamiento.getMedicamentos().add(medicamentos.get((i+1) % medicamentos.size()));
            }

            // Guardar el tratamiento
            tratamientoRepository.save(tratamiento);
        }

        logger.debug("\n\n   tratamiento 1/2. *******************************************************" + tratamientoRepository.findAll().get(2).getMascota().getNombre() + "\n\n");
    }

}