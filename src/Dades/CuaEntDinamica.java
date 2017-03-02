package Dades;

import Exceptions.*;

public class CuaEntDinamica implements TADCuaEnters {
	private Node primer;
	private Node ultim;

	// Constructor
	public CuaEntDinamica() {
		primer = null;
		ultim = null;
	}

	public void encuar(int e) throws CuaPlena {
		if (primer == null) {
			ultim = new Node(e, null);
			primer = ultim;
		} else {
			Node nou = new Node(e, null);
			primer.setSeg(nou);
			primer = nou;
		}
	}

	public int desencuar() throws CuaBuida {
		if (ultim == null)
			throw new CuaBuida();
		int valorPrimer = primer.getValor();
		if (primer == ultim) {
			primer = null;
			ultim = null;
		} else {
			primer = primer.getSeg();
		}
		return valorPrimer;
	}

	public int primer() throws CuaBuida {
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
