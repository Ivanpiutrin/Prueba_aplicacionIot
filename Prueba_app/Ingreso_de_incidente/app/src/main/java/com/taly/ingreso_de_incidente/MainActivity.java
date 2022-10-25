package com.taly.ingreso_de_incidente;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  SensorEventListener {

    Spinner spLista;
    Button  btnGrabar;
    EditText editRut;
    EditText editNombre;
    EditText editDescripcion;
    TextView x, txtmensaje;
    private SensorEvent event;




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingreso_incidente);


//DEfinimos las variables
        editRut=(EditText)findViewById(R.id.editRut);
        editNombre=(EditText)findViewById(R.id.editName);
        editDescripcion=(EditText)findViewById(R.id.editDescrip);
        btnGrabar=(Button)findViewById(R.id.btnGrabar);
        spLista=(Spinner) findViewById(R.id.spLista);
        x = (TextView)findViewById(R.id.xID);
        txtmensaje=(TextView)findViewById(R.id.txtmensaje);


//Agregamos el sensor vertical
        super.onResume();
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.size() > 0) //verificamos que exista acelerometro
        {
            sm.registerListener((SensorEventListener) this, sensors.get(0), SensorManager.SENSOR_DELAY_GAME);
        }



       //Agregamos ArrayAdapter para mostrar la listas
       ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lista, android.R.layout.simple_list_item_1);
        spLista.setAdapter(adapter);
        //Agregamos la funcion del boton Grabar incidente

       btnGrabar.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View view){

                if(validar()){

                }

                //Mostrara mensaje a la hora de presionar el boton Grabar incidente
                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setMessage("¿Está seguro que desea grabar?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {



                                //Capturamps la fecha y hora actual del sistemas al presionar el boton si
                                DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss z");

                                String FechaHora = dateFormat.format(new Date());

                                System.out.println(FechaHora);
                                TextView textViewDate = findViewById(R.id.textview_date);
                                textViewDate.setText(FechaHora);
                            }


                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog titulo = alerta.create();
                titulo.setTitle("Advertencia");
                titulo.show();


            }

       });

    }

    public void onSensorChanged(SensorEvent event) {
        Integer x_entero;


        String texto_mensaje;


        x_entero = (int) (event.values[SensorManager.DATA_X]);

        txtmensaje.setText(" ");
        if ((x_entero==0)){
            texto_mensaje="La pantalla esta en modo vertical";
            txtmensaje.setText(texto_mensaje);
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    //Agregamos la validacion para los datos
    public boolean validar(){
        boolean retorno = true;

        String rut= editRut.getText().toString();
        String nombre = editNombre.getText().toString();
        String descripcion = editDescripcion.getText().toString();
        if(rut.isEmpty()){
            editRut.setError("Ingrese  RUT");
            Toast.makeText(this, "Campo RUT vacio", Toast.LENGTH_SHORT).show();
            retorno = false;

        }
        if(nombre.isEmpty()){
            editNombre.setError("Ingrese Nombre");
            Toast.makeText(this, "Campo Nombre vacio", Toast.LENGTH_SHORT).show();
            retorno = false;
        }
        if(descripcion.isEmpty()){
            editDescripcion.setError("ingrese la Descripcion");
            Toast.makeText(this, "Campo Descripcion vacio", Toast.LENGTH_SHORT).show();
            retorno = false;
        }

        return true;
    }
}