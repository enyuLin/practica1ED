package Dades;

import Exceptions.*;

/**
 * Classe que representa el tipus per una cua dinàmica genèrica amb punters i refències.
 * 
 *
 */
public class CuaEntDinamica<E> implements TADCuaGenerica<E> {
	private Node<E> primer;
	private Node<E> ultim;

	// Constructor
	public CuaEntDinamica() {
		primer = null;
		ultim = null;
	}

	public void encuar(E e) throws CuaPlena {
		if (primer == null) {
			ultim = new Node<E>(e, null);
			primer = ultim;
		} else {
			Node<E> nou = new Node<E>(e, null);
			ultim.setSeg(nou);
			ultim = nou;
		}
	}

	public E desencuar() throws CuaBuida {
		if (ultim == null)
			throw new CuaBuida();
		E valorPrimer = primer.getValor();
		if (primer == ultim) {
			primer = null;
			ultim = null;
		} else {
			primer = primer.getSeg();
		}
		return valorPrimer;
	}

	public E primer() throws CuaBuida {
		if (primer == null)
			throw new CuaBuida();
		return primer.getValor();
	}

	public boolean esBuida() {
		return ultim == null;
	}

	public boolean esPlena() {
		return false;
	}

	public int numElements() {
		return 0;
	}
}
