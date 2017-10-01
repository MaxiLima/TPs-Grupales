package utilidades;

import juegoestrategico.Unidad;

public class Puñal extends UnidadDecorator{

	public Puñal(Unidad unidad) {//O(1)
		this.unidad = unidad;
	}

	@Override
	public void recibirAtaque(double golpe) {//O(1)
		this.unidad.recibirAtaque(golpe + 3);
	}

	
	//OVERRIDING GETTERS
	
	@Override
	public double getPoder() {//O(1)
		return unidad.getPoder() + 3;
	}

	

}