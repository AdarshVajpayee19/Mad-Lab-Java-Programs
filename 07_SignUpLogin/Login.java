package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    int count = 0;
    EditText un, pw, ph;
    Button b;
    String user1, user2, pass1, pass2, phone1, phone2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        un = (EditText) findViewById(R.id.un);
        pw = (EditText) findViewById(R.id.pw);
        ph = (EditText) findViewById(R.id.ph);
        b = (Button) findViewById(R.id.b);
        b.setOnClickListener(this);
        Bundle bun = getIntent().getBundleExtra("data");
        user1 = bun.getString("user");
        pass1 = bun.getString("pass");
        phone1 = bun.getString("phone");
    }

    @Override
    public void onClick(View v) {
        user2 = un.getText().toString();
        pass2 = pw.getText().toString();
        phone2 = ph.getText().toString();
        if(user1.equals(user2) && pass1.equals(pass2) && phone1.equals(phone2))
            Toast.makeText(getBaseContext(), "Login Successful", Toast.LENGTH_LONG).show();
        else {
            count++;
            if(count == 3) {
                Toast.makeText(getBaseContext(), "Failed login attempts", Toast.LENGTH_LONG).show();
                b.setEnabled(false);
            }
            else Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        }
    }
}
