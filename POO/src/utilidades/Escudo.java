package utilidades;

import juegoestrategico.Personaje;

public class Escudo extends PersonajeDecorator{

	public Escudo(Personaje personaje) {
		super(personaje);
	}

	@Override
	public double getSalud() {
		return getPersonaje().getSalud();
	}

	@Override
	public double getDaño() {
		return getPersonaje().getDaño();
	}

	@Override
	public int getEnergia() {
		return getPersonaje().getEnergia();
	}

	@Override
	public void setSalud(double salud) {
		getPersonaje().setSalud(salud);
	} 

	@Override
	public void recibirAtaque(double golpe) {
		double daño = golpe*0.4;
		getPersonaje().setSalud(getPersonaje().getSalud() - daño);
	}

}
