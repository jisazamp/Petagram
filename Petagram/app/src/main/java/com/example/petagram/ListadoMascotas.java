package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ListadoMascotas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // super llama a la superclase, y su metodo onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_mascotas); //muestra lo que hay en el archivo layout

    }
}