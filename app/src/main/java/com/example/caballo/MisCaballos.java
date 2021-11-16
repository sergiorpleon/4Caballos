package com.example.caballo;

import android.util.Log;
import android.widget.Toast;

public class MisCaballos {
	public static final boolean BLANCO = true;
	public static final boolean NEGRO = false;

	private boolean[] tablero;
	private int caballo_B1;
	private int caballo_B2;
	private int caballo_N1;
	private int caballo_N2;

	private int posF_B1;
	private int posF_B2;
	private int posF_N1;
	private int posF_N2;

	public MisCaballos(int n) {
		tablero = new boolean[20];
		for (int i = 0; i < tablero.length; i++) {
			tablero[i] = true;
		}
		switch (n) {
		case 1:

			tablero[0] = false;
			tablero[1] = false;
			tablero[2] = false;
			tablero[3] = false;
			tablero[4] = false;
			tablero[8] = false;
			tablero[9] = false;
			// tablero[11] = false;
			tablero[13] = false;
			tablero[14] = false;
			tablero[18] = false;
			tablero[19] = false;
			inicializarC(5, 7, 15, 17);

			posF_B1 = 15;
			posF_B2 = 17;
			posF_N1 = 5;
			posF_N2 = 7;
			break;

		case 2:

			tablero[1] = false;
			tablero[4] = false;
			tablero[7] = false;
			tablero[9] = false;
			tablero[10] = false;
			tablero[14] = false;
			tablero[15] = false;
			tablero[16] = false;
			tablero[19] = false;
			inicializarC(0, 6, 2, 8);

			posF_B1 = 2;
			posF_B2 = 8;
			posF_N1 = 0;
			posF_N2 = 6;
			break;

		case 3:

			tablero[1] = false;
			tablero[3] = false;
			tablero[4] = false;
			tablero[8] = false;
			tablero[9] = false;
			tablero[13] = false;
			tablero[14] = false;
			tablero[16] = false;
			tablero[18] = false;
			tablero[19] = false;
			inicializarC(0, 2, 15, 17);

			posF_B1 = 15;
			posF_B2 = 17;
			posF_N1 = 0;
			posF_N2 = 2;
			break;

		case 4:

			tablero[0] = false;
			tablero[2] = false;
			tablero[3] = false;
			tablero[4] = false;
			tablero[7] = false;
			tablero[8] = false;
			tablero[9] = false;
			tablero[14] = false;
			tablero[18] = false;
			tablero[19] = false;
			inicializarC(6, 12, 10, 16);

			posF_B1 = 10;
			posF_B2 = 16;
			posF_N1 = 6;
			posF_N2 = 12;

			break;

		case 5:

			tablero[0] = false;
			tablero[3] = false;
			tablero[4] = false;
			tablero[9] = false;
			tablero[14] = false;
			tablero[15] = false;
			tablero[18] = false;
			tablero[19] = false;
			inicializarC(6, 7, 11, 12);

			posF_B1 = 11;
			posF_B2 = 12;
			posF_N1 = 6;
			posF_N2 = 7;
			break;

		case 6:
			tablero[3] = false;
			tablero[4] = false;
			tablero[6] = false;
			tablero[9] = false;
			tablero[11] = false;
			tablero[12] = false;
			tablero[14] = false;
			tablero[15] = false;
			tablero[19] = false;
			inicializarC(0, 10, 16, 18);

			posF_B1 = 16;
			posF_B2 = 18;
			posF_N1 = 0;
			posF_N2 = 10;
			break;

		case 7:

			tablero[1] = false;
			tablero[4] = false;
			tablero[7] = false;
			tablero[9] = false;
			tablero[11] = false;
			tablero[12] = false;
			tablero[14] = false;
			tablero[19] = false;
			inicializarC(6, 10, 13, 17);

			posF_B1 = 13;
			posF_B2 = 17;
			posF_N1 = 6;
			posF_N2 = 10;
			break;

		case 8:
			tablero[0] = false;
			tablero[1] = false;
			tablero[4] = false;
			tablero[9] = false;
			tablero[11] = false;
			tablero[12] = false;
			tablero[14] = false;
			tablero[17] = false;
			tablero[19] = false;
			inicializarC(7, 18, 10, 16);

			posF_B1 = 10;
			posF_B2 = 16;
			posF_N1 = 7;
			posF_N2 = 18;
			break;

		case 9:

			tablero[0] = false;
			tablero[1] = false;
			tablero[2] = false;
			tablero[4] = false;
			tablero[5] = false;
			tablero[9] = false;
			tablero[10] = false;
			tablero[14] = false;
			tablero[18] = false;
			tablero[19] = false;
			inicializarC(11, 15, 3, 7);

			posF_B1 = 3;
			posF_B2 = 7;
			posF_N1 = 11;
			posF_N2 = 15;
			break;

		case 10:

			tablero[0] = false;
			tablero[1] = false;
			tablero[2] = false;
			tablero[3] = false;
			tablero[4] = false;
			tablero[8] = false;
			tablero[9] = false;
			tablero[10] = false;
			tablero[11] = false;
			tablero[14] = false;
			tablero[18] = false;
			tablero[19] = false;
			inicializarC(5, 7, 15, 17);

			posF_B1 = 15;
			posF_B2 = 17;
			posF_N1 = 5;
			posF_N2 = 7;
			break;

		case 11:

			tablero[0] = false;
			tablero[1] = false;
			tablero[2] = false;
			tablero[3] = false;
			tablero[4] = false;
			tablero[5] = false;
			tablero[8] = false;
			tablero[9] = false;
			tablero[14] = false;
			tablero[19] = false;
			inicializarC(10, 15, 13, 18);

			posF_B1 = 13;
			posF_B2 = 18;
			posF_N1 = 10;
			posF_N2 = 15;

			break;

		case 12:
			tablero[0] = false;
			tablero[1] = false;
			tablero[2] = false;
			tablero[3] = false;
			tablero[4] = false;
			tablero[6] = false;
			tablero[9] = false;
			tablero[12] = false;
			tablero[14] = false;
			tablero[17] = false;
			tablero[19] = false;
			inicializarC(10, 16, 7, 13);

			posF_B1 = 7;
			posF_B2 = 13;
			posF_N1 = 10;
			posF_N2 = 16;
			break;

		case 13:
			tablero[0] = false;
			tablero[1] = false;
			tablero[2] = false;
			tablero[3] = false;
			tablero[4] = false;
			tablero[6] = false;
			tablero[7] = false;
			tablero[8] = false;
			inicializarC(5, 9, 15, 19);

			posF_B1 = 15;
			posF_B2 = 19;
			posF_N1 = 5;
			posF_N2 = 9;
			break;

		case 14:

			tablero[0] = false;
			tablero[1] = false;
			tablero[2] = false;
			tablero[3] = false;
			tablero[4] = false;
			tablero[7] = false;
			tablero[9] = false;
			tablero[14] = false;
			tablero[16] = false;
			tablero[19] = false;
			inicializarC(8, 17, 6, 15);

			posF_B1 = 6;
			posF_B2 = 15;
			posF_N1 = 8;
			posF_N2 = 17;

			break;
		
		case 15:

			tablero[0] = false;
			tablero[1] = false;
			tablero[2] = false;
			tablero[3] = false;
			tablero[4] = false;
			tablero[5] = false;
			tablero[9] = false;
			tablero[13] = false;
			tablero[14] = false;
			tablero[18] = false;
			tablero[19] = false;
			inicializarC(8, 12, 10, 16);

			posF_B1 = 10;
			posF_B2 = 16;
			posF_N1 = 8;
			posF_N2 = 12;

			break;

		case 16:
			tablero[0] = false;
			tablero[1] = false;
			tablero[2] = false;
			tablero[3] = false;
			tablero[4] = false;
			tablero[6] = false;
			tablero[9] = false;
			tablero[12] = false;
			tablero[14] = false;
			tablero[17] = false;
			tablero[19] = false;
			inicializarC(10, 16, 7, 18);

			posF_B1 = 7;
			posF_B2 = 18;
			posF_N1 = 10;
			posF_N2 = 16;
			break;

		case 17:
			tablero[1] = false;
			tablero[4] = false;
			tablero[8] = false;
			tablero[9] = false;
			tablero[11] = false;
			tablero[13] = false;
			tablero[14] = false;
			tablero[16] = false;
			tablero[19] = false;
			inicializarC(0, 18, 3, 15);

			posF_B1 = 3;
			posF_B2 = 15;
			posF_N1 = 0;
			posF_N2 = 18;
			break;

		case 18:

			tablero[3] = false;
			tablero[4] = false;
			tablero[7] = false;
			tablero[8] = false;
			tablero[9] = false;
			tablero[10] = false;
			tablero[11] = false;
			tablero[14] = false;
			tablero[15] = false;
			tablero[19] = false;
			inicializarC(1, 5, 13, 17);

			posF_B1 = 13;
			posF_B2 = 17;
			posF_N1 = 1;
			posF_N2 = 5;
			break;

		case 19:
			tablero[2] = false;
			tablero[3] = false;
			tablero[4] = false;
			tablero[5] = false;
			tablero[9] = false;
			tablero[10] = false;
			tablero[12] = false;
			tablero[14] = false;
			tablero[17] = false;
			tablero[19] = false;
			inicializarC(0, 7, 13, 16);

			posF_B1 = 13;
			posF_B2 = 16;
			posF_N1 = 0;
			posF_N2 = 7;
			break;

		case 20:
			tablero[0] = false;
			tablero[1] = false;
			tablero[2] = false;
			tablero[6] = false;
			tablero[7] = false;
			tablero[9] = false;
			tablero[11] = false;
			tablero[14] = false;
			inicializarC(12, 16, 4, 8);

			posF_B1 = 4;
			posF_B2 = 8;
			posF_N1 = 12;
			posF_N2 = 16;
			break;

		case 21:
			tablero[3] = false;
			tablero[4] = false;
			tablero[7] = false;
			tablero[8] = false;
			tablero[9] = false;
			tablero[10] = false;
			tablero[14] = false;
			tablero[15] = false;
			tablero[16] = false;
			inicializarC(2, 5, 12, 19);

			posF_B1 = 12;
			posF_B2 = 19;
			posF_N1 = 2;
			posF_N2 = 5;
			break;

		case 22:
			tablero[0] = false;
			tablero[4] = false;
			tablero[5] = false;
			tablero[8] = false;
			tablero[9] = false;
			tablero[12] = false;
			tablero[13] = false;
			tablero[14] = false;
			tablero[18] = false;
			tablero[19] = false;
			inicializarC(1, 7, 10, 17);

			posF_B1 = 10;
			posF_B2 = 17;
			posF_N1 = 1;
			posF_N2 = 7;
			break;

		case 23:
			tablero[1] = false;
			tablero[2] = false;
			tablero[7] = false;
			tablero[9] = false;
			tablero[10] = false;
			tablero[14] = false;
			tablero[15] = false;
			tablero[16] = false;
			tablero[18] = false;
			tablero[19] = false;
			inicializarC(0, 6, 4, 8);

			posF_B1 = 4;
			posF_B2 = 8;
			posF_N1 = 0;
			posF_N2 = 6;
			break;

		case 24:
			tablero[1] = false;
			tablero[2] = false;
			tablero[9] = false;
			tablero[10] = false;
			tablero[12] = false;
			tablero[14] = false;
			tablero[15] = false;
			tablero[16] = false;
			tablero[17] = false;
			tablero[19] = false;
			inicializarC(6, 11, 8, 13);

			posF_B1 = 8;
			posF_B2 = 13;
			posF_N1 = 6;
			posF_N2 = 11;
			break;
		default:
			break;
		}

	}

	private void inicializarC(int cb1, int cb2, int cn1, int cn2) {
		caballo_B1 = cb1;
		caballo_B2 = cb2;
		caballo_N1 = cn1;
		caballo_N2 = cn2;
	}

	// verifica si el movimiento es valido
	public boolean valido(int p, int newp) {

		if (caballo(newp)) {
			// Log.d("mio", "uno");
			return false;
		} else {
			if (unPaso(p % 5, newp % 5)) {
				if (dosPasos(p / 5, newp / 5)) {
					// Log.d("mio", "dos");
					return true;
				} else {
					// Log.d("mio", "tres");
					return false;
				}
			} else if (dosPasos(p % 5, newp % 5)) {
				if (unPaso(p / 5, newp / 5)) {
					// Log.d("mio", "cuatro");
					return true;
				} else {
					// Log.d("mio", "cinco");
					return false;
				}
			} else {
				// Log.d("mio", "seis");
				return false;
			}
		}

	}

	// mueve el caballo de posicion
	public void mover(int p, int newp) {
		if (caballo_B1 == p) {
			caballo_B1 = newp;
		}
		if (caballo_B2 == p) {
			caballo_B2 = newp;
		}
		if (caballo_N1 == p) {
			caballo_N1 = newp;
		}
		if (caballo_N2 == p) {
			caballo_N2 = newp;
		}

	}

	// retorena true si casilla existe y hay un caballo en la posicion
	public boolean caballo(int p) {
		if (tablero[p]) {
			boolean ocupado = false;
			// Log.d("mio", ocupado + "1");
			ocupado |= (p == caballo_B1);
			// Log.d("mio", ocupado + "2");
			ocupado |= (p == caballo_B2);
			// Log.d("mio", ocupado + "3");
			ocupado |= (p == caballo_N1);
			// Log.d("mio", ocupado + "4");
			ocupado |= (p == caballo_N2);
			// Log.d("mio", ocupado + "5");
			return ocupado;
		} else {
			return false;
		}
	}

	private boolean unPaso(int i, int f) {
		return Math.abs(i - f) == 1;
	}

	private boolean dosPasos(int i, int f) {
		return Math.abs(i - f) == 2;
	}

	// retorna verdadero si el color el caballo es del que se pregunta
	public boolean colorC(int c, boolean b) {
		if (b) {
			return (c == caballo_B1) || (c == caballo_B2);
		} else {
			return (c == caballo_N1) || (c == caballo_N2);
		}
	}

	public boolean finalizado() {
		if ((caballo_B1 == posF_B1 && caballo_B2 == posF_B2)
				|| (caballo_B1 == posF_B2 && caballo_B2 == posF_B1)) {
			if ((caballo_N1 == posF_N1 && caballo_N2 == posF_N2)
					|| (caballo_N1 == posF_N2 && caballo_N2 == posF_N1)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public int getcaballo_B1() {
		return caballo_B1;
	}

	public int getcaballo_B2() {
		return caballo_B2;
	}

	public int getcaballo_N1() {
		return caballo_N1;
	}

	public int getcaballo_N2() {
		return caballo_N2;
	}

	public void setcaballo_B1(int n) {
		caballo_B1 = n;
	}

	public void setcaballo_B2(int n) {
		caballo_B2 = n;
	}

	public void setcaballo_N1(int n) {
		caballo_N1 = n;
	}

	public void setcaballo_N2(int n) {
		caballo_N2 = n;
	}

	public int getPosF_B1() {
		return posF_B1;
	}

	public int getPosF_B2() {
		return posF_B2;
	}

	public int getPosF_N1() {
		return posF_N1;
	}

	public int getPosF_N2() {
		return posF_N2;
	}

	public boolean[] getTablero() {
		return tablero;
	}

}
