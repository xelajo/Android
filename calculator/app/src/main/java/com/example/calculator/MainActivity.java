package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    EditText ed2;
    TextView TV;

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
        ed1 = (EditText)findViewById(R.id.e1);
        ed2 = (EditText)findViewById(R.id.e2);
        TV = (TextView)findViewById(R.id.result);
    }

    public void ADD(View view) {
        double  num1 = Double.parseDouble(ed1.getText().toString());
        double  num2 = Double.parseDouble(ed2.getText().toString());
        double  ans = num1 + num2;
        TV.setText(""+ans);
    }

    public void SUB(View view) {
        double  num1 = Double.parseDouble(ed1.getText().toString());
        double  num2 = Double.parseDouble(ed2.getText().toString());
        double  ans = num1 - num2;
        TV.setText(""+ans);
    }

    public void DIV(View view) {
        double  num1 = Double.parseDouble(ed1.getText().toString());
        double  num2 = Double.parseDouble(ed2.getText().toString());
        double  ans = num1 / num2;
        TV.setText(""+ans);
    }

    public void MUL(View view) {
        double  num1 = Double.parseDouble(ed1.getText().toString());
        double  num2 = Double.parseDouble(ed2.getText().toString());
        double  ans = num1 * num2;
        TV.setText(""+ans);
    }
}