package com.example.odevimiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class KarsilamaEkrani extends AppCompatActivity {

    Handler mhandler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karsilama_ekrani2);

mhandler.postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent intent=new Intent(KarsilamaEkrani.this,MainActivity.class);
        startActivity(intent);
        finish();

    }
}, 5000);


    }
}