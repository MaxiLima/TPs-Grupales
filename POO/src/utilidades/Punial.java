package utilidades;

import juegoestrategico.Unidad;

public class Punial extends UnidadDecorator{

	public Punial(Unidad unidad) {
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