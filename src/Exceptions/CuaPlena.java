package Exceptions;

/**
 * Classe CuaBuida que extend d'Exception per notifucar l'excepció quan una cua està plena.
 */
public class CuaPlena extends Exception {
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor.
	 */
	public CuaPlena(){
		super("ERROR : Cua plena i no podem afegir el valor ");
	}
	
}
