package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {

	public static void main(String[] args) {
		int opcion;
		boolean salir = false;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Producto> productos = new ArrayList<>();
		cargarProductos(productos);
		
		do {
			mostrarMenu();
			opcion = verificarEntradaDeDatoInt( scanner, "Ingrese numero de opcion: ");
			switch (opcion) {
			case 1:
				mostrarProductos(productos);
				break;
			case 2:
				mostrarProductosFaltantes(productos);
				break;
			case 3:
				incrementarPrecios(productos);
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
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
	
	private static void incrementarPrecios(ArrayList<Producto> productos) {
		Function<Producto,Producto> functionIncrementarPrecio = x -> {x.setPrecioUnitario(x.getPrecioUnitario()*1.2);return x;};
		List<Producto> productosNuevoPrecio = productos.stream().map(functionIncrementarPrecio).collect(Collectors.toList());
		mostrarProductos(new ArrayList<>(productosNuevoPrecio));
	}

	private static void mostrarProductosFaltantes(ArrayList<Producto> productos) {
		Predicate<Producto> filterProduct = x -> !x.getInStock();
		List<Producto> productosSinStock = productos.stream().filter(filterProduct).collect(Collectors.toList());
		mostrarProductos(new ArrayList<>(productosSinStock));
	}

	public static void mostrarProductos(ArrayList<Producto> productos) {
		Consumer<Producto> printConsumerProd = x -> System.out.println(x);
		productos.forEach(printConsumerProd);
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
							"2 – Mostrar los productos faltantes." + "\n" +
							"3 – Incrementar los precios de los productos en un 20%." + "\n" +
							"4 – Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta." + "\n" +
							"5 – Ordenar los productos por precio de forma descendente." + "\n" +
							"6 – Mostrar los productos con los nombres en mayúsculas." + "\n" +
							"7 – Salir.");
	}
	
	private static void cargarProductos(ArrayList<Producto> productos) {
		productos.add(new Producto(101, "Mouse inalambrico", 23000.00, Producto.Paises.ARGENTINA, Producto.Categorias.INFORMATICA, true));
		productos.add(new Producto(102, "Mouse pad", 12000.00, Producto.Paises.ARGENTINA, Producto.Categorias.INFORMATICA, true));
		productos.add(new Producto(103, "Mouse gamer", 45000.00, Producto.Paises.ARGENTINA, Producto.Categorias.INFORMATICA, false));
		productos.add(new Producto(104, "Microondas", 156000.00, Producto.Paises.ARGENTINA, Producto.Categorias.ELECTROHOGAR, true));
		productos.add(new Producto(105, "Cafetera", 85000.00, Producto.Paises.ARGENTINA, Producto.Categorias.ELECTROHOGAR, false));
		productos.add(new Producto(106, "Licuadora", 65000.00, Producto.Paises.BRASIL, Producto.Categorias.ELECTROHOGAR, true));
		productos.add(new Producto(107, "Lijadora orbital", 92000.00, Producto.Paises.BRASIL, Producto.Categorias.HERRAMIENTAS, true));
		productos.add(new Producto(108, "Taladro inalambrico", 115000.00, Producto.Paises.BRASIL, Producto.Categorias.HERRAMIENTAS, false));
		productos.add(new Producto(109, "Caja de herramientas", 53000.00, Producto.Paises.BRASIL, Producto.Categorias.HERRAMIENTAS, true));
		productos.add(new Producto(110, "Celular Samsumg", 237000.00, Producto.Paises.BRASIL, Producto.Categorias.TELEFONIA, true));
		productos.add(new Producto(111, "Celular Poco", 133000.00, Producto.Paises.CHINA, Producto.Categorias.TELEFONIA, false));
		productos.add(new Producto(112, "Celular Motorola", 208000.00, Producto.Paises.CHINA, Producto.Categorias.TELEFONIA, true));
		productos.add(new Producto(113, "Teclado gamer", 141000.00, Producto.Paises.CHINA, Producto.Categorias.INFORMATICA, true));
		productos.add(new Producto(114, "Microfono para pc", 99000.00, Producto.Paises.CHINA, Producto.Categorias.INFORMATICA, false));
		productos.add(new Producto(115, "Headset", 87000.00, Producto.Paises.CHINA, Producto.Categorias.INFORMATICA, true));
	}

}
