package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

public class Main {

	public static void main(String[] args) {
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
				mostrarProductos(productos);
				break;
			case 2:
				realizarCompra(productos,carrito,scanner);
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
	
	private static void realizarCompra(ArrayList<Producto> productos, ArrayList<Producto> carrito, Scanner scanner) {
		boolean salir = false;
		do {
			mostrarMenuCompra();
			int opcion = verificarEntradaDeDatoInt( scanner, "Ingrese numero de opcion: ");
			switch (opcion) {
			case 1:
				cargarCarrito(productos, carrito, scanner);
				break;
			case 2:
				if (!carrito.isEmpty()) {
					pagar(carrito, scanner);
				}else {
					System.out.println("El carrito de compras esta vacio.");
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
	}

	private static void pagar(ArrayList<Producto> carrito, Scanner scanner) {
		boolean salir = false;
		Double total = 0.0;
		do {
			mostrarMenuPagar();
			int opcion = verificarEntradaDeDatoInt( scanner, "Ingrese numero de opcion: ");
			switch (opcion) {
			case 1:
				PagoEfectivo nuevoPago = new PagoEfectivo();
				for (Producto producto : carrito) {
					total = total + producto.getPrecioUnitario();
				}
				nuevoPago.setFechaDePago(LocalDate.now());
				nuevoPago.realizarPago(total);
				nuevoPago.imprimirRecibo();
				carrito.clear();
				salir = true;
				System.out.println("Se pago exitosamente");
				break;
			case 2:
				PagoTarjeta nuevoPagoTarjeta = new PagoTarjeta();
				for (Producto producto : carrito) {
					total = total + producto.getPrecioUnitario();
				}
				System.out.println("Ingrese numero de tarjeta: ");
				nuevoPagoTarjeta.setNumeroDeTarjeta(scanner.next());
				nuevoPagoTarjeta.setFechaDePago(LocalDate.now());
				nuevoPagoTarjeta.realizarPago(total);
				nuevoPagoTarjeta.imprimirRecibo();
				carrito.clear();
				salir = true;
				System.out.println("----- Se pago exitosamente -----");
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
	}

	private static void mostrarProductos(ArrayList<Producto> productos) {
		for (Producto producto : productos) {
			if (producto.getInStock()) {
				System.out.println(producto);
			}
		}
	}

	private static void cargarCarrito(ArrayList<Producto> productos, ArrayList<Producto> carrito, Scanner scanner) {
		int indice = 0;
		boolean productoEncotrado = false;
		int codigo = verificarEntradaDeDatoInt(scanner, "Ingrese codigo de producto que desea poner en el carrito: ");
		for (Producto producto : productos) {
			if (producto.getCodigo() == codigo && producto.getInStock()) {
				productoEncotrado = true;
				break;
			}
			indice++;
		}
		if (productoEncotrado) {
			carrito.add(productos.get(indice));
			productos.get(indice).setInStock(false);
		}else {
			System.out.println("Producto no encontrado. Revise la lista de productos.");
		}
	}
	
	private static void cargarProductos(ArrayList<Producto> productos) {
		productos.add(new Producto(100, "Mouse inalambrico", 23000.00, Producto.Paises.ARGENTINA, Producto.Categorias.INFORMATICA, true));
		productos.add(new Producto(102, "Mouse pad", 12000.00, Producto.Paises.ARGENTINA, Producto.Categorias.INFORMATICA, true));
		productos.add(new Producto(103, "Mouse gamer", 45000.00, Producto.Paises.ARGENTINA, Producto.Categorias.INFORMATICA, true));
		productos.add(new Producto(104, "Microondas", 156000.00, Producto.Paises.ARGENTINA, Producto.Categorias.ELECTROHOGAR, true));
		productos.add(new Producto(105, "Cafetera", 85000.00, Producto.Paises.ARGENTINA, Producto.Categorias.ELECTROHOGAR, true));
		productos.add(new Producto(106, "Licuadora", 65000.00, Producto.Paises.BRASIL, Producto.Categorias.ELECTROHOGAR, true));
		productos.add(new Producto(107, "Lijadora orbital", 92000.00, Producto.Paises.BRASIL, Producto.Categorias.HERRAMIENTAS, true));
		productos.add(new Producto(108, "Taladro inalambrico", 115000.00, Producto.Paises.BRASIL, Producto.Categorias.HERRAMIENTAS, true));
		productos.add(new Producto(109, "Caja de herramientas", 53000.00, Producto.Paises.BRASIL, Producto.Categorias.HERRAMIENTAS, true));
		productos.add(new Producto(110, "Celular Samsumg", 237000.00, Producto.Paises.BRASIL, Producto.Categorias.TELEFONIA, true));
		productos.add(new Producto(111, "Celular Poco", 133000.00, Producto.Paises.CHINA, Producto.Categorias.TELEFONIA, true));
		productos.add(new Producto(112, "Celular Motorola", 208000.00, Producto.Paises.CHINA, Producto.Categorias.TELEFONIA, true));
		productos.add(new Producto(113, "Teclado gamer", 141000.00, Producto.Paises.CHINA, Producto.Categorias.INFORMATICA, true));
		productos.add(new Producto(114, "Microfono para pc", 99000.00, Producto.Paises.CHINA, Producto.Categorias.INFORMATICA, true));
		productos.add(new Producto(115, "Headset", 87000.00, Producto.Paises.CHINA, Producto.Categorias.INFORMATICA, true));
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
	
	public static void mostrarMenuPagar() {
		System.out.println( "Menu: " + "\n" +
							"1 – Pago en efectivo." + "\n" +
							"2 – Pago con tarjeta." + "\n" +
							"3 – Salir.");
	}
	
	public static void mostrarMenuCompra() {
		System.out.println( "Menu: " + "\n" +
							"1 – Cargara Productos al carrito." + "\n" +
							"2 – Pagar." + "\n" +
							"3 – Salir.");
	}

	public static void mostrarMenu() {
		System.out.println( "Menu: " + "\n" +
							"1 – Mostrar Productos." + "\n" +
							"2 – Realizar compra." + "\n" +
							"3 – Salir.");
	}

}
