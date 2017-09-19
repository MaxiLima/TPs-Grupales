package matematica;

public class BinomioNewton {
	private int grado;
	private double x;
	private double b;
	private double[][] tarta;
	

	public BinomioNewton(int grado, double x, double b) {
		super();
		this.grado = grado;
		this.x = x;
		this.b = b;
		this.tarta = new double[grado + 1][grado + 1];
	}
	
	public BinomioNewton(int grado) {
		super();
		this.grado = grado;
		this.x = this.b = 0;
		this.tarta = new double[grado + 1][grado + 1];
	}

	public BinomioNewton() {
		this(0, 0, 0);
	}

	public double evaluarMSucesivas(double x) {
		double retorno = 0;
		retorno = potenciaPorMult((this.getX() * x) + this.getB(),this.getGrado());
		return retorno;
	}

	public double evaluarRecursiva(double x) {
		double retorno = 0;
		for (int i = 0; i <= this.getGrado(); i++)
			retorno = potenciaRecursiva((this.getX() * x) + this.getB(),this.getGrado());
		return retorno;
	}
	
	public double evaluarRecursivaPar(double x) {
		double retorno = 0;
		for (int i = 0; i <= this.getGrado(); i++) {
			if (i % 2 != 0)
				retorno = potenciaRecursiva((this.getX() * x) + this.getB(),this.getGrado());
			else
				retorno = potenciaRecursivaPar((this.getX() * x) + this.getB(),this.getGrado());
		} 

		return retorno;
	}
	
	public double evaluarProgDinamica(double x) {
		double retorno = this.getX()*x + this.getB();
		double potencia = retorno;
		for (int i = 1; i < this.getGrado(); i++) 
		    retorno*= potencia;
		return retorno;
	}
	
	public double evaluarPow(double x) {
		double retorno = 0;
		retorno = Math.pow((this.getX() * x) + this.getB(), this.getGrado());
		return retorno;
	}
	
	public double evaluarHorner(double x) {
		double[] terminos = obtenerTerminosTarta(this.getGrado() + 1);
		double[] coeficientes = new double[this.getGrado() + 1];
		
		for (int i = 0, j = this.getGrado(); i <= this.getGrado(); j--, i++) {
			coeficientes[i] = terminos[i] * Math.pow(this.getX(), j) * Math.pow(this.getB(), i);
		}		
		double retorno = 0;
		if (this.getGrado() == 0)
			return coeficientes[0];
		retorno = coeficientes[0] * x + coeficientes[1];
		for (int i = 2; i <= this.getGrado(); i++)
			retorno = (retorno * x) + coeficientes[i];
		return retorno;
	}

	public double[] obtenerTerminosTarta(int nivel) {
		
		if (tarta[nivel - 1][0] != 0)
			return tarta[nivel - 1];
		for (int i = 0; i < nivel; i++) {
			if (tarta[i][0] == 0) {
				tarta[i][0] = 1;
				for (int j = 1; j <= i; j++)
					tarta[i][j] = Double.valueOf(tarta[i - 1][j - 1]
							+ tarta[i - 1][j]);
			}
		}
		return tarta[nivel - 1];
	}

	public String mostrarBinomioResuelto() {
		StringBuffer buffer = new StringBuffer();
		double[] terminos = obtenerTerminosTarta(this.getGrado() + 1);
		double temporal;
		for (int i = 0, j = this.getGrado(); i <= this.getGrado(); j--, i++) {
			temporal = terminos[i] * Math.pow(this.getX(), j) * Math.pow(this.getB(), i);
			if (temporal > 0)
				buffer.append("+");
			buffer.append(temporal);
			buffer.append("X");
			buffer.append(j);
		}
		return buffer.toString();
	}

	public double resolverBinomio() {
		double retorno = 0;
		double[] terminos = new double[this.getGrado() + 1];
		terminos = obtenerTerminosTarta(this.getGrado() + 1);
		for (int i = this.getGrado(), j = 0; i >= 0; i--, j++) {
			retorno += terminos[j] * Math.pow(this.x, i) * Math.pow(this.b, j);
		}
		return retorno;
	}

	public double resolverBinomio(final double x, final double b, final int grado, double valor) {
		double retorno = 0;
		double[] terminos = new double[grado];
		double auxX = Math.pow(x, grado);
		double auxB = 1;
		terminos = obtenerTerminosTarta(grado + 1);

		for (int i = grado, j = 1; i >= 0; i--, j++) {
			retorno += terminos[j - 1] * (valor * auxX) * auxB;
			auxX /= x;
			auxB *= b;
		}
		return retorno;
	}

	public double potenciaPorMult(double numero, int potencia) {
		double retorno = 1;
		for (int i = potencia; i > 0; i--)
			retorno *= numero;
		return retorno;
	}

	public double potenciaRecursiva(double numero, int potencia) {
		if (potencia == 0)
			return 1;
		else
			return numero * potenciaRecursiva(numero, potencia - 1);
	}

	public double potenciaRecursivaPar(double numero, int potencia) {
		if (potencia == 0)
			return 1;
		if ((potencia % 2) == 0)
			return potenciaRecursivaPar(numero * numero, potencia / 2); 
		return numero * potenciaRecursivaPar(numero, potencia - 1);
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public double getX() {
		return x;
	}

	public void setX(double coeficienteA) {
		this.x = coeficienteA;
	}

	public double getB() {
		return b;
	}

	public void setB(double coeficienteB) {
		this.b = coeficienteB;
	}

	public double[][] tarta() {
		return tarta;
	}

	public void setTartaglia(double[][] tarta) {
		this.tarta = tarta;
	}
}