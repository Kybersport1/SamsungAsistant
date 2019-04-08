package com.example.sacwp;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sacwp.api.NetworkService;
import com.example.sacwp.data.City;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {
    //public static final String ICO_KEY = "Ico key ";

    private SharedPreferences sharedPreferences;
    private final String APP_PREFERENCES = "Shared_preferences_app";
    private final String NAME_KEY = "Name_key";
    private final String TYPE_KEY = "Type_key";
    private final String MARK_KEY = "Mark_key";

    private ImageView imageView;
    public final String APPID = "693bc5884d2a585cdb170d137f0da55a";
    public final String UNITS = "metric";
    public String name;
    private LocationManager locationManager;
    private LocationListener listener;
    private String result;
    private TextView city;
    public TextView names;
    public int i_exit = 1;
    public TextView logicResult;

    public String str_1 = "Хорошее время помыть машину!";
    public String str_2 = "Только при большой потребности!";
    public String str_3 = "Сейчас нельзя мыть машину !";
    public String str_e = "Error";

    private String desc = "Clear";
    double temp_v = 0;
    private Intent intent_p;

    //openMap intent
    public Intent intent_r;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);


        imageView = findViewById(R.id.image);
        //imageView.setImageResource(getIntent().getIntExtra(ICO_KEY, 1));
        imageView.setImageResource(sharedPreferences.getInt(MARK_KEY, -1));

        //name = getIntent().getStringExtra("sname");
        name = sharedPreferences.getString(NAME_KEY, "Anonym");
        city = findViewById(R.id.city);
        names = findViewById(R.id.name);
        names.setText("Приветствую " + name + "!");
        logicResult = findViewById(R.id.logicResult);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Geocoder gcd = new Geocoder(SecondActivity.this, Locale.getDefault());
                List<Address> list = null;
                try {
                    list = gcd.getFromLocation(location
                            .getLatitude(), location.getLongitude(), 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (list != null & list.size() > 0) {
                    Address address = list.get(0);
                    result = address.getLocality();
                    city.setText(result);
                }

                NetworkService.getInstance()
                        .getCityApi()
                        .getCity(result,APPID,UNITS)
                        .enqueue(new Callback<City>() {
                            @Override
                            public void onResponse(Call<City> call, Response<City> response) {
                                if (response.isSuccessful()) {
                                    City city = response.body();
                                    showTemp(city);
                                } else {

                                }
                            }

                            @Override
                            public void onFailure(Call<City> call, Throwable t) {

                            }

                        });

                switch (desc) {
                    case "Clear":
                        logicClear(temp_v, logicResult);
                        break;
                    case "Clouds":
                        logicClouds(temp_v,logicResult);
                        break;
                    case "Rain":
                        logicRain(temp_v,logicResult);
                        break;
                    case "Snow":
                        logicSnow(temp_v,logicResult);
                        break;
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };

        configure_button();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                configure_button();
                break;
            default:
                break;
        }
    }


    void configure_button() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}
                        , 10);
            }
            return;
        }
        locationManager.requestLocationUpdates("gps", 5000, 0, listener);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (ActivityCompat.checkSelfPermission(SecondActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(SecondActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                    // TODO: Consider calling
//                    //    ActivityCompat#requestPermissions
//                    // here to request the missing permissions, and then overriding
//                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                    //                                          int[] grantResults)
//                    // to handle the case where the user grants the permission. See the documentation
//                    // for ActivityCompat#requestPermissions for more details.
//                    return;
//                }
//                locationManager.requestLocationUpdates("gps", 5000, 0, listener);
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        if(i_exit == 1){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Нажмите ещё раз для выхода!", Toast.LENGTH_SHORT);
            toast.show();
            i_exit = 2;
        }else if(i_exit ==2) {
            i_exit =1;

        }
    }

    private void showTemp(City city){
        temp_v = city.getMain().getTemp();
        String tempist = String.valueOf(temp_v);
        ((TextView)findViewById(R.id.temp_y)).setText(tempist);
    }

    private void showDescription(City city){
        desc = city.getWeather().getMain();
    }

    public void logicClear(double temp,TextView textView){
        if(temp>= 10){
            textView.setText(str_1);
        }else if(temp<10 && temp >=-5){
            textView.setText(str_2);
        }else if(temp<=-5){
            textView.setText(str_3);
        }else{
            textView.setText(str_e);
        }
    }

    public void logicClouds(double temp,TextView textView){

    }

    public void logicRain(double temp,TextView textView){

    }

    public void logicSnow(double temp,TextView textView){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.settings:
                intent_p = new Intent(SecondActivity.this, Settings_to.class);
                startActivity(intent_p);
                break;
            case R.id.zp:
                intent_p = new Intent(SecondActivity.this, Driveacar.class);
                startActivity(intent_p);
                break;
            case R.id.openMap:
                intent_p = new Intent(SecondActivity.this, OpenMap.class);
                intent_p.putExtra("result", result);
                startActivity(intent_p);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
