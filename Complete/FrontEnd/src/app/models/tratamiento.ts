import { Mascota } from "./mascota";
import { Medicamento } from "./medicamento";
import { Veterinario } from "./veterinario";

export interface Tratamiento{
    id?: number;
    titulo: string;
    descripcion: string;
    estado: string;
    mascota: Mascota;
    veterinario: Veterinario;
    medicamentos: Medicamento[];
}