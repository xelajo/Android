package com.example.relativelayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    EditText ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ed1 = (EditText) findViewById(R.id.username);
        ed2 = (EditText) findViewById(R.id.password);
    }

    public void Login(View view) {
        String UserName = "alxjhn@gmail.com";
        String Password = "haHa#1";
        String user = String.valueOf(ed1.getText());
        String pass = String.valueOf(ed2.getText());
        if (user.equals(UserName) && pass.equals(Password)) {
            Toast.makeText(this, "Login Succesfull", Toast.LENGTH_SHORT).show();

        }

        else {
            Toast.makeText(this, "login Failed", Toast.LENGTH_SHORT).show();
        }
    }
}
