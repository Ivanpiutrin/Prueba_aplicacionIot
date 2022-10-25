package com.taly.control_led;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btn_iniciar;
    Button btn_crear;
    Button btn_recuperar;
    Button btn_off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btn_iniciar = (Button) findViewById(R.id.btn_iniciar);
        btn_crear = (Button) findViewById(R.id.btn_crearCuenta);
        btn_recuperar = (Button) findViewById(R.id.btn_RecuperarPass);
        btn_off = (Button) findViewById(R.id.btn_off);

//Funcion de btn_iniciar
        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Inicio_App.class);
                startActivity(i);
                Toast.makeText(MainActivity.this, "Inicio sesión exitosa", Toast.LENGTH_SHORT).show();
            }
        });
//Funcion de btn_crear
        btn_crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(getApplicationContext(), Crear_cuenta.class);
                startActivity(e);
            }
        });
//Funcion de btn_recuperar
        btn_recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Recuperar_passw.class);
                startActivity(i);
            }
        });
        //Funcion de btn_off para salir de la aplicacion
        btn_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}