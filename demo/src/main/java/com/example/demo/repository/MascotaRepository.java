package com.example.demo.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Mascota;

@Repository
public class MascotaRepository {
    
    private Map<Integer, Mascota> data = new HashMap<>();

    public MascotaRepository() {
        data.put(1, new Mascota( 1, "Lorenzo", "Terrier", 12, "https://i.pinimg.com/originals/fb/6d/16/fb6d16c4321ab45dad1c6290f2740f7a.jpg", 1, 60, 25, "Higiene bucal"));
        data.put(2, new Mascota( 2,"Lukas", "Beagle", 5, "https://aperrados.com/wp-content/uploads/2017/01/west-highland-razas-de-perros-pequenos-blancos.jpg", 2, 40, 20, "Displacia de cadera"));
        data.put(3, new Mascota( 3, "Rocco", "Snauser", 3, "https://i.pinimg.com/originals/28/de/50/28de504a3b4d4e33244ba04d76a796b1.jpg", 3, 50, 30, "Glandulas oculares"));
        data.put(4, new Mascota( 4, "Luna", "Pitbull", 9, "https://i.pinimg.com/originals/d2/2b/25/d22b25bcca6f642654236bba249723fa.jpg",  4, 70, 35, "Sarna de la piel"));
        data.put(5, new Mascota( 5, "Doki", "Golden", 1, "https://heraldodemexico.com.mx/wp-content/uploads/2020/07/Bull-Terrier-4.jpg", 5, 80, 40, "Rotura de pata izquierda posterior"));
        data.put(6, new Mascota( 6, "Morty", "Chihuahua", 2, "https://2.bp.blogspot.com/_w8LSoVjqY6c/S-3rSxKLgAI/AAAAAAAAACY/Po1scSOx8dQ/s1600/349-el_estres_y_los_perros_peque_os_0.jpg", 6, 90, 45, "Ingesta de plásticos"));
    }

    public Mascota findById(int id){
        return data.get(id);
    }

    public Collection<Mascota> findAll(){
        return data.values();
    }

    public void deleteById(int id){
        data.remove(id);
    }

    public void update(Mascota mascota){
        data.put(mascota.getId(), mascota);
    }

    public void add(Mascota mascota){
        int tam = data.size();
        int lastId = data.get(tam).getId();
        mascota.setId(lastId+1);
        data.put(mascota.getId(), mascota);
    }

}
