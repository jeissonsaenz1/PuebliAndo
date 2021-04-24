package com.example.puebliando;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;


public class Home extends AppCompatActivity {

    ArrayList<Inicio> listaDeDatos = new ArrayList<>();
    RecyclerView listado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listado = findViewById(R.id.listado);
        listado.setHasFixedSize(true);
        listado.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        crearListado();

        AdaptadorLista adaptador = new AdaptadorLista(listaDeDatos);
        listado.setAdapter(adaptador);

    }


    private void crearListado() {

        listaDeDatos.add(new Inicio(
                "Lugares Turisticos",
                R.drawable.foto1
        ));
        listaDeDatos.add(new Inicio(
                "Celebraciones",
                R.drawable.cel1
        ));

    }
}

