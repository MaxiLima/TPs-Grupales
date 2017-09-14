package test.matematica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import matematica.BinomioNewton;

public class BinomioTest {

	BinomioNewton binomio ;
	@Before
	public void setUp() {
		binomio = new BinomioNewton(2,4,-2);
	}

	@Test
	public void obtenerTerminosTartaTest() {
		int[]resultado = new int[binomio.getGrado()];
		int[]esperado = {1,2,1};
		resultado = BinomioNewton.obtenerTerminosTarta(binomio.getGrado() + 1);
		long start = System.currentTimeMillis();
		
		Assert.assertArrayEquals(esperado, resultado);
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Binomio]obtenerTerminosTartaTest: " + tiempo + " ms");
	}
	
	
	@Test
	public void resolverBinomioTest() {
		long start = System.currentTimeMillis();
		
		Assert.assertTrue(binomio.resolverBinomio()==4);
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Binomio]resolverBinomioTest: " + tiempo + " ms");
	}
	
	@Test
	public void resolverBinomioEstaticoTest() {
		
		long start = System.currentTimeMillis();
		Assert.assertTrue(BinomioNewton.resolverBinomio(3, 5, 2,1)==64);
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Binomio]resolverBinomioEstaticoTest: " + tiempo + " ms");
	}
	
	@Test
	public void mostrarBinomioTest() {
		String resultado = "+16.0X2-16.0X1+4.0X0";
		long start = System.currentTimeMillis();
		Assert.assertEquals(resultado, binomio.mostrarBinomioResuelto());
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Binomio]mostrarBinomioTest: " + tiempo + " ms");
	}
}