package com.taly.control_led;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Crear_cuenta extends MainActivity{
    //Definimos las variables
    Button btn_exi;
    Button btn_crearC;
    TextView editEmail;
    TextView editPass;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crearcuenta);
        btn_exi = (Button)findViewById(R.id.btn_atras);
        btn_crearC = (Button)findViewById(R.id.btn_creado);
        editEmail = (EditText)findViewById(R.id.editCorreoEle);
        editPass = (EditText)findViewById(R.id.editTextPassword);





        //Creamos las funciones de los botones
        btn_crearC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean retorn = true;

                if(validar()) {
                    Toast.makeText(Crear_cuenta.this, "Cuenta creada con exito", Toast.LENGTH_SHORT).show();
                    retorn = false;
                }
            }
        });
        //Creamos la funcion de btn_exi de salir
        btn_exi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //Agregamos la validacion para los datos
    public boolean validar(){
        boolean retorno = true;

        String email= editEmail.getText().toString();
        String pass = editPass.getText().toString();

        if(email.isEmpty()){
            editEmail.setError("Ingrese Correo electronico");
            retorno = false;
        }
        if(pass.isEmpty()){
            editPass.setError("Ingrese una contraseña");
            retorno = false;
        }

        return true;
    }
}
