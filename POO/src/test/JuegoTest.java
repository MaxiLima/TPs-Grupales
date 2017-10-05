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
		
		soldado2 = new Puñal(soldado2);
		
		assertTrue(soldado2.getPoder() == 13);
		
		soldado1.moverHacia(2, 1);
		soldado2.moverHacia(2, 0);
		
		soldado1.peleaCon(soldado2);

		assertTrue(soldado2.getPoder() == 13);
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
		
		arquero1 = new Puñal(arquero1);
		
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
		
		caballero1 = new Puñal(caballero1);
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
	
	  
	/////////////////////////    TESTS "EXHAUSTIVOS"    ///////////////////////////////////////////
	
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
		soldado1.peleaCon(soldado2);				
		//CONCLUSION: El decorator solo sirve para "decorar" no cambia atributos

	}

	
	@Test
	public void moverYDistanciaTest(){
		
		
		//Test basicos
		assertTrue(soldado1.distanciaConEnemigo(soldado2) == 0 );
		for (int i = 1; i < 100000; i++) {
			soldado1.moverHacia(i, 0);
			assertTrue(soldado1.distanciaConEnemigo(soldado2) == i );
		}
		
		for (int i = 1; i < 100000; i++) {
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
	
	@Test
	public void puedeAtacarTest(){
		
		assertTrue(soldado1.puedeAtacar() && arquero1.puedeAtacar() && lancero1.puedeAtacar() && caballero1.puedeAtacar());
		
		arquero1.moverHacia(0, 3);
		for (int i = 0; i < 20; i++) {
			arquero1.peleaCon(caballero1);
		}
		assertFalse(arquero1.puedeAtacar());
		
		for (int i = 0; i < 10; i++) {
			soldado1.peleaCon(soldado2);
		}
		
		assertFalse(soldado1.puedeAtacar());
		
		caballero1.moverHacia(0, 1);
		caballero2.tomarPocionAgua();
		for (int i = 0; i < 3; i++) {
			caballero1.peleaCon(caballero2);
		}
		
		assertFalse(caballero1.puedeAtacar());
		
		//Lancero no tiene condiciones para atacar
		
		//Recupero lo necesario en todos para ver si pueden volver a atacar
		
		caballero1.tomarPocionAgua();
		soldado1.tomarPocionAgua();
		arquero1.cargarFlechas();
		
		assertTrue(soldado1.puedeAtacar() && arquero1.puedeAtacar() && caballero1.puedeAtacar());
	}
	
	@Test
	public void recibirAtaqueTest(){
		//Normal
		soldado1.recibirAtaque(10);
		arquero1.recibirAtaque(10);
		lancero1.recibirAtaque(10);
		caballero1.recibirAtaque(10);
		
		assertTrue(soldado1.getSalud() == 190);
		assertTrue(arquero1.getSalud() == 40);
		assertTrue(lancero1.getSalud() == 140);
		assertTrue(caballero1.getSalud() == 190);
		
		//Lo mata
		soldado2.recibirAtaque(200);
		arquero2.recibirAtaque(50);
		lancero2.recibirAtaque(150);
		caballero2.recibirAtaque(200);
		
		assertTrue(soldado2.getSalud() == 0);
		assertTrue(arquero2.getSalud() == 0);
		assertTrue(lancero2.getSalud() == 0);
		assertTrue(caballero2.getSalud() == 0);
		
		//Con double
		soldado1.recibirAtaque(10.5);
		arquero1.recibirAtaque(10.5);
		lancero1.recibirAtaque(10.5);
		caballero1.recibirAtaque(10.5);
		
		assertTrue(soldado1.getSalud() == 179.5);
		assertTrue(arquero1.getSalud() == 29.5);
		assertTrue(lancero1.getSalud() == 129.5);
		assertTrue(caballero1.getSalud() == 179.5);
		
		soldado1.tomarPocionAgua();
		arquero1.tomarPocionAgua();
		lancero1.tomarPocionAgua();
		caballero1.tomarPocionAgua();
		
		//Golpee mayor al necesario para matar
		
		soldado1.recibirAtaque(300);
		arquero1.recibirAtaque(300);
		lancero1.recibirAtaque(300);
		caballero1.recibirAtaque(300);
		
		assertTrue(soldado1.getSalud() == 0);
		assertTrue(arquero1.getSalud() == 0);
		assertTrue(lancero1.getSalud() == 0);
		assertTrue(caballero1.getSalud() == 0);
		
	}
	
	@Test
	public void escudoTest(){
		soldado1 = new Escudo(soldado1);
		arquero1 = new Escudo(arquero1);
		lancero1 = new Escudo(lancero1);
		caballero1 = new Escudo(caballero1);
		
		soldado1.recibirAtaque(10);
		arquero1.recibirAtaque(10);
		lancero1.recibirAtaque(10);
		caballero1.recibirAtaque(10);
		
		//Si funciona bien deberian recibir solo el 40% del ataque o sea 4 puntos de daño
		
		assertTrue(soldado1.getSalud() == 196);
		assertTrue(arquero1.getSalud() == 46);
		assertTrue(lancero1.getSalud() == 146);
		assertTrue(caballero1.getSalud() == 196);
		
		//El escudo no decora ningun otro atributo asi que no harian falta mas tests
		
	}
	
	@Test
	public void puñalTest(){
		
		soldado1 = new Puñal(soldado1);
		arquero1 = new Puñal(arquero1);
		lancero1 = new Puñal(lancero1);
		caballero1 = new Puñal(caballero1);
		
		//Testeamos que el ataque sea el original mas 3
		
		assertTrue(soldado1.getPoder() == 13);
		assertTrue(arquero1.getPoder() == 8);
		assertTrue(lancero1.getPoder() == 28);
		assertTrue(caballero1.getPoder() == 53);
		
		//Testeamos que, como la defensa baja tres puntos, que reciban +3 de daño
		
		soldado1.recibirAtaque(1);
		arquero1.recibirAtaque(1);
		lancero1.recibirAtaque(1);
		caballero1.recibirAtaque(1);
		
		assertTrue(soldado1.getSalud() == 196);
		assertTrue(arquero1.getSalud() == 46);
		assertTrue(lancero1.getSalud() == 146);
		assertTrue(caballero1.getSalud() == 196);
		
	}
	
	@Test
	public void capaTest(){
		
		soldado1 = new Capa(soldado1);
		arquero1 = new Capa(arquero1);
		lancero1 = new Capa(lancero1);
		caballero1 = new Capa(caballero1);
		
		//Testeo que tengan solo el 90% del daño
		
		assertTrue(soldado1.getPoder() == 9);
		assertTrue(arquero1.getPoder() == 4.5);
		assertTrue(lancero1.getPoder() == 22.5); 
		assertTrue(caballero1.getPoder() == 45);
		
		//Testeo que la Unidad en verdad saque solo el 90% del daño
		
		soldado1.peleaCon(soldado2);
		assertTrue(soldado2.getSalud() == 191);
		
		arquero1.moverHacia(0, 3);
		arquero1.peleaCon(arquero2);
		assertTrue(arquero2.getSalud() == 45.5);
		
		lancero1.moverHacia(0, 1);
		lancero1.peleaCon(lancero2);
		assertTrue(lancero2.getSalud() == 127.5);
		
		caballero1.moverHacia(0, 1);
		caballero1.peleaCon(caballero2);
		assertTrue(caballero2.getSalud() == 155);
		
		//Testeo que el soldado tenga el doble de su energia
		
		soldado1.tomarPocionAgua();
		assertTrue(soldado1.getEnergia() == 200);
		soldado1.atacar();
		assertTrue(soldado1.getEnergia() == 190);
	}
	
	// xxx- test_items_combinados_soldado
	
	@Test
	public void soldadoEscudoYCapaPeleaConSoldado(){
		
		soldado1.moverHacia(0, 0);
		soldado2.moverHacia(0, 0);
		
		assertTrue(soldado1.getSalud() ==200);
		assertTrue(soldado1.getEnergia() ==100);
		
		soldado1 = new Escudo(soldado1);
		soldado1 = new Capa(soldado1);
		
		assertTrue(soldado1.getEnergia() ==200); //duplica energia  [capa]
		assertTrue(soldado1.getPoder() == 9);    //reduce poder 10% [capa]
		
		soldado2.peleaCon(soldado1);
		
		assertTrue(soldado1.getSalud() == 196); //reduce ataque al 40% [escudo]
		
	}
	
	@Test
	public void soldadoEscudoYPunialPeleaConSoldado(){
		
		soldado1.moverHacia(0, 0);
		soldado2.moverHacia(0, 0);
		
		assertTrue(soldado1.getSalud() ==200);
		assertTrue(soldado1.getEnergia() ==100);
		
		soldado1 = new Escudo(soldado1);
		soldado1 = new Puñal(soldado1);
		
		assertTrue(soldado1.getPoder() == 13); //aumenta poder +3 [punial]
		
		soldado2.peleaCon(soldado1);
		
		assertTrue(soldado1.getSalud() == 194.8); //reduce ataque al 40% (40% x 13 = 5.2)[escudo]
		
		//ahora soldado1 ataca a soldado2
		
		assertTrue(soldado2.getSalud() == 200);
		
		soldado1.peleaCon(soldado2);
		
		assertTrue(soldado2.getSalud() == 187);
	}
	
	@Test
	public void soldadoCapaYPunialPeleaConSoldado(){
		
		soldado1.moverHacia(0, 0);
		soldado2.moverHacia(0, 0);
		
		assertTrue(soldado2.getSalud() == 200);
		
		assertTrue(soldado1.getEnergia() == 100);
		assertTrue(soldado1.getPoder() == 10);
		
		soldado1 = new Capa(soldado1);    //primero capa [poder -10% -> 9]
		soldado1 = new Puñal(soldado1);   //despues puñal[poder +3 -> 9 + 3 -> 12]
		
		assertTrue(soldado1.getEnergia() == 200); //duplica energia [capa]
		assertTrue(soldado1.getPoder() == 12);
		
		soldado1.peleaCon(soldado2);
		
		assertTrue(soldado2.getSalud() == 188);
		
		//ahora soldado2 ataca a soldado1
		
		assertTrue(soldado1.getSalud() == 200);
		
		soldado2.peleaCon(soldado1);
		
		assertTrue(soldado1.getSalud() == 187); //puñal reduce defensa en 3
		
	}
	
	// xxx
}





