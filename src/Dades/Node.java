package Dades;

public class Node <E> {
	E valor;
	Node<E> seg;
	//Constructor
	public Node(E valor, Node<E> seg) {
		this.valor = valor;
		this.seg = seg;
	}
	
	public E getValor() {
		return valor;
	}
	public void setValor(E valor) {
		this.valor = valor;
	}
	public Node<E> getSeg() {
		return seg;
	}
	public void setSeg(Node<E> seg) {
		this.seg = seg;
	}
	
	
	
}
