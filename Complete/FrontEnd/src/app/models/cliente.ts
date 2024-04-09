export interface Cliente{
    id?: number;
    userName: string;
    password: string;
    correoElectronico: string;
    nombres: string;
    apellidos: string;
    telefono: string;
    telefonoAux: string;
    mascotasIds?: number[];
}