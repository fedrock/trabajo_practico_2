package ar.edu.unju.fi.Ejercicio7.main;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import ar.edu.unju.fi.Ejercicio7.model.Producto;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Producto> productos = new ArrayList<>();
		productos.add(new Producto("Lavadora", 500.0, true, "Electrohogar"));
		productos.add(new Producto("Televisor", 700.0, true, "Electrohogar"));
        productos.add(new Producto("Laptop", 1000.0, false, "Informática"));
        productos.add(new Producto("Licuadora", 50.0, true, "Electrohogar"));
        productos.add(new Producto("Horno", 300.0, false, "Electrohogar"));
        productos.add(new Producto("Nevera", 800.0, true, "Electrohogar"));
        productos.add(new Producto("Teléfono", 200.0, true, "Telefonía"));
        productos.add(new Producto("Aspiradora", 150.0, false, "Electrohogar"));
        productos.add(new Producto("Cafetera", 80.0, true, "Electrohogar"));
        productos.add(new Producto("Microondas", 200.0, false, "Electrohogar"));
        productos.add(new Producto("Secadora", 400.0, true, "Electrohogar"));
        productos.add(new Producto("Plancha", 30.0, true, "Electrohogar"));
        productos.add(new Producto("Exprimidor", 40.0, false, "Electrohogar"));
        productos.add(new Producto("Batidora", 60.0, true, "Electrohogar"));
        productos.add(new Producto("Estufa", 250.0, true, "Electrohogar"));
        int option = 0;
        do {
        	mostrarMenu ();
			 option = scanner.nextInt();
			 scanner.nextLine();
        	switch (option) {
			case 1: mostrarProductos(productos, p -> p.isEstado(), p -> System.out.print("\n"+p));
				break;
			case 2: mostrarProductos(productos, p -> !p.isEstado(), p -> System.out.print("\n"+p));
			break;
			case 3: 
				ArrayList<Producto> productosIncrementados = incrementarPrecios(productos, p -> p.getPrecio()*1.20);
				mostrarProductos(productosIncrementados, p -> true, p -> System.out.println(p));
                break;
            case 4:
                mostrarProductos(productos, p -> p.isEstado() && p.getCategoria().equals("Electrohogar"), p -> System.out.println(p));
                break;
            case 5:
                ordenarProductosPorPrecioDescendente(productos);
                mostrarProductos(productos, p -> true, p -> System.out.println(p));
                break;
            case 6:
                mostrarProductos(productos, p -> true, p -> System.out.println(p.getNombre().toUpperCase()));
                break;	
				
			default:
				break;
			}
        	
        	
        }while (option !=7);
        scanner.close();

	}
	
	private static void mostrarMenu () {
        System.out.println("\n Menú de opciones:");
        System.out.println("1 - Mostrar productos disponibles");
        System.out.println("2 - Mostrar productos no disponibles");
        System.out.println("3 - Incrementar precios en un 20%");
        System.out.println("4 - Mostrar productos de la categoría Electrohogar disponibles");
        System.out.println("5 - Ordenar productos por precio de forma descendente");
        System.out.println("6 - Mostrar nombres de productos en mayúsculas");
        System.out.println("7 - Salir");
	}
	
	private static void mostrarProductos(ArrayList<Producto> productos, Predicate<Producto> filtro, Consumer<Producto> action) {
		productos.stream().filter(filtro).forEach(action);
		
	}
	//Profe no me sale el incremento si pudiera ayudarme, gracias
	private static ArrayList<Producto> incrementarPrecios(ArrayList<Producto> productos, Function<Producto, Double> mapper ) {
		return (ArrayList<Producto>) productos.stream()
                .peek(p -> p.setPrecio(mapper.apply(p)))
                .toList();		
		
	}
	private static void ordenarProductosPorPrecioDescendente(ArrayList<Producto> productos) {
        productos.sort(Comparator.comparing(Producto::getPrecio).reversed());
    }
	
}
