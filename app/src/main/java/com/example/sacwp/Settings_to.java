package com.example.sacwp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Settings_to extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private final String APP_PREFERENCES = "Shared_preferences_app";
    private final String NAME_KEY = "Name_key";
    private final String TYPE_KEY = "Type_key";
    private final String MARK_KEY = "Mark_key";

    private RadioButton sedan;
    private RadioButton vnedoro;
    private RadioButton gryz;
    private TextView textView;
    int typeOfCar;
    private Button button;
    private EditText editText;
    private ConstraintLayout view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_to);
        sharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        view = findViewById(R.id.settings_cons);
        view.setBackgroundResource(R.drawable.settings);
        sedan = findViewById(R.id.radioButtonSedan);
        vnedoro = findViewById(R.id.radioButtonVnedoro);
        gryz = findViewById(R.id.radioButtonGryz);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editName);
        editText.setText(sharedPreferences.getString(NAME_KEY, ""));
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
                if (editText.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Заполните пожалуйста поле!", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (sedan.isChecked() == false && gryz.isChecked() == false && vnedoro.isChecked() == false) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Выберите пожалуйста тип!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Intent intent = new Intent(Settings_to.this, ListCar.class);

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(NAME_KEY, editText.getText().toString());
                    editor.putInt(TYPE_KEY, typeOfCar);
                    editor.apply();

                    startActivity(intent);
                }
            }
        });
    }
}
