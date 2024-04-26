package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

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
				modificarDatosJugador(jugadores, scanner);
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

	private static void modificarDatosJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
		System.out.println("Para modificar un jugador ingrese los datos del jugador" + "\n" + "Nombre de jugador: ");
		String nombre = scanner.next();
		System.out.println("Ingrese apellido: ");
		String apellido = scanner.next();
		boolean noEncontrado = true;
		int indice = 0;
		for (Jugador jugador : jugadores) {
			if (nombre.equals(jugador.getNombre())&&apellido.equals(jugador.getApellido())) {
				System.out.println("Jugador encontrado. Ingrese los nuevos datos:");
				jugadores.set(indice, cargarJugador(scanner));
				System.out.println("Jugador modificado exitosamente.");
				noEncontrado = false;
				break;
			}
			indice++;
		}
		if (noEncontrado) {
			System.out.println("No se encontro jugador");
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
		return jugadorNuevo;
	}

	public static void mostrarMenu() {
		System.out.println( "Menu: " + "\n" +
							"1 – Alta de jugador." + "\n" +
							"2 – Mostrar los datos del jugador." + "\n" +
							"3 – Mostrar todos los jugadores ordenados por apellido." + "\n" +
							"4 – Modificar los datos de un jugador." + "\n" +
							"5 – Eliminar un jugador." + "\n" +
							"6 – Mostrar la cantidad total de jugadores que tiene el ArrayList." + "\n" +
							"7 – Mostrar la cantidad de jugadores que pertenecen a una nacionalidad." + "\n" +
							"8 – Salir.");
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
