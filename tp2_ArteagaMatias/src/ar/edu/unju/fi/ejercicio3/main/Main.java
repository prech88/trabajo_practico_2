package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		Provincia[] provincias = Provincia.values();
		
		for (Provincia provincia : provincias) {
			System.out.println("----------------------------------------");
            System.out.println("Provincia: " + provincia);
            System.out.println("Cantidad de población: " + provincia.getCANTIDAD_POBLACION());
            System.out.println("Superficie: " + provincia.getSUPERFICIE());
            System.out.println("Densidad poblacional: " + provincia.calcularDensidadPoblacional());
            System.out.println("----------------------------------------");
        }
	}

}
