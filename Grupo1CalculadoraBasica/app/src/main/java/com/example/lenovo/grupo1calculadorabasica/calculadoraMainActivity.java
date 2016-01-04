package com.example.lenovo.grupo1calculadorabasica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class calculadoraMainActivity extends AppCompatActivity {

    private EditText operador1;
    private EditText resultado;
    private TextView operacionmat;
    private int caso = 0;
    private String cadena;
    private double resultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_main);

    //recuperamos los objetos controles
    operador1 = (EditText)findViewById(R.id.editText);
    resultado = (EditText) findViewById(R.id.resultado_editText3);
    operacionmat = (TextView) findViewById(R.id.operacion_textView2);
    }

    //
    public void mas(View v) {

        //validamos si el campo operador1 esta vacio  y el usuario oprimio la tecla +
        if (operador1.getText().toString().trim().length() < 1) {
        setCaso(1);

        //Proceso para cambiar el ultimo digito de la cadena por el signo +
        String cadena2;
        int num_cadena2;
        cadena2=getCadena();
        num_cadena2=cadena2.length();


            if(num_cadena2>1){

                char[]cad = cadena2.toCharArray();
                cad[num_cadena2-1] = '+';
                cadena2 = new String(cad);
                setCadena(cadena2);

                //se muestra la cadena que representa la operacion matematica
                operacionmat.setText(cadena);
            }


        } else {

        double ope1, ope2;
        String cadena;

        //convertimos el texto obtenido a tipo numerico double
        ope1 = Double.parseDouble(operador1.getText().toString());
        ope2 = Double.parseDouble(resultado.getText().toString());

        //Vamos armando la cadena que representa la operacion matematica
        cadena = getCadena();
        if (cadena == null) {
            cadena = String.valueOf(ope1) + "+";
            setCadena(cadena);
        } else {
            cadena = cadena + String.valueOf(ope1) + "+";
            setCadena(cadena);
        }
        //que numero de caso va
        int caso = getCaso();

                //se valida si es la primera vez que se ejecuta la operacion
                if (caso == 0) {
                    //cambiamos el cero por uno para saber que la operacion que esta iniciada es una suma
                    setCaso(1);

                    setResultado2(ope1);

                } else {
                    //se hace la respectiva operacion
                    setResultado2(operacion(caso,ope1,ope2));

                }

                //se imprime por pantalla el resultado
                resultado.setText(String.valueOf(getResultado2()));

                //se limpia el display para un nuevo operador
                operador1.setText("");

                //se muestra la cadena que representa la operacion matematica
                operacionmat.setText(cadena);

            //el usuario pidio suma
            setCaso(1);

            }
  }//fin metodo mas



    //
    public void menos(View v) {

        //validamos si el campo operador1 esta vacio  y el usuario oprimio la tecla -
        if (operador1.getText().toString().trim().length() < 1) {
            setCaso(2);

            //Proceso para cambiar el ultimo digito de la cadena por el signo -
            String cadena2;
            int num_cadena2;
            cadena2=getCadena();
            num_cadena2=cadena2.length();


            if(num_cadena2>1){

                char[]cad = cadena2.toCharArray();
                cad[num_cadena2-1] = '-';
                cadena2 = new String(cad);
                setCadena(cadena2);

                //se muestra la cadena que representa la operacion matematica
                operacionmat.setText(cadena);
            }

        } else {

            double ope1, ope2;
            String cadena;

            //convertimos el texto obtenido a tipo numerico double
            ope1 = Double.parseDouble(operador1.getText().toString());
            ope2 = Double.parseDouble(resultado.getText().toString());

            //Vamos armando la cadena que representa la operacion matematica
            cadena = getCadena();
            if (cadena == null) {
                cadena = String.valueOf(ope1) + "-";
                setCadena(cadena);
            } else {
                cadena = cadena + String.valueOf(ope1) + "-";
                setCadena(cadena);
            }
            //que numero de caso va
            int caso = getCaso();

            //se valida si es la primera vez que se ejecuta la operacion
            if (caso == 0) {
                //cambiamos el cero por uno para saber que la operacion que esta iniciada es una suma
                setCaso(2);

                setResultado2(ope1);

            } else {
                //se hace la respectiva operacion
                setResultado2(operacion(caso,ope1,ope2));

            }

            //se imprime por pantalla el resultado
            resultado.setText(String.valueOf(getResultado2()));

            //se limpia el display para un nuevo operador
            operador1.setText("");

            //se muestra la cadena que representa la operacion matematica
            operacionmat.setText(cadena);

            //el usuario pidio resta
            setCaso(2);
        }
    }//fin metodo menos




    //
    public double operacion(int caso, double ope1, double ope2){

        double resultado4 = 0;

        switch (caso) {
            case 0:
                break;
            case 1:
                resultado4 = ope1 + ope2;
                break;
            case 2:
                resultado4 = ope2 - ope1;
                break;
            case 3:
                resultado4 = ope1 * ope2;
                break;
            case 4:
                resultado4 = ope2 / ope1;
                break;
            default:
                break;
        }//fin metodo operacion

        return resultado4;

    }

    //
    public int getCaso() {
        return caso;
    }
    //
    public void setCaso(int caso) {
        this.caso = caso;
    }

    //
    public String getCadena() {
        return cadena;
    }

    //
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public double getResultado2() {
        return resultado2;
    }

    public void setResultado2(double resultado2) {
        this.resultado2 = resultado2;
    }
}
