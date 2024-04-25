export interface Tratamiento{
    id?: number;
    titulo: string;
    descripcion: string;
    estado: string;
    mascotaId: number;
    veterinarioId: number;
    medicamentosIds: number[];
}