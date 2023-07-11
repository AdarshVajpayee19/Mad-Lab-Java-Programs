package com.example.texttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {
	Button b;
	EditText t;
	TextToSpeech tts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		t = (EditText) findViewById(R.id.t);
		b = (Button) findViewById(R.id.b);
		b.setOnClickListener(this);
		tts = new TextToSpeech(getBaseContext(), this);
		tts.setLanguage(Locale.ENGLISH);
	}

	@Override
	public void onInit(int status) {
		if(status != TextToSpeech.ERROR)
			Toast.makeText(getBaseContext(), "Successful", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		String txt = t.getText().toString();
		if("".equals(txt)) {
			txt = Calendar.getInstance().getTime().toString();
			t.setText(txt);
		}
		tts.speak(txt, TextToSpeech.QUEUE_FLUSH, null);
	}
}
