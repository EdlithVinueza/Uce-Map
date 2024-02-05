package com.example.ucemap.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ucemap.R;
import com.example.ucemap.repository.modelo.Descripcion;
import com.example.ucemap.ui.MapaActivity;

import java.util.List;

public class RecycleViewAdaptadorListaDetalles extends RecyclerView.Adapter<RecycleViewAdaptadorListaDetalles.ViewHolder> {

    public List<Descripcion> listaOpcioneModelos;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView destalle;
        public ViewHolder(View itemView){
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            destalle = itemView.findViewById(R.id.textDetalle);
        }
    }

    public RecycleViewAdaptadorListaDetalles(Context context, List<Descripcion> descripciones){
        this.context = context;
        this.listaOpcioneModelos = descripciones;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detalles, parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position ){
        holder.titulo.setText(this.listaOpcioneModelos.get(position).getTitulo());
        holder.destalle.setText(this.listaOpcioneModelos.get(position).getDescripcion());
    }


    @Override
    public int getItemCount() {
        return listaOpcioneModelos.size();
    }



}

