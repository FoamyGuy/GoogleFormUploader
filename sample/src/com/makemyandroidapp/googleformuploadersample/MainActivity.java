package com.makemyandroidapp.googleformuploadersample;

import android.app.Activity;
import android.os.Bundle;

import com.makemyandroidapp.googleformuploader.GoogleFormUploader;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GoogleFormUploader uploader = new GoogleFormUploader("1AYvV0gFgB1hBuoRKnMsXy1LyF8-Ce8VAshAtho6Z08s");
		uploader.addEntry("1680144410", "Hello Word");
		uploader.addEntry("1558298396", "From android app");
		uploader.upload();
		
	}


}
