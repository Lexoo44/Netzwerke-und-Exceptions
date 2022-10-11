package net.tfobz.tictactoe;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class TicTacToeClient extends TicTacToe{
	
	private static final int FELDGROESSE = 3;
	private static java.lang.String ipAdresse= "localhost";
	private java.net.Socket client = null;
	private static final int PORT = 50555;
	
	
	public TicTacToeClient(int feldgroesse) throws IOException{
		super(feldgroesse);
		client = new Socket("localhost", PORT);
	}

	
	public static void main(java.lang.String[] args) {
		System.out.println("T I C T A C T O E - C L I E N T");
		System.out.println("===============================");
		TicTacToeClient c = null;
		try {
			c = new TicTacToeClient(FELDGROESSE);	  
			boolean abbruch = false;
	   		System.out.println(c.toString());
	          do{
	        	   	try {
	        	   		int meinzug;
        	   			do {
	        	   			meinzug = c.readInt("Geben Sie Ihren zug ein: ");
		        	   		c.setMeinZug(meinzug);
        	   			}while(meinzug < 0);
        	   			
        		   		System.out.println(c.toString());
	        	   		System.out.println("Warte auf gegner Zug...");
	        	   		int ergebnis = c.getGegnerZug();
	        	   		if(ergebnis < 0) {
	        	   			abbruch = true;
	        	   		}else {
		        	   		System.out.println(c.toString());
		        	   		if(c.getGewonnen() == -2) {
		        	   			System.out.println("Verdamt gegner hat Gewonnen!");
		        	   			abbruch = true;
		        	   		}else if(c.getEinerKannGewinnen() == false) {
		        	   			System.out.println("Keiner kann mehr Gewinnen:(");
		        	   			abbruch = true;
		        	   		}else if(c.getGewonnen() == -1) {
		        	   			System.out.println("HURA GEWONNEN");
		        	   			abbruch = true;
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
			try {c.close(); } catch (Exception e) { ; }
		}
	}
		
	
	private int readInt(java.lang.String text) {
		System.out.print(text);
	    return (new java.util.Scanner(System.in)).nextInt();
	}

	
	
	public void close() throws java.io.IOException{
		client.close();
	}

	public int getGegnerZug() throws java.io.IOException{
		int ret = 0;
		
		if(client == null) {
			System.out.println("Fehler1");
			ret = -3;
		}else {
			InputStream in = client.getInputStream();
			int zug = (byte)in.read();
			ret = setZugSPIELER1(zug);
			//client = null;
		}
		return ret;
	}
	
	
	public int setMeinZug(int zug) throws java.io.IOException{
		int ret = 0;
		// !=
		if(client == null) {
			System.out.println("Fehler2");
			ret = -3;
		}
		else {
			ret = setZugSPIELER2(zug);
			if(ret >= 0) {
				OutputStream out = client.getOutputStream();
				out.write(zug);
				//client = null;
			}
		}
		return ret;
	}
}
