package com.mitocode.demoreactor;

import java.util.Objects;

public class Persona {
    private String Nombre;
    private String Cedula;
    private Integer edad;

    public Persona(String nombre, String cedula, Integer edad) {
        Nombre = nombre;
        Cedula = cedula;
        this.edad = edad;
    }

    public Persona() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + Nombre + '\'' +
                ", Cedula='" + Cedula + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return getCedula().equals(persona.getCedula());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCedula());
    }
}
