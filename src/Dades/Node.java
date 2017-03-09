package Dades;


/**
 * Classe que representa un node per un tipus genèric.
 *
 * @param <E> el tpus d'elelemt
 */
public class Node <E> {
	// Atributs
	E valor;
	Node<E> seg;
	
	/**
	 * Constructor.
	 *
	 * @param valor El nou valor.
	 * @param seg El node que apunta el següent node.
	 */
	public Node(E valor, Node<E> seg) {
		this.valor = valor;
		this.seg = seg;
	}
	
	/**
	 * Getter del valor.
	 *
	 * @return el valor del 'valor'.
	 */
	public E getValor() {
		return valor;
	}
	
	/**
	 * Setter del valor.
	 *
	 * @param valor El nu valor a assignar
	 */
	public void setValor(E valor) {
		this.valor = valor;
	}
	
	/**
	 * Getter del node  següent.
	 *
	 * @return el node següent.
	 */
	public Node<E> getSeg() {
		return seg;
	}
	
	/**
	 * Setter del node següent.
	 *
	 * @param seg el nou node següent.
	 */
	public void setSeg(Node<E> seg) {
		this.seg = seg;
	}
		
}
