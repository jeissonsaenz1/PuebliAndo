package com.example.puebliando;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    EditText cajaNombre,cajaCedula,cajaEmail;
    Button botonRegistrar,botonListar;

    FirebaseFirestore baseDatos = FirebaseFirestore.getInstance();

    Map<String, Object> usuario = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        cajaNombre=findViewById(R.id.nombre);
        cajaCedula=findViewById(R.id.cedula);
        cajaEmail=findViewById(R.id.email);

        botonRegistrar=findViewById(R.id.botonRegistrar);
        botonListar=findViewById(R.id.botonBuscar);

        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Se obtienen los valores de cada EDITTEXT
                String nombre=cajaNombre.getText().toString();
                String cedula=cajaCedula.getText().toString();
                String cargo=cajaEmail.getText().toString();

                usuario.put("nombre",nombre);
                usuario.put("cedula",cedula);
                usuario.put("email",cargo);

                registrarUsuario();
            }
        });

    }

    private void registrarUsuario(){

        baseDatos.collection("usuarios")
                .add(usuario)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        cajaNombre.setText("");
                        Toast.makeText(getApplicationContext(),"Exito agregando el empleado",Toast.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getApplicationContext(),"Error: "+e,Toast.LENGTH_LONG).show();

                    }
                });


    }
}