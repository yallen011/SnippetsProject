package com.android.sample.snippetsproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.sample.snippetsproject.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(retrieveCars());
        recyclerView.setAdapter(adapter);
    }

    public List<Car> retrieveCars(){

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Jaguar"));
        cars.add(new Car("Honda"));
        cars.add(new Car("BMW"));
        cars.add(new Car("Buick"));
        cars.add(new Car("Tesla"));

        return cars;
    }

    public static class Car{

        String make;

        public Car(String make) {
            this.make = make;
        }

        public String getMake() {
            return make;
        }
    }
}
