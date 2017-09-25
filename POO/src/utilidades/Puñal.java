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

	@Override
	public void setSalud(double salud) {
		getPersonaje().setSalud(salud);
	} 

	@Override
	public void recibirAtaque(double golpe) {
		// TODO Auto-generated method stub
		
	}
	
	

}
