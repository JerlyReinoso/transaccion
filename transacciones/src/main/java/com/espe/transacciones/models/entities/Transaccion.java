package com.espe.transacciones.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "transacciones")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El número de transacción es obligatorio")
    @Size(max = 50, message = "El número de transacción no puede tener más de 50 caracteres")
    private String numeroTransaccion;

    @NotBlank(message = "El tipo es obligatorio")
    @Size(max = 20, message = "El tipo no puede tener más de 20 caracteres")
    private String tipo;

    @Min(value = 1, message = "El monto debe ser mayor a 0")
    private int monto;

    @NotNull(message = "La fecha de transacción es obligatoria")
    @PastOrPresent(message = "La fecha de transacción no puede ser futura")
    @Temporal(TemporalType.DATE)
    private Date fechaTransaccion;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public void setNumeroTransaccion(String numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }
}
