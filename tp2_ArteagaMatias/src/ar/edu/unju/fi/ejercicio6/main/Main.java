package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoSalvaje felino = new FelinoSalvaje("Tanner", (byte)20, 186f);
		
		Converter<FelinoSalvaje, FelinoDomestico> converter = x -> {
			if (Converter.isNotNull(x)) {
				return new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
			}else {
				return null;
			}
		};
		
		FelinoDomestico gato = converter.convert(felino);
		converter.mostrarObjeto(gato);
		
	}

}