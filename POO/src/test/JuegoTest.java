package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import juegoestrategico.*;
import utilidades.*;

public class JuegoTest {

	Personaje soldado1;
	Personaje soldado2;
	
	@Before
	public void before(){
		
		soldado1 = new Soldado("Maxi");
		soldado2 = new Soldado("Nico");
		
	}
	
	@Test
	public void soldadosTest() {
		
		assertTrue(soldado1.getDaño() == 10);
		
		soldado2 = new Puñal(soldado2);
		
		assertTrue(soldado2.getDaño() == 13);
		
		
	}

}
