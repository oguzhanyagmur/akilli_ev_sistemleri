package com.example.odevimiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Dedektor extends AppCompatActivity {

    WebView webSayfasi;
    ProgressDialog acilismesaji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dedektor);


            tanimlama();
            siteyukle();





            webSayfasi.setWebViewClient(new WebViewClient(){



                public void onPage(WebView view,String url){


                    super.onPageFinished(view, url);



                }



                                        }





            );

        }

        public void  tanimlama()
        {


            webSayfasi=findViewById(R.id.site);
        }

        public  void siteyukle(){
            webSayfasi.getSettings().setJavaScriptEnabled(true);
            webSayfasi.getSettings().setBuiltInZoomControls(true);
            webSayfasi.getSettings().setSupportZoom(true);


            webSayfasi.loadUrl("https://thingspeak.com/channels/1973538");
        }
    }



