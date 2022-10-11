package net.tfobz.tictactoe;

public class TicTacToe extends java.lang.Object
{
	public static final int SPIELER1 = -1;
	public static final int SPIELER2 = -2;
	public int[][] spielfeld;

	public TicTacToe(int feldgroesse) {
		if (feldgroesse < 3) {
			spielfeld = new int[3][3];
		} else {
			spielfeld = new int[feldgroesse][feldgroesse];
			int zaehler = 0;
			for (int i = 0; i < feldgroesse; i++) {
				for (int j = 0; j < feldgroesse; j++) {
					spielfeld[i][j] = zaehler;
					//System.out.println(spielfeld[i][j]);
					zaehler++;
				}
			}
		}
	}

	@Override
	public String toString() {
		String ret = "";
		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld.length; j++) {
				if (spielfeld[i][j] == SPIELER1) {
					ret = ret + "X";
				} else if (spielfeld[i][j] == SPIELER2) {
					ret = ret + "O";
				} else {
					ret = ret + spielfeld[i][j];
				}
			}
			ret = ret + "\n";
		}
		return ret;
	}

	public int setZugSPIELER1(int zug) {
		return (setZug(zug, SPIELER1));
	}

	public int setZugSPIELER2(int zug) {
		return (setZug(zug, SPIELER2));
	}

	private int setZug(int zug, int spielernummer) {
		int ret;
		
		int zeile = zug / getFeldgroesse();
		int spalte = zug % getFeldgroesse();
		
		if(zug >= getFeldgroesse() * getFeldgroesse()) {
			ret = -1;
		}
		
		else if(spielfeld[zeile][spalte] == -1 || spielfeld[zeile][spalte] == -2) {
			ret = -2;
		}
		
		else {
			spielfeld[zeile][spalte] = spielernummer;
				ret = 0;
			}
		return ret;
	}

	public int getSpielfeld(int zeile, int spalte) {
		int ret = 0;
		if(zeile > getFeldgroesse() || spalte > getFeldgroesse()) {
			ret = -3;
			return ret;
		}
		else if (spielfeld[zeile][spalte] == -1) {
			ret = SPIELER1;
		} 
		
		else if (spielfeld[zeile][spalte] == -2) {
			ret = SPIELER2;
		}
		 else{
				 ret = 0;
			 }
		 return ret;
		}

	public int getFeldgroesse() {
		int ret = spielfeld.length;
		return ret;
	}

	
	public int getGewonnen() {
		int ret;
		// hat Spieler 1 das Spiel gewonnen?
		boolean gewonnenSpieler1 = false;
		// hat Spieler 2 das Spiel gewonnen?
		boolean gewonnenSpieler2 = false;
		
		// Anzahl der Züge von Spieler1
		int spieler1 = 0;
		// Anzahl der Züge von Spieler2
		int spieler2 = 0;
		
		// Überprüft alle Zeilen
		for (int i = 0; i < getFeldgroesse(); i++) {
			for (int j = 0; j < getFeldgroesse(); j++) {
				if (spielfeld[i][j] == -1) {
					spieler1++;
				} else if (spielfeld[i][j] == -2) {
					spieler2++;
				}
				
				// Bestimmt wer gewonnen falls jemand gewonnen hat
				if (spieler1 == getFeldgroesse()) {
					gewonnenSpieler1 = true;
				} else if (spieler2 == getFeldgroesse()) {
					gewonnenSpieler2 = true;
				}
			}
			spieler1 = 0;
			spieler2 = 0;
		}

		// Überprüft alle Spalten
		for (int i = 0; i < getFeldgroesse(); i++) {
			for (int j = 0; j < getFeldgroesse(); j++) {
				if (spielfeld[j][i] == -1) {
					spieler1++;
				} else if (spielfeld[j][i] == -2) {
					spieler2++;
				}
				
				// Bestimmt wer gewonnen falls jemand gewonnen hat
				if (spieler1 == getFeldgroesse()) {
					gewonnenSpieler1 = true;
				} else if (spieler2 == getFeldgroesse()) {
					gewonnenSpieler2 = true;
				}
			}
			spieler1 = 0;
			spieler2 = 0;
		}
		
		// Überprüft die Diagonale von oben links bis unten links
		for (int i = 0; i < getFeldgroesse(); i++) {
			if (spielfeld[i][i] == -1) {
				spieler1++;
			} else if (spielfeld[i][i] == -2) {
				spieler2++;
			}
			
			// Bestimmt wer gewonnen falls jemand gewonnen hat
			if (spieler1 == getFeldgroesse()) {
				gewonnenSpieler1 = true;
			} else if (spieler2 == getFeldgroesse()) {
				gewonnenSpieler2 = true;
			}
		}
		spieler1 = 0;
		spieler2 = 0;
				
		
		// Überprüft die Diagonale von oben rechts bis unten links
		for (int i = 0; i < getFeldgroesse(); i++) {
			if (spielfeld[i][getFeldgroesse() - (i + 1)] == -1) {
				spieler1++;
			} else if (spielfeld[i][getFeldgroesse() - (i + 1)] == -2) {
				spieler2++;
			}
			
			// Bestimmt wer gewonnen falls jemand gewonnen hat
			if (spieler1 == getFeldgroesse()) {
				gewonnenSpieler1 = true;
			} else if (spieler2 == getFeldgroesse()) {
				gewonnenSpieler2 = true;
			}
		}
		spieler1 = 0;
		spieler2 = 0;
		
		// Spieler1 hat gewonnen
		if (gewonnenSpieler1) {
			ret = SPIELER1;
		// Spieler2 hat gewonnen
		} else if (gewonnenSpieler2) {
			ret = SPIELER2;
		// das Spiel muss noch gewonnen werden
		} else {
			ret = 0;
		}
		
		return ret;
	}
		
	
	public boolean getEinerKannGewinnen() {
		boolean ret = true;
			int X = 0;
			int O = 0;
		
			// Zeilen werden überprüft
			
			for (int i = 0; i < getFeldgroesse(); i++) {
				X = 0;
				O = 0;
				for (int j = 0; j < getFeldgroesse(); j++) {
					if (spielfeld[i][j] == -1) {
						X++;
					} else if (spielfeld[i][j] == -2) {
						O++;
					}
				}
				
				// In der Zeile ist nur ein Spieler anwesend oder gar keiner
				if (X >= 0 && O == 0 || O >= 0 && X == 0) {
					ret = true;
				}
			}
			
			
			// Spalten werden überprüft
			
			for (int i = 0; i < getFeldgroesse(); i++) {
				X = 0;
				O = 0;
				for (int j = 0; j < getFeldgroesse(); j++) {
					if (spielfeld[j][i] == -1) {
						X++;
					} else if (spielfeld[j][i] == -2) {
						O++;
					}
	 			}
				
				// In der Spalte ist nur ein Spieler anwesend oder gar keiner
				if (X >= 0 && O == 0 || O >= 0 && X == 0) {
					ret = true;
				}
			}
			
			
			// Diagonale von links oben bis rechts unten wird überprüft
			
			X = 0;
			O = 0;
			
			for (int i = 0; i < getFeldgroesse(); i++) {
				if (spielfeld[i][i] == -1) {
					X++;
				} else if (spielfeld[i][i] == -2) {
					O++;
				}
			}
			
			// In der Diagonale ist nur ein Spieler anwesend oder gar keiner
			if (X >= 0 && O == 0 || O >= 0 && X == 0) {
				ret = true;
			}
			
			
			// Diagonale von rechts oben bis links unten wird überprüft
			
			X = 0;
			O = 0;
			
			for (int i = 0; i < getFeldgroesse(); i++) {
				if (spielfeld[i][getFeldgroesse() - (i + 1)] == -1) {
					X++;
				} else if (spielfeld[i][getFeldgroesse() - (i + 1)] == -2) {
					O++;
				}
			}
		return ret;
	}
		
	
	
}
