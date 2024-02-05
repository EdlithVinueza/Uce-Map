package com.example.ucemap.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;

import com.example.ucemap.R;
import com.example.ucemap.data.DatosJason;
import com.example.ucemap.utilidades.FuncionesAdicionales;

public class MenuPrincipalActivity extends AppCompatActivity {
    private Button botonFacultad;
    private Button botonEdificio;
    private Intent intent;

    public static String nombreDocumentoInterno;
    public static String atributoParaEvaluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);

        botonFacultad = findViewById(R.id.bottonFacultad);
        botonEdificio = findViewById(R.id.bottonEdificio);



        botonFacultad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MenuPrincipalActivity.this, ListaOpcionesActivity.class);

                enviarTituloListaOpciones("Escoge una Facultad");
                enviarNombreArchivoInternoListaOpciones(DatosJason.FACULTAD_NOMBRE_DOCUMENTO_INTERNO);
                enviarAtributoListaOpciones(DatosJason.ATRIBUTO_GENERAL_NOMBRE);
                startActivity(intent);
                finish();
            }
        });


        botonEdificio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MenuPrincipalActivity.this, ListaOpcionesActivity.class);

                enviarTituloListaOpciones("Escoge un Edificio");
                enviarNombreArchivoInternoListaOpciones(DatosJason.EDIFICIO_NOMBRE_DOCUMENTO_INTERNO);
                enviarAtributoListaOpciones(DatosJason.ATRIBUTO_GENERAL_NOMBRE);
                startActivity(intent);
                finish();
            }
        });
    }

    //Metodos para enviar informacion al activity Lista Opciones

    public void enviarTituloListaOpciones(String nuevoTitulo){
        FuncionesAdicionales.enviarNuevoAtributoString(intent,"tituloLayoutListaOpciones",nuevoTitulo);
    }
    public void enviarNombreArchivoInternoListaOpciones(String opcion){
        FuncionesAdicionales.enviarNuevoAtributoString(intent,"nombreArchivoInternoListaOpciones",opcion); //Cargo informacion para ListaOpcines
        FuncionesAdicionales.enviarNuevoAtributoString(intent,"nombreDocumentoInternoMapa",opcion);
        nombreDocumentoInterno = opcion;
    }
    public void enviarAtributoListaOpciones(String atributo){
        FuncionesAdicionales.enviarNuevoAtributoString(intent,"nombreAtributoListaOpciones",atributo);
        atributoParaEvaluar = atributo;
    }

    @Override
    public Intent getIntent() {
        return intent;
    }

    @Override
    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        FuncionesAdicionales.mostrarMensaje(this, "Regresamos!!");
        finish();

    }



}
