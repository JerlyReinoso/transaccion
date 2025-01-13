package com.espe.transaccion.controllers;

import com.espe.transaccion.models.entities.Transaccion;
import com.espe.transaccion.services.TransaccionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    @Autowired
    private TransaccionService service;

    @GetMapping
    public List<Transaccion> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> getById(@PathVariable int id) {
        Transaccion transaccion = service.findById(id);
        return transaccion != null ? ResponseEntity.ok(transaccion) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Transaccion> create(@Valid @RequestBody Transaccion transaccion) {
        return ResponseEntity.ok(service.save(transaccion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaccion> update(@PathVariable int id, @Valid @RequestBody Transaccion transaccion) {
        Transaccion existing = service.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        transaccion.setId(id);
        return ResponseEntity.ok(service.save(transaccion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
