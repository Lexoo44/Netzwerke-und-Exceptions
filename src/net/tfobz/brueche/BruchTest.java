package net.tfobz.brueche;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

class BruchTest {

	@Test
	void NennerNull() throws BruchException {
		Bruch bruch = new Bruch(3, 4);
        assertThrows(BruchException.class, () -> bruch.setNenner(0));

	}
	
	@Test
	void EqualsNull() throws BruchException{
		Bruch bruch = new Bruch(3, 4);
        assertThrows(NullPointerException.class, () -> bruch.equals(null));
	}
	@Test 
	void EqualsVererbt() throws BruchException {
		Bruch bruch = new Bruch(3, 4);
        assertThrows(ClassCastException.class, () -> bruch.equals(bruch instanceof Bruch));

	}
	@Test
	void EqualsOK() throws BruchException{
		Bruch bruch = new Bruch(3, 4);
		assertTrue(bruch.equals(bruch) == true);
	}
	
	@Test
	void AddirenNull() throws BruchException {
		Bruch bruch = new Bruch(3, 4);
        assertThrows(NullPointerException.class, () -> bruch.addiere(null));
	}
	
	@Test
	void SubtrahiereNull() throws BruchException {
		Bruch bruch = new Bruch(3, 4);
        assertThrows(NullPointerException.class, () -> bruch.subtrahiere(null));
	}
	
	@Test
	void MultipliziereNull() throws BruchException {
		Bruch bruch = new Bruch(3, 4);
        assertThrows(NullPointerException.class, () -> bruch.multipliziere(null));
	}
	
	@Test
	void DividiereNull() throws BruchException {
		Bruch bruch = new Bruch(3, 4);
        assertThrows(NullPointerException.class, () -> bruch.dividiere(null));
	}
	
	@Test
	void Clone() throws BruchException{
		Bruch bruch = new Bruch(3, 4);
		assertEquals("3/4", bruch.clone(bruch).toString());
	}
	
	@Test
	void tooString() throws BruchException {
		Bruch bruch = new Bruch(3, 4);
		assertEquals("3/4", bruch.toString());
	}
	
	@Test
	void addierenTest() throws BruchException {
		Bruch bruch = new Bruch(1, 4);
		Bruch b2 = new Bruch(4, 4);
		bruch.addiere(b2);
		assertEquals("5/4", bruch.toString());
	}
	
	
	@Test
	void subtrahiereTest() throws BruchException {
		Bruch bruch = new Bruch(5, 4);
		Bruch b2 = new Bruch(2, 4);
		bruch.subtrahiere(b2);
		assertEquals("3/4", bruch.toString());
	}
	
	@Test
	void multiplikationTest() throws BruchException {
		Bruch bruch = new Bruch(3, 4);
		Bruch b2 = new Bruch(5, 6);
		bruch.multipliziere(b2);
		assertEquals("5/8", bruch.toString());
	}
	
	@Test
	void divisionTest() throws BruchException {
		Bruch bruch = new Bruch(3, 7);
		Bruch b2 = new Bruch(5, 8);
		bruch.dividiere(b2);
		assertEquals("24/35", bruch.toString());
	}
}
