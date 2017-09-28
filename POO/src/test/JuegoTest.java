package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import juegoestrategico.*;
import utilidades.*;

public class JuegoTest {

	Unidad soldado1;
	Unidad soldado2;
	Unidad arquero1;
	Unidad arquero2;
	Unidad lancero1;
	Unidad lancero2;
	Unidad caballero1;
	Unidad caballero2;
	
	@Before
	public void before(){
		
		soldado1 = new Soldado("Maxi");
		soldado2 = new Soldado("Nico");
		arquero1 = new Arquero("Maxi");
		arquero2 = new Arquero("Nico");
		lancero1 = new Lancero("Maxi");
		lancero2 = new Lancero("Nico");
		caballero1 = new Caballero("Maxi");
		caballero2 = new Caballero("Nico");
	}
	
	//////////////////////   TESTS NORMALES    ////////////////////////////////
	
	@Test
	public void soldadosTest() {
		
		soldado1 = new Capa(soldado1); 
		
		assertTrue(soldado1.getPoder() == 9);
		assertTrue(soldado1.getEnergia() == 200);
		
		soldado2 = new Escudo(soldado2);
		
		assertTrue(soldado2.getPoder() == 10);
		
		soldado1.moverHacia(2, 1);
		soldado2.moverHacia(2, 0);
		
		soldado1.peleaCon(soldado2);

		assertTrue(soldado2.getSalud() == 196.4);
		assertTrue(soldado1.getEnergia() == 190);
		
		soldado1.tomarPocionAgua();
		
		assertTrue(soldado1.getEnergia() == 200);
			
	}
	
	@Test
	public void arquerosTest(){
		
		arquero1.moverHacia(0, 0);
		arquero2.moverHacia(5, 5);
		
		arquero1.peleaCon(arquero2);
		
		assertTrue(arquero2.getSalud() == 50);
		
		arquero1.moverHacia(5, 8);
		arquero1.peleaCon(arquero2);
		
		assertTrue(arquero2.getSalud() == 45);
		
		assertTrue(arquero1.getPoder() == 5);
		
		arquero1 = new Punial(arquero1);
		
		arquero1.peleaCon(arquero2);
		arquero2.peleaCon(arquero1);

		assertTrue(arquero1.getSalud() == 42);
		assertTrue(arquero2.getSalud() == 37);
		
		
	}
	
	
	@Test
	public void CaballeroTest(){
		
		caballero1.moverHacia(0, 1);
		arquero1.moverHacia(0, 3);
		arquero2.moverHacia(0, 3);
		soldado1.moverHacia(0, 2);
		
		caballero1.peleaCon(arquero1);
		assertTrue(arquero1.getSalud() == 0);
		
		caballero1.peleaCon(arquero2);
		assertTrue(arquero2.getSalud() == 0);
		
		caballero1.peleaCon(soldado1);
		assertTrue(soldado1.getSalud() == 150);
		
		caballero1 = new Punial(caballero1);
		caballero1.tomarPocionAgua();
		
		caballero1.peleaCon(soldado1);
		assertTrue(soldado1.getSalud() == 97);
	}
	
	@Test
	public void LanceroTest(){
		
		lancero1.moverHacia(0, 0);
		lancero2.moverHacia(0, 4);
		
		lancero1.peleaCon(lancero2);
		
		assertTrue(lancero2.getSalud() == 150);
		
		lancero2 = new Escudo(lancero2);
		lancero2.moverHacia(0, 3);
		
		lancero1.peleaCon(lancero2);
		
		assertTrue(lancero2.getSalud() == 140);
	}
	
	@Test
	public void EnergiaTest(){
		
		assertTrue(soldado1.getEnergia() == 100);
		for (int i = 0; i < 10; i++) {
			soldado1.peleaCon(soldado2);
		}
		
		assertTrue(soldado1.getEnergia() == 0);
		assertTrue(soldado2.getSalud() == 100);
		
		soldado1.peleaCon(soldado2);
		assertTrue(soldado2.getSalud() == 100);
		
		soldado1 = new Capa(soldado1);
		
		System.out.println(soldado1.getEnergia()); 
		soldado1.peleaCon(soldado2);				//CONCLUSION: El decorator solo sirve para "decorar" no cambia atributos

	}
	  
	/////////////////////////    TESTS "EXHAUSTIVOS"    ///////////////////////////////////////////
	
	@Test
	public void moverYDistanciaTest(){
		
		
		//Test basicos
		assertTrue(soldado1.distanciaConEnemigo(soldado2) == 0 );
		for (int i = 1; i < 1000; i++) {
			soldado1.moverHacia(i, 0);
			assertTrue(soldado1.distanciaConEnemigo(soldado2) == i );
		}
		
		for (int i = 1; i < 1000; i++) {
			arquero1.moverHacia(0, i);
			assertTrue(arquero1.distanciaConEnemigo(arquero2) == i );
		}
		
		for (int i = 1; i < 1000; i++) {
			arquero2.moverHacia(i, i);
			soldado2.moverHacia(i, i);
			assertTrue(arquero2.distanciaConEnemigo(soldado2) == 0 );
		}
		
		//Se testea cuando estan en diagonal
		caballero1.moverHacia(4, 9);
		caballero2.moverHacia(2, 3);
		assertTrue(caballero1.distanciaConEnemigo(caballero2) == Math.sqrt(40));
		
		//Se testea con numeros negativos
		lancero1.moverHacia(-3, 7);
		lancero2.moverHacia(2, -1);
		assertTrue(lancero1.distanciaConEnemigo(lancero2) == Math.sqrt(89));
		
	}
	
}





