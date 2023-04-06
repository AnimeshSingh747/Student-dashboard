package com.example.cutm_adm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread td = new Thread(){

            public void run(){
                try {
                    sleep(4000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(SplashActivity.this , login.class);
                    startActivity(intent);
                    finish();
                }
            }
        };td.start();
    }
}