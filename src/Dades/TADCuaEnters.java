package Dades;
import Exceptions.*;

public interface TADCuaEnters {
	
	public void encuar(int e) throws CuaPlena;
	
	public int desencuar() throws CuaBuida;
	
	public int primer() throws CuaBuida;
	
	public boolean esBuida();
	
	public boolean esPlena();
	
	public int numElements();
	
}
