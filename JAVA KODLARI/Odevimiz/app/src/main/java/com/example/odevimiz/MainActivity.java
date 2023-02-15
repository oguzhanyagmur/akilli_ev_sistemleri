package com.example.odevimiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


   ImageView imgRehber;
   ImageView imgDedektör;
   ImageView imgKıtapcık;
   ImageView imgAmbulans;
   ImageView imgGaz;
   ImageView imgİtfaye;
   ImageView   imgAcilDurum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


imgKıtapcık=(ImageView) findViewById(R.id.imgKitap);
imgDedektör=(ImageView) findViewById(R.id.imgDedek);
imgRehber = (ImageView) findViewById(R.id.imgRehber);
imgAmbulans= (ImageView) findViewById(R.id.imgAmbulans);
imgGaz=(ImageView)findViewById(R.id.imgGaz);
imgİtfaye=(ImageView)findViewById(R.id.imgİtfaye);
imgAcilDurum=(ImageView)findViewById(R.id.imgMail);



imgAcilDurum.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        Intent acilDurum=new Intent(MainActivity.this,AcilDurumGmail.class);
        startActivity(acilDurum);

    }
});








        imgİtfaye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itfaye= new Intent(Intent.ACTION_DIAL);
                startActivity(itfaye);
            }
        });



imgGaz.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent gaz= new Intent(Intent.ACTION_DIAL);
        startActivity(gaz);
    }
});


        imgAmbulans.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        Intent arama=new Intent(Intent.ACTION_DIAL);

        startActivity(arama);



    }
});





        imgRehber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ıntent=new Intent(MainActivity.this,Rehber.class);
                startActivity(ıntent);


            }
        });

        imgDedektör.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntent=new Intent(MainActivity.this,Dedektor.class);
                startActivity(ıntent);
            }
        });

        imgKıtapcık.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ıntent=new Intent(MainActivity.this,Kitapcik.class);
                startActivity(ıntent);

            }
        });





    }
}