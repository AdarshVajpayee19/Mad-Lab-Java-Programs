package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String re1 = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}";
    String re2 = "\\d{10}";
    EditText un, pw, ph;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        un = (EditText) findViewById(R.id.un);
        pw = (EditText) findViewById(R.id.pw);
        ph = (EditText) findViewById(R.id.ph);
        b = (Button) findViewById(R.id.b);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String user = un.getText().toString();
        String pass = pw.getText().toString();
        String phone = ph.getText().toString();
        if(!validate(re1, pass))
            Toast.makeText(getBaseContext(), "Invalid password", Toast.LENGTH_LONG).show();
        else if(!validate(re2, phone))
            Toast.makeText(getBaseContext(), "Invalid phone no", Toast.LENGTH_LONG).show();
        else {
            Bundle bun = new Bundle();
            bun.putString("user", user);
            bun.putString("pass", pass);
            bun.putString("phone", phone);
            Toast.makeText(getBaseContext(), "Registration done", Toast.LENGTH_LONG).show();
            Intent it = new Intent(this, Login.class);
            it.putExtra("data", bun);
            startActivity(it);
        }
    }
    private static boolean validate(String re, String txt) {
        return Pattern.compile(re).matcher(txt).matches();
    }
}
