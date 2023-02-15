package com.example.odevimiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

public class VeriGaleri extends AppCompatActivity {

private  Integer[] imgList={
        R.drawable.ss1,
        R.drawable.bbb

};

private ViewPager mView;
private galeriverisi mAdapter;


private  void init(){

mView=findViewById(R.id.verigaleri);

mAdapter=new galeriverisi(imgList,this);
mView.setAdapter(mAdapter);

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veri_galeri);


init();


    }
}