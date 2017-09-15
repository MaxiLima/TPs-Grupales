package test.matematica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import matematica.BinomioNewton;

public class BinomioTest {

	BinomioNewton binomio ;
	@Before
	public void setUp() {
		binomio = new BinomioNewton(3000,4664,1022);
	}

	@Test
	public void obtenerTerminosTartaTest() {
		BinomioNewton binom = new BinomioNewton(20,4,4);
		int[]resultado = new int[binom.getGrado()];
		int[]esperado = {1,20,190,1140,4845,15504,38760,77520,125970,167960,184756,167960,125970,77520,38760,15504,4845,1140,190,20,1};
		resultado = BinomioNewton.obtenerTerminosTarta(binom.getGrado() + 1);
		long start = System.currentTimeMillis();
		
		Assert.assertArrayEquals(esperado, resultado);
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Binomio]obtenerTerminosTartaTest: " + tiempo + " ms");
	}
	
	
	@Test
	public void resolverBinomioTest() {
		long start = System.currentTimeMillis();
		
		Assert.assertTrue(binomio.resolverBinomio() != 0 );
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Binomio]resolverBinomioTest: " + tiempo + " ms");
	}
	
	@Test
	public void resolverBinomioEstaticoTest() {
		
		long start = System.currentTimeMillis();
		Assert.assertTrue(BinomioNewton.resolverBinomio(10000000, 3151, 8421,2156) !=  0);
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Binomio]resolverBinomioEstaticoTest: " + tiempo + " ms");
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