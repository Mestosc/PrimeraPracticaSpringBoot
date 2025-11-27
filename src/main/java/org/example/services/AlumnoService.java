package org.example.services;

import jakarta.transaction.Transactional;
import org.example.model.Alumno;
import org.example.model.Titor;
import org.example.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;
    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }
    @Transactional
    public Alumno crearOActualizarAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }
    public List<Alumno> obtenerTodosAlumnos() {
        return alumnoRepository.findAll();
    }
    @Transactional
    public void eliminarAlumno(Alumno alumno) {
        alumnoRepository.delete(alumno);
    }
    public Optional<Alumno> obtenerAlumno(Long id) {
        return alumnoRepository.findById(id);
    }
    public List<Alumno> obtenerAlumnosTutor(Titor titor) {
        return alumnoRepository.findByTitor(titor);
    }
}
