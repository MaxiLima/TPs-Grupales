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
		BinomioNewton binom = new BinomioNewton(30,4,4);
		long[]resultado = new long[binom.getGrado()];
		long[]esperado = {1,30,435,4060,27405,142506,593775,2035800,5852925,14307150,30045015,54627300,86493225,119759850,145422675,155117520,145422675,119759850,86493225,54627300,30045015,14307150,5852925,2035800,593775,142506,27405,4060,435,30,1,};
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