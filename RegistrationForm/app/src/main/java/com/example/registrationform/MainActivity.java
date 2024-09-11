package com.example.registrationform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText fname, lname, dob, phno, email, password, confirmPassword;
    private RadioGroup genderRadio;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "UserDetails";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize EditText and RadioGroup components
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        dob = findViewById(R.id.dob);
        phno = findViewById(R.id.phno);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        genderRadio = findViewById(R.id.genderRadio);
        Button submitButton = findViewById(R.id.button1);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        submitButton.setOnClickListener(v -> {
            if (validateForm()) {
                // Store user details in SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("fname", fname.getText().toString());
                editor.putString("lname", lname.getText().toString());
                editor.putString("dob", dob.getText().toString());
                editor.putString("phno", phno.getText().toString());
                editor.putString("email", email.getText().toString());
                editor.putString("gender", getSelectedGender());
                editor.apply(); // Commit the changes

                // Proceed to the next activity
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateForm() {
        boolean isValid = true;

        // Validate first name
        String firstName = fname.getText().toString().trim();
        if (TextUtils.isEmpty(firstName)) {
            fname.setError("First name is required");
            isValid = false;
        } else if (!firstName.matches("[a-zA-Z]+")) {
            fname.setError("First name should contain only alphabetic characters");
            isValid = false;
        }

        // Validate last name
        String lastName = lname.getText().toString().trim();
        if (TextUtils.isEmpty(lastName)) {
            lname.setError("Last name is required");
            isValid = false;
        } else if (!lastName.matches("[a-zA-Z]+")) {
            lname.setError("Last name should contain only alphabetic characters");
            isValid = false;
        }

        // Validate date of birth (basic format check, e.g., dd/mm/yyyy)
        String dateOfBirth = dob.getText().toString().trim();
        if (TextUtils.isEmpty(dateOfBirth)) {
            dob.setError("Date of birth is required");
            isValid = false;
        } else if (!dateOfBirth.matches("\\d{2}/\\d{2}/\\d{4}")) {
            dob.setError("Date of birth must be in dd/mm/yyyy format");
            isValid = false;
        }

        // Validate phone number (should be exactly 10 digits)
        String phone = phno.getText().toString().trim();
        if (TextUtils.isEmpty(phone) || !phone.matches("\\d{10}")) {
            phno.setError("Phone number must be 10 digits");
            isValid = false;
        }

        // Validate email
        String emailText = email.getText().toString().trim();
        if (TextUtils.isEmpty(emailText) || !Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            email.setError("Invalid email address");
            isValid = false;
        }

        // Validate password
        String passwordText = password.getText().toString().trim();
        String confirmPasswordText = confirmPassword.getText().toString().trim();

        if (TextUtils.isEmpty(passwordText)) {
            password.setError("Password is required");
            isValid = false;
        } else if (passwordText.length() < 6) {
            password.setError("Password must be at least 6 characters");
            isValid = false;
        } else if (!passwordText.matches(".*[A-Z].*") || !passwordText.matches(".*[a-z].*") || !passwordText.matches(".*\\d.*")) {
            password.setError("Password must contain at least one uppercase letter, one lowercase letter, and one number");
            isValid = false;
        }

        if (TextUtils.isEmpty(confirmPasswordText)) {
            confirmPassword.setError("Confirm Password is required");
            isValid = false;
        } else if (!passwordText.equals(confirmPasswordText)) {
            confirmPassword.setError("Passwords do not match");
            isValid = false;
        }

        // Validate gender selection
        if (genderRadio.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
            isValid = false;
        }

        return isValid;
    }

    private String getSelectedGender() {
        int selectedId = genderRadio.getCheckedRadioButtonId();

        if (selectedId == R.id.radio1) {
            return "Male";
        } else if (selectedId == R.id.radio2) {
            return "Female";
        } else if (selectedId == R.id.radio3) {
            return "Other";
        } else {
            return "";
        }
    }
}


