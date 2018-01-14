package com.android.sample.snippetsproject;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class NameDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_dialog);

        //add the fragment to the fragment manager and show the fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        ExampleDialogFragment exampleDialogFragment = ExampleDialogFragment.newInstance("Carl", "Change Name");
        exampleDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);
        exampleDialogFragment.show(fragmentManager,"fragment_example_dialog");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
