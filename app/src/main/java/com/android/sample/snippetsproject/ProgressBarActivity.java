package com.android.sample.snippetsproject;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {

    int mProgress;
    int mMax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);



        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Button updateBtn = (Button) findViewById(R.id.progress_btn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress++;
                progressBar.setProgress(mProgress);

            }
        });
        progressBar.setMax(500);

//        ObjectAnimator animation = ObjectAnimator.ofInt (progressBar, "progress", 0, 500); // see this max value coming back here, we animale towards that value
//        animation.setDuration (5000); //in milliseconds
//        animation.setInterpolator (new DecelerateInterpolator());
//        animation.start ();
    }
}

