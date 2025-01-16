package com.espe.transacciones.services;

import com.espe.transacciones.models.entities.Transaccion;
import com.espe.transacciones.repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    private TransaccionRepository repository;

    @Override
    public List<Transaccion> findAll() {
        return (List<Transaccion>) repository.findAll();
    }

    @Override
    public Optional<Transaccion> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Transaccion save(Transaccion transaccion) {
        return repository.save(transaccion);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
