package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import juegoestrategico.*;
import utilidades.*;

public class JuegoTest {

	Unidad soldado1;
	Unidad soldado2;
	
	@Before
	public void before(){
		
		soldado1 = new Soldado("Maxi");
		soldado2 = new Soldado("Nico");
		
	}
	
	@Test
	public void soldadosTest() {
		
		soldado1 = new Punial(soldado1); 
		
		assertTrue(soldado1.getPoder() == 13);
		
		soldado2 = new Escudo(soldado2);
		
		assertTrue(soldado2.getPoder() == 10);
		
		soldado1.moverHacia(2, 1);
		soldado2.moverHacia(2, 0);
		
		soldado1.peleaCon(soldado2);
		System.out.println(soldado2.getSalud());
		assertTrue(soldado2.getSalud() == 194.8);
		assertTrue(soldado1.getEnergia() == 90);
		
		soldado1.tomarPocionAgua();
		
		System.out.println(soldado1.getEnergia());
		assertTrue(soldado1.getEnergia() == 100);
		
		
		
		
	}

}
