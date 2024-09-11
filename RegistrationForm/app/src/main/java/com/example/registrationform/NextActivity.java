package com.example.registrationform;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    private TextView textViewName, textViewDob, textViewPhone, textViewEmail, textViewGender;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "UserDetails";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        // Initialize TextView components
        textViewName = findViewById(R.id.textViewName);
        textViewDob = findViewById(R.id.textViewDob);
        textViewPhone = findViewById(R.id.textViewPhone);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewGender = findViewById(R.id.textViewGender);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        // Retrieve and display user details
        String firstName = sharedPreferences.getString("fname", "N/A");
        String lastName = sharedPreferences.getString("lname", "N/A");
        String dateOfBirth = sharedPreferences.getString("dob", "N/A");
        String phone = sharedPreferences.getString("phno", "N/A");
        String email = sharedPreferences.getString("email", "N/A");
        String gender = sharedPreferences.getString("gender", "N/A");

        textViewName.setText("Name: " + firstName + " " + lastName);
        textViewDob.setText("Date of Birth: " + dateOfBirth);
        textViewPhone.setText("Phone: " + phone);
        textViewEmail.setText("Email: " + email);
        textViewGender.setText("Gender: " + gender);
    }
}
