package com.espe.transacciones.repositories;

import com.espe.transacciones.models.entities.Transaccion;
import org.springframework.data.repository.CrudRepository;

public interface TransaccionRepository extends CrudRepository<Transaccion, Integer> {
}
