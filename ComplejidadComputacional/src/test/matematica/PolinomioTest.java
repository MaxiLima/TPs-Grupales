package test.matematica;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import matematica.Polinomio;

public class PolinomioTest {

	private Polinomio polinomio;
	
	@Before
	public void setUp() {
		polinomio = new Polinomio(4);	
	}
	
	@Test
    public void queInicieEnUnoSegunElGrado() {
		
		int i = 0;
		while(polinomio.getCoeficientes()[i] != 1 && i <= polinomio.getGrado())
		  i ++;
		
		Assert.assertTrue(i>=polinomio.getGrado());
		
	}

	@Test
	public void evaluarMSucesivaTest() {
		double[] coeficientes = {2,2,4};
		Polinomio polinomio1 = new Polinomio(2,coeficientes);
		
		Assert.assertTrue(polinomio1.evaluarMSucesivas(2) == 16);
	}
	
	@Test
	public void evaluarRecursivaTest() {
		double[] coeficientes = {2,2,4};
		Polinomio polinomio1 = new Polinomio(2,coeficientes);
    
		Assert.assertTrue(polinomio1.evaluarRecursiva(2) == 16);
	}
	
	@Test
	public void evaluarRecursivaParTest() {
		double[] coeficientes = {1,2};
		Polinomio polinomio1 = new Polinomio(1,coeficientes);
    
		Assert.assertTrue(polinomio1.evaluarRecursivaPar(20) == 22);
	}
	
	
	@Test
	public void evaluarHornerTest() {
		double[] coeficientes = {12,-12};
		Polinomio polinomio1 = new Polinomio(1,coeficientes);
    
		Assert.assertTrue(polinomio1.evaluarHorner(3) == 24);
	}
	
	@Test
	public void evaluarPowTest(){
		double[] coeficientes = {-40,1};
		Polinomio polinomio1 = new Polinomio(1,coeficientes);
    
		Assert.assertTrue(polinomio1.evaluarPow(2) == -79);
	}
	
	@Test
	public  void evaluarProgDinamicaTest(){
		double[] coeficientes = {3,1, 10};
		Polinomio polinomio1 = new Polinomio(2,coeficientes);
    
		Assert.assertTrue(polinomio1.evaluarProgDinamica(1) == 14);
		
	}
}