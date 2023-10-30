package com.integrador3.integrador3.repository;

import com.integrador3.integrador3.dto.CantidadInscriptosDTO;
import com.integrador3.integrador3.dto.ReporteCarrera;
import com.integrador3.integrador3.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, String> {
    @Query("SELECT NEW com.integrador3.integrador3.dto.CantidadInscriptosDTO(c, count(e)) " +
            "FROM EstudianteCarrera ec " +
            "JOIN ec.carrera c " +
            "JOIN ec.estudiante e " +
            "GROUP BY c " +
            "ORDER BY count(e) DESC")
    public List<CantidadInscriptosDTO> sortByInscriptos();

    @Query(
            "SELECT NEW com.integrador3.integrador3.dto.ReporteCarrera(c.nombre, COUNT(ec.id), " +
            "(SELECT COUNT(ec2) FROM EstudianteCarrera ec2 WHERE ec2.carrera = c AND ec2.anio_graduacion = ec.anio), " +
            "ec.anio) " +
            "FROM EstudianteCarrera ec " +
            "JOIN ec.carrera c " +
            "GROUP BY c.nombre, ec.anio " +
            "ORDER BY c.nombre ASC, ec.anio ASC"
    )
    List<ReporteCarrera> generateReport();
}
