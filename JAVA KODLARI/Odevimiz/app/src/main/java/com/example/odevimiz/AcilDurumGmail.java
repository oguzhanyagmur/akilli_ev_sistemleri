package com.example.odevimiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class AcilDurumGmail extends AppCompatActivity {


    WebView gmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acil_durum_gmail);
tanim();
gmailyukle();




    }

public  void tanim(){


        gmail=findViewById(R.id.gmailWeb);

}
public void  gmailyukle(){


        gmail.loadUrl("https://mail.google.com/mail/u/0/#inbox");
}



}