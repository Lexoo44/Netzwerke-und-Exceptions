package net.tfobz.tictactoe;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class TicTacToeServer extends TicTacToe{
	
	private static final int FELDGROESSE = 3;
	private static final int PORT = 50555;
	private java.net.ServerSocket server = null;
	private java.net.Socket serverclient = null;
	
	public TicTacToeServer(int feldgroesse, int port) throws IOException{
		super(feldgroesse);
		server = new ServerSocket(port);	
	}

	
	public static void main(java.lang.String[] args) {
		System.out.println("T I C T A C T O E - S E R V E R");
		System.out.println("===============================");
		TicTacToeServer s = null;
		try {
			s = new TicTacToeServer(FELDGROESSE, PORT);	  
			boolean abbruch = false;
	          do{
	        	   	try {
	        	   		System.out.println(s.toString());
	        	   		System.out.println("Warte auf gegner Zug...");
	        	   		int ergebnis = s.getGegnerZug();
	        	   		if(ergebnis < 0) {
	        	   			abbruch = true;
	        	   		}else {
		        	   		System.out.println(s.toString());
		        	   		if(s.getGewonnen() == -2) {
		        	   			System.out.println("Verdamt gegner hat Gewonnen!");
		        	   			abbruch = true;
		        	   		}else if(s.getEinerKannGewinnen() == false) {
		        	   			System.out.println("Keiner kann mehr Gewinnen:(");
		        	   			abbruch = true;
		        	   		}else if(s.getGewonnen() == -1) {
		        	   			System.out.println("HURA GEWONNEN");
		        	   			abbruch = true;
		        	   		}
		        	   		else {
		        	   			int meinzug;
		        	   			do {
			        	   			meinzug = s.readInt("Geben Sie Ihren zug ein: ");
				        	   		s.setMeinZug(meinzug);
		        	   			}while(meinzug < 0);
		        	   		}
	        	   		}
	        	   		
	        	   	}catch(Exception e) {
	        	   		System.out.println(e.getClass().getName()); 
	        			System.out.println(e.getMessage());
	        			abbruch = true;
	        	   	}
	           }while(abbruch != true);
		}catch(IOException e) {
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
		} finally {
			try {s.close(); } catch (Exception e) { ; }
		}
	}
		
	
	private int readInt(java.lang.String text) {
		System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

	
	
	public void close() throws java.io.IOException{
		try {
			serverclient.close();
		}catch(Exception e) {
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
		}
		try {
			server.close();
		}catch(Exception e) {
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}

	public int getGegnerZug() throws java.io.IOException{
		int ret = 0;
		
		//Falls clientsocket bereits exestiert
		if(serverclient != null) {
			System.out.println("Fehler1");
			ret = -3;
		}else {
			serverclient = server.accept();
			InputStream in = serverclient.getInputStream();
			int zug = (byte)in.read();
			ret = setZugSPIELER2(zug);
		}
		return ret;
	}
	
	
	public int setMeinZug(int zug) throws java.io.IOException{
		int ret = 0;
		
		//Falls kein clientsocket exestiert
		if(serverclient == null) {
			System.out.println("Fehler2");
			ret = -3;
		}else {
			ret = setZugSPIELER1(zug);
			if(ret >= 0) {
				OutputStream out = serverclient.getOutputStream();
				out.write(zug);
				serverclient = null; 
			}
		}
		return ret;
	}
}
