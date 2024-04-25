package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categorias;
import ar.edu.unju.fi.ejercicio1.model.Producto.Paises;

public class Main {

	public static void main(String[] args) {
		int opcion;
		boolean salir = false;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Producto> productos = new ArrayList<>();
		
		do {
			mostrarMenu();
			opcion = verificarEntradaDeDatoInt( scanner, "Ingrese numero de opcion: ");
			switch (opcion) {
			case 1:
				cargarProducto(productos,scanner);
				break;
			case 2:
				for (Producto producto : productos) {
					System.out.println(producto);
				}
				break;
			case 3:
				
				break;
			case 4:
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
	
	private static void cargarProducto(ArrayList<Producto> productos, Scanner scanner) {
		Producto nuevoProducto = new Producto();
		nuevoProducto.setCodigo(verificarEntradaDeDatoInt(scanner, "Ingrese codigo de producto: "));
		System.out.println("Ingrese descripcion del producto: ");
		nuevoProducto.setDescripcion(scanner.next());
		nuevoProducto.setPrecioUnitario(verificarEntradaDeDatoDouble(scanner, "Ingrese precio unitario del producto: "));
		nuevoProducto.setOrigenFabricacion(cargarPais(scanner));
		nuevoProducto.setCategoria(cargarCategoria(scanner));
		productos.add(nuevoProducto);
		System.out.println("------ Producto nuevo cargado exitosamente ------");
	}

	private static Categorias cargarCategoria(Scanner scanner) {
		boolean categoriaFueraDeRango = true;
		Categorias categoriaNuevo = null;
		do {
			int indice = 0;
			System.out.println("------ Categoría ------");
			for (Categorias categoria : Categorias.values()) {
				indice++;
				System.out.println(indice + " - " + categoria);
			}
			int opcion = verificarEntradaDeDatoInt(scanner, "Elija opcion de categoria de producto: ");
			if (opcion > 0 && opcion <= Categorias.values().length) {
				categoriaNuevo = Categorias.values()[opcion-1];
				categoriaFueraDeRango = false;
			} else {
				System.out.println("No selecciono una opcion de categoria valida. Vuelva a intentarlo.");
			} 
		} while (categoriaFueraDeRango);
		return categoriaNuevo;
	}

	private static Paises cargarPais(Scanner scanner) {
		boolean paisFueraDeRango = true;
		Paises paisNuevo = null;
		do {
			int indice = 0;
			System.out.println("---- Origen de fabricación ------");
			for (Paises pais : Paises.values()) {
				indice++;
				System.out.println(indice + " - " + pais);
			}
			int opcion = verificarEntradaDeDatoInt(scanner, "Elija opcion de pais de producto: ");
			if (opcion > 0 && opcion <= Paises.values().length) {
				paisNuevo = Paises.values()[opcion-1];
				paisFueraDeRango = false;
			} else {
				System.out.println("No selecciono una opcion de pais valida. Vuelva a intentarlo.");
			} 
		} while (paisFueraDeRango);
		return paisNuevo;
	}

	public static void mostrarMenu() {
		System.out.println( "Menu: " + "\n" +
							"1 – Crear Producto." + "\n" +
							"2 – Mostrar productos." + "\n" +
							"3 – Modificar producto." + "\n" +
							"4 – Salir.");
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
	
	public static Double verificarEntradaDeDatoDouble(Scanner scanner, String mensaje) {
		Double entradaNumero = 0.0;
		boolean entradaValida = false;
		
		while (!entradaValida) {
			try {
				System.out.println(mensaje);
				entradaNumero = scanner.nextDouble();
				entradaValida = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Error en el ingreso de datos. Debe ingresar un numero valido.");
				scanner.nextLine();
			}
		}
		
		return entradaNumero;
	}

}
