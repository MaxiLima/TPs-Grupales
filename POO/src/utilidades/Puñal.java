package utilidades;

import juegoestrategico.Unidad;

public class Puñal extends UnidadDecorator{

	public Puñal(Unidad unidad) {
		this.unidad = unidad;
	}

	@Override
	public void recibirAtaque(double golpe) {
		this.unidad.recibirAtaque(golpe + 3);
	}

	
	//OVERRIDING GETTERS
	
	@Override
	public double getPoder() {
		return unidad.getPoder() + 3;
	}

	

}