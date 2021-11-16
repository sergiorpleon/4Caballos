package com.example.caballo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class inciar extends Activity{
	private SharedPreferences miPrefer;
	private int level;
	private boolean gano;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_begin);
	}	
	
	@Override
	protected void onResume() {
		super.onResume();
		
	}

	
	
	
	public void iniciar(View v){
		try {
			Class<?> clazz;
			clazz = Class.forName("com.example.caballo.MainActivity_Cab");
			Intent intent = new Intent(this, clazz);
			intent.putExtra("level", 1);
			intent.putExtra("gano", gano);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void continuar(View v){
		try {
			Class<?> clazz;
			clazz = Class.forName("com.example.caballo.MainActivity_Cab");
			Intent intent = new Intent(this, clazz);
			intent.putExtra("level", (level==25)?1:level);
			intent.putExtra("gano", gano);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void ir(View v){
		try {
			Class<?> clazz;
			clazz = Class.forName("com.example.caballo.MainActivity_Cab");
			Intent intent = new Intent(this, clazz);
			intent.putExtra("level", level);
			intent.putExtra("gano", gano);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
