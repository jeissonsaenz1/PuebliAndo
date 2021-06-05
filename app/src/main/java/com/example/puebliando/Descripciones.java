package com.example.puebliando;

import java.io.Serializable;

public class Descripciones implements Serializable {
    String titulo,descripcion,foto1;

    public Descripciones(String titulo, String descripcion, String foto1) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.foto1 = foto1;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }
}
