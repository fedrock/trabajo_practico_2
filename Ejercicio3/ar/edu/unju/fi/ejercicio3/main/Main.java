package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		
		Provincia[] provincias = Provincia.values();
		
		System.out.println("Información de las provincias: ");
		
		for (Provincia provincia : provincias) {
			System.out.println("\n Provincia: "+provincia);
			System.out.println("Cantidad de habitantes: "+provincia.getCantidadHabitantes());
			System.out.println("Superficie: "+provincia.getSuperficie());
			System.out.println("Densidad poblacional: "+provincia.calcularDensidadPoblacional());
		}

	}

}
