package com.android.sample.snippetsproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.sample.snippetsproject.R;
import com.android.sample.snippetsproject.Snippet;

import java.util.List;

/**
 * Created by Yvonne on 7/16/2017.
 */

public class SnippetRecyclerViewAdapter extends RecyclerView.Adapter<SnippetRecyclerViewAdapter.SnippetViewHolder> {

    List<Snippet> mSnippets;

    public SnippetRecyclerViewAdapter(List<Snippet> snippets){
        mSnippets = snippets;
    }

    @Override
    public SnippetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inflate the view
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.snippet_item_row, parent, false);
        return new SnippetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SnippetRecyclerViewAdapter.SnippetViewHolder holder, int position) {

        //add the cardview elements to inflate
        Snippet snippet = mSnippets.get(position);
        holder.thumbnail.setImageResource(snippet.getThumbnail());
        holder.title.setText(snippet.getTitle());
        holder.description.setText(snippet.getDescription());

    }

    @Override
    public int getItemCount() {
        return mSnippets.size();
    }

    public class SnippetViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;
        TextView title;
        TextView description;
        private final Context context;
        public SnippetViewHolder(View itemView) {
            super(itemView);

            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            context = itemView.getContext();

            //set onClick listener for the view.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //start the activity for the snippet
                    context.startActivity(mSnippets.get(getAdapterPosition()).getIntent());
                }
            });
        }
    }
}
