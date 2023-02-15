package com.example.odevimiz;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class galeriverisi extends PagerAdapter {
private Integer[] imgList;
private Context mContext;

private ImageView imageView;
private ViewGroup.LayoutParams mparams;

    public galeriverisi(Integer[] imgList, Context mContext) {
        this.imgList = imgList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imgList.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);


    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        imageView=new ImageView(mContext);
        mparams=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

        imageView.setLayoutParams(mparams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(imgList[position]);
        container.addView(imageView);
        return  imageView;
    }


}
