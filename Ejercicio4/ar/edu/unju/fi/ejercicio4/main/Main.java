package ar.edu.unju.fi.ejercicio4.main;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;


public class Main {
	public static ArrayList<Jugador> jugadores = new ArrayList<>();
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int option = 0;
		do {
			mostrarMenu();
			option = scanner.nextInt();
			scanner.nextLine();
			switch (option) {
			case 1: altaJugador();
				break;
			case 2: mostrarJugadores();
				break;
			case 3: modificarJugador();
			break;
			case 4: eliminarJugador();
			break;
			case 5: System.out.println("Saludos hasta luego!");
			break;
			default:
				System.out.println("Opcion incorrecta! Vuelva a ingresar para salir o elegir una opcion!");
			}
		}while (option!=5);
		

	}
	private static void mostrarMenu () {
		System.out.println("\n-- Menú --");
        System.out.println("1 - Alta de Jugador");
        System.out.println("2 - Mostrar Todos los jugadores");
        System.out.println("3 - Modificar la posición de un jugador ");
        System.out.println("4 - Eliminar un jugador ");
        System.out.println("5 - Salir");
        System.out.print("Elija una opción: ");
	}
	
	
	public static void altaJugador () {
		System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();
        System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
        /*try {
        	LocalDate fechaNacimiento = LocalDate.parse(scanner.next());
		} catch (DateTimeException e) {
			System.out.println("No se puede convertir la fecha ");
			System.out.println("Ingrese valores enteros y tal cual lo indica");
			boolean fechacorrecta = false; 
			do {
				System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
				try {
                    LocalDate fechaNacimiento = LocalDate.parse(scanner.next());
                    fechacorrecta = true;
                    System.out.println("Fecha de nacimiento: " + fechaNacimiento);
                } catch (DateTimeParseException ex) {
                    System.out.println("Fecha inválida. Inténtelo nuevamente.");
                }
			}while(!fechacorrecta);
		}finally {
			scanner.close();
		}*/
        LocalDate fechaNacimiento = LocalDate.parse(scanner.next());
        System.out.print("Ingrese la nacionalidad del jugador: ");
        String nacionalidad = scanner.next();
        System.out.print("Ingrese la estatura del jugador: ");
        double estatura = scanner.nextDouble();
        System.out.print("Ingrese el peso del jugador: ");
        double peso = scanner.nextDouble();
        System.out.print("Ingrese la posición del jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
        Posicion posicion = Posicion.valueOf(scanner.next().toUpperCase());
        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
        jugadores.add(jugador);
	}
	
	public static void mostrarJugadores () {
		if (jugadores.isEmpty()) {
			System.out.println("No hay jugadores que mostrar");
			return;
		}
		System.out.println("\n--- JUGADORES ----");
		for (Jugador j : jugadores) {
			System.out.println(j);
		}
	}
	
	public static void modificarJugador () {
		System.out.print("Ingrese el nombre del jugador: ");
        String nombreModificar = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellidoModificar = scanner.next();
        boolean encontrado = false;
        Iterator<Jugador> iterator = jugadores.iterator();
        while (iterator.hasNext()) {
            Jugador j = iterator.next();
            if (j.getNombre().equalsIgnoreCase(nombreModificar) && j.getApellido().equalsIgnoreCase(apellidoModificar)) {
                System.out.print("Ingrese la nueva posición del jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
                Posicion nuevaPosicion = Posicion.valueOf(scanner.next().toUpperCase());
                j.setPosicion(nuevaPosicion);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró al jugador.");
        }
	}
	
	public static void eliminarJugador () {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombreEliminar = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellidoEliminar = scanner.next();
        Iterator<Jugador> iterator= jugadores.iterator();
        while (iterator.hasNext()) {
            Jugador j = iterator.next();
            if (j.getNombre().equalsIgnoreCase(nombreEliminar) && j.getApellido().equalsIgnoreCase(apellidoEliminar)) {
                iterator.remove();
                System.out.println("Jugador eliminado correctamente.");
            }
        }
	}
}
