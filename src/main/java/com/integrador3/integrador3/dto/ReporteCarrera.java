package com.integrador3.integrador3.dto;

import lombok.Data;

@Data
public class ReporteCarrera {

    private String nombre;
    private int inscriptos;
    private Long egresados;
    private int anio;

    public ReporteCarrera(String nombre, Long egres, int insc, int anio ) {
        this.nombre = nombre;
        this.inscriptos = insc;
        this.egresados = egres;
        this.anio = anio;
    }
}
