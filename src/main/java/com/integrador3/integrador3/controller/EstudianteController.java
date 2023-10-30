package com.integrador3.integrador3.controller;

import com.integrador3.integrador3.model.Estudiante;
import com.integrador3.integrador3.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService EstudianteService;

    public EstudianteController(EstudianteService service) {}

    @PostMapping("/")
    public Estudiante newEstudiante(@RequestBody Estudiante e) { return EstudianteService.add(e); }

    @PostMapping("/{dni}/enroll")
    public ResponseEntity<Estudiante> enrollEstudiante(
            @PathVariable String dni,
            @RequestParam String materia) {
        Estudiante estudiante = EstudianteService.getByID(dni);
        if (estudiante != null) {
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/")
    public ResponseEntity<List<Estudiante>> getEstudiantes() {
        List<Estudiante> estudiantes = EstudianteService.getAll();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    @GetMapping(value="/ByLibreta/{num_libreta}")
    public ResponseEntity<Estudiante> getEstudiantesByLU(String num_libreta) {
        Estudiante resultado = EstudianteService.getByLU(num_libreta);
        if (resultado != null) {
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ByGenero/{genero}")
    public ResponseEntity<List<Estudiante>> getEstudiantesByGender(String genero) {
        List<Estudiante> resultado = EstudianteService.getAllByGender(genero);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @GetMapping("/ByCiudadAndCarrera/{carrera}/{ciudad}")
    public ResponseEntity<List<Estudiante>> getEstudiantesByCarreraYCiudad(String carrera, String ciudad) {
        List<Estudiante> resultado = EstudianteService.getAllByCarreraANDCiudad(carrera, ciudad);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
