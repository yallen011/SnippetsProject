package com.android.sample.snippetsproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.android.sample.snippetsproject.entity.Dog;

import java.util.ArrayList;

/**
 * Created by Yvonne on 9/18/2017.
 */

public class DogRecyclerViewAdapter extends RecyclerView.Adapter<DogRecyclerViewAdapter.DogViewHolder> {




    public DogRecyclerViewAdapter(ArrayList<Dog> dogs) {
        super();
    }

    @Override
    public DogRecyclerViewAdapter.DogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(DogRecyclerViewAdapter.DogViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DogViewHolder extends RecyclerView.ViewHolder {



        public DogViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(){

        }
    }
}
