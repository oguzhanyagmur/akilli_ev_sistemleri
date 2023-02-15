package com.example.odevimiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Kitapcik extends AppCompatActivity {
    WebView gazDurum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitapcik);

        gazDurumu();
       talimatYukle();


    }

    public void  gazDurumu()
    {


        gazDurum=findViewById(R.id.gazTalimat);
    }

    public  void talimatYukle(){
        gazDurum.getSettings().setJavaScriptEnabled(true);
        gazDurum.getSettings().setBuiltInZoomControls(true);
        gazDurum.getSettings().setSupportZoom(true);


        gazDurum.loadUrl("https://www.gazbir.org.tr/187-dogal-gaz-acil/20");
    }
}