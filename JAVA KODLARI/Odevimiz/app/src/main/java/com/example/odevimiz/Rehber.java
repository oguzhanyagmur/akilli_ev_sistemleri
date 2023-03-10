package com.example.odevimiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Rehber extends AppCompatActivity  implements SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    private RecyclerView rv;
   private FloatingActionButton fab;
   private ArrayList<Kisiler> kisilerArrayList;
   private KisilerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehber);

toolbar=findViewById(R.id.toolbar);
        rv=findViewById(R.id.rv);
       fab=findViewById(R.id.fab);

       rv.setHasFixedSize(true);
       rv.setLayoutManager(new LinearLayoutManager(this));

       toolbar.setTitle("Acil Durumda Arancak Kişiler");
       setSupportActionBar(toolbar);

       kisilerArrayList= new ArrayList<>();

       Kisiler k1=new Kisiler(1,"oguzhan","123456");
        Kisiler k2=new Kisiler(1,"kerem","41414");

        kisilerArrayList.add(k1);
        kisilerArrayList.add(k2);


        adapter=new KisilerAdapter(this,kisilerArrayList);
        rv.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

alertGoster();



            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

getMenuInflater().inflate(R.menu.toolbar_menu,menu);
MenuItem menuItem=menu.findItem(R.id.action_ara);
SearchView searchView=(SearchView) MenuItemCompat.getActionView(menuItem);




        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("onQueryTextSubmit",query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("onQueryTextSubmit",newText);

        return false;
    }


    public  void alertGoster(){

        LayoutInflater layout=LayoutInflater.from(this);
        View tasarim=layout.inflate(R.layout.alert_tasarim,null);
      final   EditText  editTextAd=tasarim.findViewById(R.id.editTextAd);
        final EditText  editTextTel=tasarim.findViewById(R.id.editTextTel);


        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Acil Durum Kişisi Ekle");
       ad.setView(tasarim);

        ad.setPositiveButton("Ekle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                String kisi_ad=editTextAd.getText().toString().trim();
                String kisi_Tel=editTextTel.getText().toString().trim();

                Toast.makeText(getApplicationContext(),kisi_ad+"-"+kisi_Tel,Toast.LENGTH_SHORT).show();


            }
        });

        ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

ad.create().show();

    }
}