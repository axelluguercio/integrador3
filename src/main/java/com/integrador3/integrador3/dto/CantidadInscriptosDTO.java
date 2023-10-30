package com.integrador3.integrador3.dto;

import com.integrador3.integrador3.model.Carrera;
import lombok.Data;

@Data
public class CantidadInscriptosDTO {

    private Carrera carrera;
    private Long cantidad;

    public CantidadInscriptosDTO(Carrera carrera, Long cant) {
        this.carrera = carrera;
        this.cantidad = cant;
    }
}
