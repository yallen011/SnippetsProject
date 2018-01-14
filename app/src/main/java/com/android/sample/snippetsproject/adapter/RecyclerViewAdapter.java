package com.android.sample.snippetsproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.sample.snippetsproject.R;
import com.android.sample.snippetsproject.RecyclerViewActivity.Car;

import java.util.List;

/**
 * Created by Yvonne on 6/18/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Car> mCars;

    public RecyclerViewAdapter(List<Car> cars){
        this.mCars = cars;
    }
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.carMakeTextView.setText(mCars.get(position).getMake());
    }

    @Override
    public int getItemCount() {
        return mCars.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView carMakeTextView;

        public MyViewHolder(View itemView) {

            super(itemView);
            carMakeTextView = (TextView) itemView.findViewById(R.id.car_make_title);

            //set onClick listener for the view.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "View Selected", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
