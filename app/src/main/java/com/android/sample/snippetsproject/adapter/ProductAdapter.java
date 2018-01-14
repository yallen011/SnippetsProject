package com.android.sample.snippetsproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.sample.snippetsproject.R;
import com.android.sample.snippetsproject.entity.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

import static java.lang.System.load;

/**
 * Created by Yvonne on 8/14/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> mProducts;

    public ProductAdapter(List<Product> products) {
        mProducts = products;
    }

    public void addItemsToList(List<Product> items){

        mProducts = items;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        holder.bind(mProducts.get(position));
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productName;

        public ProductViewHolder(View itemView) {
            super(itemView);

            productImage = (ImageView) itemView.findViewById(R.id.product_image);
            productName = (TextView) itemView.findViewById(R.id.product_name);
        }

        public void bind(Product product){

            productName.setText(product.getName());
            Picasso
                    .with(itemView.getContext())
                    .load(product.getImageUrl())
                    .into(productImage);

        }
    }
}
