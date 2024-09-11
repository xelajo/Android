package com.example.logout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.logout.R;
import com.example.logout.second_activity;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEdit;
    private EditText passwordEdit;
    private Button submitEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEdit = findViewById(R.id.userid);
        passwordEdit = findViewById(R.id.passcode);
        submitEdit = findViewById(R.id.submit);

        submitEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEdit.getText().toString().trim();
                String password = passwordEdit.getText().toString().trim();

                Bundle b = new Bundle();
                b.putString("User",username);
                b.putString("Pass", password);
                Intent intent = new Intent(MainActivity.this, second_activity.class);
                intent.putExtras(b);

                if (username.equals("admin") && password.equals("admin1"))
                {
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}