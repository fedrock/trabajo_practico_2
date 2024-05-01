package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Efemeride> efemerides = new ArrayList<>();
	public static void main(String[] args) {	
		
		int option = 0;
		
		do {
			mostrarMenu();
			option = scanner.nextInt();
			switch (option) {
			case 1: crearEfemeride();
				break;
			case 2: mostrarEfemeride();
				break;
			case 3: eliminarEfemeride();
			break;
			case 4: modificarEfemeride();
			break;
			case 5:
				System.out.println("Fin del programa!");
			break;
			default:
				System.out.println("Opcion invalida! ");
			}
			
		}while (option != 5);
	}
	private static void mostrarMenu () {
		System.out.println("\n-- Menú --");
        System.out.println("1 - Crear efeméride");
        System.out.println("2 - Mostrar efemérides");
        System.out.println("3 - Eliminar efeméride");
        System.out.println("4 - Modificar efeméride");
        System.out.println("5 - Salir");
        System.out.print("Elija una opción: ");
	}
	
	private static void crearEfemeride () {
		Efemeride efemeride = new Efemeride();
		System.out.println("Ingrese el codigo efemeride: ");
		efemeride.setCodigo(scanner.next());
		System.out.println("Ingrese el mes correspondiente efemeride: [1-12]");
		int mesControl = scanner.nextInt();
		
		while (mesControl < 1 || mesControl >12) {
			System.out.println("El numero ingresado es menor o mayor que los meses del [1-12]");
			System.out.println("Vuelva a ingresar el mes correcto.");
			mesControl = scanner.nextInt();
		}
		efemeride.setMes(Mes.values()[mesControl-1]);
		System.out.println("Ingrese el dia: ");
		efemeride.setDia(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Ingrese el detalle correspondiente: ");
		efemeride.setDetalle(scanner.nextLine());
		efemerides.add(efemeride);
		System.out.println("--Se a creado correctamente la efemeride--");
		
	}
	private static void mostrarEfemeride () {
		if (efemerides.isEmpty()) {
			System.out.println("No hay efemerides creadas o no hay para mostrar");
			return;
		}
		System.out.println("---|| Efemeride ||---");
		for (Efemeride efemeride : efemerides) {
			System.out.println(efemeride);
		}
	}
	
	private static void eliminarEfemeride () {
		if (!efemerides.isEmpty()) {
			System.out.println("\n-- Eliminar Efeméride --");
	        mostrarEfemeride();
	        System.out.print("Ingrese el código de la efeméride a eliminar: ");
	        String codigoEliminar = scanner.next();

	        boolean encontrado = false;
	        for (Efemeride efemeride : efemerides) {
	            if (efemeride.getCodigo().equals(codigoEliminar)) {
	                efemerides.remove(efemeride);
	                encontrado = true;
	                System.out.println("Efeméride eliminada exitosamente!");
	                break;
	            }
	        }
	        if (!encontrado) {
	            System.out.println("No se encontró una efeméride con ese código");
	        }
	    	}else {
	    		System.out.println("No hay efemérides para eliminar");
	    	}
		}
	private static void modificarEfemeride () {
		if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para modificar.");
            return;
        }
        System.out.println("\n-- Modificar Efeméride --");
        mostrarEfemeride();
        System.out.print("Ingrese el código de la efeméride a modificar: ");
        String codigoModificar = scanner.next();

        boolean encontrado = false;
        for (Efemeride efemeride : efemerides) {
            if (efemeride.getCodigo().equals(codigoModificar)) {
                encontrado = true;
                System.out.print("Ingrese el número del nuevo mes (1 - 12): ");
                int numMes = scanner.nextInt();
                while (numMes < 1 || numMes > 12) {
                    System.out.println("Número de mes inválido. Debe estar entre 1 y 12");
                    System.out.print("Ingrese el número del nuevo mes (1 - 12): ");
                    numMes = scanner.nextInt();
                }
                efemeride.setMes(Mes.values()[numMes - 1]);
                System.out.print("Ingrese el nuevo día: ");
                efemeride.setDia(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Ingrese el nuevo detalle: ");
                efemeride.setDetalle(scanner.nextLine());
                System.out.println("Efeméride modificada exitosamente!");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró una efeméride con ese código.");
        }
	}
	
}
