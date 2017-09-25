package juegoestrategico;

public interface Personaje {
	public double getSalud();
	public void setSalud(double salud);
	public double getDaño();
	public int getEnergia();
	public void recibirAtaque(double golpe);
	
}
