package org.example.controller;

import org.example.model.Titor;
import org.example.services.TitorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/titores")
public class TitorController {
    private final TitorService titorService;

    public TitorController(TitorService titorService) {
        this.titorService = titorService;
    }

    @PostMapping("/añadir")
    public ResponseEntity<Titor> anadirTitor(@RequestBody Titor titor) {
        Titor titor1 = titorService.crearOActualizarTitor(titor);
        if (titor1!=null) {
            return ResponseEntity.ok(titor1);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/obtener")
    public ResponseEntity<Titor> obtenerTitor(@RequestParam Long id) {
        Optional<Titor> titor = titorService.obtenerTitor(id);
        return titor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); // El map devuelve un optional al que contiene el resultado de ResponseEntity.ok sobre el objeto y el orElseGet obtiene el error si lo hay
    }

    @DeleteMapping("/eliminar")
    public void eliminarTitor(@RequestBody Titor titor) {
        titorService.eliminarTitor(titor);
    }
    @DeleteMapping("/eliminarID")
    public void eliminarTitor(@RequestParam Long id) {
        Optional<Titor> titor = titorService.obtenerTitor(id);
        titor.ifPresent(this::eliminarTitor);
    }
}
