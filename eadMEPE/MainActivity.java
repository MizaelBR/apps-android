package com.mizael.ead.museudoestado;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void agendar(View v){
        Intent visita =  new Intent(this, AgendeActivity.class);
        startActivity(visita);
    }

    public void localMaps(View v){
        Intent mapa = new Intent(this, MapsActivity.class);
        startActivity(mapa);
    }

    public void webSite(View v){
        Uri url = Uri.parse("http://www.museudoestadope.com.br/");

        Intent site = new Intent(Intent.ACTION_VIEW, url);
        startActivity(site);
    }

    public void doar(View v){
        Intent doe = new Intent(this, DoarActivity.class);
        startActivity(doe);
    }

}
