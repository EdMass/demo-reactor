package com.mitocode.demoreactor;

import java.time.LocalDateTime;
import java.util.Objects;

public class Ventas {

    private Integer idVenta;
    private LocalDateTime fecha;

    public Ventas(Integer idVenta, LocalDateTime fecha) {
        this.idVenta = idVenta;
        this.fecha = fecha;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Ventas{" +
                "idVenta=" + idVenta +
                ", fecha=" + fecha +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ventas)) return false;
        Ventas ventas = (Ventas) o;
        return Objects.equals(getIdVenta(), ventas.getIdVenta()) && Objects.equals(getFecha(), ventas.getFecha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdVenta(), getFecha());
    }
}
