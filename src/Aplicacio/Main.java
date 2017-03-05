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
		TADCuaEnters cuaE = null;
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
			} else {
				// Opcio de java.util.collection
			}

			String nomFitxer = fitxerE.substring(0, fitxerE.indexOf('.'));
			BufferedWriter fitxerS;
			if (opcioXifratge == 1) {
				// Estem xifrant
				try {
					fitxerS = new BufferedWriter(new FileWriter(nomFitxer + "_vX.txt"));
					String fraseE = f.readLine();
					while (fraseE != null) {
						String fraseS = "";
						int desplaza = 0;
						int valorE = 0;
						for (int i = 0; i < fraseE.length(); i++) {
							if (opcio == 1 || opcio == 2)
								desplaza = cuaE.desencuar();
							else if (opcio == 3)
								desplaza = cuaG.desencuar();
							valorE = (int) fraseE.charAt(i);
							valorE += desplaza % 255;
							fraseS += "" + (char) valorE;
							if (opcio == 1 || opcio == 2)
								cuaE.encuar(desplaza);
							else if (opcio == 3)
								cuaG.encuar(desplaza);
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
			} else if (opcioXifratge == 2) {
				// Estem desxifrant
				try {
					fitxerS = new BufferedWriter(new FileWriter(nomFitxer + "_vD.txt"));
					String fraseE = f.readLine();
					while (fraseE != null) {
						String fraseS = "";
						int desplaza = 0;
						int valorE = 0;
						for (int i = 0; i < fraseE.length(); i++) {
							if (opcio == 1 || opcio == 2)
								desplaza = cuaE.desencuar();
							else if (opcio == 3)
								desplaza = cuaG.desencuar();
							valorE = (int) fraseE.charAt(i);
							valorE -= desplaza % 255;
							fraseS += "" + (char) valorE;
							if (opcio == 1 || opcio == 2)
								cuaE.encuar(desplaza);
							else if (opcio == 3)
								cuaG.encuar(desplaza);
						}
						fitxerS.write(fraseS);
						fitxerS.newLine();
						fraseE = f.readLine();
					}
					fitxerS.close();

				} catch (IOException e) {
					System.out.println("S'ha produit un error en el fitxer de sortida!");
				}
			}
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fitxer introduït no existeix");
		} catch (IOException e) {
			System.out.println("S'ha produït un error general d'E/S");

		}
		teclat.close();
	}

}
