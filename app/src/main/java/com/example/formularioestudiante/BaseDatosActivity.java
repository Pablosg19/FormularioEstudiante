package com.example.formularioestudiante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.formularioestudiante.clases.Estudiante;

public class BaseDatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_datos);

        Intent intent = getIntent();
        if(intent != null){
            Estudiante e =(Estudiante) intent.getSerializableExtra(MainActivity.EXTRA_ESTUDIANTE);
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }
}