package com.example.formularioestudiante;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.formularioestudiante.clases.Estudiante;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_ESTUDIANTE = "com.example.formularioestudiante.mainactivity.estudiante";
    private String cursoSeleccionado = null;
    private EditText edtDni;
    private EditText edtNombre;
    private Spinner spListaCursos;
    private EditText edtFecha;
    private EditText edtHoraVisita;
    private CheckBox cbCondiciones;

    private String dni;
    private String nombre;
    private String curso;
    private String fecha;
    private String hora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtDni = (EditText) findViewById(R.id.edt_dni);
        edtNombre = (EditText) findViewById(R.id.edt_nombre);
        spListaCursos = (Spinner) findViewById(R.id.spinner_curso);
        edtFecha = (EditText) findViewById(R.id.edt_fechaNacimiento);
        edtHoraVisita = (EditText) findViewById(R.id.edt_horaVisita);
        cbCondiciones = (CheckBox) findViewById(R.id.cb_Condiciones);
        if(spListaCursos != null){
            spListaCursos.setOnItemSelectedListener(this);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cursos, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spListaCursos.setAdapter(adapter);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
       cursoSeleccionado = adapterView.getItemAtPosition(i).toString();
        Log.i("itemSeleccionado", cursoSeleccionado);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        cursoSeleccionado = "1º DAM";
        Log.i("itemSeleccionado", cursoSeleccionado);
    }

    public void mostrarCalendario(View view) {
        // Cargar el datepicker y mostrarlo
        DatepickerFragment calendario1 = new DatepickerFragment();
        calendario1.show(getSupportFragmentManager(),"DatePicker");
    }
    public void crearFecha(int year, int month, int day){
        String txtYear = String.valueOf(year);
        month = month+1;
        String txtMonth = String.valueOf(month);
        String txtDay = String.valueOf(day);
        String txtFecha = txtDay +"/" + month + "/" + year;
        edtFecha.setText(txtFecha);
    }

    public void mostrarHora(View view) {
       TimePickerFragment reloj1 = new TimePickerFragment();
       reloj1.show(getSupportFragmentManager(),"TimePicker");
    }

    public void crearHora(int hora, int minutos) {
        String txtHora = "";
        String txtMinutos = "";
        if(hora>=10){
            txtHora= String.valueOf(hora);
        }
        else{
            txtHora="0"+String.valueOf(hora);
        }
        if(minutos >=10){
            txtMinutos = String.valueOf(minutos);
        }
        else{
            txtMinutos = "0" + String.valueOf(minutos);
        }
        String txtHoraVisita = txtHora +":" + txtMinutos;
        edtHoraVisita.setText(txtHoraVisita);
    }

    public void mostrarMensaje(String texto){
        Toast.makeText(this,texto,Toast.LENGTH_LONG).show();
    }
    public void enviarEstudiante(View view) {
        if(!cbCondiciones.isChecked()){
            Toast.makeText(this,"Debes aceptar las condiciones",Toast.LENGTH_LONG).show();
            return;
        }
        dni = String.valueOf(edtDni.getText());
        nombre = String.valueOf(edtNombre.getText());
        curso = cursoSeleccionado;
        fecha = String.valueOf(edtFecha.getText());
        hora = String.valueOf(edtHoraVisita.getText());
        // Mandarlo a la base de datos
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("ALTA DE ESTUDIANTE");
        alerta.setMessage("¿Son correctos los datos proporcionados?");
        alerta.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                irPantalla2();
            }
        });
        alerta.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                mostrarMensaje("Cancelando el alta de usuario");
            }
        });
        alerta.show();
    }

    private void irPantalla2() {
        Estudiante e1 = new Estudiante(dni,nombre,curso,fecha,hora);
        Intent intent = new Intent(this,BaseDatosActivity.class);
        intent.putExtra(EXTRA_ESTUDIANTE,e1);
        startActivity(intent);
    }
}