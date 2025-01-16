package com.espe.transacciones.services;

import com.espe.transacciones.models.entities.Transaccion;

import java.util.List;
import java.util.Optional;

public interface TransaccionService {
    List<Transaccion> findAll();
    Optional<Transaccion> findById(int id);
    Transaccion save(Transaccion transaccion);
    void deleteById(int id);
}
