
package Dades;

import Exceptions.*;

/**
 * Interface per a definir el contenidor/col·lecció cua d'enters.
 * 
 * @author Enyu Lin i Óscar Lorite Jódar
 */
public interface TADCuaEnters {

	/**
	 * Afegeix un enter a la cua sempre pel final.
	 *
	 * @param e enter a afegir
	 * @throws CuaPlena - la cua està plena i no es pot afegir el valor
	 */
	public void encuar(int e) throws CuaPlena;

	/**
	 * Retorna i elimina el primer de la cua.
	 *
	 * @return l'enter que hi ha a la primera posició de la pila.
	 * @throws CuaBuida - la cua està buida i no hi ha cap enter per a retornar.
	 */
	public int desencuar() throws CuaBuida;

	/**
	 * Retorna el primer enter de la cua.
	 *
	 * @return l'enter que hi ha a la primera posició de la pila.
	 * @throws CuaBuida - La cua està buida i no hi ha cap enter per a retornar.
	 */
	public int primer() throws CuaBuida;

	/**
	 * Retorna si la cua està buida
	 * 
	 * @return cert si la cua està buida, fals en cas contrari.
	 */
	public boolean esBuida();

	/**
	 * Retorna si la cua està plena.
	 * 
	 * @return cert si la cua està plena, fals en cas contrari.
	 */
	public boolean esPlena();

	/**
	 * Retorna el numero d'enters guardats a la cua.
	 * 
	 * @return nombre d'enters guardats a la cua.
	 */
	public int numElements();

}
