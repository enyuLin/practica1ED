package Dades;

import Exceptions.*;

public class CuaEntVector implements TADCuaEnters {
	private int cua[];
	private int nElem;

	public CuaEntVector(int mida) {
		cua = new int[mida];
		nElem = 0;
	}

	public void encuar(int e) throws CuaPlena {
		if (nElem == cua.length)
			throw new CuaPlena(e);
		nElem++;
		cua[nElem-1] = e;
	}

	public int desencuar() throws CuaBuida {
		if (nElem == 0)
			throw new CuaBuida();
		int primer = cua[0];
		for (int i=0; i<(nElem-1); i++)
			cua[i] = cua[i+1];
		nElem--;
		return primer;
	}

	public int primer() throws CuaBuida {
		if (nElem == 0)
			throw new CuaBuida();
		return cua[0];
	}

	public boolean esBuida() {
		return (nElem == 0);
	}

	public boolean esPlena() {
		return nElem == cua.length;
	}

	public int numElements() {
		return nElem;
	}

}
