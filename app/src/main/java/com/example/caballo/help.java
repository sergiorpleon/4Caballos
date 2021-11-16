package com.example.caballo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class help extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
	}

	public void aceptar(View v){
		onBackPressed();
	}
	
}
