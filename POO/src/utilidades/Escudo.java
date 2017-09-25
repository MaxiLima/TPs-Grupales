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

}
