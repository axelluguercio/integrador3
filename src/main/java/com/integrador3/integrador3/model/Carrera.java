package com.integrador3.integrador3.model;

import com.integrador3.integrador3.dto.ReporteCarrera;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "carrera")
public class Carrera {

    @Id
    @Column(name = "id_carrera")
    private String id;

    @Column(name = "carrera")
    private String nombre;

    @Column(name = "duracion")
    private int duracion;

    public Carrera(){}
    public Carrera(String id, String nombre, int duracion) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
