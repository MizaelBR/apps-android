package com.mizael.ead.museudoestado;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoarActivity extends AppCompatActivity {

    TextView valor1, valor2, valor3, tvObrigado, tvValor, tvEscolha;
    Button bDoar;
    SharedPreferences banco;
    int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doar);

        valor1 = (TextView) findViewById(R.id.valor1);
        valor2 = (TextView) findViewById(R.id.valor2);
        valor3 = (TextView) findViewById(R.id.valor3);
        tvObrigado = (TextView) findViewById(R.id.tvObrigado);
        tvValor = (TextView) findViewById(R.id.tvValor);
        tvEscolha = (TextView) findViewById(R.id.tvEscolha);
        bDoar = (Button) findViewById(R.id.bDoar);

        // Criando chave banco
        banco = getSharedPreferences("banco", MODE_PRIVATE);

        // Fazer os textviews clicaveis
        valor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor1.setBackgroundColor(getResources().getColor(R.color.i));
                valor2.setBackgroundColor(getResources().getColor(R.color.b));
                valor3.setBackgroundColor(getResources().getColor(R.color.b));
                c = 1;
            }
        });
        valor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor2.setBackgroundColor(getResources().getColor(R.color.i));
                valor1.setBackgroundColor(getResources().getColor(R.color.b));
                valor3.setBackgroundColor(getResources().getColor(R.color.b));
                c = 2;
            }
        });
        valor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor3.setBackgroundColor(getResources().getColor(R.color.i));
                valor1.setBackgroundColor(getResources().getColor(R.color.b));
                valor2.setBackgroundColor(getResources().getColor(R.color.b));
                c = 3;
            }
        });


        // usando o shared
        if(banco.contains("botao")){
            bDoar.setVisibility(banco.getInt("botao", 0));
            valor1.setVisibility(banco.getInt("v1", 0));
            valor2.setVisibility(banco.getInt("v2", 0));
            valor3.setVisibility(banco.getInt("v3", 0));
            tvEscolha.setVisibility(banco.getInt("escolha", 0));

            tvObrigado.setVisibility(banco.getInt("obrigado", 0));
            tvValor.setVisibility(banco.getInt("valor", 0));
            tvValor.setText(banco.getString("texto", null));
        }

    }

    // metodo de doar
    public void doar(View v){

        // edita o shared
        SharedPreferences.Editor guardar = banco.edit();

        // verifica se o contador c é diferente de 0
        if(c != 0){

            if (c == 1) {
                tvValor.setText(valor1.getText());
            }

            if (c == 2) {
                tvValor.setText(valor2.getText());
            }

            if (c == 3) {
                tvValor.setText(valor3.getText());
            }

            bDoar.setVisibility(View.GONE);
            valor1.setVisibility(View.GONE);
            valor2.setVisibility(View.GONE);
            valor3.setVisibility(View.GONE);
            tvEscolha.setVisibility(View.GONE);

            tvObrigado.setVisibility(View.VISIBLE);
            tvValor.setVisibility(View.VISIBLE);

            guardar.putInt("botao", View.GONE);
            guardar.putInt("v1", View.GONE);
            guardar.putInt("v2", View.GONE);
            guardar.putInt("v3", View.GONE);
            guardar.putInt("escolha", View.GONE);

            guardar.putInt("obrigado", View.VISIBLE);
            guardar.putInt("valor", View.VISIBLE);
            guardar.putString("texto", tvValor.getText().toString());

            guardar.commit();

        }

    }

    // este metodo esta lgado ao nome doação(titulo da activiy)
    // este metodo é para testar e refazer o metodo acima
    // Descomente caso queira testar
    /*
    public void refazer(View v){

        SharedPreferences.Editor guardar = banco.edit();

        bDoar.setVisibility(View.VISIBLE);
        valor1.setVisibility(View.VISIBLE);
        valor2.setVisibility(View.VISIBLE);
        valor3.setVisibility(View.VISIBLE);
        tvEscolha.setVisibility(View.VISIBLE);

        tvObrigado.setVisibility(View.GONE);
        tvValor.setVisibility(View.GONE);

        guardar.putInt("botao", View.VISIBLE);
        guardar.putInt("v1", View.VISIBLE);
        guardar.putInt("v2", View.VISIBLE);
        guardar.putInt("v3", View.VISIBLE);
        guardar.putInt("escolha", View.VISIBLE);

        guardar.putInt("obrigado", View.GONE);
        guardar.putInt("valor", View.GONE);
        guardar.putString("texto", tvValor.getText().toString());

        guardar.commit();

    }*/

}
