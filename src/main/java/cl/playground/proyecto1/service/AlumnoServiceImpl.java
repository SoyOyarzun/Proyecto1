package cl.playground.proyecto1.service;

import cl.playground.proyecto1.model.Alumno;
import cl.playground.proyecto1.repository.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public void registarAlumno(Alumno alumno) {

        if (alumno != null) {
            alumnoRepository.saveAlumnoQuery(alumno.getNombre(), alumno.getApellido(), alumno.getEdad(), alumno.getCurso());
        }

    }

    @Override
    public void autenticarAlumno(String username, String password) {

    }

    @Override
    public Optional<Alumno> buscarPorId(Long id) {
        Optional<Alumno> alumnoEncontrado = alumnoRepository.findById(id);

        if (alumnoEncontrado.isPresent()) {
            System.out.println("Alumno encontrado: " + alumnoEncontrado.get());
            return alumnoEncontrado; // Retorna el alumno si existe
        } else {
            System.out.println("No se encontró ningún alumno con ID: " + id);
            return Optional.empty(); // Retorna un Optional vacío si no existe
        }
    }

    @Override
    public List<Alumno> findAll() {
        List<Alumno> alumnos = alumnoRepository.findAllAlumnosQuery();
        if (alumnos.isEmpty()) {
            System.out.println("No se encontraron alumnos en la base de datos.");
            throw new RuntimeException("No hay nada");
        }

        return alumnos;
    }

    @Override
    public void editarAlumno(Alumno alumno) { // editarAlumno(Long usuarioId, Alumno alumno)
        Optional<Alumno> alumnoEncontrado = alumnoRepository.findById(alumno.getId());
        if (alumnoEncontrado.isPresent()) {
            // Actualizar los datos del alumno existente

            alumnoRepository.updateAlumnoQuery(
                    // alumno.getId() o alumnoEncontrado.get().getId()
                    alumnoEncontrado.get().getId(),
                    alumno.getNombre(),
                    alumno.getApellido(),
                    alumno.getEdad(),
                    alumno.getCurso());

            System.out.println("Alumno actualizado con éxito: " + alumnoEncontrado);
        } else {
            System.out.println("No se encontró ningún alumno con el ID: " + alumno.getId());
            throw new IllegalArgumentException("No se puede editar. El alumno con ID " + alumno.getId() + " no existe.");
        }

    }

    @Override
    public void eliminarAlumno(Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("El objeto alumno no puede ser nulo.");
        }

        // Validar que el ID del alumno no sea nulo ni negativo
        if (alumno.getId() == null || alumno.getId() <= 0) {
            throw new IllegalArgumentException("El ID del alumno no puede ser nulo o negativo.");
        }

        // Verificar si el alumno con el ID existe en la base de datos
        Optional<Alumno> alumnoExistente = alumnoRepository.findById(alumno.getId());
        if (alumnoExistente.isPresent()) {
            // Eliminar el alumno encontrado
            alumnoRepository.deleteById(alumno.getId());
            System.out.println("Alumno eliminado con éxito: " + alumnoExistente.get());
        } else {
            // Si no existe, lanzar una excepción
            System.out.println("No se encontró ningún alumno con el ID: " + alumno.getId());
            throw new IllegalArgumentException("No se puede eliminar. El alumno con ID " + alumno.getId() + " no existe.");
        }
    }

    //Alonso estuvo aqui 2.0
}
