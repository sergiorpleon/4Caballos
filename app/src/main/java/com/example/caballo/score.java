package com.example.caballo;

import java.util.logging.Level;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class score extends Activity {
	private SharedPreferences miPrefer;

	private boolean guardar;
	private int nivelL;
	private int tiempoL;
	private int movL;
	private int movT;
	private int tiempoT;

	private ListaRecord l;

	private TextView[][] textV;
	private int[] imgArr;

	private TextView enc;
	private ImageView img;

	private Button ok;
	private Button preview;
	private Button next;

	boolean mostrarToast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);

		Intent i = getIntent();
		guardar = i.getBooleanExtra("guardar", false);
		nivelL = i.getIntExtra("nivel", 0);
		tiempoL = i.getIntExtra("tiempo", 0);
		movL = i.getIntExtra("mov", 0);
		movT = i.getIntExtra("total", 0);
		tiempoT = i.getIntExtra("tiempoT", 0);
		//tiempoL = tiempoT;
		mostrarToast = false;
		actualizar();

		imgArr = new int[25];

		imgArr[0] = R.drawable.level1;
		imgArr[1] = R.drawable.level2;
		imgArr[2] = R.drawable.level3;
		imgArr[3] = R.drawable.level4;
		imgArr[4] = R.drawable.level5;
		imgArr[5] = R.drawable.level6;
		imgArr[6] = R.drawable.level7;
		imgArr[7] = R.drawable.level8;
		imgArr[8] = R.drawable.level9;
		imgArr[9] = R.drawable.level10;
		imgArr[10] = R.drawable.level11;
		imgArr[11] = R.drawable.level12;
		imgArr[12] = R.drawable.level13;
		imgArr[13] = R.drawable.level14;
		imgArr[14] = R.drawable.level15;
		imgArr[15] = R.drawable.level16;
		imgArr[16] = R.drawable.level17;
		imgArr[17] = R.drawable.level18;
		imgArr[18] = R.drawable.level19;
		imgArr[19] = R.drawable.level20;
		imgArr[20] = R.drawable.level21;
		imgArr[21] = R.drawable.level22;
		imgArr[22] = R.drawable.level23;
		imgArr[23] = R.drawable.level24;
		imgArr[24] = R.drawable.level25;

		textV = new TextView[9][3];

		textV[0][0] = (TextView) findViewById(R.id.textView11);
		textV[0][1] = (TextView) findViewById(R.id.textView12);
		textV[0][2] = (TextView) findViewById(R.id.textView13);

		textV[1][0] = (TextView) findViewById(R.id.textView21);
		textV[1][1] = (TextView) findViewById(R.id.textView22);
		textV[1][2] = (TextView) findViewById(R.id.textView23);

		textV[2][0] = (TextView) findViewById(R.id.textView31);
		textV[2][1] = (TextView) findViewById(R.id.textView32);
		textV[2][2] = (TextView) findViewById(R.id.textView33);

		textV[3][0] = (TextView) findViewById(R.id.textView41);
		textV[3][1] = (TextView) findViewById(R.id.textView42);
		textV[3][2] = (TextView) findViewById(R.id.textView43);

		textV[4][0] = (TextView) findViewById(R.id.textView51);
		textV[4][1] = (TextView) findViewById(R.id.textView52);
		textV[4][2] = (TextView) findViewById(R.id.textView53);

		textV[5][0] = (TextView) findViewById(R.id.textView61);
		textV[5][1] = (TextView) findViewById(R.id.textView62);
		textV[5][2] = (TextView) findViewById(R.id.textView63);

		textV[6][0] = (TextView) findViewById(R.id.textView71);
		textV[6][1] = (TextView) findViewById(R.id.textView72);
		textV[6][2] = (TextView) findViewById(R.id.textView73);

		textV[7][0] = (TextView) findViewById(R.id.textView81);
		textV[7][1] = (TextView) findViewById(R.id.textView82);
		textV[7][2] = (TextView) findViewById(R.id.textView83);

		textV[8][0] = (TextView) findViewById(R.id.textView91);
		textV[8][1] = (TextView) findViewById(R.id.textView92);
		textV[8][2] = (TextView) findViewById(R.id.textView93);

		enc = (TextView) findViewById(R.id.encabezado);
		img = (ImageView) findViewById(R.id.imageViewLevel);

		ok = (Button) findViewById(R.id.botonOK);
		preview = (Button) findViewById(R.id.botonPreview);
		next = (Button) findViewById(R.id.botonNext);

		if (!guardar) {
			((LinearLayout) findViewById(R.id.layoutNombre))
					.setVisibility(View.GONE);
			preview.setVisibility(View.VISIBLE);
			next.setVisibility(View.VISIBLE);
			((ImageView) findViewById(R.id.imageViewLevel))
					.setVisibility(View.VISIBLE);
		} else {
			((LinearLayout) findViewById(R.id.layoutNombre))
					.setVisibility(View.VISIBLE);
			preview.setVisibility(View.INVISIBLE);
			next.setVisibility(View.INVISIBLE);
			((ImageView) findViewById(R.id.imageViewLevel))
					.setVisibility(View.INVISIBLE);
		}

		if (nivelL < 25) {
			preview.setVisibility(View.INVISIBLE);
			next.setVisibility(View.INVISIBLE);
			enc.setText("NIVEL: " + nivelL);
			img.setBackgroundResource(imgArr[nivelL - 1]);
		} else {
			nivelL = 25;
			next.setVisibility(View.INVISIBLE);
			((LinearLayout) findViewById(R.id.layoutNombre))
					.setVisibility(View.GONE);
			enc.setText("TOTAL");
			img.setBackgroundResource(imgArr[24]);
			if (guardar) {
				((LinearLayout) findViewById(R.id.layoutNombre))
						.setVisibility(View.VISIBLE);
			}
		}

		if (nivelL == 25) {
			enc.setText("TOTAL");
			img.setBackgroundResource(imgArr[24]);
		}

		String nombrePrefer = "miPrefer" + nivelL;
		miPrefer = getSharedPreferences(nombrePrefer, MODE_PRIVATE);

		l = new ListaRecord();
		l.cargar(miPrefer);

		// ir a score
		mostrar();

	}

	public void mostrar() {
		Persona p;
		for (int i = 0; i < 9; i++) {
			p = l.getLisP().get(i);
			textV[i][0].setText(p.getNombre());
			textV[i][1].setText(p.getTiempo() + "");
			textV[i][2].setText(p.getMovimientos() + "");
		}
	}

	public void pressOK(View v) {
		EditText e = (EditText) findViewById(R.id.nombre);
		Toast.makeText(getBaseContext(), e.getText().toString() + tiempoL
				+ movL, Toast.LENGTH_LONG);
		l.adicionar(new Persona(e.getText().toString(), tiempoL, movL));
		l.guardar(miPrefer);
		l.cargar(miPrefer);
		mostrar();

		((LinearLayout) findViewById(R.id.layoutNombre))
				.setVisibility(View.GONE);
	}

	public void pressPreview(View v) {
		nivelL--;
		String nombrePrefer = "miPrefer" + nivelL;
		miPrefer = getSharedPreferences(nombrePrefer, MODE_PRIVATE);
		l.cargar(miPrefer);
		mostrar();
		enc.setText("NIVEL: " + nivelL);
		img.setBackgroundResource(imgArr[nivelL - 1]);
		if (nivelL == 1) {
			preview.setVisibility(View.INVISIBLE);
		}
		if (nivelL == 24) {
			next.setVisibility(View.VISIBLE);
		}
	}

	public void pressNext(View v) {
		nivelL++;
		String nombrePrefer = "miPrefer" + nivelL;
		miPrefer = getSharedPreferences(nombrePrefer, MODE_PRIVATE);
		l.cargar(miPrefer);
		mostrar();
		enc.setText("NIVEL: " + nivelL);
		img.setBackgroundResource(imgArr[nivelL - 1]);
		if (nivelL == 2) {
			preview.setVisibility(View.VISIBLE);
		}
		if (nivelL == 25) {
			next.setVisibility(View.INVISIBLE);
			enc.setText("TOTAL");
			img.setBackgroundResource(imgArr[24]);

		}
	}

	public void actualizar() {

		if (nivelL < 25) {
			mostrarToast = true;
			SharedPreferences miPref;
			String nombrePrefer = "guarda";
			miPref = getSharedPreferences(nombrePrefer, MODE_PRIVATE);
			int level;
			boolean gano;

			level = miPref.getInt("level", 1);
			gano = miPref.getBoolean("gano", false);
			if (!gano) {

				if (level <= nivelL) {

					SharedPreferences.Editor editor = miPref.edit();

					if (nivelL == 24) {
						editor.putBoolean("gano", true);
						editor.putInt("level", 1);
						editor.putInt("total", 0);
					} else {
						editor.putBoolean("gano", false);
						editor.putInt("level", nivelL + 1);
						editor.putInt("total", movT);
						editor.putInt("tiempoT", tiempoT);
						
					}
					editor.commit();

				}
			}
		}
	}

	public void onDestroy() {
		if (Control.menuscore==false) {
			if (mostrarToast) {
				Toast.makeText(getBaseContext(), "NIVEL " + (nivelL + 1),
						Toast.LENGTH_SHORT).show();
			}
		}
		super.onDestroy();
	}
}