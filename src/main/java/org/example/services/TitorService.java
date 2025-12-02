
package org.example.services;

import org.example.model.Alumno;
import org.example.model.Titor;
import org.example.repository.TitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitorService {
    private final TitorRepository titorRepository;
    @Autowired
    public TitorService(TitorRepository titorRepository) {
        this.titorRepository = titorRepository;
    }

    public Titor crearOActualizarTitor(Titor titor) {
        return titorRepository.save(titor);
    }
    public List<Titor> obtenerTitores() {
        return titorRepository.findAll();
    }
    public Optional<Titor> obtenerTitor(Long id) {
        return titorRepository.findById(id);
    }
    public void eliminarTitor(Titor titor) {
        titorRepository.delete(titor);
    }
}
