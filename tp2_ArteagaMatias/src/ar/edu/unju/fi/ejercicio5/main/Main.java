package ar.edu.unju.fi.ejercicio5.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		boolean salir = false;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Producto> productos = new ArrayList<>();
		ArrayList<Producto> carrito = new ArrayList<>();
		cargarProductos(productos);
		
		do {
			mostrarMenu();
			opcion = verificarEntradaDeDatoInt( scanner, "Ingrese numero de opcion: ");
			switch (opcion) {
			case 1:
				cargarCarrito(productos,carrito,scanner);
				break;
			case 2:
				if (!carrito.isEmpty()) {
					
				}else {
					System.out.println("El carrito de productos esta vacio.");
				}
				break;
			case 3:
				salir = true;
				System.out.println("Saliendo del menu.");
				break;
			default:
				System.out.println("Ingreso un numero de opcion invalido. Por favor vuelva a intentarlo.");
				break;
			}
		} while (salir == false);
		
		System.out.println("Fin del programa.");
		
		scanner.close();
	}
	
	private static void cargarCarrito(ArrayList<Producto> productos, ArrayList<Producto> carrito, Scanner scanner) {
		// TODO Auto-generated method stub
		
	}
	
	private static void cargarProductos(ArrayList<Producto> productos) {
		// TODO Auto-generated method stub
		productos.add(new Producto(111, "Mouse inalambrico", 23000.00, Producto.Paises.ARGENTINA, Producto.Categorias.INFORMATICA, true));
		productos.add(new Producto(111, "Mouse pad", 12000.00, Producto.Paises.ARGENTINA, Producto.Categorias.INFORMATICA, true));
		productos.add(new Producto(111, "Mouse gamer", 45000.00, Producto.Paises.ARGENTINA, Producto.Categorias.INFORMATICA, true));
		productos.add(new Producto(111, "Microondas", 156000.00, Producto.Paises.ARGENTINA, Producto.Categorias.ELECTROHOGAR, true));
		productos.add(new Producto(111, "Cafetera", 85000.00, Producto.Paises.ARGENTINA, Producto.Categorias.ELECTROHOGAR, true));
		productos.add(new Producto(111, "Licuadora", 65000.00, Producto.Paises.BRASIL, Producto.Categorias.ELECTROHOGAR, true));
		productos.add(new Producto(111, "Lijadora orbital", 92000.00, Producto.Paises.BRASIL, Producto.Categorias.HERRAMIENTAS, true));
		productos.add(new Producto(111, "Taladro inalambrico", 115000.00, Producto.Paises.BRASIL, Producto.Categorias.HERRAMIENTAS, true));
		productos.add(new Producto(111, "Caja de herramientas", 53000.00, Producto.Paises.BRASIL, Producto.Categorias.HERRAMIENTAS, true));
		productos.add(new Producto(111, "Celular Samsumg", 237000.00, Producto.Paises.BRASIL, Producto.Categorias.TELEFONIA, true));
		productos.add(new Producto(111, "Celular Poco", 133000.00, Producto.Paises.CHINA, Producto.Categorias.TELEFONIA, true));
		productos.add(new Producto(111, "Celular Motorola", 208000.00, Producto.Paises.CHINA, Producto.Categorias.TELEFONIA, true));
		productos.add(new Producto(111, "Teclado gamer", 141000.00, Producto.Paises.CHINA, Producto.Categorias.INFORMATICA, true));
		productos.add(new Producto(111, "Microfono para pc", 99000.00, Producto.Paises.CHINA, Producto.Categorias.INFORMATICA, true));
		productos.add(new Producto(111, "Headset", 87000.00, Producto.Paises.CHINA, Producto.Categorias.INFORMATICA, true));
	}
	
	public static int verificarEntradaDeDatoInt(Scanner scanner, String mensaje) {
		int entradaEntero = 0;
		boolean entradaValida = false;
		
		while (!entradaValida) {
			try {
				System.out.println(mensaje);
				entradaEntero = scanner.nextInt();
				entradaValida = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Error en el ingreso de datos. Debe ingresar un numero entero valido.");
				scanner.nextLine();
			}
		}
		
		return entradaEntero;
	}

	public static void mostrarMenu() {
		System.out.println( "Menu: " + "\n" +
							"1 – Mostrar Productos." + "\n" +
							"2 – Realizar compra." + "\n" +
							"3 – Salir.");
	}

}
