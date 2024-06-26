package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		int opcion;
		boolean salir = false;
		ArrayList<Jugador> jugadores = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		do {
			mostrarMenu();
			opcion = verificarEntradaDeDatoInt( scanner, "Ingrese opcion de operacion: ");
			switch (opcion) {
			case 1:
				jugadores.add(cargarJugador(scanner));
				break;
			case 2:
				if (!jugadores.isEmpty()) {
					for (Jugador jugador : jugadores) {
						System.out.println(jugador);
					} 
				}else {
					System.out.println("La lista de jugadores esta vacia.");
				}
				break;
			case 3:
				modificarPosicionJugador(jugadores, scanner);
				break;
			case 4:
				eliminarJugador(jugadores, scanner);
				break;
			case 5:
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

	private static void eliminarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {		
		if (jugadores.isEmpty()) {
			System.out.println("La lista de jugadores esta vacia.");
		}else {
			System.out.println("Para eliminar un jugador ingrese los datos del jugador" + "\n" + "Nombre de jugador: ");
			String nombre = scanner.next();
			System.out.println("Ingrese apellido: ");
			String apellido = scanner.next();
			boolean noEncontrado = true;
			Iterator<Jugador> iterator = jugadores.iterator();
			while (iterator.hasNext()) {
				Jugador jugador = (Jugador) iterator.next();
				if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
					iterator.remove();
					noEncontrado = false;
					System.out.println("Se elimino el jugador.");
				}
			}
			if (noEncontrado) {
				System.out.println("No se encontro jugador.");
			}
		}
	}

	private static void modificarPosicionJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
		if (!jugadores.isEmpty()) {
			System.out.println("Para modificar un jugador ingrese los datos del jugador" + "\n" + "Nombre de jugador: ");
			String nombre = scanner.next();
			System.out.println("Ingrese apellido: ");
			String apellido = scanner.next();
			boolean noEncontrado = true;
			int indice = 0;
			for (Jugador jugador : jugadores) {
				if (nombre.equals(jugador.getNombre()) && apellido.equals(jugador.getApellido())) {
					System.out.println("Jugador encontrado. Ingrese nueva posicion de jugador:");
					jugadores.get(indice).setPosicion(cargarPocicion(scanner));
					System.out.println("Jugador modificado exitosamente.");
					noEncontrado = false;
					break;
				}
				indice++;
			}
			if (noEncontrado) {
				System.out.println("No se encontro jugador");
			} 
		}else {
			System.out.println("La lista de jugadores esta vacia.");
		}
	}

	private static Jugador cargarJugador(Scanner scanner) {
		Jugador jugadorNuevo = new Jugador();
		System.out.println("---------- Ingresar nuevo jugador ----------" + "\n" + "Ingrese nombre de jugador: ");
		jugadorNuevo.setNombre(scanner.next());
		System.out.println("Ingrese apellido de jugador: ");
		jugadorNuevo.setApellido(scanner.next());
		jugadorNuevo.setFechaDeNacimiento(verificarFecha(scanner, "Ingrese fecha de nacimiento Formato(Formato: dd/MM/yyyy): "));
		System.out.println("Ingrese nacionalidad de jugador: ");
		jugadorNuevo.setNacionalidad(scanner.next());		
		jugadorNuevo.setEstatura(verificarEntradaDeDatoFloat(scanner, "Ingrese estatura de jugador: "));
		jugadorNuevo.setPeso(verificarEntradaDeDatoInt(scanner, "Ingrese peso de jugador: "));
		jugadorNuevo.setPosicion(cargarPocicion(scanner));
		return jugadorNuevo;
	}

	private static Posicion cargarPocicion(Scanner scanner) {
		boolean posicionFueraDeRango = true;
		Posicion nuevaPosicion = null;
		do {
			int indice = 0;
			System.out.println("------ Categoría ------");
			for (Posicion posicion : Posicion.values()) {
				indice++;
				System.out.println(indice + " - " + posicion);
			}
			int opcion = verificarEntradaDeDatoInt(scanner, "Seleccione numero de posicion: ");
			if (opcion > 0 && opcion <= Posicion.values().length) {
				nuevaPosicion = Posicion.values()[opcion-1];
				posicionFueraDeRango = false;
			} else {
				System.out.println("No selecciono una opcion de pocicion valida. Vuelva a intentarlo.");
			} 
		} while (posicionFueraDeRango);
		return nuevaPosicion;
	}

	public static void mostrarMenu() {
		System.out.println( "----- Menu ----- " + "\n" +
							"1 – Alta de jugador." + "\n" +
							"2 – Mostrar todos los jugadores." + "\n" +
							"3 – Modificar posicion de un jugador." + "\n" +
							"4 – Eliminar un jugador." + "\n" +
							"5 – Salir.");
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
	
	public static Float verificarEntradaDeDatoFloat(Scanner scanner, String mensaje) {
		Float entradaNumero = 0f;
		boolean entradaValida = false;
		
		while (!entradaValida) {
			try {
				System.out.println(mensaje);
				entradaNumero = scanner.nextFloat();
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
	
	public static LocalDate verificarFecha(Scanner scanner, String mensaje) {
		LocalDate eleccion = LocalDate.now();
		boolean eleccionCorrecta = false;
		String fechadenacimientoString;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		do {
			try {
				System.out.println(mensaje);
				fechadenacimientoString = scanner.next();
				eleccion = LocalDate.parse(fechadenacimientoString, formatter);
				eleccionCorrecta = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Ingreso un formato de fecha erroneo. Por favvor ingrese una fecha con el formato correspondiente");
			}
		} while (!eleccionCorrecta);
		return eleccion;
	}

}
