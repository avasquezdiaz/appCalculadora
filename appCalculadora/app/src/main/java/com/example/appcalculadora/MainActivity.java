package com.example.appcalculadora;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //intanciar los id del archivos activity_main.xml
    EditText valor1, valor2;
    TextView resultado;
    Button sumar, restar, multiplicar, dividir, limpiar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar los objetos con los elementos del archivo xml
        valor1 = findViewById(R.id.etvalor1);
        valor2 = findViewById(R.id.etvalor2);
        resultado = findViewById(R.id.tvresultado);
        sumar = findViewById(R.id.btnsumar);
        restar = findViewById(R.id.btnrestar);
        multiplicar = findViewById(R.id.btnmultiplicar);
        dividir = findViewById(R.id.btndividir);
        limpiar = findViewById(R.id.btnlimpiar);

        //generar los eventos para realizar el codigo por cada uno de los botones
        /*sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tomar los datos del valor1 y valor2 como numericos
                double mvalor1= parseDouble(valor1.getText().toString());
                double mvalor2= parseDouble(valor2.getText().toString());
                double mresultado= mvalor1 + mvalor2;
                //utilizar la clase DecimalFormat al resultado
                DecimalFormat oNumero= new DecimalFormat("###,###,###,###.##");
                //asignar el contenido de la variable mresultado al objeto referenciado de resultado
                resultado.setText( String.valueOf (oNumero.format (mresultado)));
            }
        });

        //generar los eventos para realizar el codigo por cada uno de los botones
        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tomar los datos del valor1 y valor2 como numericos
                double mvalor1= parseDouble(valor1.getText().toString());
                double mvalor2= parseDouble(valor2.getText().toString());
                double mresultado= mvalor1 - mvalor2;
                //utilizar la clase DecimalFormat al resultado
                DecimalFormat oNumero= new DecimalFormat("###,###,###,###.##");
                //asignar el contenido de la variable mresultado al objeto referenciado de resultado
                resultado.setText( String.valueOf (oNumero.format (mresultado)));
            }
        });

        //generar los eventos para realizar el codigo por cada uno de los botones
        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tomar los datos del valor1 y valor2 como numericos
                double mvalor1= parseDouble(valor1.getText().toString());
                double mvalor2= parseDouble(valor2.getText().toString());
                double mresultado= mvalor1 * mvalor2;
                //utilizar la clase DecimalFormat al resultado
                DecimalFormat oNumero= new DecimalFormat("###,###,###,###.##");
                //asignar el contenido de la variable mresultado al objeto referenciado de resultado
                resultado.setText( String.valueOf (oNumero.format (mresultado)));
            }
        });

        //generar los eventos para realizar el codigo por cada uno de los botones
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tomar los datos del valor1 y valor2 como numericos
                double mvalor1= parseDouble(valor1.getText().toString());
                double mvalor2= parseDouble(valor2.getText().toString());
                double mresultado= mvalor1 / mvalor2;
                //utilizar la clase DecimalFormat al resultado
                DecimalFormat oNumero= new DecimalFormat("###,###,###,###.##");
                //asignar el contenido de la variable mresultado al objeto referenciado de resultado
                resultado.setText( String.valueOf (oNumero.format (mresultado)));
            }
        });*/



        sumar.setOnClickListener(this);
        restar.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        dividir.setOnClickListener(this);

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor1.setText("");
                valor2.setText("");
                resultado.setText("");
                valor1.requestFocus();//se envia el foco al control valor 1

            }
        });

    }

    @Override
    public void onClick(View v) {
        //este metodo se comparte para todos los botones teniendo en cuenta el id de cada boton
        //validar los datos (valor 1 y valor 2 se hayan digitado

        if (!valor1.getText().toString().isEmpty() && !valor2.getText().toString().isEmpty()){
            double mvalor1=parseDouble(valor1.getText().toString());
            double mvalor2=parseDouble(valor2.getText().toString());
            double mresultado= 0;

            //chequear a cual boton se hizo clic

            switch (v.getId()){
                case R.id.btnsumar:
                    mresultado = mvalor1 + mvalor2;
                    break;
                case R.id.btnrestar:
                    mresultado = mvalor1 - mvalor2;
                    break;
                case R.id.btnmultiplicar:
                    mresultado = mvalor1 * mvalor2;
                    break;
                case R.id.btndividir:
                    mresultado = mvalor1 / mvalor2;
                    break;
            }
            DecimalFormat oNumero = new DecimalFormat("###,###,###,###.#");
            resultado.setText( String.valueOf(oNumero.format(mresultado)));
        }

        else{
            //notificacion

            Toast.makeText(getApplicationContext(),"Debe ingresar los 2 valores", Toast.LENGTH_LONG).show();
        }

    }
}