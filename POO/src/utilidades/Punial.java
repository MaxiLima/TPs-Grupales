package utilidades;

import juegoestrategico.Unidad;

public class Punial extends UnidadDecorator{

	public Punial(Unidad unidad) {
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
		this.unidad.recibirAtaque(golpe + 3);
	}
	
	@Override
	public void tomarPocionAgua(){
		this.unidad.tomarPocionAgua();
	}
	
	//OVERRIDING SETTERS
	
//	@Override
//	public void setEnergia(int energia){
//		this.unidad.setEnergia(energia);
//	}
//	
//	@Override
//	public void setPoder(double poder){
//		this.unidad.setPoder(poder + 3);
//	}
//	
//	@Override
//	public void setName(String name) {
//		unidad.setName(name);
//	}
//
//	@Override
//	public void setSalud(double salud) {
//		unidad.setSalud(salud);
//	}
//	
//	@Override
//	public void setPosX(int posX) {
//		unidad.setPosX(posX);
//	}
//
//	@Override
//	public void setPosY(int posY) {
//		unidad.setPosY(posY);
//	}
//
//	@Override
//	public void setDistanciaMin(int distanciaMin) {
//		unidad.setDistanciaMin(distanciaMin);
//	}
//	
//	@Override
//	public void setDistanciaMax(int distanciaMax) {
//		unidad.setDistanciaMax(distanciaMax);
//	}
	
	//OVERRIDING GETTERS
	
	@Override
	public String getName() {
		return unidad.getName();
	}
	
	@Override
	public double getPoder() {
		return unidad.getPoder() + 3;
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