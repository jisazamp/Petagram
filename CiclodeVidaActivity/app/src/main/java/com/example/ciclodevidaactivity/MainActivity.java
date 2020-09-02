package com.example.ciclodevidaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, getResources().getString(R.string.oncreate), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, getResources().getString(R.string.onstart), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, getResources().getString(R.string.onresume), Toast.LENGTH_SHORT).show();
    }

    // hasta este punto la actividad ya está corriendo

    @Override
    protected void onRestart() {
        Toast.makeText(this, getResources().getString(R.string.onrestart), Toast.LENGTH_SHORT).show();
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, getResources().getString(R.string.onpause), Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, getResources().getString(R.string.onstop), Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, getResources().getString(R.string.ondsetroy), Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}