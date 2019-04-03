package com.example.sacwp;

import android.Manifest;
import android.content.Intent;
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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sacwp.api.NetworkService;
import com.example.sacwp.data.City;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {
    ImageView imageView;
    public static final String ICO_KEY = "Ico key ";
    public final String APPID = "693bc5884d2a585cdb170d137f0da55a";
    public final String UNITS = "metric";
    public String name;
    private double latitude;
    private double longitude;
    private LocationManager locationManager;
    private LocationListener listener;

    private TextView lot;
    private TextView longs;

    private Button b;

    private Intent intent;
    private String result;
    private TextView city;
    public TextView names;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageView = findViewById(R.id.image);
        imageView.setImageResource(getIntent().getIntExtra(ICO_KEY, 1));

        intent = getIntent();
        lot = findViewById(R.id.latitude);
        longs = findViewById(R.id.longitude);

        name = intent.getStringExtra("sname");
        city = findViewById(R.id.city);
        b = findViewById(R.id.button);
        names = findViewById(R.id.name);
        names.setText("Приветствую " + name + "!");

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                longitude = location.getLongitude();
                latitude = location.getLatitude();
                longs.setText(String.valueOf(longitude));
                lot.setText(String.valueOf(latitude));
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
                                    showAge(city);
                                } else {

                                }
                            }

                            @Override
                            public void onFailure(Call<City> call, Throwable t) {

                            }

                        });
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
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(SecondActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(SecondActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                locationManager.requestLocationUpdates("gps", 5000, 0, listener);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    private void showAge(City city){
        double age = city.getMain().getTemp();
        String ageist = String.valueOf(age);
        ((TextView)findViewById(R.id.temp)).setText(ageist);
    }

}
