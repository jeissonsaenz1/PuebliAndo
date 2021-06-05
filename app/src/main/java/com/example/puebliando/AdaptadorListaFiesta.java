package com.example.puebliando;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorListaFiesta extends RecyclerView.Adapter<AdaptadorListaFiesta.viewHolder> {

    ArrayList<Descripciones> listaDeDatos;

    public AdaptadorListaFiesta(ArrayList<Descripciones> listaDeDatos) {
        this.listaDeDatos = listaDeDatos;

    }

    @NonNull
    @Override
    public AdaptadorListaFiesta.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaItemListaFiestas= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_de_lista_fiestas,parent,false);
        return new viewHolder(vistaItemListaFiestas);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorListaFiesta.viewHolder holder, int position) {
        holder.actualizarDatosDeItem(listaDeDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDeDatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView descripcion;
        ImageView foto;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            titulo=itemView.findViewById(R.id.titulo1);
            descripcion=itemView.findViewById(R.id.descripcion1);
            foto=itemView.findViewById(R.id.foto1);
        }

        public void actualizarDatosDeItem(Descripciones datos) {
            titulo.setText(datos.getTitulo());
            descripcion.setText(datos.getDescripcion());
            Picasso.with(itemView.getContext())
                    .load(datos.getFoto1())
                    .into(foto);



        }
    }
}