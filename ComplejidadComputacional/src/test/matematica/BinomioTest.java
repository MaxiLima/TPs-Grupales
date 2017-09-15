package test.matematica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import matematica.BinomioNewton;

public class BinomioTest {

	BinomioNewton binomio ;
	BinomioNewton binomio1 ;
	BinomioNewton binomio2 ;
	BinomioNewton binomio3 ;
	@Before
	public void setUp() {
		binomio = new BinomioNewton(100,4664,1022);
		binomio1 = new BinomioNewton(1000 , 1212,4654);
		binomio2 = new BinomioNewton(3000,646,684);
		binomio3 = new BinomioNewton(8000,557,87);
	}

	@Test
	public void obtenerTerminosTartaTest() {
		BinomioNewton binom30 = new BinomioNewton(30,4,4);
		long[]resultado = new long[binom30.getGrado()];
		long[]esperado = {1,30,435,4060,27405,142506,593775,2035800,5852925,14307150,30045015,54627300,86493225,119759850,145422675,155117520,145422675,119759850,86493225,54627300,30045015,14307150,5852925,2035800,593775,142506,27405,4060,435,30,1,};
		resultado = BinomioNewton.obtenerTerminosTarta(binom30.getGrado() + 1);
		long start = System.currentTimeMillis();
		
		Assert.assertArrayEquals(esperado, resultado);
		
		long stop30 = System.currentTimeMillis();
		long tiempo = stop30 - start;
		System.out.println("[Binomio]obtenerTerminosTartaTest: " + tiempo + " ms para grado 30");
		
		BinomioNewton binom10 = new BinomioNewton(10,4,4);
		long[]esperado1 = {1,10,45,120,210,252,210,120,45,10,1};
		resultado = BinomioNewton.obtenerTerminosTarta(binom10.getGrado()+1);
		start = System.currentTimeMillis();
		
		Assert.assertArrayEquals(esperado1, resultado);
		
		long stop10 = System.currentTimeMillis();
		long tiempo1 = stop10 - start;
		System.out.println("[Binomio]obtenerTerminosTartaTest: " + tiempo1 + " ms para grado 10");
	}
	
	
	@Test
	public void resolverBinomioTest() {
		long start = System.currentTimeMillis();
		
		Assert.assertTrue(binomio.resolverBinomio() != 0 );
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Binomio]resolverBinomioTest: " + tiempo + " ms para grado 100");
		///////////////////////////////////////////////////////////////////////////////
		start = System.currentTimeMillis();
		
		Assert.assertTrue(binomio1.resolverBinomio() != 0 );
		
		stop = System.currentTimeMillis();
		tiempo = stop - start;
		System.out.println("[Binomio]resolverBinomioTest: " + tiempo + " ms para grado 1000");
		///////////////////////////////////////////////////////////////////////////////
		start = System.currentTimeMillis();
		
		Assert.assertTrue(binomio2.resolverBinomio() != 0 );
		
		stop = System.currentTimeMillis();
		tiempo = stop - start;
		System.out.println("[Binomio]resolverBinomioTest: " + tiempo + " ms para grado 3000");
		///////////////////////////////////////////////////////////////////////////////
		start = System.currentTimeMillis();
		
		Assert.assertTrue(binomio3.resolverBinomio() != 0 );
		
		stop = System.currentTimeMillis();
		tiempo = stop - start;
		System.out.println("[Binomio]resolverBinomioTest: " + tiempo + " ms para grado 8000");		
		
	}
	
	@Test
	public void resolverBinomioEstaticoTest() {
		
		long start = System.currentTimeMillis();
		Assert.assertTrue(BinomioNewton.resolverBinomio(1000, 3151, 8421,2156) !=  0);
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Binomio]resolverBinomioEstaticoTest: " + tiempo + " ms para grado 1.000");
		/////////////////////////////////////////////////////////////////////////////////
		start = System.currentTimeMillis();
		Assert.assertTrue(BinomioNewton.resolverBinomio(10000, 3151, 8421,2156) !=  0);
		
		stop = System.currentTimeMillis();
		tiempo = stop - start;
		System.out.println("[Binomio]resolverBinomioEstaticoTest: " + tiempo + " ms para grado 10.000" );
		/////////////////////////////////////////////////////////////////////////////////
		start = System.currentTimeMillis();
		Assert.assertTrue(BinomioNewton.resolverBinomio(100000, 3151, 8421,2156) !=  0);
		
		stop = System.currentTimeMillis();
		tiempo = stop - start;
		System.out.println("[Binomio]resolverBinomioEstaticoTest: " + tiempo + " ms para grado 100.000");
		/////////////////////////////////////////////////////////////////////////////////
		start = System.currentTimeMillis();
		Assert.assertTrue(BinomioNewton.resolverBinomio(1000000, 3151, 8421,2156) !=  0);
		
		stop = System.currentTimeMillis();
		tiempo = stop - start;
		System.out.println("[Binomio]resolverBinomioEstaticoTest: " + tiempo + " ms para grado 1.000.000");
		/////////////////////////////////////////////////////////////////////////////////
		start = System.currentTimeMillis();
		Assert.assertTrue(BinomioNewton.resolverBinomio(10000000, 3151, 8421,2156) !=  0);
		
		stop = System.currentTimeMillis();
		tiempo = stop - start;
		System.out.println("[Binomio]resolverBinomioEstaticoTest: " + tiempo + " ms para grado 10.000.000");
	}
	
//	@Test
//	public void mostrarBinomioTest() {
//		String resultado = "+16.0X2-16.0X1+4.0X0";
//		long start = System.currentTimeMillis();
//		Assert.assertEquals(resultado, binomio.mostrarBinomioResuelto());
//		
//		long stop = System.currentTimeMillis();
//		long tiempo = stop - start;
//		System.out.println("[Binomio]mostrarBinomioTest: " + tiempo + " ms");
//	}
}