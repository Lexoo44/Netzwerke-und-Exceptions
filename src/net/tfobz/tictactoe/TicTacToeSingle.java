package net.tfobz.tictactoe;

public class TicTacToeSingle
{

	public static void main(String[] args) {
		TicTacToe tictactoe = new TicTacToe(3);
		
		
		System.out.println("T I C T A C T O E");
		System.out.println("=================");
		
		tictactoe.spielfeld = new int[tictactoe.getFeldgroesse()][tictactoe.getFeldgroesse()];
		
		int zaehler = 0;
		
		for (int i = 0; i < tictactoe.getFeldgroesse(); i++) {
			for (int j = 0; j < tictactoe.getFeldgroesse(); j++) {
				tictactoe.spielfeld[i][j] = zaehler;
				zaehler++;
			}
		}
		
		
		/*
		char nochmal = 'j';
		while(nochmal == 'j') {
			if(tictactoe.getEinerKannGewinnen() == true) {
				System.out.println(tictactoe.toString());
				int zug = TestScannerErweitert.readInt("Spieler 1, ihr Zug: ");
				
				if(zug  == tictactoe.spielfeld.length) {
					System.out.println("Zug bereits gesetzt oder auserhalb des Spielfeldes!");
				}
				else if(tictactoe.getEinerKannGewinnen() == false) {
					System.out.println("Kainer kann mehr gewinnen");
					nochmal = 'n';
				}
				else if(tictactoe.getGewonnen() == -1) {
					System.out.println("Speiler 1 hat gewonnen");
					nochmal = 'n';
				}
				else if(tictactoe.getGewonnen() == -2) {
					System.out.println("Speiler 2 hat gewonnen");
					nochmal = 'n';
				}
				else if(nochmal == 'j'){
					tictactoe.setZugSPIELER1(zug);
					if(tictactoe.getGewonnen() == -1) {
						System.out.println("Speiler 1 hat gewonnen");
						nochmal = 'n';
					}
					else if(tictactoe.getGewonnen() == -2) {
						System.out.println("Speiler 2 hat gewonnen");
						nochmal = 'n';
				}
				}

				
				
				
				if(tictactoe.getGewonnen() != -1 || tictactoe.getGewonnen() != -2) {
				System.out.println(tictactoe.toString());
				zug = TestScannerErweitert.readInt("Spieler 2, ihr Zug: ");
				}
				if(zug  == tictactoe.spielfeld.length) {
					System.out.println("Zug bereits gesetzt oder auserhalb des Spielfeldes!");
				}
				else if(tictactoe.getEinerKannGewinnen() == false) {
					System.out.println("Kainer kann mehr gewinnen");
					nochmal = 'n';
				}
				else if(tictactoe.getGewonnen() == -1) {
					System.out.println("Speiler 1 hat gewonnen");
					nochmal = 'n';
				}
				else if(tictactoe.getGewonnen() == -2) {
					System.out.println("Speiler 2 hat gewonnen");
					nochmal = 'n';
				}
				else if(nochmal == 'j'){
					tictactoe.setZugSPIELER2(zug);
				  if(tictactoe.getGewonnen() == -1) {
						System.out.println("Speiler 1 hat gewonnen");
						nochmal = 'n';
					}
					else if(tictactoe.getGewonnen() == -2) {
						System.out.println("Speiler 2 hat gewonnen");
						nochmal = 'n';
				}
				
				
			}
			else {
				nochmal = 'n';
			}
			
		}
		
	}*/
		
		char nochmal = 'j';
		while (nochmal == 'j') {
			System.out.println(tictactoe.toString());
			while (tictactoe.setZugSPIELER1(TestScannerErweitert.readInt("Spieler 1, ihr Zug: ")) != 0) {
				System.out.println("Zug bereits gesetzt oder auserhalb des Spielfeldes!");
			}
			if(tictactoe.getEinerKannGewinnen()==false) {
				System.out.println("Keiner kann mehr gewinnen, also wird das Spiel abgebrochen!");
				break;
			}
			if (tictactoe.getGewonnen() == -1) {
				System.out.println("Spieler 1 hat gewonnen");
				nochmal = TestScannerErweitert.readChar("Nochmal spielen? (j/n) ");
				if (nochmal == 'n')
					break;
				else if (nochmal == 'j') {
					zaehler = 0;
					for (int i = 0; i < tictactoe.getFeldgroesse(); i++) {
						for (int j = 0; j < tictactoe.getFeldgroesse(); j++) {
							tictactoe.spielfeld[i][j] = zaehler;
							zaehler++;
						}
					}
				}
			}
			System.out.println(tictactoe.toString());
			while (tictactoe.setZugSPIELER2(TestScannerErweitert.readInt("Spieler 2, ihr Zug: ")) != 0) {
				System.out.println("Zug bereits gesetzt oder auserhalb des Spielfeldes!");
			}
			if(tictactoe.getEinerKannGewinnen()==false) {
				System.out.println("Keiner kann mehr gewinnen");
				break;
			}
			if (tictactoe.getGewonnen() == -2) {
				System.out.println("Spieler 2 hat gewonnen");
				nochmal = TestScannerErweitert.readChar("Nochmal spielen? (j/n) ");
				if (nochmal == 'n')
					break;
				else if (nochmal == 'j') {
					zaehler = 0;
					for (int i = 0; i < tictactoe.getFeldgroesse(); i++) {
						for (int j = 0; j < tictactoe.getFeldgroesse(); j++) {
							tictactoe.spielfeld[i][j] = zaehler;
							zaehler++;
						}
					}
				}
			}
		
		}
	}
}

