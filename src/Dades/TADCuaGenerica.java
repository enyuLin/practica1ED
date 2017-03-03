
package Dades;

import Exceptions.*;

/**
 * Interface per a definir el contenidor/col·lecció cua genèrica.
 * 
 * @author Enyu Lin i Óscar Lorite Jódar
 */
public interface TADCuaGenerica<E> {

	/**
	 * Afegeix un element a la cua sempre pel final.
	 *
	 * @param e - element a afegir
	 * @throws CuaPlena - la cua està plena i no es pot afegir l'element nou.
	 */
	public void encuar(E e) throws CuaPlena;

	/**
	 * Retorna i elimina el primer de la cua.
	 *
	 * @return element que hi ha a la primera posició de la pila.
	 * @throws CuaBuida - la cua està buida i no hi ha cap element per a retornar.
	 */
	public E desencuar() throws CuaBuida;

	/**
	 * Retorna el primer element de la cua.
	 *
	 * @return l'element que hi ha a la primera posició de la pila.
	 * @throws CuaBuida - La cua està buida i no hi ha cap element per a retornar.
	 */
	public E primer() throws CuaBuida;

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
	 * Retorna el numero d'element guardats a la cua.
	 * 
	 * @return nombre d'element guardats a la cua.
	 */
	public int numElements();

}
