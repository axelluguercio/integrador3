package com.integrador3.integrador3.repository;

import com.integrador3.integrador3.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {

        @Override
        public List<Estudiante> findAll();
        @Query("SELECT e FROM Estudiante e WHERE e.dni = :id")
        public Estudiante findByID(String id);

        @Query("SELECT e FROM Estudiante e WHERE e.num_libreta = :id")
        public Estudiante findByLU(String numLibreta);

        @Query("SELECT t FROM Estudiante t WHERE t.genero = :genero")
        public List<Estudiante> findAllByGender(String genero);

        @Query("SELECT ec.estudiante " +
                "FROM EstudianteCarrera ec " +
                "JOIN ec.estudiante e " +
                "JOIN ec.carrera c " +
                "WHERE e.ciudad = :carrera " +
                "AND c.nombre = :ciudad ")

        public List<Estudiante> findAllByCarreraANDCiudad(@Param("carrera") String carrera, @Param("ciudad") String ciudad);
}
