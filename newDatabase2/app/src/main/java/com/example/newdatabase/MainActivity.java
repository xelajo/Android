package com.example.newdatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText Name,Mark,Surname;
    TextView DataV;
    MyDatabase database = new MyDatabase(this) ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.ed1);
        Surname = findViewById(R.id.ed2);
        Mark = findViewById(R.id.ed3);
        DataV = findViewById(R.id.textView);
    }
    public void SaveDat(View view) {
        String UserVal = Name.getText().toString();
        String SurnameVal = Surname.getText().toString();
        Integer PassVal = Integer.parseInt(Mark.getText().toString());
        Boolean result = database.insertdata(UserVal, PassVal,SurnameVal);
        if (result == true) {
            Toast.makeText(getApplicationContext(), "Data inserted Sucessfully",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Data inserted failed",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void read(View view) {
        Cursor res = database.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if (res != null && res.getCount() > 0) {
            while (res.moveToNext()) {
                stringBuffer.append("Id: " + res.getString(0) + "\n");
                stringBuffer.append("Name: " + res.getString(1) + "\n");
                stringBuffer.append("Surname: " + res.getString(2) + "\n");
                stringBuffer.append("marks: " + res.getString(3) + "\n");
            }
            DataV .setText(stringBuffer.toString());
        } else {
            Toast.makeText(getApplicationContext(), "Data Retrieved Successfully",
                    Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(), "Data Retrieved Successfully",
                Toast.LENGTH_SHORT).show();
    }
    public void update(View view) {
        String UserVal = Name.getText().toString();
        String SurnameVal = Surname.getText().toString();
        Integer PassVal = Integer.parseInt(Mark.getText().toString());

        Boolean result = database.updateData(UserVal, PassVal, SurnameVal);
        if (result==true){
            Toast.makeText(getApplicationContext(), "Data updated Successfully",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "No Rows Affected", Toast.LENGTH_SHORT).show();
        }
    }
    public void delete(View view) {
        String UserVal = Name.getText().toString();
        int result=database.deletedata(UserVal);
        Toast.makeText(getApplicationContext(), "Rows Affected", Toast.LENGTH_SHORT).show();
    }
}