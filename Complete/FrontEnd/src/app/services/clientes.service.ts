import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Cliente } from '../models/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private clientesList: Cliente[] = [
    {
      "id": 1,
      "userName": "1Pepe",
      "password": "abc1",
      "correoElectronico": "jsadz847@example.com",
      "nombres": "abc",
      "apellidos": "def",
      "telefono": "521-0101",
      "telefonoAux": "556-0232",
      "mascotasIds": [1, 2]
    },
    {
      "id": 2,
      "userName": "jPerez847",
      "password": "P@ssw0rd!234",
      "correoElectronico": "juan.perez847@example.com",
      "nombres": "Juan",
      "apellidos": "Pérez",
      "telefono": "555-0101",
      "telefonoAux": "555-0102",
      "mascotasIds": [3]
    },
    {
      "id": 3,
      "userName": "lGomez321",
      "password": "G0mez!Secure",
      "correoElectronico": "laura.g321@correo.com",
      "nombres": "Laura",
      "apellidos": "Gómez",
      "telefono": "555-0201",
      "telefonoAux": "555-0202",
      "mascotasIds": [4, 5, 6]
    },
    {
      "id": 4,
      "userName": "sTorres2024",
      "password": "T0rresSammy",
      "correoElectronico": "samuel.torres@vetmail.com",
      "nombres": "Samuel",
      "apellidos": "Torres",
      "telefono": "555-0301",
      "telefonoAux": "555-0302",
      "mascotasIds": [7, 8, 9, 10]
    },
    {
      "id": 5,
      "userName": "sofiRamz44",
      "password": "Spark4Sof!",
      "correoElectronico": "sofia.ramirez@sparkmail.com",
      "nombres": "Sofía",
      "apellidos": "Ramírez",
      "telefono": "555-0401",
      "telefonoAux": "555-0402",
      "mascotasIds": [11]
    },
    {
      "id": 6,
      "userName": "nMartinez5",
      "password": "N1n@P@ss",
      "correoElectronico": "nina.martinez@dogworld.com",
      "nombres": "Nina",
      "apellidos": "Martínez",
      "telefono": "555-0501",
      "telefonoAux": "555-0502"
    },
    {
      "id": 7,
      "userName": "rayoV222",
      "password": "R4yo2024",
      "correoElectronico": "rayo.valdez@fastmail.com",
      "nombres": "Rayo",
      "apellidos": "Valdez",
      "telefono": "555-0601",
      "telefonoAux": "555-0602"
    },
    {
      "id": 8,
      "userName": "tobyLunatic",
      "password": "TobyTreats!",
      "correoElectronico": "tobias.luna@tinydogs.com",
      "nombres": "Tobías",
      "apellidos": "Luna",
      "telefono": "555-0701",
      "telefonoAux": "555-0702"
    },
    {
      "id": 9,
      "userName": "chiFernandez",
      "password": "Chiqui!Lab",
      "correoElectronico": "chiara.fernandez@lablove.com",
      "nombres": "Chiara",
      "apellidos": "Fernández",
      "telefono": "555-0801",
      "telefonoAux": "555-0802"
    },
    {
      "id": 10,
      "userName": "rocioDalmata",
      "password": "RockyD!az",
      "correoElectronico": "rocio.diaz@dalmail.com",
      "nombres": "Rocío",
      "apellidos": "Díaz",
      "telefono": "555-0901",
      "telefonoAux": "555-0902"
    },
    {
      "id": 11,
      "userName": "pedroN_Boxer",
      "password": "Plut0nBox!",
      "correoElectronico": "pedro.nava@boxerfan.com",
      "nombres": "Pedro",
      "apellidos": "Nava",
      "telefono": "555-1001",
      "telefonoAux": "555-1002"
    },
    {
      "id": 12,
      "userName": "theresa_O",
      "password": "Th0rThunder!",
      "correoElectronico": "theresa.ortega@canichecloud.com",
      "nombres": "Theresa",
      "apellidos": "Ortega",
      "telefono": "555-1101",
      "telefonoAux": "555-1102"
    },
    {
      "id": 13,
      "userName": "franHusky",
      "password": "Ch1c0Cool",
      "correoElectronico": "francisco.hernandez@coldmail.com",
      "nombres": "Francisco",
      "apellidos": "Hernández",
      "telefono": "555-1201",
      "telefonoAux": "555-1202"
    },
    {
      "id": 14,
      "userName": "simonB_Az",
      "password": "SimbaKing!",
      "correoElectronico": "simon.barrera@lionking.com",
      "nombres": "Simón",
      "apellidos": "Barrera",
      "telefono": "555-1301",
      "telefonoAux": "555-1302"
    },
    {
      "id": 15,
      "userName": "lunaMStar",
      "password": "MoonSh1n3",
      "correoElectronico": "luna.mendez@moonshine.com",
      "nombres": "Luna",
      "apellidos": "Mendez",
      "telefono": "555-1401",
      "telefonoAux": "555-1402"
    },
    {
      "id": 16,
      "userName": "brunoV_Guard",
      "password": "Brun0V!Vega",
      "correoElectronico": "bruno.vega@shepherdmail.com",
      "nombres": "Bruno",
      "apellidos": "Vega",
      "telefono": "555-1501",
      "telefonoAux": "555-1502"
    },
    {
      "id": 17,
      "userName": "dLolaCruz",
      "password": "L0laFluff!",
      "correoElectronico": "dolores.cruz@pompride.com",
      "nombres": "Dolores",
      "apellidos": "Cruz",
      "telefono": "555-1601",
      "telefonoAux": "555-1602"
    },
    {
      "id": 18,
      "userName": "nicoJ_Chow",
      "password": "N1c0Chow!",
      "correoElectronico": "nicolas.jimenez@chowchowspace.com",
      "nombres": "Nicolás",
      "apellidos": "Jiménez",
      "telefono": "555-1701",
      "telefonoAux": "555-1702"
    },
    {
      "id": 19,
      "userName": "cocoCastillo",
      "password": "C0c0Spaniel",
      "correoElectronico": "jacobo.castillo@spanielstars.com",
      "nombres": "Jacobo",
      "apellidos": "Castillo",
      "telefono": "555-1801",
      "telefonoAux": "555-1802"
    },
    {
      "id": 20,
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

  obtenerClientePorId(id: number): Observable<Cliente | undefined> {
    const cliente = this.clientesList.find(c => c.id === id);
    return of(cliente);
  }

  verificarCredenciales(userName: string, password: string): Observable<boolean> {
    const usuarioEncontrado = this.clientesList.find(usuario => usuario.userName === userName && usuario.password === password);
    return of(!!usuarioEncontrado);
  }

  agregarCliente(cliente: Cliente): Observable<Cliente> {
    this.clientesList.push(cliente);
    return of(cliente);
  }

  actualizarCliente(cliente: Cliente): Observable<Cliente> {
    const index = this.clientesList.findIndex(c => c.id === cliente.id);
    if (index !== -1) {
      this.clientesList[index] = cliente;
    }
    return of(cliente);
  }

  eliminarCliente(id: number): Observable<{}> {
    const index = this.clientesList.findIndex(c => c.id === id);
    if (index !== -1) {
      this.clientesList.splice(index, 1);
    }
    return of({});
  }

  // obtenerMascotasDeCliente(clienteId: number): Observable<Mascota[]> {
  //   // Aquí iría la lógica para filtrar y devolver las mascotas correspondientes a los IDs
  //   const cliente = this.clientesList.find(c => c.id === clienteId);
  //   if (cliente && cliente.mascotasIds) {
  //     // Suponiendo que tienes un servicio de mascotas que puede obtener mascotas por ID
  //     return this.mascotasService.obtenerMascotasPorIds(cliente.mascotasIds);
  //   }
  //   return of([]);
  // }
}