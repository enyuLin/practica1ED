package Aplicacio;

import java.io.*;
import java.util.Scanner;
import Dades.*;
import Exceptions.*;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	
	/**
	 * Mètode principal de l'aplicació.
	 * @param args
	 * @throws CuaPlena
	 * @throws CuaBuida
	 */
	public static void main(String[] args) throws CuaPlena, CuaBuida {
		Scanner teclat = new Scanner(System.in);
		TADCuaGenerica<Integer> cuaG = null; // Variable per la cua de memòria dinàmica.
		TADCuaEnters cuaE = null; // Variable per la cua estàtica (cua normal i cua circular)
		Queue<Integer> cuaCollection = new LinkedList<Integer>(); // Cua d'estructura de java.util.collection
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

			// Inicialitzem les respectives cues depenent de l'opció triat per l'usuari.
			if (opcio == 1) {
				// Cua d'un vector i amb un índex de posició.
				cuaE = new CuaEntVector(clau.length());
				// Afegim cada xifra de la clau a la cua utilitzant el mètode encuar()
				for (int i = 0; i < clau.length(); i++)
					cuaE.encuar(clau.charAt(i) - '0');
			} else if (opcio == 2) {
				// Cua circular
				cuaE = new CuaEntCircular(clau.length());
				for (int i = 0; i < clau.length(); i++)
					cuaE.encuar(clau.charAt(i) - '0');
			} else if (opcio == 3) {
				// Cua dinàmica
				cuaG = new CuaEntDinamica<Integer>();
				for (int i = 0; i < clau.length(); i++)
					cuaG.encuar(clau.charAt(i) - '0');
			} else if (opcio == 4) {
				// Cua de java.util.collection
				for (int i = 0; i < clau.length(); i++)
					cuaCollection.add(clau.charAt(i) - '0');
			}

			String nomFitxer = fitxerE.substring(0, fitxerE.indexOf('.')); // Nom del fitxer entrant sense el format.
			BufferedWriter fitxerS = null;
			try {
				// Afegim el nom del fitxer entrant 'vX' o 'vD' segons si estem xifrant o desxifrant.
				if (opcioXifratge == 1)
					fitxerS = new BufferedWriter(new FileWriter(nomFitxer + "_vX.txt"));
				else if (opcioXifratge == 2)
					fitxerS = new BufferedWriter(new FileWriter(nomFitxer + "_vD.txt"));

				String fraseE = f.readLine(); // Llegim la primera frase del fitxer entrant
				long tempsExec = System.nanoTime(); // Variable per retornat el temps d'execució dels diferents implementacions de la cua.
				while (fraseE != null) {
					// Iteració per llegir totes les frases del fitxer entrant.
					String fraseS = "";
					int desplaza = 0;
					int valorE = 0;
					char lletra;
					for (int i = 0; i < fraseE.length(); i++) {
						// Iterem cada caràcter de la frase per tractar de xifrar o desxifrar.
						lletra = fraseE.charAt(i);
						valorE = (int) lletra;
						// Només apliquem la clau quan el caràcter és dintre de la franja [A-Z] o [a-z]
						if (esLletraAlfabetic(lletra)) {
							// Retornem una clau de la cua ( la que estigui a la primera de la cua).
							if (opcio == 1 || opcio == 2)
								desplaza = cuaE.desencuar();
							else if (opcio == 3)
								desplaza = cuaG.desencuar();
							else if (opcio == 4)
								desplaza = cuaCollection.remove();
							// Segons l'opció de xifratge (desxifrant o xifrant) elegit per l'usuari, apliquem un desplaçament o
							// l'altre.
							if (opcioXifratge == 1) {
								// Xifrant:
								if (lletra >= 'A' && lletra <= 'Z')
									valorE = (int) ((lletra - 'A' + desplaza) % 26 + 'A');
								else
									valorE = (int) ((lletra - 'a' + desplaza) % 26 + 'a'); // Per les minúscules.
							} else if (opcioXifratge == 2) {
								// Desxifrant:
								if (lletra >= 'A' && lletra <= 'Z') {
									valorE = (int) ('A' + (lletra - 'A' - desplaza) % 26);
									if (valorE < 'A')
										valorE += 26; // Si el caràcter a l'aplicar el desplaçament és petit que 'A', llavors
														// sumem 26 posicions.
								} else {
									valorE = (int) ('a' + (lletra - 'a' - desplaza) % 26);
									if (valorE < 'a')
										valorE += 26;
								}
							}
							// Després d'haver aplicat la clau, l'afegim a l'última de la cua. Així, quan s'acaba l'últim digit,
							// tornarem a començar pel primer.
							if (opcio == 1 || opcio == 2)
								cuaE.encuar(desplaza);
							else if (opcio == 3)
								cuaG.encuar(desplaza);
							else if (opcio == 4)
								cuaCollection.add(desplaza);
						}
						fraseS += "" + (char) valorE; // Afegim el caràcter (aplicat la clau o no) a la frase resultant.
					}
					fitxerS.write(fraseS); // La frase resultant l'escriurem al fitxer resultant.
					fitxerS.newLine();
					fraseE = f.readLine();
				}
				tempsExec = System.nanoTime() -tempsExec;
				System.out.println(" El temps que ha tardat en aplicar el xifratge a tot el fitxer és:  " + tempsExec + " ns.");
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

	/**
	 * Mètode estàtica per indicar-nos si una lletra és alfabètica. Inclou les majúscules i les minúscules. Però estan exloses els
	 * vocals amb accents.
	 * 
	 * @param c la lletra a comprovar
	 * @return cert si la lletra és alfabètica. Fals en cas contrari.
	 */
	public static boolean esLletraAlfabetic(char c) {
		return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
	}

}
