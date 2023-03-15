package com.example.cutm_adm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class thankyou_exitsplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou_exitsplash);
        Thread td = new Thread(){

            public void run(){
                try {
                    sleep(3900);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(thankyou_exitsplash.this , login.class);
                    startActivity(intent);
                    finish();
                }
            }
        };td.start();
    }
}