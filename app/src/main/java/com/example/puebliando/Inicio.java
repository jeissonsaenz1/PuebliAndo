package com.example.puebliando;

import java.io.Serializable;

public class Inicio implements Serializable {

    String titulo;
    int foto;

    public Inicio(String titulo, int foto) {
        this.titulo = titulo;
        this.foto = foto;
    }

    public String getLugaresTuristicos() {
        return titulo;
    }

    public void setLugaresTuristicos(String lugaresTuristicos) {
        this.titulo = lugaresTuristicos;
    }

    public int getFotoTurismo() {
        return foto;
    }

    public void setFotoTurismo(int fotoTurismo) {
        this.foto = fotoTurismo;
    }
}









