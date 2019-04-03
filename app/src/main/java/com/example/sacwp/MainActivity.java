package com.example.sacwp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private RadioButton sedan;
    private RadioButton vnedoro;
    private RadioButton gryz;
    private TextView textView;
    int typeOfCar;
    private Button button;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sedan = findViewById(R.id.radioButtonSedan);
        vnedoro = findViewById(R.id.radioButtonVnedoro);
        gryz = findViewById(R.id.radioButtonGryz);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editName);
        button = findViewById(R.id.Go);
        sedan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gryz.setChecked(false);
                vnedoro.setChecked(false);
                typeOfCar = 1;
            }
        });

        gryz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vnedoro.setChecked(false);
                sedan.setChecked(false);
                typeOfCar = 3;
            }
        });

        vnedoro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sedan.setChecked(false);
                gryz.setChecked(false);
                typeOfCar = 2;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Заполните пожалуйста поле!", Toast.LENGTH_SHORT);
                    toast.show();
                }else if(sedan.isChecked()==false && gryz.isChecked()==false && vnedoro.isChecked() == false){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Выберите пожалуйста тип!", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Intent intent = new Intent(MainActivity.this, ListCar.class);
                    intent.putExtra("fname", editText.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {

    }

}
