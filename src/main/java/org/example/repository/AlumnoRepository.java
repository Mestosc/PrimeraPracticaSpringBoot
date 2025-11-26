package org.example.repository;

import org.example.model.Alumno;
import org.example.model.Titor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
    List<Alumno> findByTitor(Titor tutor);
}
