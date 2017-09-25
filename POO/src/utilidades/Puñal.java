package utilidades;

import juegoestrategico.Personaje;

public class Puñal extends PersonajeDecorator{

	public Puñal(Personaje personaje) {
		super(personaje);
	}

	@Override
	public double getSalud() {
		return getPersonaje().getSalud();
	}

	@Override
	public double getDaño() {
		return getPersonaje().getDaño() +3;
	}

	@Override
	public int getEnergia() {
		return 0;
	}
	
	

}
