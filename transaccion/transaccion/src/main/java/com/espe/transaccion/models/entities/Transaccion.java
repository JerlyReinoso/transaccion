package com.espe.transaccion.models.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transacciones")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numero_transaccion", nullable = false, length = 50)
    private String numeroTransaccion;

    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;

    @Column(name = "monto", nullable = false)
    private int monto;

    @Column(name = "fecha_transaccion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaTransaccion;

    // Getters
    public int getId() {
        return id;
    }

    public String getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public String getTipo() {
        return tipo;
    }

    public int getMonto() {
        return monto;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNumeroTransaccion(String numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }
}
