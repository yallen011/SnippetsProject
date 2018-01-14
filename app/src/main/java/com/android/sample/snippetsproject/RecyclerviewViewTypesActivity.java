package com.android.sample.snippetsproject;

import android.support.constraint.solver.Goal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.android.sample.snippetsproject.adapter.DogRecyclerViewAdapter;
import com.android.sample.snippetsproject.entity.Dog;

import java.util.ArrayList;

public class RecyclerviewViewTypesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_view_types);

        RecyclerView dogsRecyclerView = (RecyclerView) findViewById(R.id.dog_list);;

//        adapter = new DogRecyclerViewAdapter(new ArrayList<Dog>());
//        dogsRecyclerView.setAdapter(adapter);
    }
}
