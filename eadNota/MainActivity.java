package com.mizael.ead.eadnotas;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
    Obs: Nao tive tempo suficiente
    mas acho que ele assim pode resolver o problema.

    Oi!
    Eu não sei se o meu geito aki está correto
    mas o que eu entendi da atividade eu tentei criar
    com o material que eles esncinaram

    Pode ter assuntus que posso ter passado despercebido
    pois os destaques q eles botam eu aimda nao vi todos
    então min desculpe.

    Qualquer coisa estou disponivel
    para tirar duvidas tire o print da parte
    e me mande para responder!

    ;D

*/

public class MainActivity extends AppCompatActivity {

    EditText etNome;
    // Usei Arrays para criar variáveis das View do XML
    EditText[] etNota = new EditText[3];
    TextView[] tvNome = new TextView[2];
    TextView[] tvNota = new TextView[2];
    TextView[] tvEstatu = new TextView[2];
    Button[] bMedia = new Button[2];

    // Escolhi ter nota de dois alunos,
    // estes arrays são os nomes e a media(notas) dos alunos
    String[] nome = new String[2];
    double[] notas = new double[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNome = (EditText) findViewById(R.id.et_nome);
        // Usar o "for" para pegar as View do XML
        for(int i = 0; i < 3; i++) {
            etNota[i] = (EditText) findViewById(R.id.et_nota + i);
        }
        for(int i = 0; i < 2; i++) {
            bMedia[i] = (Button) findViewById(R.id.b_media + i);
            tvNome[i] = (TextView) findViewById(R.id.tv_nome + i);
            tvNota[i] = (TextView) findViewById(R.id.tv_nota + i);
            tvEstatu[i] = (TextView) findViewById(R.id.tv_status + i);
        }

        // Botão 0: Vai adicionar os dados no primeiro bloco dos resultados
        bMedia[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Pega os valores para variáveis double
                double nota1 = Double.valueOf(etNota[0].getText().toString());
                double nota2 = Double.valueOf(etNota[1].getText().toString());
                double nota3 = Double.valueOf(etNota[2].getText().toString());

                // usa o "Array" para adicionar a media e o nome
                notas[0] = ((nota1 * 2) + (nota2 * 2) + (nota3 * 6)) / 10;
                nome[0] = etNome.getText().toString();

                // Configura o texto para o nome e media obtido
                tvNome[0].setText(nome[0]);
                tvNota[0].setText("" + notas[0]);

                // O "if" Verifica se o aluno foi aprovado ou reprovado
                if (notas[0] >= 6) {
                    tvEstatu[0].setText(R.string.aprovado); // Muda o Texto
                    tvEstatu[0].setTextSize(22); // Muda o tamanho do texto
                } else {
                    tvEstatu[0].setText(R.string.recuperação);
                    tvEstatu[0].setTextSize(20);
                }

                // Aqui é uma gambiarra que eu não sei se está certo usar desta maneira
                // Lá no XML criei 2 botoes e aqui uso estes comandos para deixar um invisivel(GONE)
                // e o outro visivel(VISIBLE)
                bMedia[0].setVisibility(View.GONE);
                bMedia[1].setVisibility(View.VISIBLE);


            }
        });

        // Botão 1: Vai adicionar os dados no segundo bloco dos resultados
        bMedia[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Pega os valores para variáveis double
                double nota1 = Double.valueOf(etNota[0].getText().toString());
                double nota2 = Double.valueOf(etNota[1].getText().toString());
                double nota3 = Double.valueOf(etNota[2].getText().toString());

                // usa o "Array" para adicionar a media e o nome
                notas[1] = ((nota1 * 2) + (nota2 * 2) + (nota3 * 6)) / 10;
                nome[1] = etNome.getText().toString();

                // Configura o texto para o nome e media obtido
                tvNome[1].setText(nome[1]);
                tvNota[1].setText("" + notas[1]);

                // O "if" Verifica se o aluno foi aprovado ou reprovado
                if (notas[1] >= 6) {
                    tvEstatu[1].setText(R.string.aprovado);
                    tvEstatu[1].setTextSize(22);
                } else {
                    tvEstatu[1].setText(R.string.recuperação);
                    tvEstatu[1].setTextSize(20);
                }

                // Aqui é uma gambiarra que eu não sei se está certo usar desta maneira
                // Lá no XML criei 2 botoes e aqui uso estes comandos para deixar um invisivel(GONE)
                // e o outro visivel(VISIBLE)
                bMedia[1].setVisibility(View.GONE);
                bMedia[0].setVisibility(View.VISIBLE);

            }
        });


    }
}
