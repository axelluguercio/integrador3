package com.integrador3.integrador3.service;

import com.integrador3.integrador3.model.Estudiante;
import com.integrador3.integrador3.repository.EstudianteRepository;
import org.hibernate.sql.model.PreparableMutationOperation;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EstudianteService {

    EstudianteRepository repository;


    public Estudiante getByID(String dni) {
        return repository.findByID(dni);
    }

    public List<Estudiante> getAll() {
        return repository.findAll();
    }

    public Estudiante getByLU(String numLibreta) {
        return repository.findByLU(numLibreta);
    }

    public List<Estudiante> getAllByGender(String genero) {
        return repository.findAllByGender(genero);
    }

    public List<Estudiante> getAllByCarreraANDCiudad(String carrera, String ciudad) {
        return repository.findAllByCarreraANDCiudad(carrera, ciudad);
    }

    public Estudiante add(Estudiante e) {
        return repository.save(e);
    }
}
