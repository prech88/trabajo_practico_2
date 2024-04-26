package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(811611,53219), SALTA(1441351,155488), TUCUMAN(1687305,22525), CATAMARCA(429562,102602), LA_RIOJA(383865,89680), SANTIAGO_DEL_ESTERO(896461,136351);
	
	
	private Integer CANTIDAD_POBLACION;
	private Integer SUPERFICIE;
	
	private Provincia(Integer cANTIDAD_POBLACION, Integer sUPERFICIE) {
		CANTIDAD_POBLACION = cANTIDAD_POBLACION;
		SUPERFICIE = sUPERFICIE;
	}

	public Integer getCANTIDAD_POBLACION() {
		return CANTIDAD_POBLACION;
	}

	public Integer getSUPERFICIE() {
		return SUPERFICIE;
	}
	
	public double calcularDensidadPoblacional() {
        return (double) CANTIDAD_POBLACION / SUPERFICIE;
    }
	
}
