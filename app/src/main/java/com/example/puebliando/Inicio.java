package com.example.puebliando;

import java.io.Serializable;

public class Inicio implements Serializable {

    String titulo, foto;

    public Inicio(String titulo, String foto) {
        this.titulo = titulo;
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}










