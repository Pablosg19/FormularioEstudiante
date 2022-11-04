package com.example.formularioestudiante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.formularioestudiante.clases.Estudiante;

public class BaseDatosActivity extends AppCompatActivity {

    private Estudiante e = null;
    private TextView txtDni = null;
    private TextView txtNombre = null;
    private TextView txtCurso = null;
    private TextView txtFecha = null;
    private TextView txtHora = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_datos);

        Intent intent = getIntent();
        if(intent != null){
             e =(Estudiante) intent.getSerializableExtra(MainActivity.EXTRA_ESTUDIANTE);
        }
        if (e != null){
            txtDni = (TextView) findViewById(R.id.txt_dni);
            txtDni.setText("DNI: \n" + e.getDni());
            txtNombre = (TextView) findViewById(R.id.txt_nombre);
            txtNombre.setText("Nombre: \n" + e.getNombre());
            txtCurso = (TextView) findViewById(R.id.txt_curso);
            txtCurso.setText("Curso: \n" + e.getCurso());
            txtFecha = (TextView) findViewById(R.id.txt_fechaNacimiento);
            txtFecha.setText("Fecha: \n" + e.getFecha_nacimiento());
            txtHora = (TextView) findViewById(R.id.txt_horaVisita);
            txtHora.setText("Hora: \n" + e.getHora_tutoria());

        }
    }
}