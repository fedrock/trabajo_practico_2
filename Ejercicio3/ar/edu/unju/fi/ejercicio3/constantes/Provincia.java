package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(811611, 53219), //Poblacion y superficie de Jujuy
	SALTA(1441351, 155488), //Poblacion y superficie de Salta
	TUCUMAN(1687305, 22524), //Poblacion y superficie de Tucuman
	CATAMARCA(429562, 102602), //Poblacion y superficie de Catamarca
	LA_RIOJA(383865, 89680), //Poblacion y superficie de La Rioja
	SANTIAGO_DEL_ESTERO(896461, 136351); //Poblacion y superficie de Santiago del estero

	private int cantidadHabitantes;
	private int superficie;
	
	private Provincia(int cantidadHabitantes, int superficie) {
		this.cantidadHabitantes = cantidadHabitantes;
		this.superficie = superficie;
	}

	public int getCantidadHabitantes() {
		return cantidadHabitantes;
	}

	public void setCantidadHabitantes(int cantidadHabitantes) {
		this.cantidadHabitantes = cantidadHabitantes;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public double calcularDensidadPoblacional () {
		return (double) cantidadHabitantes / superficie;
	}
	
}
