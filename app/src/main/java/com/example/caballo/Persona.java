package com.example.caballo;

public class Persona implements Comparable<Persona> {
	private String nombre;
	private int tiempo;
	private int movimientos;

	public Persona(String n, int t, int m) {
		nombre = n;
		tiempo = t;
		movimientos = m;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public int getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}

	@Override
	public int compareTo(Persona arg0) {
		// TODO Auto-generated method stub
		double yo = (movimientos * 1000000 + (1 - (1 / (tiempo + 1))) * 1000000);
		double tu = (arg0.getMovimientos() * 1000000 + (1 - (1 / (arg0.getTiempo() + 1))) * 1000000);
		if (movimientos > arg0.getMovimientos()) {
			// if (mov < umbral) {
			
			return 1;
		} else if (movimientos == arg0.getMovimientos()) {
			if(tiempo>arg0.getTiempo()){
				return 1;
			}else if(tiempo==arg0.getTiempo()){ 
				return 0;
			}else{
				return -1;
			}
		}else{
		
			return -1;
		}
		// return movimientos-arg0.getMovimientos();
		
	}

}
