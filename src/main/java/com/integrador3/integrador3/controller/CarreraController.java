package com.integrador3.integrador3.controller;

import com.integrador3.integrador3.dto.CantidadInscriptosDTO;
import com.integrador3.integrador3.dto.ReporteCarrera;
import com.integrador3.integrador3.model.Carrera;
import com.integrador3.integrador3.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    CarreraService CarreraServicio;

    @GetMapping("/SortByInscriptos")
    public ResponseEntity<List<CantidadInscriptosDTO>> getCarrerasByInscriptos() {
        List<CantidadInscriptosDTO> resultado = CarreraServicio.getAllCarrerasOrdenadas();
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @GetMapping("/reporte")
    public List<ReporteCarrera> getReporteCarreras() {
        return CarreraServicio.getReport();
    }
}
