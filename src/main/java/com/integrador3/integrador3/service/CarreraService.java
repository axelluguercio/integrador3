package com.integrador3.integrador3.service;

import com.integrador3.integrador3.dto.CantidadInscriptosDTO;
import com.integrador3.integrador3.dto.ReporteCarrera;
import com.integrador3.integrador3.model.Carrera;
import com.integrador3.integrador3.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService  {
    @Autowired
    CarreraRepository repository;


    public List<CantidadInscriptosDTO> getAllCarrerasOrdenadas() {
        return repository.sortByInscriptos();
    }

    public List<ReporteCarrera> getReport() {
        return repository.generateReport();
    }
}
