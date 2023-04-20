package com.example.cutm_adm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class Feedback extends AppCompatActivity {
    RatingBar rt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        rt = (RatingBar) findViewById(R.id.ratingBar);

        //finding the specific RatingBar with its unique ID
        LayerDrawable stars=(LayerDrawable)rt.getProgressDrawable();

        //Use for changing the color of RatingBar
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
    }

    public void Call(View v)
    {
        // This function is called when button is clicked.
        // Display ratings, which is required to be converted into string first.
        TextView t = (TextView)findViewById(R.id.textView2);
        t.setText("You Rated :"+String.valueOf(rt.getRating()));

    }
}