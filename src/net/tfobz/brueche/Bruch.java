package net.tfobz.brueche;

public class Bruch
{
	private int zähler;
	private int nenner;
	
	
	public Bruch(int zähler, int nenner) throws BruchException{
		if(nenner == 0) {
			throw new BruchException("Nenner ist Null");
		}
		this.setZähler(zähler);
		this.setNenner(nenner);
	}



	public int getZähler() {
		return zähler;
	}


	public void setZähler(int zähler) {
		this.zähler = zähler;
	}


	public int getNenner() {
		return nenner;
	}


	public void setNenner(int nenner) throws BruchException{
		if(nenner == 0) {
			throw new BruchException("Nenner ist Null");
		}
		this.nenner = nenner;
	}
	public Bruch clone(Bruch b) throws BruchException{
		Bruch ret = null;
			ret = new Bruch(this.zähler, this.nenner);
			return ret;
	}

			
	
	private void kuerzen() {
		int ggT = ggT(this.getZähler(), this.getNenner());
		this.setZähler(this.getZähler() / ggT);
		try {
			this.setNenner(this.getNenner() / ggT);
		} catch (BruchException e) {
			e.printStackTrace();
		}
	}
	
	public int ggT(int a, int b) {
		int ret = 0;
		while (b != 0) {
		     if (a > b) {
		       a = a - b;
		     } else {
		       b = b - a;
		     }
		    }
		   ret = a;	
		return ret;
	}
	
	public String toString() {
		String ret = "";	
				ret = this.getZähler() + "/" + this.getNenner();
		return ret;
	}
	
	public boolean equals(Object o) throws NullPointerException{
		boolean ret = true;
		if(o == null) {
			ret = false;
			throw new NullPointerException("Zweiter Bruch leer");
		}
		 if(!(o instanceof Bruch) || !(o instanceof Object)) {
			 ret = false;
			throw new ClassCastException("Typ nicht passend");
		 }
		 if(o instanceof Bruch) {
			 ret = true;
		 }
		return ret;
	}
	
	public void addiere(Object o) throws BruchException, NullPointerException{
		if(o == null) {
			throw new NullPointerException("Zweiter Bruch leer");
		}
		Bruch b = (Bruch)o;
		int nenner;
		int zähler;
			if(this.getNenner() == b.getNenner()) {		
				nenner = this.getNenner();
				zähler = this.getZähler() + b.getZähler();
				this.setZähler(zähler);
				this.setNenner(nenner);
				kuerzen();
			}else {
				nenner = this.getZähler() * b.getNenner(); 
				zähler = (this.getZähler() * b.getNenner()) + (b.getZähler() * this.getNenner());
				this.setZähler(zähler);
				this.setNenner(nenner);
				kuerzen();
			}
	}
	
	public void subtrahiere(Object o) throws BruchException, NullPointerException{
		if(o == null) {
			throw new NullPointerException("Zweiter Bruch leer");
		}
		int nenner;
		int zähler;
		Bruch b = (Bruch)o;
		if(this.getNenner() == b.getNenner()) {
			nenner = this.getNenner();
			zähler = this.getZähler() - b.getZähler();
			this.setZähler(zähler);
			this.setNenner(nenner);
			kuerzen();
		}else {
		nenner = this.getZähler() * b.getNenner(); 
		zähler = this.getZähler() * b.getNenner() - b.getZähler() * this.getNenner();
		this.setZähler(zähler);
		this.setNenner(nenner);
		kuerzen();
		}
	}
	
	
	public void multipliziere(Object o) throws BruchException, NullPointerException{
		if(o == null) {
			throw new NullPointerException("Zweiter Bruch leer");
		}
		Bruch b = (Bruch)o;
		int zähler = this.getZähler() * b.getZähler();
		int nenner = this.getNenner() * b.getNenner();
		this.setZähler(zähler);
		this.setNenner(nenner);
		kuerzen();
	}
	
	public void dividiere(Object o) throws BruchException, NullPointerException{
		if(o == null) {
			throw new NullPointerException("Zweiter Bruch leer");
		}
		Bruch b = (Bruch)o;
		int zähler = this.getZähler() * b.getNenner();
		int nenner = this.getNenner() * b.getZähler();
		this.setZähler(zähler);
		this.setNenner(nenner);
		kuerzen();
	}
	
	
}
