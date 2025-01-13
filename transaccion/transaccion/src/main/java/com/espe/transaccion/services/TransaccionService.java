package com.espe.transaccion.services;

import com.espe.transaccion.models.entities.Transaccion;
import com.espe.transaccion.repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository repository;

    public List<Transaccion> findAll() {
        return repository.findAll();
    }

    public Transaccion findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Transaccion save(Transaccion transaccion) {
        return repository.save(transaccion);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
