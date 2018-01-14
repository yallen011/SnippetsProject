package com.android.sample.snippetsproject;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.android.sample.snippetsproject.adapter.ProductAdapter;
import com.android.sample.snippetsproject.dao.ProductDao;
import com.android.sample.snippetsproject.database.MyDatabase;
import com.android.sample.snippetsproject.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class RoomDemoActivity extends AppCompatActivity {

    MyDatabase myDatabase;
    private RecyclerView recyclerView;
    List<Product> mProductList;
    ProductAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_demo);

        myDatabase = MyDatabase.getDatabase(this);

        recyclerView = (RecyclerView) findViewById(R.id.product_recycler_view);

        //Get data from database and set results to ProductAdapter
        new ProductAsyncTask().execute();
        mProductList = new ArrayList<>();
        mAdapter = new ProductAdapter(mProductList);
        recyclerView.setAdapter(mAdapter);
    }

    private class ProductAsyncTask extends AsyncTask<Void, Void, List<Product>>{

        private final ProductDao productDao = myDatabase.productDao();

        @Override
        protected List<Product> doInBackground(Void... params) {
            List<Product> products = productDao.getAll();
            if(products.isEmpty()){
                products = retrieveProducts();
            }
                mProductList = products;
            return products;
        }

        @Override
        protected void onPostExecute(List<Product> products) {
            super.onPostExecute(products);

            //layout manager was set in the xml
            mAdapter.addItemsToList(products);
            mAdapter.notifyDataSetChanged();
        }

        private List<Product> retrieveProducts(){

            List<Product> list = new ArrayList<>();

            //If database is empty then add data
            for (int i = 0; i < 10; i++) {
                Product product = new Product();
                product.setName(getString(R.string.name_format, String.valueOf(i)));
                product.setImageUrl("http://lorempixel.com/500/500/technics/" + i);
                list.add(product);
            }

            productDao.insertAll(list);

            return list;
        }
    }
}
