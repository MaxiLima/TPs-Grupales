package utilidades;

import juegoestrategico.Unidad;

public abstract class UnidadDecorator extends Unidad{
	
	protected Unidad unidad;

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	
	@Override
	public double distanciaConEnemigo(Unidad that) {
		return this.unidad.distanciaConEnemigo(that);
	}

	@Override
	public void moverHacia(int x, int y) {
		this.unidad.moverHacia(x, y);
	}

	@Override
	public void atacar() {
		this.unidad.atacar();
	}

	@Override
	public boolean puedeAtacar() {
		return this.unidad.puedeAtacar();
	}

	@Override
	public void recibirAtaque(double golpe) {
		this.unidad.recibirAtaque(golpe);
	}
	
	@Override
	public void tomarPocionAgua(){
		this.unidad.tomarPocionAgua();
	}
	
	//OVERRIDING GETTERS
	
		@Override
		public String getName() {
			return unidad.getName();
		}
		
		@Override
		public double getPoder() {
			return unidad.getPoder();
		}

		@Override
		public double getSalud() {
			return unidad.getSalud();
		}
		
		@Override
		public int getEnergia() {
			return unidad.getEnergia();
		}
		
		@Override
		public int getPosX() {
			return unidad.getPosX();
		}
		
		@Override
		public int getPosY() {
			return unidad.getPosY();
		}
		
		@Override
		public int getDistanciaMin() {
			return unidad.getDistanciaMin();
		}
		
		@Override
		public int getDistanciaMax() {
			return unidad.getDistanciaMax();
		}

}
