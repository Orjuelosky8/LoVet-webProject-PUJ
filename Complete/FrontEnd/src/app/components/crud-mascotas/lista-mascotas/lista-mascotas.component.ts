import { Component, OnInit } from '@angular/core';
import { Mascota } from '../../../models/mascota';
import { MascotaMockService } from '../../../services/mascotas/mascota-mock.service';

@Component({
  selector: 'app-lista-mascotas',
  templateUrl: './lista-mascotas.component.html',
  styleUrls: ['./lista-mascotas.component.css']
})
export class ListaMascotasComponent implements OnInit {
  mascotas!: Mascota[];

  constructor(private mascotaService: MascotaMockService) { }

  ngOnInit() {
    this.mascotaService.obtenerMascotas().subscribe(data => {
      this.mascotas = data;
    });
  }
  

  mascotaList: Mascota[] = [
    {
      "nombre": "Mico",
      "raza": "Terrier",
      "edad": 5,
      "imagen": "https://img.freepik.com/fotos-premium/lindo-perro-posando-aislado-sobre-fondo-hermoso_639785-1155.jpg",
      "permanencia": 4,
      "altura": 24,
      "peso": 13,
      "antecedentes": "Higiene bucal",
      "estado": "Activo"
    },
    {
      "nombre": "Noa",
      "raza": "Beagle",
      "edad": 11,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2016/07/perro-de-presa-canario-1.jpg",
      "permanencia": 3,
      "altura": 25,
      "peso": 13,
      "antecedentes": "Displasia de cadera",
      "estado": "Activo"
    },
    {
      "nombre": "Samantha",
      "raza": "Corgi",
      "edad": 6,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2017/01/corgi.jpg",
      "permanencia": 2,
      "altura": 42,
      "peso": 22,
      "antecedentes": "Diarrea",
      "estado": "Activo"
    },
    {
      "nombre": "Chispa",
      "raza": "Schnauzer",
      "edad": 6,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2019/04/raza-spitz-japon%C3%A9s.jpg",
      "permanencia": 4,
      "altura": 41,
      "peso": 21,
      "antecedentes": "Glandulas oculares",
      "estado": "Activo"
    },
    {
      "nombre": "Nina",
      "raza": "Pitbull",
      "edad": 6,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2019/05/raza-spaniel-breton.jpg",
      "permanencia": 2,
      "altura": 30,
      "peso": 15,
      "antecedentes": "Sarna de la piel",
      "estado": "Activo"
    },
    {
      "nombre": "Rayo",
      "raza": "Golden",
      "edad": 2,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2019/04/terrier-ruso.jpg",
      "permanencia": 3,
      "altura": 42,
      "peso": 22,
      "antecedentes": "Rotura de pata izquierda posterior",
      "estado": "Activo"
    },
    {
      "nombre": "Toby",
      "raza": "Chihuahua",
      "edad": 13,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2019/04/spitz-japon%C3%A9s.jpg",
      "permanencia": 3,
      "altura": 28,
      "peso": 15,
      "antecedentes": "Ingesta de plásticos",
      "estado": "Activo"
    },
    {
      "nombre": "Chiqui",
      "raza": "Labrador",
      "edad": 1,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2019/05/sarloos-perro-lobo.jpg",
      "permanencia": 1,
      "altura": 40,
      "peso": 21,
      "antecedentes": "Alergias",
      "estado": "Activo"
    },
    {
      "nombre": "Rocky",
      "raza": "Dálmata",
      "edad": 10,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2019/05/collie-barbudo-bearded-collie.jpg",
      "permanencia": 1,
      "altura": 46,
      "peso": 24,
      "antecedentes": "Problemas de corazón",
      "estado": "Activo"
    },
    {
      "nombre": "Plutón",
      "raza": "Boxer",
      "edad": 12,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2019/07/collie-de-pelo-largo.jpg",
      "permanencia": 3,
      "altura": 35,
      "peso": 18,
      "antecedentes": "Glandulas oculares",
      "estado": "Activo"
    },
    {
      "nombre": "Thor",
      "raza": "Caniche",
      "edad": 7,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2019/09/perro-coton-de-tulear.jpg",
      "permanencia": 3,
      "altura": 26,
      "peso": 14,
      "antecedentes": "Problemas de corazón",
      "estado": "Activo"
    },
    {
      "nombre": "Chico",
      "raza": "Husky",
      "edad": 8,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2019/09/perro-terrier-irland%C3%A9s.jpg",
      "permanencia": 4,
      "altura": 44,
      "peso": 23,
      "antecedentes": "Ansiedad",
      "estado": "Activo"
    },
    {
      "nombre": "Simba",
      "raza": "Poodle",
      "edad": 12,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2020/09/perro-azawakh.jpg",
      "permanencia": 2,
      "altura": 22,
      "peso": 12,
      "antecedentes": "Sobrepeso",
      "estado": "Activo"
    },
    {
      "nombre": "Luna",
      "raza": "Golden",
      "edad": 3,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2020/08/american-pitbull-terrier.jpg",
      "permanencia": 1,
      "altura": 33,
      "peso": 17,
      "antecedentes": "Problemas de piel",
      "estado": "Activo"
    },
    {
      "nombre": "Bruno",
      "raza": "Pastor Alemaño",
      "edad": 6,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2015/05/raza-pug-carlino.jpg",
      "permanencia": 3,
      "altura": 29,
      "peso": 16,
      "antecedentes": "Problemas de oido",
      "estado": "Activo"
    },
    {
      "nombre": "Lola",
      "raza": "Pomerania",
      "edad": 10,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2015/03/husky-siberiano.jpg",
      "permanencia": 2,
      "altura": 21,
      "peso": 12,
      "antecedentes": "Problemas de nariz",
      "estado": "Activo"
    },
    {
      "nombre": "Nico",
      "raza": "Chow chow",
      "edad": 9,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2014/08/perros-golden-retriever.jpg",
      "permanencia": 4,
      "altura": 43,
      "peso": 23,
      "antecedentes": "Pulgas",
      "estado": "Activo"
    },
    {
      "nombre": "Coco",
      "raza": "Cocker Spaniel",
      "edad": 2,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2014/08/boston-terrier-caracter%C3%ADsticas.jpg",
      "permanencia": 1,
      "altura": 33,
      "peso": 17,
      "antecedentes": "Mosca del establo",
      "estado": "Activo"
    },
    {
      "nombre": "Bimba",
      "raza": "Shih Tzu",
      "edad": 4,
      "imagen": "https://www.petdarling.com/wp-content/uploads/2015/10/perro-shiba-inu.jpg",
      "permanencia": 2,
      "altura": 23,
      "peso": 13,
      "antecedentes": "Garrapatas",
      "estado": "Activo"
    }
  ];
}
