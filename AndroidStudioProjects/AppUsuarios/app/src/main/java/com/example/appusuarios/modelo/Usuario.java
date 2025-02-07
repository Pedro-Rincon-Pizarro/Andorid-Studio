package com.example.appusuarios.modelo;


public class Usuario {

    private String DNI;
    private String nombre;
    private String telefono;

    public Usuario() {
    }

    public Usuario(String DNI, String nombre, String telefono) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}