package utilidades;

import juegoestrategico.Personaje;

public abstract class PersonajeDecorator implements Personaje{
	
	protected Personaje personaje;
	
	public PersonajeDecorator(Personaje personaje){
		this.personaje = personaje;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
	

}
