package matematica;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Polinomio {
	
	
	private int grado;
	private double[] coeficientes;
	
	public Polinomio(String path, String file){
		Scanner entrada = null;
		
		try {
			entrada=new Scanner(new File( path + file ));
			
			int grado = entrada.nextInt();
			coeficientes = new double[grado +1];
			
			for(int i=0;i<=grado;i++){
				coeficientes[i]=entrada.nextDouble();
			}
			
			//set valores
			this.grado=grado;
			this.coeficientes=coeficientes;
			
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			entrada.close();
		}
		
	}
	
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
		
		for (int i = this.getGrado(); i >= 0; i--) {
			resultado += this.getCoeficientes()[i]*pot;
			pot *= x; 
		}
		
		
		return resultado;
	}
	
	public double evaluarMejorada(double x) {
		
		double resultado = 0;
		int i, j ;
		for ( i = this.getGrado(), j = 1 ; i >= 0 ; i--, j*=x) 
		 resultado += this.getCoeficientes()[i]*(j);
		
		return resultado;
	}
	
	
	public double evaluarMSucesivas(double x) {
		
		double resultado = 0;
		
		for (int i = 0; i <= this.getGrado(); i++) 
			resultado += this.getCoeficientes()[i]*potenciaPorMult(x, this.getGrado() - i );
		
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
