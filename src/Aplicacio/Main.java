package Aplicacio;

import java.io.*;
import java.util.Scanner;
import Dades.*;

public class Main {

	public static void main(String[] args) {
		Scanner teclat = new Scanner(System.in);
		TADCuaGenerica<Integer> pilaG = null;
		TADCuaEnters pilaE;

		// Pregunntar a l'usuari les 4 diferents implementacions
		System.out.println(
				"Indiqui el tipus de Cua a utilitzar:\n\t1. Vector\n\t2. Circular \n\t3. Dinamica\n\t4. Estruc. de Java.Util.Collection");
		int opcio = Integer.parseInt(teclat.nextLine().trim());

		if (opcio == 1) {
			pilaE = new CuaEntVector(30);
		} else if (opcio==2){
			pilaE = new CuaEntCircular(30);
		} else if (opcio== 3) {
			pilaG = new CuaEntDinamica<Integer>();
		} else {
			// Opcio de java.util.collection
		}
		
		// Preguntar a l'usuari el nom del fitxer
		try {
			System.out.println("Indiqui el nom del fitxer:");
			String fileNom = teclat.nextLine().trim();
			BufferedReader f = new BufferedReader(new FileReader(fileNom));
			
			// Preguntar a l'usuari si es vol xifrar o desxifrar
			System.out.println("Triï l'opció de xifratge:\n\t 1.Xifrar. \n\t 2.Desxifrar");
			int opcioXifratge=0;
			try{
				opcioXifratge = Integer.parseInt(teclat.nextLine().trim());
			} catch(NumberFormatException e){
				System.out.println("Format incorrecte de l'opció introduïda!");
			}
			
			// Preguntar a l'usuari la clau a utilitzar
			System.out.println("Indiqui la clau:");
			int clau = 0;
			try {
				clau = Integer.parseInt(teclat.nextLine().trim());
				System.out.println("Clau:"+clau);
			}catch(NumberFormatException e){
				System.out.println("Format incorrecte de la clau introduïda!");
			}
			
			if (opcioXifratge==1){
				
			}else if(opcioXifratge==2){
				
			}
			
		
			
			
			f.close();
			
		} catch (FileNotFoundException e){
			System.out.println("El fitxer introduït no existeix");
		} catch(IOException e){
			System.out.println("S'ha produït un error general d'E/S");
			
		}
		
		
		teclat.close();
	}

	// Mètode per comprovar que la clau introduïda per l'usuari sigui numèrica
	public static boolean esValorNumeric(String valor) {
		try {
			Integer.parseInt(valor);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
