package com.example.sacwp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class OpenMap extends AppCompatActivity {
    public Intent intent;
    private String city;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_map);
        intent = getIntent();
        city = intent.getStringExtra("result");
        imageView =findViewById(R.id.imageCityMap);
        imgCheck(city);
    }

    private void imgCheck(String citys){
        if(citys.equals("Вінниця")){
            ((TextView)findViewById(R.id.city_name)).setText(citys);
            int imgresourse = getResources().getIdentifier("@drawable/vinnitsa",null , this.getPackageName());
            imageView.setImageResource(imgresourse);
        }else if(citys.equals("Київ")){
            ((TextView)findViewById(R.id.city_name)).setText(citys);
            int imgresourse = getResources().getIdentifier("@drawable/kiev",null , this.getPackageName());
            imageView.setImageResource(imgresourse);
        }else if(citys.equals("Кам'янець-Подільський")){
            ((TextView)findViewById(R.id.city_name)).setText(citys);
            int imgresourse = getResources().getIdentifier("@drawable/kamenets_podolsk",null , this.getPackageName());
            imageView.setImageResource(imgresourse);
        }else if(citys.equals("Хмельницкий")){
            ((TextView)findViewById(R.id.city_name)).setText(citys);
            int imgresourse = getResources().getIdentifier("@drawable/hmelnitski",null , this.getPackageName());
            imageView.setImageResource(imgresourse);
        }else if(citys.equals("Миколаїв")){
            ((TextView)findViewById(R.id.city_name)).setText(citys);
            int imgresourse = getResources().getIdentifier("@drawable/nikolaev",null , this.getPackageName());
            imageView.setImageResource(imgresourse);
        }else if(citys.equals("Одеса")){
            ((TextView)findViewById(R.id.city_name)).setText(citys);
            int imgresourse = getResources().getIdentifier("@drawable/odessa",null , this.getPackageName());
            imageView.setImageResource(imgresourse);
        }else if(citys.equals("Умань")){
            ((TextView)findViewById(R.id.city_name)).setText(citys);
            int imgresourse = getResources().getIdentifier("@drawable/uman",null , this.getPackageName());
            imageView.setImageResource(imgresourse);
        }else{
            ((TextView)findViewById(R.id.city_name)).setText(citys);
            int imgresourse = getResources().getIdentifier("@drawable/vinnitsa",null , this.getPackageName());
            imageView.setImageResource(imgresourse);
        }
    }


}
