package Exceptions;

/**
 * Classe CuaBuida que extend d'Exception per notifucar l'excepció quan una cua està buida.
 */
public class CuaBuida extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public CuaBuida() {
		super("ERROR: Cua Buida!");
		
	}
}
