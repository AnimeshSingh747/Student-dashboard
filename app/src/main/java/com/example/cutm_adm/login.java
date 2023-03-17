package com.example.cutm_adm;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    Button button;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://sims-92776-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        final EditText username = findViewById(R.id.username1);
        final EditText password = findViewById(R.id.Password);
        final Button LoginBtn = findViewById(R.id.login_btn);

        button = findViewById(R.id.login_btn);

        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          final String usernameTxt = username.getText().toString();
                                          final String PasswordTxt = password.getText().toString();

                                          if (usernameTxt.isEmpty() || PasswordTxt.isEmpty()) {
                                              Toast.makeText(login.this, "Please enter your Username and Password", Toast.LENGTH_SHORT).show();
                                          }
                                          else {

                                              databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                                                  @Override
                                                  public void onDataChange(@NonNull DataSnapshot snapshot) {

                                                      //check if email is existing in the db
                                                      if (snapshot.hasChild(usernameTxt)){

                                                          final String getpassword = snapshot.child(usernameTxt).child("password").getValue(String.class);

                                                          if (getpassword.equals(PasswordTxt)){
                                                              Toast.makeText(login.this, "Successfully Logged in",Toast.LENGTH_SHORT).show();

                                                              //Starting student form
                                                              startActivity(new Intent(login.this, DashBoard.class));
                                                              finish();
                                                          }
                                                          else {
                                                              Toast.makeText(login.this,"Wrong Credentials",Toast.LENGTH_SHORT).show();
                                                          }

                                                      }
//
                                                  }


                                                  @Override
                                                  public void onCancelled(@NonNull DatabaseError error) {

                                                  }
                                              });

                                          }
                                          ////////////////////////////////////////////////////////////////////////////////
                                          databaseReference.child("admin").addListenerForSingleValueEvent(new ValueEventListener() {
                                              @Override
                                              public void onDataChange(@NonNull DataSnapshot snapshot) {

                                                  //check if email is existing in the db
                                                  if (snapshot.hasChild(usernameTxt)){

                                                      final String getpassword = snapshot.child(usernameTxt).child("password").getValue(String.class);

                                                      if (getpassword.equals(PasswordTxt)){
                                                          Toast.makeText(login.this, "Successfully Logged in admin panel",Toast.LENGTH_SHORT).show();

                                                          //Starting student form
                                                          startActivity(new Intent(login.this, Adminpage.class));
                                                          finish();
                                                      }
//                                                      Toast.makeText(login.this," ",Toast.LENGTH_SHORT).show();
                                                      else {
                                                          Toast.makeText(login.this,"Incorrect username or password",Toast.LENGTH_SHORT).show();
                                                      }
                                                  }
//
                                              }


                                              @Override
                                              public void onCancelled(@NonNull DatabaseError error) {

                                              }
                                          });
                                          ////////////////////////////////////////////////////////////////////////////////
                                      }
                                  });

                TextView tv = (TextView) this.findViewById(R.id.registernowBtn);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //open register activity
                        startActivity(new Intent(login.this, Register.class));
                    }
                });

            ScrollView scrollView = findViewById(R.id.mainLayout);

            AnimationDrawable animationDrawable = (AnimationDrawable) scrollView.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();
        }
    }