package com.example.imc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvIMC, tvClassificacaoIMC;
    EditText edtPeso, edtAltura;

    Button btnClassificacaoIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvIMC = (TextView) findViewById(R.id.lblIMC);
        tvClassificacaoIMC = (TextView) findViewById(R.id.lblClassificacaoIMC);

        edtPeso = (EditText) findViewById(R.id.txtPeso);
        edtAltura = (EditText) findViewById(R.id.txtAltura);

        btnClassificacaoIMC = (Button) findViewById(R.id.cmdClassificarIMC);
        btnClassificacaoIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double imc, peso, altura;
                    String classificacaoIMC;
                    peso = Double.parseDouble(edtPeso.getText().toString());
                    altura = Double.parseDouble(edtAltura.getText().toString());
                    imc = peso / (altura*altura);
                    if (imc<=18.5) {
                        classificacaoIMC = "Abaixo do Peso.";
                    } else if (imc > 18.5 && imc<=24.9) {
                        classificacaoIMC = "Peso Normal.";
                    } else if (imc > 24.9 && imc <= 29.9){
                        classificacaoIMC = "Sobrepeso.";
                    } else {
                        classificacaoIMC = "Obeso.";
                    }
                    tvIMC.setText(String.valueOf(imc));
                    tvClassificacaoIMC.setText(classificacaoIMC);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}