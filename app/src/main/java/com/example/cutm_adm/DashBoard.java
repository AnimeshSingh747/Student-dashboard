package com.example.cutm_adm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);


        TextView tv = (TextView) this.findViewById(R.id.results);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //open register activity
                startActivity(new Intent(DashBoard.this, myresume.class));
            }
        });

        ImageView ig = (ImageView) this.findViewById(R.id.image13);
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //open register activity
                startActivity(new Intent(DashBoard.this, myresume.class));
            }
        });
        ImageView profile = (ImageView) this.findViewById(R.id.imageView11);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //open register activity
                startActivity(new Intent(DashBoard.this, Profilepage.class));
            }
        });
        ImageView CREDIT = (ImageView) this.findViewById(R.id.imageView13);
        CREDIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //open register activity
                startActivity(new Intent(DashBoard.this, Profilepage.class));
            }
        });
        ImageView FEEDBACK = (ImageView) this.findViewById(R.id.image11);
        FEEDBACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //open register activity
                startActivity(new Intent(DashBoard.this, Profilepage.class));
            }
        });
    }

}