package matematica;


public class Polinomio {
	
	
	private int grado;
	private double[] coeficientes;
	
	public Polinomio(int grado){
		
		double[] coeficientes = new double[grado];
		for (int i = 0; i < grado; i++) 
			coeficientes[i] = 1;
		this.setCoeficientes(coeficientes);
	}
	
	public Polinomio(int grado, double[] coeficientes) {
		this.grado = grado;
		this.coeficientes = coeficientes;
	}

	public int getGrado() {
		return grado;
	}
	
	public void setGrado(int grado) {
		this.grado = grado;
	}
	
	public double[] getCoeficientes() {
		return coeficientes;
	}
	
	public void setCoeficientes(double[] coeficientes) {
		this.coeficientes = coeficientes;
	}

	
	public double evaluarProgDinamica(double x) {
		
		double resultado = 0;
		double pot = 1;
		
		for (int i = 0; i < this.getGrado(); i++) {
			resultado += this.getCoeficientes()[i]*pot;
			pot *= x; //O(1)
		}
		//O(n)
		
		return resultado;
	}
	
	
	public double evaluarMSucesivas(double x) {
		
		double resultado = 0;
		
		for (int i = 0; i <= this.getGrado(); i++) 
			resultado += this.getCoeficientes()[i]*potenciaPorMult(x, this.getGrado() - i );//O(n2)
		
		return resultado;
	}
	
	public double evaluarRecursiva(double x) {
		
		double resultado = 0;
		
		for (int i = 0; i <= this.getGrado(); i++) 
			resultado += this.getCoeficientes()[i]*potenciaRecursiva(x, this.getGrado() - i );
		
		return resultado;
	}
	
	public double evaluarHorner(double x) {
		double resultado = 0;
		
		resultado = this.getCoeficientes()[0]*x + this.getCoeficientes()[1];
		
		for (int i = 2; i <= this.getGrado(); i++) 
			resultado = (resultado*x) + this.getCoeficientes()[i];
		

		return resultado;
	}
	
	
	public double evaluarRecursivaPar(double x){
		
		double resultado = 0;
		
		for (int i = 0; i <= this.getGrado(); i++) 
		{
			if(i % 2 != 0)
				resultado += this.getCoeficientes()[i]*potenciaRecursiva(x, this.getGrado() - i );//Impar
			else
				resultado += this.getCoeficientes()[i]*potenciaRecursivaPar(x, this.getGrado() - i );//Par
		}
			
		
		return resultado;
	}
	
	
	public double evaluarPow(double x){
		
		double resultado = 0;
		for(int i = 0; i <= this.getGrado(); i ++)
			resultado += this.getCoeficientes()[i]* Math.pow(x,this.getGrado()-i);
			
		return resultado;
	}
	public double potenciaPorMult(double numero, int pot){
		
		double resultado = 1;
		
		for (int i = 0; i < pot; i++) 
			resultado *= numero;
			
		
		return resultado;
	} 
	
	public double potenciaRecursiva(double numero, int pot) {
		
		if(pot == 0)
			return 1;
		else
			return numero*potenciaRecursiva(numero, pot -1);
	}
	
	public double potenciaRecursivaPar(double numero, int pot) {
		
		if(pot == 0)
			return 1;
		else
			return numero*potenciaRecursiva(numero*numero, pot /2);
	}
	

	
	
	
	
	
}