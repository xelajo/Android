package com.example.gridview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView tv;
    GridView gv; // Change ListView to GridView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.t1);
        String msg=getIntent().getStringExtra("mykey");
        msg = " Alex";
        tv.setText("Welcome" + msg);
        gv=(GridView)findViewById(R.id.gv); // Initialize GridView
        String[] courses={"MCA","MBA","BBA","BCA"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, courses);
        gv.setAdapter(adapter); // Set the adapter on GridView
        gv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String itemname=gv.getItemAtPosition(i).toString(); // Change ListView to GridView
        Toast.makeText(this, itemname, Toast.LENGTH_SHORT).show();
    }
}
