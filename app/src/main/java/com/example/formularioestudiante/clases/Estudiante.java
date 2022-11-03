package com.example.formularioestudiante.clases;

import java.io.Serializable;
import java.util.Objects;

public class Estudiante implements Serializable {
    // Atributos
    private String dni;
    private String nombre;
    private String curso;
    private String fecha_nacimiento;
    private String hora_tutoria;
    // Constructor
    public Estudiante(String dni, String nombre, String curso, String fecha_nacimiento, String hora_tutoria) {
        this.dni = dni;
        this.nombre = nombre;
        this.curso = curso;
        this.fecha_nacimiento = fecha_nacimiento;
        this.hora_tutoria = hora_tutoria;
    }
    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getHora_tutoria() {
        return hora_tutoria;
    }

    public void setHora_tutoria(String hora_tutoria) {
        this.hora_tutoria = hora_tutoria;
    }
    // Equasl and HasCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return dni.equals(that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
    // To String

    @Override
    public String toString() {
        return "Estudiante{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", hora_tutoria='" + hora_tutoria + '\'' +
                '}';
    }
}
