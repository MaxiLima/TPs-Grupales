package utilidades;

import juegoestrategico.Unidad;

public class Capa extends UnidadDecorator{

	public Capa(Unidad unidad) {//O(1)
		this.unidad = unidad;
	}

	@Override
	public double getPoder() {//O(1)
		return unidad.getPoder() * 0.9;
	}
	
	@Override
	public int getEnergia() {//O(1)
		if(unidad.getEnergia() == 0)
			return 0;
		return unidad.getEnergia()*2 +(100 - unidad.getEnergia());
	}
	
}
