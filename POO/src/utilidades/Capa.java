package utilidades;

import juegoestrategico.Unidad;

public class Capa extends UnidadDecorator{

	public Capa(Unidad unidad) {
		this.unidad = unidad;
	}

	@Override
	public double getPoder() {
		return unidad.getPoder() * 0.9;
	}
	
	@Override
	public int getEnergia() {
		if(unidad.getEnergia() == 0)
			return 0;
		return unidad.getEnergia()*2 +(100 - unidad.getEnergia());
	}
	
}
