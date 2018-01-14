package com.android.sample.snippetsproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;




public class FabDesignSupportLibraryActivity extends AppCompatActivity {

    FloatingActionButton fab_info, fab_reminder, fab_dialer;
    boolean isFABOpen=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_design_support_library);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fab_info = (FloatingActionButton) findViewById(R.id.fab_info);
        fab_reminder = (FloatingActionButton) findViewById(R.id.fab_reminder);
        fab_dialer = (FloatingActionButton) findViewById(R.id.fab_dialer);

        setOnClickBehavior();

    }

    private void setOnClickBehavior() {

        fab_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFABOpen){
                    showFABMenu();
                }else{
                    closeFABMenu();
                }
            }
        });
    }

    private void showFABMenu(){

        isFABOpen=true;
        fab_info.animate().rotationBy(180);
        fab_reminder.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fab_dialer.animate().translationY(-getResources().getDimension(R.dimen.standard_100));
    }

    private void closeFABMenu(){

        isFABOpen = false;
        fab_info.animate().rotationBy(-180);
        fab_reminder.animate().translationY(0);
        fab_dialer.animate().translationY(0);

    }

    @Override
    public void onBackPressed() {
        if(isFABOpen){
            closeFABMenu();
        }else{
            super.onBackPressed();
        }
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
