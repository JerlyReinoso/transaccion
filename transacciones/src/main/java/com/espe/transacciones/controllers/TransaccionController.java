package com.espe.transacciones.controllers;

import com.espe.transacciones.models.entities.Transaccion;
import com.espe.transacciones.services.TransaccionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    @Autowired
    private TransaccionService service;

    @GetMapping
    public List<Transaccion> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        Optional<Transaccion> transaccion = service.findById(id);
        if (transaccion.isPresent()) {
            return ResponseEntity.ok(transaccion.get());
        } else {
            Map<String, String> mensaje = new HashMap<>();
            mensaje.put("mensaje", "Transacción no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }


    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Transaccion transaccion, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> errores.put(err.getField(), err.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(transaccion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable int id, @Valid @RequestBody Transaccion transaccion, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> errores.put(err.getField(), err.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }

        Optional<Transaccion> transaccionExistente = service.findById(id);
        if (transaccionExistente.isPresent()) {
            Transaccion transaccionActualizada = transaccionExistente.get();
            transaccionActualizada.setNumeroTransaccion(transaccion.getNumeroTransaccion());
            transaccionActualizada.setTipo(transaccion.getTipo());
            transaccionActualizada.setMonto(transaccion.getMonto());
            transaccionActualizada.setFechaTransaccion(transaccion.getFechaTransaccion());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(transaccionActualizada));
        } else {
            Map<String, String> mensaje = new HashMap<>();
            mensaje.put("mensaje", "Transacción no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("mensaje", "Transacción no encontrada"));
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
