package Aplicacio;

import java.io.*;
import java.util.Scanner;
import Dades.*;
import Exceptions.*;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws CuaPlena, CuaBuida {
		Scanner teclat = new Scanner(System.in);
		TADCuaGenerica<Integer> cuaG = null;
		TADCuaEnters cuaE = null;
		Queue<Integer> cuaCollection = new LinkedList<Integer>();
		int opcio = 0;

		// Pregunntar a l'usuari les 4 diferents implementacions
		try {
			System.out.println(
					"Indiqui el tipus de Cua a utilitzar:\n\t1. Vector\n\t2. Circular \n\t3. Dinamica\n\t4. Estruc. de Java.Util.Collection");
			opcio = Integer.parseInt(teclat.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println("Format de l'opció incorrecte!");
		}

		// Preguntar a l'usuari el nom del fitxer
		try {
			System.out.println("Indiqui el nom del fitxer:");
			String fitxerE = teclat.nextLine().trim();
			BufferedReader f = new BufferedReader(new FileReader(fitxerE));

			// Preguntar a l'usuari si es vol xifrar o desxifrar
			System.out.println("Triï l'opció de xifratge:\n\t 1.Xifrar. \n\t 2.Desxifrar");
			int opcioXifratge = 0;
			try {
				opcioXifratge = Integer.parseInt(teclat.nextLine().trim());
			} catch (NumberFormatException e) {
				System.out.println("Format incorrecte de l'opció introduïda!");
			}

			// Preguntar a l'usuari la clau a utilitzar
			System.out.println("Indiqui la clau:");
			String clau = teclat.nextLine().trim();

			if (opcio == 1) {
				cuaE = new CuaEntVector(clau.length());
				for (int i = 0; i < clau.length(); i++)
					cuaE.encuar(clau.charAt(i) - '0');
			} else if (opcio == 2) {
				cuaE = new CuaEntCircular(clau.length());
				for (int i = 0; i < clau.length(); i++)
					cuaE.encuar(clau.charAt(i) - '0');
			} else if (opcio == 3) {
				cuaG = new CuaEntDinamica<Integer>();
				for (int i = 0; i < clau.length(); i++)
					cuaG.encuar(clau.charAt(i) - '0');
			} else if (opcio == 4) {
				// Opcio de java.util.collection
				for (int i = 0; i < clau.length(); i++)
					cuaCollection.add(clau.charAt(i) - '0');
			}

			String nomFitxer = fitxerE.substring(0, fitxerE.indexOf('.'));
			BufferedWriter fitxerS = null;
			try {
				if (opcioXifratge == 1)
					fitxerS = new BufferedWriter(new FileWriter(nomFitxer + "_vX.txt"));
				else if (opcioXifratge == 2)
					fitxerS = new BufferedWriter(new FileWriter(nomFitxer + "_vD.txt"));
				String fraseE = f.readLine();

				while (fraseE != null) {
					String fraseS = "";
					int desplaza = 0;
					int valorE = 0;
					char lletra;
					for (int i = 0; i < fraseE.length(); i++) {
						lletra = fraseE.charAt(i);
						valorE = (int) lletra;
						if (esLletraAlfabetic(lletra)) {
							if (opcio == 1 || opcio == 2)
								desplaza = cuaE.desencuar();
							else if (opcio == 3)
								desplaza = cuaG.desencuar();
							else if (opcio == 4)
								desplaza = cuaCollection.remove();

							if (opcioXifratge == 1) {
								if  (lletra >= 'A' && lletra <= 'Z') 
									valorE = (int)((lletra - 'A' + desplaza) % 26 + 'A');
								else 
									valorE = (int)((lletra - 'a' + desplaza) % 26 + 'a');
							} else if (opcioXifratge == 2) {
								if  (lletra >= 'A' && lletra <= 'Z') {
									valorE = (int)('A'+ (lletra - 'A' - desplaza) % 26);
									if (valorE < 'A')
										valorE += 26;
								}else {
									valorE = (int)('a' + (lletra - 'a' - desplaza) % 26);
									if (valorE < 'a')
										valorE += 26;
								}
							}

							if (opcio == 1 || opcio == 2)
								cuaE.encuar(desplaza);
							else if (opcio == 3)
								cuaG.encuar(desplaza);
							else if (opcio == 4)
								cuaCollection.add(desplaza);
						}
						fraseS += "" + (char) valorE;
					}
					// System.out.println("fraseS: "+ fraseS);
					fitxerS.write(fraseS);
					fitxerS.newLine();
					fraseE = f.readLine();
				}
				fitxerS.close();
			} catch (IOException e) {
				System.out.println("S'ha produit un error en el fitxer de sortida!");
			}
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fitxer introduït no existeix");
		} catch (IOException e) {
			System.out.println("S'ha produït un error general d'E/S");

		}
		teclat.close();
	}

	public static boolean esLletraAlfabetic(char c) {
		return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
	}

}
