package com.example.caballo;

import java.util.GregorianCalendar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_Cab extends Activity {
	float timePerdIni;
	float timePerdFinal;
	float timePerdTotal = 0;

	int tiempo_total;
	float startTime;
	float endTime;
	private SharedPreferences miPrefer;
	boolean vista;
	boolean tmp;
	int c1;
	int c2;
	int c3;
	int c4;

	TextView text0;
	TextView text1;
	TextView text2;

	// numero de nivel
	boolean gano;
	int nivel;

	// score
	// cantidad de mov
	private int mov;
	private int movT;
	private int tiempoT;
	// tiempo inicial
	String fcomienzo;
	GregorianCalendar t_ini;

	// tiempo final
	String fin;
	GregorianCalendar t_fin;

	// clase java con juego
	private MisCaballos m;

	// var mano(con pieza alzada o sin pieza)
	private boolean presionado;

	// var movidas
	private int varP;// posicion incio
	private int newP;// posicion fin

	// tablero de imagenes
	private ImageView[] im;

	private boolean oncreate = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
		setContentView(R.layout.activity_main_activity__cab);
		
		int ww = (getWindowManager().getDefaultDisplay().getWidth()/6);
		
		//int hh = getWindowManager().getDefaultDisplay().getHeight();
		LinearLayout tablero = (LinearLayout) findViewById(R.id.tablero);
		LayoutParams lp=new LayoutParams(ww*5, ww*4);
		tablero.setLayoutParams(lp);
		tablero.setGravity(Gravity.CENTER);
		tablero.setPadding(10, 0, 0, 0);
		
		Control.menuscore = false;
		Control.viewfinal = false;
		timePerdIni = System.nanoTime();
		Restart();



	}

	private void Restart() {
		vista = true;
		tmp = false;
		c1 = 0;
		c2 = 0;
		c3 = 0;
		c4 = 0;

		text0 = (TextView) findViewById(R.id.nivel);
		text1 = (TextView) findViewById(R.id.textView2);
		text2 = (TextView) findViewById(R.id.textView4);

		nivel = 1;

		presionado = false;

		varP = -1;
		newP = -1;

		mov = 0;
		movT = 0;
		tiempoT = 0;

		String nombrePrefer = "guarda";
		miPrefer = getSharedPreferences(nombrePrefer, MODE_PRIVATE);
		nivel = miPrefer.getInt("level", 1);
		gano = miPrefer.getBoolean("gano", false);
		movT = miPrefer.getInt("total", 0);
		tiempoT = miPrefer.getInt("tiempoT", 0);

		// nivel = 23;

		t_ini = (GregorianCalendar) GregorianCalendar.getInstance();
		t_fin = new GregorianCalendar();

		im = new ImageView[20];
		im[0] = (ImageView) findViewById(R.id.ImageButton1);
		im[1] = (ImageView) findViewById(R.id.ImageButton2);
		im[2] = (ImageView) findViewById(R.id.ImageButton3);
		im[3] = (ImageView) findViewById(R.id.ImageButton4);

		im[4] = (ImageView) findViewById(R.id.ImageButton5);
		im[5] = (ImageView) findViewById(R.id.ImageButton6);
		im[6] = (ImageView) findViewById(R.id.ImageButton7);
		im[7] = (ImageView) findViewById(R.id.ImageButton8);

		im[8] = (ImageView) findViewById(R.id.ImageButton9);
		im[9] = (ImageView) findViewById(R.id.ImageButton10);
		im[10] = (ImageView) findViewById(R.id.ImageButton11);
		im[11] = (ImageView) findViewById(R.id.ImageButton12);

		im[12] = (ImageView) findViewById(R.id.ImageButton13);
		im[13] = (ImageView) findViewById(R.id.ImageButton14);
		im[14] = (ImageView) findViewById(R.id.ImageButton15);
		im[15] = (ImageView) findViewById(R.id.ImageButton16);
		im[16] = (ImageView) findViewById(R.id.ImageButton17);
		im[17] = (ImageView) findViewById(R.id.ImageButton18);
		im[18] = (ImageView) findViewById(R.id.ImageButton19);
		im[19] = (ImageView) findViewById(R.id.ImageButton20);

		text0.setText("Level " + nivel + "/24");
		text1.setText(mov + "");
		text2.setText(movT + "");

		pintarTablero(nivel);

		// pintarTablero();
		pintarCaballo();

	}

	@Override
	protected void onResume() {
		Control.menuscore = false;
		if (oncreate) {
			timePerdFinal = System.nanoTime();
			timePerdTotal += (int) ((timePerdFinal - timePerdIni) / 1000000000.0f);
			// Control.viewfinal = false;
			oncreate = false;
		}

		if (nivel == 25) {

			SharedPreferences miPrefer;
			String nombrePrefer = "miPrefer" + (nivel);
			miPrefer = getSharedPreferences(nombrePrefer, MODE_PRIVATE);

			Intent i = new Intent(getBaseContext(), score.class);

			// long umbral = miPrefer.getLong("umbral", 1000000 * 1000000);
			int umbralmov = miPrefer.getInt("umbralmov", 1000000);
			int umbraltiemp = miPrefer.getInt("umbraltiemp", 1000000);

			double newTotal = (movT * 1000000 + (1 - (1 / (tiempoT + 1))) * 1000000);

			double umbral = (umbralmov * 1000000 + (1 - (1 / (umbraltiemp + 1))) * 1000000);
			if (newTotal < umbral) {
				// if (movT < umbral) {
				i.putExtra("guardar", true);
			} else {
				i.putExtra("guardar", false);
			}
			if (movT < umbralmov) {
				// if (mov < umbral) {

				i.putExtra("guardar", true);
			} else if (movT == umbralmov) {
				if (tiempoT < umbraltiemp) {
					i.putExtra("guardar", true);
				} else {
					i.putExtra("guardar", false);
				}
			} else {

				i.putExtra("guardar", false);
			}

			i.putExtra("nivel", nivel);
			i.putExtra("tiempo", tiempoT);
			i.putExtra("mov", movT);
			i.putExtra("total", movT);
			i.putExtra("tiempoT", tiempoT);
			startActivity(i);
			nivel = 0;
			movT = 0;
			tiempoT = 0;
			Toast.makeText(getBaseContext(), "FELICIDADES!!!",
					Toast.LENGTH_LONG).show();

			m = new MisCaballos(++nivel);
			text0.setText("Level " + nivel + "/24");
			//prueba 
			
			SharedPreferences miPref;
			nombrePrefer = "guarda";
			miPref = getSharedPreferences(nombrePrefer, MODE_PRIVATE);
			SharedPreferences.Editor editor = miPref.edit();
			editor.putBoolean("gano", false);
			editor.putInt("level", 1);
			editor.putInt("total", 0);
			editor.putInt("tiempoT", 0);
			editor.commit();
			
			//fin prueba
			pintarTablero(nivel);
			pintarCaballo();
			mov = 0;
			text1.setText(mov + "");
			text2.setText(movT + "");
		}
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity__cab, menu);
		// ------MENU MENU MENU

		crearMenu(menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		selectItem(item);
		return true;
	}

	public void crearMenu(Menu menu) {
		MenuItem record = menu.add(0, 0, 0, getString(R.string.ayuda));
		{
			record.setAlphabeticShortcut('s');
			// record.setIcon(R.drawable.logo);
		}

		MenuItem marca = menu.add(0, 1, 1, getString(R.string.marcas));
		{
			marca.setAlphabeticShortcut('s');
			// record.setIcon(R.drawable.logo);
		}

		MenuItem reiniciar = menu.add(0, 3, 3, getString(R.string.reiniciar));
		{
			reiniciar.setAlphabeticShortcut('b');
			// informacion.setIcon(R.drawable.logo);
		}

		/*
		MenuItem ayuda = menu.add(0, 0, 0, "HELP");
		{
			ayuda.setAlphabeticShortcut('h');
			// ayuda.setIcon(R.drawable.logo);
		}
		*/

	}

	public boolean selectItem(MenuItem item) {
		switch (item.getItemId()) {
		case 0:

			try {
				Class<?> clazz;
				clazz = Class.forName("com.example.caballo.help");
				Intent intent = new Intent(this, clazz);
				startActivity(intent);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 1:
			try {
				Class<?> clazz;
				clazz = Class.forName("com.example.caballo.score");
				Intent intent = new Intent(this, clazz);
				intent.putExtra("nivel", 25);
				synchronized (this) {
					Control.menuscore = true;
					// Control.viewfinal = false;
				}
				startActivity(intent);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		//case 2:
		//	try {
		//		Class<?> clazz;
		//		clazz = Class.forName("com.example.caballo.about");
		//		Intent intent = new Intent(this, clazz);
		//		startActivity(intent);
		//	} catch (ClassNotFoundException e) {
		//		// TODO Auto-generated catch block
		//		e.printStackTrace();
		//	}
		//	break;
		case 3:
			if (Control.viewfinal == true) {
				viewB(findViewById(R.id.view));
			}
			SharedPreferences miPref;
			String nombrePrefer = "guarda";
			miPref = getSharedPreferences(nombrePrefer, MODE_PRIVATE);
			SharedPreferences.Editor editor = miPref.edit();
			editor.putBoolean("gano", false);
			editor.putInt("level", 1);
			editor.putInt("total", 0);
			editor.putInt("tiempoT", 0);
			editor.commit();
			Restart();
			break;

		default:
			break;
		}

		return true;
	}

	public void click(View v) {
		int i = 0;
		switch (v.getId()) {
		case R.id.ImageButton1:
			i = 1;
			break;
		case R.id.ImageButton2:
			i = 2;
			break;
		case R.id.ImageButton3:
			i = 3;
			break;
		case R.id.ImageButton4:
			i = 4;
			break;
		case R.id.ImageButton5:
			i = 5;
			break;
		case R.id.ImageButton6:
			i = 6;
			break;
		case R.id.ImageButton7:
			i = 7;
			break;
		case R.id.ImageButton8:
			i = 8;
			break;
		case R.id.ImageButton9:
			i = 9;
			break;
		case R.id.ImageButton10:
			i = 10;
			break;
		case R.id.ImageButton11:
			i = 11;
			break;
		case R.id.ImageButton12:
			i = 12;
			break;
		case R.id.ImageButton13:
			i = 13;
			break;
		case R.id.ImageButton14:
			i = 14;
			break;
		case R.id.ImageButton15:
			i = 15;
			break;
		case R.id.ImageButton16:
			i = 16;
			break;
		case R.id.ImageButton17:
			i = 17;
			break;
		case R.id.ImageButton18:
			i = 18;
			break;
		case R.id.ImageButton19:
			i = 19;
			break;
		case R.id.ImageButton20:
			i = 20;
			break;
		default:
			break;
		}

		if (vista) {
			analizar(i - 1);
		}
	}

	public void analizar(int i) {
		if (presionado) {
			im[varP].setAlpha(255);
			newP = i;

			// t.setText("valido: " + valido(varP, newP));
			if (valido(varP, newP)) {
				newP = i;
				// Toast.makeText(getBaseContext(),
				// "valido: " + varP + " " + newP, Toast.LENGTH_SHORT)
				// .show();
				// t.setText("valido: " + varP + " " + newP);
				mover(varP, newP);
				presionado = false;
			} else {
				presionado = false;
				if (caballo(i)) {
					varP = i;
					im[i].setAlpha(100);
					presionado = true;
				}

			}
		} else {
			// t.setText("valido: " + caballo(i));
			if (caballo(i)) {
				varP = i;
				// t.setText("valido: " + i);
				im[i].setAlpha(100);
				presionado = true;
			}

		}

	}

	private boolean valido(int p, int newp) {
		return m.valido(p, newp);
	}

	private void mover(int p, int newp) {

		// pintar casillas involucradas en el movimiento
		if ((p) % 2 == 0) {
			im[p].setImageResource(R.drawable.blanco);
			if (m.colorC(p, MisCaballos.BLANCO)) {
				im[newp].setImageResource(R.drawable.blancoverde);
				// poner fondo blanco caballo blanco
			} else {
				im[newp].setImageResource(R.drawable.negroverde);
				// poner fondo blanco caballo negro
			}
		} else {
			im[p].setImageResource(R.drawable.verde);
			if (m.colorC(p, MisCaballos.BLANCO)) {
				im[newp].setImageResource(R.drawable.blancoblanco);
				// poner fondo blanco caballo blanco
			} else {
				im[newp].setImageResource(R.drawable.negroblanco);
				// poner fondo blanco caballo negro
			}
		}

		// hacer mov en clase
		m.mover(p, newp);

		mov++;// contarlo
		movT++;
		text1.setText(mov + "");
		text2.setText(movT + "");

		// ver si fin
		if (m.finalizado()) {

			if (nivel < 25) {
				endTime = System.nanoTime();
				tiempo_total = (int) ((endTime - startTime) / 1000000000.0f - timePerdTotal);
				timePerdTotal = 0;
				tiempoT += (int) tiempo_total;

				Log.d("tiempo", "inicio " + startTime + "  fin " + endTime
						+ "  total " + tiempo_total);
				Toast.makeText(getBaseContext(), mov + " MOV",
						Toast.LENGTH_LONG).show();
				// t_fin = (GregorianCalendar) GregorianCalendar.getInstance();
				// int dia = t_fin.get(Calendar.DAY_OF_YEAR) -
				// t_ini.get(Calendar.DAY_OF_YEAR);
				// int hora = t_fin.get(Calendar.HOUR) -
				// t_ini.get(Calendar.HOUR);
				// int minutos = t_fin.get(Calendar.MINUTE) -
				// t_ini.get(Calendar.MINUTE);
				// int segundos = t_fin.get(Calendar.SECOND) -
				// t_ini.get(Calendar.SECOND);

				presionado = false;
				varP = -1;
				newP = -1;

				SharedPreferences miPrefer;
				String nombrePrefer = "miPrefer" + (nivel);
				miPrefer = getSharedPreferences(nombrePrefer, MODE_PRIVATE);

				int umbralmov = miPrefer.getInt("umbralmov", 1000000);
				int umbraltiemp = miPrefer.getInt("umbraltiemp", 1000000);
				Log.d("valores", "umbralmov " + umbralmov + "  umbraltiemp "
						+ umbraltiemp);

				Intent i = new Intent(getBaseContext(), score.class);

				double newMov = (mov * 1000000 + (1 - (1 / (tiempo_total + 1))) * 1000000);
				double umbral = (umbralmov * 1000000 + (1 - (1 / (umbraltiemp + 1))) * 1000000);

				Log.d("umbral",
						"umbral "
								+ (umbralmov * 100 + (1 - (1 / (umbraltiemp + 1))) * 100));
				Log.d("umbral", "mio " + newMov + "  defecto " + umbral);

				if (mov < umbralmov) {
					// if (mov < umbral) {

					i.putExtra("guardar", true);
				} else if (mov == umbralmov) {
					if (tiempo_total < umbraltiemp) {
						i.putExtra("guardar", true);
					} else {
						i.putExtra("guardar", false);
					}
				} else {

					i.putExtra("guardar", false);
				}
				i.putExtra("nivel", nivel);
				i.putExtra("tiempo", tiempo_total);
				i.putExtra("mov", mov);
				i.putExtra("total", movT);
				i.putExtra("tiempoT", tiempoT);
				startActivity(i);

				if (nivel == 24) {
					pintarTablero(25);
					++nivel;
				} else {

					m = new MisCaballos(++nivel);
					text0.setText("Level " + nivel + "/24");
					pintarTablero(nivel);
					pintarCaballo();
					mov = 0;
					text1.setText(mov + "");
				}
				// ir a score
			} else {
				pintarTablero(0);
			}
		}
	}

	private boolean caballo(int p) {
		return m.caballo(p);
	}

	public void pintarTablero(int nivel) {
		startTime = System.nanoTime();
		m = new MisCaballos(nivel);
		
		//LayoutParams lp=new LayoutParams(ww, ww);
		//im[i].setLayoutParams(lp);
		for (int i = 0; i < im.length; i++) {
			im[i].setVisibility(View.VISIBLE);
			
			if (i % 2 == 0) {
				
				im[i].setImageResource(R.drawable.blanco);
				im[i].setAlpha(255);
			} else {
				im[i].setImageResource(R.drawable.verde);
				im[i].setAlpha(255);
			}
		}

		for (int i = 0; i < m.getTablero().length; i++) {
			if (!(m.getTablero()[i])) {
				im[i].setVisibility(View.INVISIBLE);
			}

		}
	}

	public void pintarCaballo() {
		if ((m.getcaballo_B1()) % 2 == 0) {
			im[m.getcaballo_B1()].setImageResource(R.drawable.blancoblanco);
			im[m.getcaballo_B1()].setAlpha(255);
		} else {
			im[m.getcaballo_B1()].setImageResource(R.drawable.blancoverde);
			im[m.getcaballo_B1()].setAlpha(255);
		}
		if ((m.getcaballo_B2()) % 2 == 0) {
			im[m.getcaballo_B2()].setImageResource(R.drawable.blancoblanco);
			im[m.getcaballo_B2()].setAlpha(255);
		} else {
			im[m.getcaballo_B2()].setImageResource(R.drawable.blancoverde);
			im[m.getcaballo_B2()].setAlpha(255);
		}
		if ((m.getcaballo_N1()) % 2 == 0) {
			im[m.getcaballo_N1()].setImageResource(R.drawable.negroblanco);
			im[m.getcaballo_N1()].setAlpha(255);
		} else {
			im[m.getcaballo_N1()].setImageResource(R.drawable.negroverde);
			im[m.getcaballo_N1()].setAlpha(255);
		}
		if ((m.getcaballo_N2()) % 2 == 0) {
			im[m.getcaballo_N2()].setImageResource(R.drawable.negroblanco);
			im[m.getcaballo_N2()].setAlpha(255);
		} else {
			im[m.getcaballo_N2()].setImageResource(R.drawable.negroverde);
			im[m.getcaballo_N2()].setAlpha(255);
		}
	}

	public void resetB(View v) {
		if (Control.viewfinal == true) {
			viewB(findViewById(R.id.view));
		}
		presionado = false;
		varP = -1;
		newP = -1;
		mov = 0;
		text1.setText(mov + "");
		pintarTablero(nivel);
		pintarCaballo();
	}

	public void exitB(View v) {
		this.finish();
	}

	public void viewB(View v) {
		Control.viewfinal = !Control.viewfinal;
		if (vista) {
			c1 = m.getcaballo_B1();
			c2 = m.getcaballo_B2();
			c3 = m.getcaballo_N1();
			c4 = m.getcaballo_N2();

			boolean tmp = presionado;

			m = new MisCaballos(nivel);
			float tmptime = startTime;
			pintarTablero(nivel);
			startTime = tmptime;
			m.setcaballo_B1(m.getPosF_B1());
			m.setcaballo_B2(m.getPosF_B2());
			m.setcaballo_N1(m.getPosF_N1());
			m.setcaballo_N2(m.getPosF_N2());

			if (presionado) {
				im[varP].setAlpha(255);
			}

			pintarCaballo();
			text0.setText(getString(R.string.view));
			vista = false;

			((ImageView) findViewById(R.id.view))
					.setImageResource(R.drawable.retun);
			((TextView) findViewById(R.id.viewtext)).setText(getString(R.string.continuar));

		} else {
			m = new MisCaballos(nivel);
			float tmptime = startTime;

			pintarTablero(nivel);
			startTime = tmptime;
			m.setcaballo_B1(c1);
			m.setcaballo_B2(c2);
			m.setcaballo_N1(c3);
			m.setcaballo_N2(c4);
			text0.setText("Level " + nivel + "/24");

			pintarCaballo();
			presionado = tmp;
			vista = true;

			((ImageView) findViewById(R.id.view))
					.setImageResource(R.drawable.view);
			((TextView) findViewById(R.id.viewtext)).setText(getString(R.string.view));
		}

	}

	public void onDestroy() {
		SharedPreferences miPref;
		String nombrePrefer = "guarda";
		miPref = getSharedPreferences(nombrePrefer, MODE_PRIVATE);
		SharedPreferences.Editor editor = miPref.edit();
		editor.putInt("total", movT);
		editor.putInt("tiempoT", tiempoT);

		editor.commit();
		super.onDestroy();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		timePerdIni = System.nanoTime();
	}

}
