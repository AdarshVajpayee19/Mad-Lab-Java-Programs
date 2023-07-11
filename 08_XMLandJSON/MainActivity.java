package com.example.xmljsonparser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	Button jb, xb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		jb = (Button) findViewById(R.id.jb);
		jb.setOnClickListener(this);
		xb = (Button) findViewById(R.id.xb);
		xb.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String data = v.equals(jb) ? "json" : "xml";
		Intent it = new Intent(getBaseContext(), ViewDataActivity.class);
		it.putExtra("data", data);
		startActivity(it);
	}
}
