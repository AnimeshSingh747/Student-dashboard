package com.example.cutm_adm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {

    // create object at database reference to access firebase realtime database
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://sims-92776-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText fullname = findViewById(R.id.fullname);
        final EditText email = findViewById(R.id.EMAIL);
        final EditText Reg = findViewById(R.id.regno);
        final EditText password = findViewById(R.id.password);
        final EditText confirmpassword = findViewById(R.id.conPassword);

        final Button registerBtn = findViewById(R.id.register_btn);
        final TextView loginnowbtn = findViewById(R.id.login_btn2);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //fetch data from edit text
                final String fullnametxt = fullname.getText().toString();
                final String emailtxt = email.getText().toString();
                final String regtxt = Reg.getText().toString();
                final String passwordtxt = password.getText().toString();
                final String conPasswordtxt = confirmpassword.getText().toString();

                //checking no feilds are empty
                if (fullnametxt.isEmpty() || emailtxt.isEmpty() || passwordtxt.isEmpty() || regtxt.isEmpty()){
                    Toast.makeText(Register.this, "Please fill all feilds", Toast.LENGTH_SHORT).show();
                }

                //check if passwords are matching with each other
                else if (!passwordtxt.equals(conPasswordtxt)){
                    Toast.makeText(Register.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
                }
                else{

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            //check if email is registered
                            if (snapshot.hasChild(emailtxt)){
                                Toast.makeText(Register.this, "Email is already registered", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                //sending data to firebase realtime database
                                //using email as unique identity
                                databaseReference.child("users").child(regtxt).child("email").setValue(fullnametxt);
                                databaseReference.child("users").child(regtxt).child("fullname").setValue(emailtxt);
                                databaseReference.child("users").child(regtxt).child("password").setValue(passwordtxt);
                                databaseReference.child("users").child(regtxt).child("RegNo").setValue(regtxt);

                                Toast.makeText(Register.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
        loginnowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}