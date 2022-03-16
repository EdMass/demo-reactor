package com.mitocode.demoreactor;

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
}
