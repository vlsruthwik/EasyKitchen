package com.example.easykitchen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    public void next(View view) {
        ph = findViewById(R.id.ph_no);
        String p = ph.getText().toString();
        if(p.length()==10){
            startActivity(new Intent(MainActivity.this,MainScreen.class));
        }
        else{
            Toast t = Toast.makeText(getApplicationContext(),"Please enter a valid 10-digit mobile number",Toast.LENGTH_LONG);
            t.show();
        }
    }
}