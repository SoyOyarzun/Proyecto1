package cl.playground.proyecto1.controllers;

import cl.playground.proyecto1.service.AlumnoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlumnoControllers {
    private final AlumnoService alumnoService;

    public AlumnoControllers(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("alumnos", alumnoService.findAll());
        return "home";

    }
}
