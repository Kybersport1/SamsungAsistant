package com.example.sacwp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import static com.example.sacwp.ListCar.ICO_KEY;

public class SecondActivity extends AppCompatActivity {
    ImageView imageView;
    public static final String ICO_KEY = "Ico key ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageView = findViewById(R.id.image);
        imageView.setImageResource(getIntent().getIntExtra(ICO_KEY, 1));
    }
}
