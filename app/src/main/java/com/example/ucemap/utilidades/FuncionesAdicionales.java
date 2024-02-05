package com.example.ucemap.utilidades;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.widget.Toast;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class FuncionesAdicionales {

    public static void mostrarMensaje(Context context, String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

    public static void enviarNuevoAtributoString(Intent intent, String marcador, String atributo) {
        intent.putExtra(marcador, atributo);
    }

    public static void enviarNuevoAtributoInt(Intent intent, String marcador, int nuevoValor) {
        intent.putExtra(marcador, nuevoValor);
    }

    public static String agregarViñetas(List<String> lista) {
        StringBuilder resultado = new StringBuilder();

        for (String elemento : lista) {
            resultado.append("• ").append(elemento).append("\n");
        }

        return resultado.toString();
    }

    public static int obtenerAlturaBarraNavegacion(Context context) {
        int alturaBarraNavegacion = 0;

        // Obtener el servicio de DisplayMetrics
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();

        // Extraer la altura de la barra de navegación en píxeles
        int resourceId = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            alturaBarraNavegacion = context.getResources().getDimensionPixelSize(resourceId);
        }

        return alturaBarraNavegacion;
    }

    public static List<CarouselItem> convertirAListaCarouselItem(List<String> urls) {
        List<CarouselItem> listaCarouselItem = new ArrayList<>();

        for (String url : urls) {
            listaCarouselItem.add(new CarouselItem((String) url));
        }

        return listaCarouselItem;
    }


}
