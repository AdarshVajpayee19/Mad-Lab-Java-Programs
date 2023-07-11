package com.example.xmljsonparser;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ViewDataActivity extends AppCompatActivity {

	TextView xc, jc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_data);
		xc = (TextView) findViewById(R.id.xc);
		jc = (TextView) findViewById(R.id.jc);
		Intent it = getIntent();
		String data = it.getStringExtra("data");
		if(data.equals("xml")) {
			xc.setText("Test xml parsed content");
			parseXML();
		} else if(data.equals("json")) {
			jc.setText("Test json parsed content");
			parseJSON();
		}
	}

	public void parseXML() {
		try (InputStream is = getAssets().open("weather.xml")) {
			Document doc =  DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
			doc.normalize();
			NodeList nodeList = doc.getElementsByTagName("weather");
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					xc.setText("City_Name: " + element.getElementsByTagName("city_name").item(0).getTextContent() + "\n");
					xc.append("Latitude: " + element.getElementsByTagName("latitude").item(0).getTextContent() + "\n");
					xc.append("Longitude: " + element.getElementsByTagName("longitude").item(0).getTextContent() + "\n");
					xc.append("Temperature: " + element.getElementsByTagName("temperature").item(0).getTextContent() + "\n");
					xc.append("Humidity: " + element.getElementsByTagName("humidity").item(0).getTextContent());
				}
			}
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
	}

	public void parseJSON() {
		try (InputStream is = getAssets().open("weather.json")) {
			byte[] data = new byte[is.available()];
			is.read(data);
			String js = new String(data);
			JSONObject jo = new JSONObject(js);
			JSONObject weather = jo.getJSONObject("weather");
			jc.setText("City Name: " + weather.getString("city_name") + "\n");
			jc.append("Latitude: " + weather.getString("latitude") + "\n");
			jc.append("Longitude: " + weather.getString("longitude") + "\n");
			jc.append("Temperature: " + weather.getString("temperature") + "\n");
			jc.append("Humidity: " + weather.getString("humidity") + "\n");
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
	}
}

