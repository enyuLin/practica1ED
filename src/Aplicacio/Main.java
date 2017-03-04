package Aplicacio;

import java.io.*;
import java.util.Scanner;
import Dades.*;
import Exceptions.CuaBuida;
import Exceptions.CuaPlena;

public class Main {

	public static void main(String[] args) throws CuaPlena, CuaBuida {
		Scanner teclat = new Scanner(System.in);
		TADCuaGenerica<Integer> cuaG = null;
		TADCuaEnters cuaE;

		// Pregunntar a l'usuari les 4 diferents implementacions
		System.out.println(
				"Indiqui el tipus de Cua a utilitzar:\n\t1. Vector\n\t2. Circular \n\t3. Dinamica\n\t4. Estruc. de Java.Util.Collection");
		int opcio = Integer.parseInt(teclat.nextLine().trim());

		
		
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
			String clau = teclat.nextLine().trim();
			
			if (opcio == 1) {
				cuaE = new CuaEntVector(clau.length());
				for (int i=0; i<clau.length();i++)
					cuaE.encuar(clau.charAt(i)-'0');
			} else if (opcio==2){
				cuaE = new CuaEntCircular(clau.length());
				for (int i=0; i<clau.length();i++)
					cuaE.encuar(clau.charAt(i)-'0');
			} else if (opcio== 3) {
				cuaG = new CuaEntDinamica<Integer>();
				for (int i=0; i<clau.length();i++)
					cuaG.encuar(clau.charAt(i)-'0');
			} else {
				// Opcio de java.util.collection
			}
			
				
			/*
			try {
				clau = Integer.parseInt(teclat.nextLine().trim());
				//System.out.println("Clau:"+clau);
			}catch(NumberFormatException e){
				System.out.println("Format incorrecte de la clau introduïda!");
			}
			*/
			
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
