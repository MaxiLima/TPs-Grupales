package utilidades;

import juegoestrategico.Unidad;

public class Escudo extends UnidadDecorator{

	public Escudo(Unidad unidad) {
		this.unidad = unidad;
	}

	@Override
	public void recibirAtaque(double golpe) {
		this.unidad.recibirAtaque(golpe*0.4);
	}

	
}
