import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Cliente } from '../models/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private clientesList: Cliente[] = [
    {
      "userName": "1Pepe",
      "password": "abc1",
      "correoElectronico": "jsadz847@example.com",
      "nombres": "abc",
      "apellidos": "def",
      "telefono": "521-0101",
      "telefonoAux": "556-0232"
    },
    {
      "userName": "jPerez847",
      "password": "P@ssw0rd!234",
      "correoElectronico": "juan.perez847@example.com",
      "nombres": "Juan",
      "apellidos": "Pérez",
      "telefono": "555-0101",
      "telefonoAux": "555-0102"
    },
    {
      "userName": "lGomez321",
      "password": "G0mez!Secure",
      "correoElectronico": "laura.g321@correo.com",
      "nombres": "Laura",
      "apellidos": "Gómez",
      "telefono": "555-0201",
      "telefonoAux": "555-0202"
    },
    {
      "userName": "sTorres2024",
      "password": "T0rresSammy",
      "correoElectronico": "samuel.torres@vetmail.com",
      "nombres": "Samuel",
      "apellidos": "Torres",
      "telefono": "555-0301",
      "telefonoAux": "555-0302"
    },
    {
      "userName": "sofiRamz44",
      "password": "Spark4Sof!",
      "correoElectronico": "sofia.ramirez@sparkmail.com",
      "nombres": "Sofía",
      "apellidos": "Ramírez",
      "telefono": "555-0401",
      "telefonoAux": "555-0402"
    },
    {
      "userName": "nMartinez5",
      "password": "N1n@P@ss",
      "correoElectronico": "nina.martinez@dogworld.com",
      "nombres": "Nina",
      "apellidos": "Martínez",
      "telefono": "555-0501",
      "telefonoAux": "555-0502"
    },
    {
      "userName": "rayoV222",
      "password": "R4yo2024",
      "correoElectronico": "rayo.valdez@fastmail.com",
      "nombres": "Rayo",
      "apellidos": "Valdez",
      "telefono": "555-0601",
      "telefonoAux": "555-0602"
    },
    {
      "userName": "tobyLunatic",
      "password": "TobyTreats!",
      "correoElectronico": "tobias.luna@tinydogs.com",
      "nombres": "Tobías",
      "apellidos": "Luna",
      "telefono": "555-0701",
      "telefonoAux": "555-0702"
    },
    {
      "userName": "chiFernandez",
      "password": "Chiqui!Lab",
      "correoElectronico": "chiara.fernandez@lablove.com",
      "nombres": "Chiara",
      "apellidos": "Fernández",
      "telefono": "555-0801",
      "telefonoAux": "555-0802"
    },
    {
      "userName": "rocioDalmata",
      "password": "RockyD!az",
      "correoElectronico": "rocio.diaz@dalmail.com",
      "nombres": "Rocío",
      "apellidos": "Díaz",
      "telefono": "555-0901",
      "telefonoAux": "555-0902"
    },
    {
      "userName": "pedroN_Boxer",
      "password": "Plut0nBox!",
      "correoElectronico": "pedro.nava@boxerfan.com",
      "nombres": "Pedro",
      "apellidos": "Nava",
      "telefono": "555-1001",
      "telefonoAux": "555-1002"
    },
    {
      "userName": "theresa_O",
      "password": "Th0rThunder!",
      "correoElectronico": "theresa.ortega@canichecloud.com",
      "nombres": "Theresa",
      "apellidos": "Ortega",
      "telefono": "555-1101",
      "telefonoAux": "555-1102"
    },
    {
      "userName": "franHusky",
      "password": "Ch1c0Cool",
      "correoElectronico": "francisco.hernandez@coldmail.com",
      "nombres": "Francisco",
      "apellidos": "Hernández",
      "telefono": "555-1201",
      "telefonoAux": "555-1202"
    },
    {
      "userName": "simonB_Az",
      "password": "SimbaKing!",
      "correoElectronico": "simon.barrera@lionking.com",
      "nombres": "Simón",
      "apellidos": "Barrera",
      "telefono": "555-1301",
      "telefonoAux": "555-1302"
    },
    {
      "userName": "lunaMStar",
      "password": "MoonSh1n3",
      "correoElectronico": "luna.mendez@moonshine.com",
      "nombres": "Luna",
      "apellidos": "Mendez",
      "telefono": "555-1401",
      "telefonoAux": "555-1402"
    },
    {
      "userName": "brunoV_Guard",
      "password": "Brun0V!Vega",
      "correoElectronico": "bruno.vega@shepherdmail.com",
      "nombres": "Bruno",
      "apellidos": "Vega",
      "telefono": "555-1501",
      "telefonoAux": "555-1502"
    },
    {
      "userName": "dLolaCruz",
      "password": "L0laFluff!",
      "correoElectronico": "dolores.cruz@pompride.com",
      "nombres": "Dolores",
      "apellidos": "Cruz",
      "telefono": "555-1601",
      "telefonoAux": "555-1602"
    },
    {
      "userName": "nicoJ_Chow",
      "password": "N1c0Chow!",
      "correoElectronico": "nicolas.jimenez@chowchowspace.com",
      "nombres": "Nicolás",
      "apellidos": "Jiménez",
      "telefono": "555-1701",
      "telefonoAux": "555-1702"
    },
    {
      "userName": "cocoCastillo",
      "password": "C0c0Spaniel",
      "correoElectronico": "jacobo.castillo@spanielstars.com",
      "nombres": "Jacobo",
      "apellidos": "Castillo",
      "telefono": "555-1801",
      "telefonoAux": "555-1802"
    },
    {
      "userName": "biancaMor_Tzu",
      "password": "B1mbaTzu!",
      "correoElectronico": "bianca.morales@shihmail.com",
      "nombres": "Bianca",
      "apellidos": "Morales",
      "telefono": "555-1901",
      "telefonoAux": "555-1902"
    }
  ];

  constructor() { }

  obtenerClientes(): Observable<Cliente[]> {
    return of(this.clientesList);
  }

  verificarCredenciales(userName: string, password: string): Observable<boolean> {
    const usuarioEncontrado = this.clientesList.find(usuario => usuario.userName === userName && usuario.password === password);
    alert("res: " + usuarioEncontrado);
    return of(!!usuarioEncontrado);
  }
}