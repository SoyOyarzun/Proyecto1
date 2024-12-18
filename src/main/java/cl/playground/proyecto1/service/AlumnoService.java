package cl.playground.proyecto1.service;

import cl.playground.proyecto1.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    void registarAlumno(Alumno alumno);
    void autenticarAlumno(String username, String password);
    Optional<Alumno> buscarPorId(Long id);
    List<Alumno> findAll();
    void editarAlumno(Alumno alumno);
    void eliminarAlumno (Alumno alumno);
}

