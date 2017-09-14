package test.matematica;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import matematica.Polinomio;

public class PolinomioTest {

	private Polinomio polinomio;
	
	@Before
	public void setUp() {
		double[] coeficientes = {-1,-2,5,14,-9,-6,21,-4,10,7,-200,-828};
		polinomio = new Polinomio(11, coeficientes);	
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

		long start = System.currentTimeMillis();
		
		Assert.assertTrue(polinomio.evaluarMSucesivas(2) == 0);
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Polinomio]evaluarMSucesivaTest: " + tiempo + " ms");
	}
	
	@Test
	public void evaluarRecursivaTest() {
		
		long start = System.currentTimeMillis();
		
		Assert.assertTrue(polinomio.evaluarRecursiva(2) == 0);
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Polinomio]evaluarRecursivaTest: " + tiempo + " ms");
	}
	
	@Test
	public void evaluarRecursivaParTest() {
		long start = System.currentTimeMillis();
    
		Assert.assertTrue(polinomio.evaluarRecursivaPar(2) == 0);
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Polinomio]evaluarRecursivaParTest: " + tiempo + " ms");
	}
	
	
	@Test
	public void evaluarHornerTest() {
		long start = System.currentTimeMillis();
		
		Assert.assertTrue(polinomio.evaluarHorner(2) == 0);
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Polinomio]evaluarHornerTest: " + tiempo + " ms");
	}
	
	@Test
	public void evaluarPowTest(){
		long start = System.currentTimeMillis();
		
		Assert.assertTrue(polinomio.evaluarPow(2) == 0);
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Polinomio]evaluarPowTest: " + tiempo + " ms");
		
	}
	
	@Test
	public  void evaluarProgDinamicaTest(){
		long start = System.currentTimeMillis();
    
		Assert.assertTrue(polinomio.evaluarProgDinamica(2) == 0);
		
		long stop = System.currentTimeMillis();
		long tiempo = stop - start;
		System.out.println("[Polinomio]evaluarProgDinamicaTest: " + tiempo + " ms");
		
	}
}