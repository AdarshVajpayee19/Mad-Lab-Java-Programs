package com.example.callandsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Intents.Insert;
import android.provider.ContactsContract.RawContacts;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, delb, callb, saveb, bs, bh;
	EditText t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1 = (Button) findViewById(R.id.b1);
		b1.setOnClickListener(this);
		b2 = (Button) findViewById(R.id.b2);
		b2.setOnClickListener(this);
		b3 = (Button) findViewById(R.id.b3);
		b3.setOnClickListener(this);
		b4 = (Button) findViewById(R.id.b4);
		b4.setOnClickListener(this);
		b5 = (Button) findViewById(R.id.b5);
		b5.setOnClickListener(this);
		b6 = (Button) findViewById(R.id.b6);
		b6.setOnClickListener(this);
		b7 = (Button) findViewById(R.id.b7);
		b7.setOnClickListener(this);
		b8 = (Button) findViewById(R.id.b8);
		b8.setOnClickListener(this);
		b9 = (Button) findViewById(R.id.b9);
		b9.setOnClickListener(this);
		b0 = (Button) findViewById(R.id.b0);
		b0.setOnClickListener(this);
		bs = (Button) findViewById(R.id.bs);
		bs.setOnClickListener(this);
		bh = (Button) findViewById(R.id.bh);
		bh.setOnClickListener(this);
		callb = (Button) findViewById(R.id.callb);
		callb.setOnClickListener(this);
		saveb = (Button) findViewById(R.id.saveb);
		saveb.setOnClickListener(this);
		delb = (Button) findViewById(R.id.delb);
		delb.setOnClickListener(this);
		t = (EditText) findViewById(R.id.t);
	}

	@Override
	public void onClick(View v) {
		Button b = (Button) v;
		switch(b.getId()) {
			case R.id.b0:
			case R.id.b1:
			case R.id.b2:
			case R.id.b3:
			case R.id.b4:
			case R.id.b5:
			case R.id.b6:
			case R.id.b7:
			case R.id.b8:
			case R.id.b9:
			case R.id.bs:
			case R.id.bh:
				t.append(b.getText());
				break;
			case R.id.saveb:
				save();
				break;
			case R.id.callb:
				call();
				break;
			case R.id.delb:
				String txt = t.getText().toString();
				if(txt.length() > 0)
					t.setText(txt.substring(0, txt.length() - 1));
		}
	}

	private void call() {
		String txt = t.getText().toString();
		Intent it = new Intent(Intent.ACTION_DIAL);
		it.setData(Uri.parse("tel:" + txt));
		startActivity(it);
	}

	private void save() {
		String txt = t.getText().toString();
		Intent it = new Intent(Insert.ACTION);
		it.setType(RawContacts.CONTENT_TYPE);
		it.putExtra(Insert.NAME, "Unknown");
		it.putExtra(Insert.PHONE, txt);
		startActivity(it);
	}
}
