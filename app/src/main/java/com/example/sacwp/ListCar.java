package com.example.sacwp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListCar extends AppCompatActivity implements RecyclerAdapter.ItemClicked {
    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    private List<RecyclerItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_car);


        list = generateList();

        recyclerView = findViewById(R.id.car_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }

    private List<RecyclerItem> generateList() {
        List<RecyclerItem> list = new ArrayList<>();
        list.add(new RecyclerItem("acura", R.drawable.acura));
        list.add(new RecyclerItem("alfa_romeo", R.drawable.alfa_romeo));
        list.add(new RecyclerItem("aston_martin", R.drawable.aston_martin));
        list.add(new RecyclerItem("audi", R.drawable.audi));
        list.add(new RecyclerItem("bentley", R.drawable.bentley));
        list.add(new RecyclerItem("bmw", R.drawable.bmw));
        list.add(new RecyclerItem("bugatti", R.drawable.bugatti));
        list.add(new RecyclerItem("buick", R.drawable.buick));
        list.add(new RecyclerItem("cadillac", R.drawable.cadillac));
        list.add(new RecyclerItem("chery", R.drawable.chery));
        list.add(new RecyclerItem("chevrolet", R.drawable.chevrolet));
        list.add(new RecyclerItem("chrysler", R.drawable.chrysler));
        list.add(new RecyclerItem("citroen", R.drawable.citroen));
        list.add(new RecyclerItem("dacia", R.drawable.dacia));
        list.add(new RecyclerItem("daewoo", R.drawable.daewoo));
        list.add(new RecyclerItem("daihatsu", R.drawable.daihatsu));
        list.add(new RecyclerItem("dodge", R.drawable.dodge));
        list.add(new RecyclerItem("ds", R.drawable.ds));
        list.add(new RecyclerItem("ferrari", R.drawable.ferrari));
        list.add(new RecyclerItem("fiat", R.drawable.fiat));
        list.add(new RecyclerItem("fisker", R.drawable.fisker));
        list.add(new RecyclerItem("ford", R.drawable.ford));
        list.add(new RecyclerItem("geely", R.drawable.geely));
        list.add(new RecyclerItem("genesis", R.drawable.genesis));
        list.add(new RecyclerItem("gmc", R.drawable.gmc));
        list.add(new RecyclerItem("honda", R.drawable.honda));
        list.add(new RecyclerItem("hummer", R.drawable.hummer));
        list.add(new RecyclerItem("hyundai", R.drawable.hyundai));
        list.add(new RecyclerItem("infiniti", R.drawable.infiniti));
        list.add(new RecyclerItem("isuzu", R.drawable.isuzu));
        list.add(new RecyclerItem("iveco", R.drawable.iveco));
        list.add(new RecyclerItem("jaguar", R.drawable.jaguar));
        list.add(new RecyclerItem("jeep", R.drawable.jeep));
        list.add(new RecyclerItem("kia", R.drawable.kia));
        list.add(new RecyclerItem("koenigsegg", R.drawable.koenigsegg));
        list.add(new RecyclerItem("lamborghini", R.drawable.lamborghini));
        list.add(new RecyclerItem("lancia", R.drawable.lancia));
        list.add(new RecyclerItem("land_rover", R.drawable.land_rover));
        list.add(new RecyclerItem("lexus", R.drawable.lexus));
        list.add(new RecyclerItem("lincoln", R.drawable.lincoln));
        list.add(new RecyclerItem("lotus", R.drawable.lotus));
        list.add(new RecyclerItem("maserati", R.drawable.maserati));
        list.add(new RecyclerItem("mazda", R.drawable.mazda));
        list.add(new RecyclerItem("mercedes_benz", R.drawable.mercedes_benz));
        list.add(new RecyclerItem("mercury", R.drawable.mercury));
        list.add(new RecyclerItem("mg", R.drawable.mg));
        list.add(new RecyclerItem("mini", R.drawable.mini));
        list.add(new RecyclerItem("mitsubishi", R.drawable.mitsubishi));
        list.add(new RecyclerItem("nissan", R.drawable.nissan));
        list.add(new RecyclerItem("opel", R.drawable.opel));
        list.add(new RecyclerItem("peugeot", R.drawable.peugeot));
        list.add(new RecyclerItem("piaggio", R.drawable.piaggio));
        list.add(new RecyclerItem("pontiac", R.drawable.pontiac));
        list.add(new RecyclerItem("porsche", R.drawable.porsche));
        list.add(new RecyclerItem("proton", R.drawable.proton));
        list.add(new RecyclerItem("ravon", R.drawable.ravon));
        list.add(new RecyclerItem("renault", R.drawable.renault));
        list.add(new RecyclerItem("roewe", R.drawable.roewe));
        list.add(new RecyclerItem("rolls_royce", R.drawable.rolls_royce));
        list.add(new RecyclerItem("rover", R.drawable.rover));
        list.add(new RecyclerItem("saab", R.drawable.saab));
        list.add(new RecyclerItem("saturn", R.drawable.saturn));
        list.add(new RecyclerItem("scania", R.drawable.scania));
        list.add(new RecyclerItem("scion", R.drawable.scion));
        list.add(new RecyclerItem("seat", R.drawable.seat));
        list.add(new RecyclerItem("skoda", R.drawable.skoda));
        list.add(new RecyclerItem("smart", R.drawable.smart));
        list.add(new RecyclerItem("srt", R.drawable.srt));
        list.add(new RecyclerItem("ssangyong", R.drawable.ssangyong));
        list.add(new RecyclerItem("subaru", R.drawable.subaru));
        list.add(new RecyclerItem("suzuki", R.drawable.suzuki));
        list.add(new RecyclerItem("tata", R.drawable.tata));
        list.add(new RecyclerItem("tesla", R.drawable.tesla));
        list.add(new RecyclerItem("toyota", R.drawable.toyota));
        list.add(new RecyclerItem("volkswagen", R.drawable.volkswagen));
        list.add(new RecyclerItem("volvo", R.drawable.volvo));
        return list;
    }

    @Override
    public void itemClickedCallback(int itemPosition) {

    }
}
