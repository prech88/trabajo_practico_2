package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		int opcion;
		boolean salir = false;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Efemeride> efemerides = new ArrayList<>();
		
		do {
			mostrarMenu();
			opcion = verificarEntradaDeDatoInt( scanner, "Ingrese numero de opcion: ");
			switch (opcion) {
			case 1:
				cargarEfemeride(efemerides,scanner);
				break;
			case 2:
				if (!efemerides.isEmpty()) {
					for (Efemeride efemeride : efemerides) {
						System.out.println(efemeride);
					}
				}else {
					System.out.println("La lista de Efemerides esta vacia.");
				}
				break;
			case 3:
				eliminarEfemeride(efemerides,scanner);
				break;
			case 4:
				modificarEfemeride(efemerides,scanner);
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
	
	private static void modificarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

	private static void eliminarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

	private static void cargarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
		Efemeride nuevafemeride = new Efemeride();
		nuevafemeride.setCodigo(verificarEntradaDeDatoInt(scanner, "Ingrese codigo de Efemeride"));
		nuevafemeride.setMes(cargarMes(scanner));
		nuevafemeride.setDia(cargarDia(scanner,nuevafemeride));
		System.out.println("Ingrese detalle de Efemeride: ");
		nuevafemeride.setDetalle(scanner.next());
		efemerides.add(nuevafemeride);
	}

	private static Short cargarDia(Scanner scanner, Efemeride nuevafemeride) {
		boolean diaValido = false;
		Short nuevoDia = 0;
		do {
			nuevoDia = verificarEntradaDeDatoShort(scanner, "Ingrese dia del mes: ");
			if (nuevoDia > 0 && nuevoDia < 32 && (nuevafemeride.getMes().name().equals("ENERO")||
					nuevafemeride.getMes().name().equals("MARZO")||
					nuevafemeride.getMes().name().equals("MAYO")||
					nuevafemeride.getMes().name().equals("JULIO")||
					nuevafemeride.getMes().name().equals("AGOSTO")||
					nuevafemeride.getMes().name().equals("OCTUBRE")||
					nuevafemeride.getMes().name().equals("DICIEMBRE"))) {
				diaValido = true;
			}
			if (nuevoDia > 0 && nuevoDia < 31 && (nuevafemeride.getMes().name().equals("ABRIL")||
					nuevafemeride.getMes().name().equals("JUNIO")||
					nuevafemeride.getMes().name().equals("SEPTIEMBRE")||
					nuevafemeride.getMes().name().equals("NOVIEMBRE"))) {
				diaValido = true;
			}
			if (nuevoDia > 0 && nuevoDia < 29 && nuevafemeride.getMes().name().equals("FEBRERO")) {
				diaValido = true;
			}
			if (!diaValido) {
				System.out.println("Cargo un dia invalido respecto al mes elegido. Vuelva a intentarlo.");
			}
		} while (!diaValido);
		return nuevoDia;
	}

	private static Mes cargarMes(Scanner scanner) {
		boolean mesFueraDeRango = true;
		Mes nuevoMes = null;
		do {
			int opcion = verificarEntradaDeDatoInt(scanner, "Seleccione numero del mes: ");
			if (opcion > 0 && opcion <= Mes.values().length) {
				nuevoMes = Mes.values()[opcion-1];
				mesFueraDeRango = false;
			} else {
				System.out.println("No selecciono una opcion de mes valida. Vuelva a intentarlo. Elija entre 1 y 12 para los meses");
			} 
		} while (mesFueraDeRango);
		return nuevoMes;
	}

	public static void mostrarMenu() {
		System.out.println( "Menu: " + "\n" +
							"1 – Crear efeméride." + "\n" +
							"2 – Mostrar efemérides." + "\n" +
							"3 – Eliminar efeméride." + "\n" +
							"4 – Modificar efeméride." + "\n" +
							"5 – Salir.");
	}
	
	public static Integer verificarEntradaDeDatoInt(Scanner scanner, String mensaje) {
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
	
	public static Short verificarEntradaDeDatoShort(Scanner scanner, String mensaje) {
		short entradaEntero = 0;
		boolean entradaValida = false;
		
		while (!entradaValida) {
			try {
				System.out.println(mensaje);
				entradaEntero = scanner.nextShort();
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

}
