package com.example.semana2aplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextInputEditText tiFechaNacimiento;
    DatePickerDialog.OnDateSetListener setListener;

    TextInputEditText tiNombre, tiTelefono, tiEmail, tiDescripcion;
    Button btnMiBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inicializar variables
        tiNombre            = (TextInputEditText) findViewById(R.id.tiNombre);
        tiFechaNacimiento   = (TextInputEditText) findViewById(R.id.tiFechaNacimiento);
        tiTelefono          = (TextInputEditText) findViewById(R.id.tiTelefono);
        tiEmail             = (TextInputEditText) findViewById(R.id.tiEmail);
        tiDescripcion       = (TextInputEditText) findViewById(R.id.tiDescripcion);
        btnMiBoton          = (Button) findViewById(R.id.btnMiBoton);


        // Recibir parametros
        Bundle parametros        = getIntent().getExtras();
        if (parametros != null) {
            String nombre = parametros.getString(getResources().getString(R.string.pnombre));
            String fechaNacimiento = parametros.getString(getResources().getString(R.string.pfechanacimiento));
            String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
            String email = parametros.getString(getResources().getString(R.string.pemail));
            String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

            tiNombre.setText(nombre);
            tiFechaNacimiento.setText(fechaNacimiento);
            tiTelefono.setText(telefono);
            tiEmail.setText(email);
            tiDescripcion.setText(descripcion);
        }
        // picker para la fecha
        Calendar calendar   = Calendar.getInstance();
        final int year      = calendar.get(Calendar.YEAR);
        final int month     = calendar.get(Calendar.MONTH);
        final int day       = calendar.get(Calendar.DAY_OF_MONTH);

        tiFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        AlertDialog.THEME_HOLO_LIGHT,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                tiFechaNacimiento.setText(date);
            }
        };

        // listener para el botón
        btnMiBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConfirmarActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre), tiNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfechanacimiento), tiFechaNacimiento.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), tiTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), tiEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), tiDescripcion.getText().toString());
                startActivity(intent);
            }
        });
    }

}