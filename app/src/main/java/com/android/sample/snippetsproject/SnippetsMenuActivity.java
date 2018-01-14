package com.android.sample.snippetsproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.sample.snippetsproject.adapter.RecyclerViewAdapter;
import com.android.sample.snippetsproject.adapter.SnippetRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SnippetsMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snippets_menu);

        RecyclerView snippetRecyclerView = (RecyclerView) findViewById(R.id.snippet_menu_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        snippetRecyclerView.setLayoutManager(layoutManager);
        SnippetRecyclerViewAdapter adapter = new SnippetRecyclerViewAdapter(retrieveSnippets());
        snippetRecyclerView.setAdapter(adapter);
    }

    private List<Snippet> retrieveSnippets() {
        List<Snippet> snippets = new ArrayList<>();

        //Floating action button using Android Design Support Library
        Intent fabIntent = new Intent(this, FabDesignSupportLibraryActivity.class);
        Snippet fabSnippet = new Snippet(
                R.drawable.android_fab_img_small,
                "Floating Action Button Menu",
                "Floating action button speed dial menu", fabIntent);
        snippets.add(fabSnippet);

        //Simple RecyclerView with onclick functionality
        Intent rcIntent = new Intent(this, RecyclerViewActivity.class);
        Snippet rcSnippet = new Snippet(
                R.drawable.recyclerview_img_small,
                "RecyclerView",
                "Simple RecyclerView example with an on click functionality", rcIntent);
        snippets.add(rcSnippet);

        //Dialog Snippet
        Intent dialogIntent = new Intent(this, NameDialogActivity.class);
        Snippet dialogSnippet = new Snippet(
                R.drawable.dialog_box_no_buttons_small,
                "Dialog Fragment",
                "Simple custom dialog example to change the name in a text field with no action buttons"
                , dialogIntent);

        snippets.add(dialogSnippet);

        //Basic Room snippet
        Intent roomIntent = new Intent(this, RoomDemoActivity.class);
        Snippet roomSnippet = new Snippet(
                R.drawable.android_room_small,
                "Android Room",
                "Android Room example with async task to retrieve data from database"
                , roomIntent);

        snippets.add(roomSnippet);

        return snippets;

    }
}
