package utilidades;

import juegoestrategico.Personaje;

public class Capa extends PersonajeDecorator{

	public Capa(Personaje personaje) {
		super(personaje);
	}

	@Override
	public double getSalud() {
		return getPersonaje().getSalud();
	}

	@Override
	public double getDaño() {
		return getPersonaje().getDaño() * 0.9;
	}

	@Override
	public int getEnergia() {
		return getPersonaje().getEnergia() *2;
	} 
	
	
	
	
}
