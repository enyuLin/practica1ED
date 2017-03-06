package Dades;

import Exceptions.*;

public class CuaEntCircular implements TADCuaEnters {
	// Atributs
	private int nElem;
	private int primer;
	private int ultim;
	private int[] cua;

	// Constructor
	public CuaEntCircular(int mida) {
		cua = new int[mida];
		ultim = 0;
		primer = 0;
		nElem = 0;
	}

	public void encuar(int e) throws CuaPlena {
		if (nElem >= cua.length)
			throw new CuaPlena(e);
		cua[ultim] = e;
		ultim = (ultim + 1) % cua.length;
		nElem++;
	}

	public int desencuar() throws CuaBuida {
		if (nElem == 0)
			throw new CuaBuida();
		int e = cua[primer];
		nElem--;
		primer = (primer + 1) % cua.length;
		return e;
	}

	public int primer() throws CuaBuida {
		if (nElem == 0)
			throw new CuaBuida();
		return cua[primer];
	}

	public boolean esBuida() {
		return nElem == 0;
	}

	public boolean esPlena() {
		return (nElem == cua.length);
	}

	public int numElements() {
		return nElem;
	}

}
