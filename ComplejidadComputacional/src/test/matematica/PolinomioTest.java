package test.matematica;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import matematica.Polinomio;

public class PolinomioTest {

	private Polinomio polinomio;
	private Polinomio polinomio2;
	private Polinomio polinomio3;
	
	@Before
	public void setUp() {
		double[] coeficientes = {22,55,88,66,44,77,99,22,55,555,12,8,254,87,1,8,2,18,42,18,42,456,84,84
								,54,564,84,21,25,45,8,64,51,21,8,78,545,42,154,587,821,18,724,2,18,42,418,424,
								54,87,2,87,2,14,587,12,4,7,21,4,5,48,72,14,21,1,40,14,78,9,854,54,54,21,45,
								45,87,65,12,47,58,55,88,77,77,88,55,22,44,55,55,88,66,22,55,11,33,55,44,234,123};
		//System.out.println(coeficientes.length);
		polinomio = new Polinomio(100, coeficientes);
		
		double[] coeficientes2 = {564,84,21,25,45,8,64,51,21,8,78,545,42,154,587,821,18,724,2,18,42,418,424,
								54,87,2,87,2,14,587,12,4,7,21,4,5,48,72,14,21,1,40,14,78,9,854,54,54,21,45};
		//System.out.println(coeficientes2.length);
		polinomio2 = new Polinomio(49, coeficientes2);
		
		double[] coeficientes3 = {22,55,88,66,44,77,99,22,55,555,12};
		polinomio3 = new Polinomio(10, coeficientes3);

		
	}
	
	@Test
    public void queInicieEnUnoSegunElGrado() {
		
		int i = 0;
		Polinomio poli = new Polinomio(6);
		while(poli.getCoeficientes()[i] != 1 && i <= poli.getGrado())
		  i ++;
		
		Assert.assertTrue(i>=poli.getGrado());
		
	}

	@Test
	public void evaluarMSucesivaTest() {

		long start = System.nanoTime();
		
		Assert.assertTrue(polinomio.evaluarMSucesivas(12) != 0);
		
		long stop = System.nanoTime();
		long tiempo = stop - start;
		System.out.println("[Polinomio]evaluarMSucesivaTest: " + tiempo + " ns para grado 100");
		////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		
		Assert.assertTrue(polinomio2.evaluarMSucesivas(12) != 0);
		
		stop = System.nanoTime();
		tiempo = stop - start;
		System.out.println("[Polinomio]evaluarMSucesivaTest: " + tiempo + " ns para grado 50");
		////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		
		Assert.assertTrue(polinomio3.evaluarMSucesivas(12) != 0);
		
		stop = System.nanoTime();
		tiempo = stop - start;
		System.out.println("[Polinomio]evaluarMSucesivaTest: " + tiempo + " ns para grado 10");
		
		System.out.println();
		
	}
	
	@Test
	public void evaluarRecursivaTest() {
		
		long start = System.nanoTime();
		
		Assert.assertTrue(polinomio.evaluarRecursiva(12) != 0);
		
		long stop = System.nanoTime();
		long tiempo = stop - start;
		System.out.println("[Polinomio]evaluarRecursivaTest: " + tiempo + " ns para grado 100");
		////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		
		Assert.assertTrue(polinomio2.evaluarRecursiva(12) != 0);
		
		stop = System.nanoTime();
		tiempo = stop - start;
		System.out.println("[Polinomio]evaluarRecursivaTest: " + tiempo + " ns para grado 50");
		////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		
		Assert.assertTrue(polinomio3.evaluarRecursiva(12) != 0);
		
		stop = System.nanoTime();
		tiempo = stop - start;
		System.out.println("[Polinomio]evaluarRecursivaTest: " + tiempo + " ns para grado 10");
		
		System.out.println();
	}
	
	@Test
	public void evaluarRecursivaParTest() {
		long start = System.nanoTime();
    
		Assert.assertTrue(polinomio.evaluarRecursivaPar(12) != 0);
		
		long stop = System.nanoTime();
		long tiempo = stop - start;
		System.out.println("[Polinomio]evaluarRecursivaParTest: " + tiempo + " ns para grado 100");
		////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		
		Assert.assertTrue(polinomio2.evaluarRecursivaPar(12) != 0);
		
		stop = System.nanoTime();
		tiempo = stop - start;
		System.out.println("[Polinomio]evaluarRecursivaParTest: " + tiempo + " ns para grado 50");
		////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		
		Assert.assertTrue(polinomio3.evaluarRecursivaPar(12) != 0);
		
		stop = System.nanoTime();
		tiempo = stop - start;
		System.out.println("[Polinomio]evaluarRecursivaParTest: " + tiempo + " ns para grado 10");
		
		System.out.println();
	}
	
	
	@Test
	public void evaluarHornerTest() {
		long start = System.nanoTime();
		
		Assert.assertTrue(polinomio.evaluarHorner(12) != 0);
		
		long stop = System.nanoTime();
		long tiempo = stop - start;
		System.out.println("[Polinomio]evaluarHornerTest: " + tiempo + " ns grado 100");
		////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		
		Assert.assertTrue(polinomio2.evaluarHorner(12) != 0);
		
		stop = System.nanoTime();
		tiempo = stop - start;
		System.out.println("[Polinomio]evaluarHornerTest: " + tiempo + " ns para grado 50");
		////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		
		Assert.assertTrue(polinomio3.evaluarHorner(12) != 0);
		
		stop = System.nanoTime();
		tiempo = stop - start;
		System.out.println("[Polinomio]evaluarHornerTest: " + tiempo + " ns para grado 10");
		
		System.out.println();
	}
	
	@Test
	public void evaluarPowTest(){
		long start = System.nanoTime();
		
		Assert.assertTrue(polinomio.evaluarPow(12) != 0);
		
		long stop = System.nanoTime();
		long tiempo = stop - start;
		System.out.println("[Polinomio]evaluarPowTest: " + tiempo + " ns grado 100");
		////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		
		Assert.assertTrue(polinomio2.evaluarPow(12) != 0);
		
		stop = System.nanoTime();
		tiempo = stop - start;
		System.out.println("[Polinomio]evaluarPowTest: " + tiempo + " ns para grado 50");
		////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		
		Assert.assertTrue(polinomio3.evaluarPow(12) != 0);
		
		stop = System.nanoTime();
		tiempo = stop - start;
		System.out.println("[Polinomio]evaluarPowTestTest: " + tiempo + " ns para grado 10");
		
		System.out.println();
		
	}
	
	@Test
	public  void evaluarProgDinamicaTest(){
		long start = System.nanoTime();
    
		Assert.assertTrue(polinomio.evaluarProgDinamica(12) != 0);
		
		long stop = System.nanoTime();
		long tiempo = stop - start;
		System.out.println("[Polinomio]evaluarProgDinamicaTest: " + tiempo + " ns para grado 100");
		////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		
		Assert.assertTrue(polinomio2.evaluarProgDinamica(12) != 0);
		
		stop = System.nanoTime();
		tiempo = stop - start;
		System.out.println("[Polinomio]evaluarProgDinamicaTest: " + tiempo + " ns para grado 50");
		////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		
		Assert.assertTrue(polinomio2.evaluarProgDinamica(12) != 0);
		
		stop = System.nanoTime();
		tiempo = stop - start;
		System.out.println("[Polinomio]evaluarProgDinamicaTest: " + tiempo + " ns para grado 10");
		
		System.out.println();
		
	}
	
	@Test
	public  void evaluarMejoradaTest(){
		long start = System.nanoTime();
    
		Assert.assertTrue(polinomio.evaluarMejorada(12) != 0);
		
		long stop = System.nanoTime();
		long tiempo = stop - start;
		System.out.println("[Polinomio]evaluarMejoradaTest: " + tiempo + " ns para grado 100");
		////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		
		Assert.assertTrue(polinomio2.evaluarMejorada(12) != 0);
		
		stop = System.nanoTime();
		tiempo = stop - start;
		System.out.println("[Polinomio]evaluarMejoradaTest: " + tiempo + " ns para grado 50");
		////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		
		Assert.assertTrue(polinomio2.evaluarMejorada(12) != 0);
		
		stop = System.nanoTime();
		tiempo = stop - start;
		System.out.println("[Polinomio]evaluarMejoradaTest: " + tiempo + " ns para grado 10");
		
		System.out.println();
		
	}
}