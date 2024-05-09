package ar.edu.unju.fi.Ejercicio5.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.Ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.Ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.Ejercicio5.model.Producto;

public class Main {

	public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Producto1", 10.0, true));
        productos.add(new Producto("Producto2", 20.0, true));
        productos.add(new Producto("Producto3", 30.0, true));
        productos.add(new Producto("Producto4", 40.0, true));
        productos.add(new Producto("Producto5", 50.0, true));
        productos.add(new Producto("Producto6", 60.0, false));
        productos.add(new Producto("Producto7", 70.0, false));
        productos.add(new Producto("Producto8", 80.0, false));
        productos.add(new Producto("Producto9", 90.0, true));
        productos.add(new Producto("Producto10", 100.0, true));
        productos.add(new Producto("Producto11", 110.0, true));
        productos.add(new Producto("Producto12", 120.0, true));
        productos.add(new Producto("Producto13", 130.0, false));
        productos.add(new Producto("Producto14", 140.0, false));
        productos.add(new Producto("Producto15", 150.0, true));
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menu de opciones:");
            System.out.println("1 - Mostrar productos");
            System.out.println("2 - Realizar compra");
            System.out.println("3 - Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarProductos(productos);
                    break;
                case 2:
                    realizarCompra(productos, scanner);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    public static void mostrarProductos(ArrayList<Producto> productos) {
    	System.out.println("Productos disponibles:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public static void realizarCompra(ArrayList<Producto> productos, Scanner scanner) {
    	double total = calcularTotal(productos);
    	System.out.println("Total a pagar: " + total);
        System.out.println("Seleccione el metodo de pago:");
        System.out.println("1 - Pago efectivo");
        System.out.println("2 - Pago con tarjeta");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                PagoEfectivo pagoEfectivo = new PagoEfectivo();
                pagoEfectivo.realizarPago(total);
                pagoEfectivo.imprimirRecibo();
                break;
            case 2:
                PagoTarjeta pagoTarjeta = new PagoTarjeta();
                pagoTarjeta.realizarPago(total);
                pagoTarjeta.imprimirRecibo();
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }
    
    public static double calcularTotal(ArrayList<Producto> productos) {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecioUnitario();
        }
        return total;
    }
}

