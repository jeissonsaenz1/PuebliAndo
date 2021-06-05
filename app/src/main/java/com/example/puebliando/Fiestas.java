package com.example.puebliando;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Fiestas extends AppCompatActivity {

    ArrayList<Descripciones> listaDeDatos = new ArrayList<>();
    RecyclerView listado2;
    FirebaseFirestore baseDatos = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiestas);

        listado2 = findViewById(R.id.listado2);
        listado2.setHasFixedSize(true);
        listado2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        crearListado();
    }

    private void crearListado() {

        baseDatos.collection("descripciones")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){


                            for (QueryDocumentSnapshot document: task.getResult()){
                                String titulo=document.get("titulo").toString();
                                String descripcion=document.get("descripcion").toString();
                                String foto=document.get("foto").toString();

                                listaDeDatos.add(new Descripciones(titulo,descripcion,foto));
                            }
                            AdaptadorListaFiesta adaptador = new AdaptadorListaFiesta(listaDeDatos);
                            listado2.setAdapter(adaptador);


                        }else{
                            Toast.makeText(getApplicationContext(),"Error al mostrar datos",Toast.LENGTH_LONG).show();
                        }

                    }
                });

    }
}