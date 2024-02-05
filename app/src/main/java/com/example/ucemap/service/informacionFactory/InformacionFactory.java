package com.example.ucemap.service.informacionFactory;

import android.util.Log;

public class InformacionFactory {

        public static IInformacionFactory contruirInformacion (String tipo){
            if ("facultades".equalsIgnoreCase(tipo)) {
                Log.d("Tipo", tipo);
                return new InformacionFacultad();
            } else if ("edificios".equalsIgnoreCase(tipo)) {
                return  new InformacionEdificio();
                
            }
            return null;
        }

}
