package es.iesnervion.rmanzano.calculadoracompadre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int radioButtonSelected;
    RadioGroup radioGroup;
    TextView resultado;
    //double num1;
    //double num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


        resultado = findViewById(R.id.resultado);

    }

    public void resolver(View view) {
        //Hay que controlar cuando los numeros vienen nulos, Da error al parsear a Double
        Double res = 0.0;
        Double num1 = 0.0;
        Double num2 = 0.0;
        radioButtonSelected = radioGroup.getCheckedRadioButtonId();
        TextView primerNumero = findViewById(R.id.primerNumeroET);
        String n1 = primerNumero.getText().toString();
        if(n1.equals(null)) {
            num1 = Double.parseDouble(n1);
        }

        TextView segundoNumero = findViewById(R.id.segundoNumeroET);
        String n2 = segundoNumero.getText().toString();
        if(n2.equals(null)) {
            num2 = Double.parseDouble(n2);
        }
        switch (radioButtonSelected) {
            case R.id.sumar :
                res = num1 + num2;
            break;
            case R.id.restar :
                res = num1 - num2;
            break;
            case R.id.multiplicar :
                res = num1 * num2;
            break;
            case R.id.dividir :
                res = num1 / num2;
            break;
        }
        resultado.setText(getResources().getString(R.string.resultado) + " " + res.toString());

    }
}
