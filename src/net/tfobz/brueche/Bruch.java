package net.tfobz.brueche;

public class Bruch
{
	private int z�hler;
	private int nenner;
	
	
	public Bruch(int z�hler, int nenner) throws BruchException{
		if(nenner == 0) {
			throw new BruchException("Nenner ist Null");
		}
		this.setZ�hler(z�hler);
		this.setNenner(nenner);
	}



	public int getZ�hler() {
		return z�hler;
	}


	public void setZ�hler(int z�hler) {
		this.z�hler = z�hler;
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
			ret = new Bruch(this.z�hler, this.nenner);
			return ret;
	}

			
	
	private void kuerzen() {
		int ggT = ggT(this.getZ�hler(), this.getNenner());
		this.setZ�hler(this.getZ�hler() / ggT);
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
				ret = this.getZ�hler() + "/" + this.getNenner();
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
		int z�hler;
			if(this.getNenner() == b.getNenner()) {		
				nenner = this.getNenner();
				z�hler = this.getZ�hler() + b.getZ�hler();
				this.setZ�hler(z�hler);
				this.setNenner(nenner);
				kuerzen();
			}else {
				nenner = this.getZ�hler() * b.getNenner(); 
				z�hler = (this.getZ�hler() * b.getNenner()) + (b.getZ�hler() * this.getNenner());
				this.setZ�hler(z�hler);
				this.setNenner(nenner);
				kuerzen();
			}
	}
	
	public void subtrahiere(Object o) throws BruchException, NullPointerException{
		if(o == null) {
			throw new NullPointerException("Zweiter Bruch leer");
		}
		int nenner;
		int z�hler;
		Bruch b = (Bruch)o;
		if(this.getNenner() == b.getNenner()) {
			nenner = this.getNenner();
			z�hler = this.getZ�hler() - b.getZ�hler();
			this.setZ�hler(z�hler);
			this.setNenner(nenner);
			kuerzen();
		}else {
		nenner = this.getZ�hler() * b.getNenner(); 
		z�hler = this.getZ�hler() * b.getNenner() - b.getZ�hler() * this.getNenner();
		this.setZ�hler(z�hler);
		this.setNenner(nenner);
		kuerzen();
		}
	}
	
	
	public void multipliziere(Object o) throws BruchException, NullPointerException{
		if(o == null) {
			throw new NullPointerException("Zweiter Bruch leer");
		}
		Bruch b = (Bruch)o;
		int z�hler = this.getZ�hler() * b.getZ�hler();
		int nenner = this.getNenner() * b.getNenner();
		this.setZ�hler(z�hler);
		this.setNenner(nenner);
		kuerzen();
	}
	
	public void dividiere(Object o) throws BruchException, NullPointerException{
		if(o == null) {
			throw new NullPointerException("Zweiter Bruch leer");
		}
		Bruch b = (Bruch)o;
		int z�hler = this.getZ�hler() * b.getNenner();
		int nenner = this.getNenner() * b.getZ�hler();
		this.setZ�hler(z�hler);
		this.setNenner(nenner);
		kuerzen();
	}
	
	
}
