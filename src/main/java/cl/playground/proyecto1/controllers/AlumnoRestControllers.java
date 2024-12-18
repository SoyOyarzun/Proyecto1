package cl.playground.proyecto1.controllers;

import cl.playground.proyecto1.model.Alumno;
import cl.playground.proyecto1.service.AlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlumnoRestControllers {
    private final AlumnoService alumnoService;

    public AlumnoRestControllers(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> getAllAlumnos() {
        List<Alumno> alumnos = alumnoService.findAll();
        return ResponseEntity.ok(alumnos);
    }
    
}
