package com.example.semana2aplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechaNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        // Recibir parametros
        Bundle parametros        = getIntent().getExtras();
        String nombre            = parametros.getString(getResources().getString(R.string.pnombre));
        String fechaNacimiento   = parametros.getString(getResources().getString(R.string.pfechanacimiento));
        String telefono          = parametros.getString(getResources().getString(R.string.ptelefono));
        String email             = parametros.getString(getResources().getString(R.string.pemail));
        String descripcion       = parametros.getString(getResources().getString(R.string.pdescripcion));

        // Ya capturamos los datos, ahora para mostrarlos
        tvNombre            = (TextView) findViewById(R.id.tvNombre);
        tvFechaNacimiento   = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvTelefono          = (TextView) findViewById(R.id.tvTelefono);
        tvEmail             = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion       = (TextView) findViewById(R.id.tvDescripcion);

        // inicializamos button
        btnEditar = (Button) findViewById(R.id.btnEditar);

        // Setear los textos
        tvNombre.setText(nombre);
        tvFechaNacimiento.setText(fechaNacimiento);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        // listener para el botón
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarActivity.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre), tvNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfechanacimiento), tvFechaNacimiento.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), tvTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), tvEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), tvDescripcion.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(ConfirmarActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}