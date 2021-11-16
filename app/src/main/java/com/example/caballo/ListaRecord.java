package com.example.caballo;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Collections;

public class ListaRecord {
	private ArrayList<Persona> lisP;
	
	private SharedPreferences miPrefer;

	public ListaRecord(){
		lisP = null;
	}
	
	public ListaRecord(ArrayList<Persona> l){
		lisP = l;
	}
	
	public void adicionar(Persona p) {
		// TODO Auto-generated method stub
		lisP.add(p);
		Collections.sort(lisP);
		lisP.remove(9);

	}

	//carga y ordena
	public void cargar(SharedPreferences prefer){
		miPrefer = prefer;
		String nomb1;
		int tiemp1;
		int mov1;
		Persona p;
		lisP = new ArrayList<Persona>();
		for (int i = 0; i < 9; i++) {
			nomb1 = miPrefer.getString("personaN"+i, "Vacio");
			tiemp1 = miPrefer.getInt("personaT"+i, 1000000);
			mov1 = miPrefer.getInt("personaM"+i, 1000000);
			p = new Persona(nomb1, tiemp1, mov1);
			lisP.add(p);
		}
		Collections.sort(lisP);
	}
	
	public void guardar(SharedPreferences prefer){
		miPrefer = prefer;
		
		//--- Creacion del editor donde se salvara los valores
		SharedPreferences.Editor editor = miPrefer.edit();
		
		String nomb1;
		int tiemp1;
		int mov1;
		Persona p;
		//--- Guardado de los valores
		for (int i = 0; i < 9; i++) {
			p = lisP.get(i);
			nomb1 = p.getNombre();
			tiemp1 = p.getTiempo();
			mov1 = p.getMovimientos();
			
			editor.putString("personaN"+i, nomb1);
			editor.putInt("personaT"+i, tiemp1);
			editor.putInt("personaM"+i, mov1);

			if(i==8){
				//long miumbral = (p.getMovimientos()*1000000 + (1-(1/((long)p.getTiempo()+1)))*1000000);
				editor.putInt("umbralmov", p.getMovimientos());
				editor.putInt("umbraltiemp", p.getTiempo());
				//editor.putInt("umbral", mov1);
			}
		}
		editor.commit();
	}

	public ArrayList<Persona> getLisP() {
		return lisP;
	}

	public void setLisP(ArrayList<Persona> lisP) {
		this.lisP = lisP;
	}
	
	
}
