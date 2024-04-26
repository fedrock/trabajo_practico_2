package ar.edu.unju.fi.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.model.Categoria;
import ar.edu.unju.fi.model.OrigenFabricacion;
import ar.edu.unju.fi.model.Producto;

public class Main {
	private static ArrayList<Producto> productos = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		 
		 int option = 0;
		 
		 do {
			 mostrarMenu();
			 option = scanner.nextInt();
			 scanner.nextLine();
			 switch (option) {
			case 1:
				crearProductos();;
				break;
			case 2:
				mostrarProductos();;
				break;
			case 3:
				modificarProductos();;
				break;
			default:
				break;
			}
		 }while (option!= 4);
		 
		 
		 
		
	}
	private static void mostrarMenu () {
		System.out.println("\n-- Menú --");
        System.out.println("1 - Crear Producto");
        System.out.println("2 - Mostrar Productos");
        System.out.println("3 - Modificar Producto");
        System.out.println("4 - Salir");
        System.out.print("Elija una opción: ");
	}
	private static void crearProductos () {
		Producto producto = new Producto();
		System.out.println("Ingrese el codigo del producto: ");
		producto.setCodigo(scanner.nextLine());
		System.out.println("Ingrese la descripcion del producto: ");
		producto.setDescripcion(scanner.nextLine());
		System.out.println("Ingrese el precio unitario del producto: ");
		producto.setPrecioUnitario(scanner.nextDouble());
		scanner.nextLine();
       
		System.out.println("\n---- Origen de fabricación -----");
        System.out.println("1 - Argentina");
        System.out.println("2 - China");
        System.out.println("3 - Brasil");
        System.out.println("4 - Uruguay");
        System.out.print("Elija una opción: ");
        int opcionOrigen = scanner.nextInt();
        switch (opcionOrigen) {
            case 1:
                producto.setOrigenFabricacion(OrigenFabricacion.ARGENTINA);
                break;
            case 2:
                producto.setOrigenFabricacion(OrigenFabricacion.CHINA);
                break;
            case 3:
                producto.setOrigenFabricacion(OrigenFabricacion.BRASIL);
                break;
            case 4:
                producto.setOrigenFabricacion(OrigenFabricacion.URUGUAY);
                break;
            default:
                System.out.println("Opción inválida. Se establecerá el origen de fabricación como Argentina.");
                producto.setOrigenFabricacion(OrigenFabricacion.ARGENTINA);
        }

        System.out.println("\n------ Categoría ------");
        System.out.println("1 - Telefonía");
        System.out.println("2 - Informática");
        System.out.println("3 - Electro hogar");
        System.out.println("4 - Herramientas");
        System.out.print("Elija una opción: ");
        int opcionCategoria = scanner.nextInt();
        switch (opcionCategoria) {
            case 1:
                producto.setCategoria(Categoria.TELEFONIA);
                break;
            case 2:
                producto.setCategoria(Categoria.INFORMATICA);
                break;
            case 3:
                producto.setCategoria(Categoria.ELECTROHOGAR);
                break;
            case 4:
                producto.setCategoria(Categoria.HERRAMIENTAS);
                break;
            default:
                System.out.println("Opción inválida. Se establecerá la categoría como Telefonía.");
                producto.setCategoria(Categoria.TELEFONIA);
        }

        productos.add(producto);
        System.out.println("Producto creado exitosamente.");
		
	}
	private static void mostrarProductos() {
		if (productos.isEmpty()) {
			System.out.println("No hay productos que mostrar");
			return;
		}
		System.out.println("\n--- Productos ----");
		for (Producto producto : productos) {
			System.out.println(producto);
		}
	}
	
	private static void modificarProductos () {
		if (productos.isEmpty()) {
            System.out.println("No hay productos para modificar.");
            return;
        }
        System.out.println("\n-- Modificar Producto --");
        mostrarProductos();
        System.out.print("Ingrese el código del producto a modificar: ");
        String codigoModificar = scanner.next();

        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigoModificar)) {
                encontrado = true;
                System.out.println("¿Qué desea modificar?");
                System.out.println("1 - Descripción");
                System.out.println("2 - Precio Unitario");
                System.out.println("3 - Origen de Fabricación");
                System.out.println("4 - Categoría");
                System.out.println("5 - Cancelar");
                System.out.print("Elija una opción: ");
                int opcionModificar = scanner.nextInt();
                switch (opcionModificar) {
                    case 1:
                        System.out.print("Ingrese la nueva descripción: ");
                        producto.setDescripcion(scanner.next());
                        break;
                    case 2:
                        System.out.print("Ingrese el nuevo precio unitario: ");
                        producto.setPrecioUnitario(scanner.nextDouble());
                        break;
                    case 3:
                        System.out.println("\n---- Origen de fabricación -----");
                        System.out.println("1 - Argentina");
                        System.out.println("2 - China");
                        System.out.println("3 - Brasil");
                        System.out.println("4 - Uruguay");
                        System.out.print("Elija una opción: ");
                        int opcionOrigen = scanner.nextInt();
                        switch (opcionOrigen) {
                            case 1:
                                producto.setOrigenFabricacion(OrigenFabricacion.ARGENTINA);
                                break;
                            case 2:
                                producto.setOrigenFabricacion(OrigenFabricacion.CHINA);
                                break;
                            case 3:
                                producto.setOrigenFabricacion(OrigenFabricacion.BRASIL);
                                break;
                            case 4:
                                producto.setOrigenFabricacion(OrigenFabricacion.URUGUAY);
                                break;
                            default:
                                System.out.println("Opción inválida. Se mantendrá el origen de fabricación actual.");
                        }
                        break;
                    case 4:
                        System.out.println("\n------ Categoría ------");
                        System.out.println("1 - Telefonía");
                        System.out.println("2 - Informática");
                        System.out.println("3 - Electro hogar");
                        System.out.println("4 - Herramientas");
                        System.out.print("Elija una opción: ");
                        int opcionCategoria = scanner.nextInt();
                        switch (opcionCategoria) {
                            case 1:
                                producto.setCategoria(Categoria.TELEFONIA);
                                break;
                            case 2:
                                producto.setCategoria(Categoria.INFORMATICA);
                                break;
                            case 3:
                                producto.setCategoria(Categoria.ELECTROHOGAR);
                                break;
                            case 4:
                                producto.setCategoria(Categoria.HERRAMIENTAS);
                                break;
                            default:
                                System.out.println("Opción inválida. Se mantendrá la categoría actual.");
                        }
                        break;
                    case 5:
                        System.out.println("Operación cancelada.");
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
                System.out.println("Producto modificado exitosamente.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró un producto con ese código.");
        }
	}

}
