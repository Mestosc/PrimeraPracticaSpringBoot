package org.example.controller;

import org.example.model.Alumno;
import org.example.model.Titor;
import org.example.services.AlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/alumnos")
public class AlumnosController {
    private final AlumnoService alumnoService;

    public AlumnosController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @PostMapping("/añadir")
    public ResponseEntity<Alumno> anadirAlumno(@RequestBody Alumno alumno) {
        Alumno alumno1 = alumnoService.crearOActualizarAlumno(alumno);
        if (alumno1!=null) {
            return ResponseEntity.ok(alumno1);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/obtener")
    public ResponseEntity<Alumno> obtenerAlumno(@RequestParam Long id) {
        Optional<Alumno> alumnoOptional = alumnoService.obtenerAlumno(id);
        if (alumnoOptional.isPresent()) {
            Alumno alumno = alumnoOptional.get();
            return ResponseEntity.ok(alumno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
