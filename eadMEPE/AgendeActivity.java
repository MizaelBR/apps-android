package com.mizael.ead.museudoestado;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AgendeActivity extends AppCompatActivity {

    // Bloco de variaveis para uso global
    EditText nome;
    RadioGroup radio;
    Spinner estados;
    CheckBox primeiraVez;
    SharedPreferences gaveta;  // Criando o SharedPreferences

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agende);


        // Conectando as variaveis aos seus devidos objetos xml
        nome = (EditText) findViewById(R.id.etNome);
        radio = (RadioGroup) findViewById(R.id.radioGroup);
        primeiraVez = (CheckBox) findViewById(R.id.cbPrimeiraVez);

        // Criando a chave "gaveta" com o "modo private"
        gaveta = getSharedPreferences("gaveta", MODE_PRIVATE);


        // Criando a ligação dos Array do arquivo string.xml pelo ArrayAdapter e o Spinner
        // 1.step: Pegando o Spinner do activity_agende.xml
        estados = (Spinner) findViewById(R.id.sEstado);
        // 2.step: Pegando o Array do string.xml
        ArrayAdapter<CharSequence> listaEstados = ArrayAdapter.createFromResource(this, R.array.estados_lista,
                android.R.layout.simple_spinner_item);
        // 3.step: Configurar o tipo de Spinner o ArrayAdapter vai ser
        listaEstados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 4.step: Conectando o ArrayAdapter no Spinner
        estados.setAdapter(listaEstados);


        // Selecionando o RadioButton Masculino pelo RadioGruop
        radio.check(R.id.rbMale);

        // Verificando se no SharedP. tem a chave "nome", caso tenha mude os valores
        nome.setText(gaveta.getString("nome", null));  // Muda o valor do EditText
        estados.setSelection(gaveta.getInt("pos", 0));  // Muda o valor do Spinner
        primeiraVez.setChecked(gaveta.getBoolean("chek", false));  // Muda o valor do CheckBox
        radio.check(gaveta.getInt("radio", 0));  // Muda o valor do RadioGruop

    }

    // Metodo Agendar os dados da atividade
    public void agendar(View v){


        String mesnsagem;  // Variavel que armazena a menssagem da verificação
        SharedPreferences.Editor guardar = gaveta.edit();  // edita o SharedPreferences


        // verifica de o EditText está fazio
        if(nome.getText().toString().equals("")) {

            mesnsagem = "Preencha todos os campos!";

        }else {

            // Guardando o valor do checkbox
            if(primeiraVez.isChecked()){
                guardar.putBoolean("chek", true);
            }else{
                guardar.putBoolean("chek", false);
            }

            // Guarda o valor do RadioButton
            switch (radio.getCheckedRadioButtonId()){
                case R.id.rbMale:
                    guardar.putInt("radio", R.id.rbMale);
                    break;

                case R.id.rbFemale:
                    guardar.putInt("radio", R.id.rbFemale);
                    break;
            }

            mesnsagem = "Agendado com Sucesso!";


            guardar.putString("nome", nome.getText().toString());  // Guarda o Nome do EditText
            guardar.putInt("pos", estados.getSelectedItemPosition());  // Guarda o valor do Spinner
            guardar.commit();
        }

        // Mensagem em modo toast
        Toast.makeText(getApplicationContext(), mesnsagem, Toast.LENGTH_SHORT).show();


    }

    // Resceve todos os valores e adiciona ao shared
    public void limpar(View v){
        SharedPreferences.Editor guardar = gaveta.edit();  // edita o SharedPreferences

        // mudando valor
        nome.setText("");
        estados.setSelection(0);
        radio.check(R.id.rbMale);
        primeiraVez.setChecked(false);

        // mudando no shared
        guardar.putInt("radio", R.id.rbMale);
        guardar.putString("nome", "");  // Guarda o Nome do EditText
        guardar.putInt("pos", estados.getSelectedItemPosition());  // Guarda o valor do Spinner
        guardar.putBoolean("chek", false);
        guardar.commit();
    }

    // Metodo Finalizar atividade
    public void cancelar(View v){
        finish();
    }
}
