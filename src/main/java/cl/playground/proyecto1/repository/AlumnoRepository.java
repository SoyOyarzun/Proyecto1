package cl.playground.proyecto1.repository;

import cl.playground.proyecto1.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
