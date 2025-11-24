package org.example.services;

import jakarta.transaction.Transactional;
import org.example.model.Alumno;
import org.example.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;
    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }
    @Transactional
    public Alumno crearAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }
}
