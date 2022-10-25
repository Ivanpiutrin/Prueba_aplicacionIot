package com.taly.control_led;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Recuperar_passw extends MainActivity{


    Button btn_volver;
    Button btn_Ingresar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recuperarpassword);

        btn_volver = (Button) findViewById(R.id.btn_volver);
        btn_Ingresar = (Button)findViewById(R.id.btn_ingresar);

        //MOSTRAMOS POR MENSAJE QUE EL USUARIO HA CAMBIADO LA CONTRASEÑA
        btn_Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Recuperar_passw.this, "¡Ah sido ingresado exitosamente!", Toast.LENGTH_SHORT).show();
            }
        });




        //Creamos el btn_volver para volver al inicio de sesión
        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
