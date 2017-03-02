package Dades;

public class Node {
	int valor;
	Node seg;
	//Constructor
	public Node(int valor, Node seg) {
		this.valor = valor;
		this.seg = seg;
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public Node getSeg() {
		return seg;
	}
	public void setSeg(Node seg) {
		this.seg = seg;
	}
	
	
	
}
