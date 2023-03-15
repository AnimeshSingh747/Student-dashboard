package com.example.cutm_adm;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class admissionform extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://sims-92776-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admissionform);
        spinnerCourse();
        spinnerStates();
        final EditText fullname = findViewById(R.id.editTextTextPersonName2);
        final EditText lastname = findViewById(R.id.editTextTextPersonName3);
        final EditText personalemail = findViewById(R.id.editTextTextEmailAddress);
        final EditText Reg = findViewById(R.id.editTextNumberx);
        final EditText StudentContact = findViewById(R.id.editTextPhone);
        final EditText FatherContact = findViewById(R.id.editTextPhone2);

        final Button registerBtn = findViewById(R.id.button_submit);
      //  final TextView loginnowbtn = findViewById(R.id.login_btn2);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //fetch data from edit text
                final String fullnametxt = fullname.getText().toString();
                final String lastnametxt = lastname.getText().toString();
                final String emailtxt = personalemail.getText().toString();
                final String regtxt = Reg.getText().toString();
                final String studentContacttxt = StudentContact.getText().toString();
                final String FatherContacttxt = FatherContact.getText().toString();

                //checking no feilds are empty
                if (fullnametxt.isEmpty() || emailtxt.isEmpty() || studentContacttxt.isEmpty() || regtxt.isEmpty()){
                    Toast.makeText(admissionform.this, "Please fill all feilds", Toast.LENGTH_SHORT).show();
                }

                else{

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            //check if email is registered
                            if (snapshot.hasChild(lastnametxt)){

                                Toast.makeText(admissionform.this, "Email is already registered", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                //sending data to firebase realtime database
                                //using email as unique identity
                                databaseReference.child("users").child(regtxt).child("Fullname").setValue(fullnametxt);
                                databaseReference.child("users").child(regtxt).child("Lastname").setValue(lastnametxt);
                                databaseReference.child("users").child(regtxt).child("PersonalEmail").setValue(emailtxt);
                                databaseReference.child("users").child(regtxt).child("StudentContact").setValue(studentContacttxt);
                                databaseReference.child("users").child(regtxt).child("FatherContact").setValue(FatherContacttxt);
                                databaseReference.child("users").child(regtxt).child("RegistrationNo").setValue(regtxt);

                                Toast.makeText(admissionform.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
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

    }
    private void spinnerCourse(){
        Spinner spinnerCources=findViewById(R.id.spinner_courses);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.SOET_Courses, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerCources.setAdapter(adapter);

    }

    private void spinnerStates(){
        Spinner spinnerStates = findViewById(R.id.spinner_states);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.States, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerStates.setAdapter(adapter);

    }

}
