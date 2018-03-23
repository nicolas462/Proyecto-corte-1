import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Esta clase lee la cadena gen�tica para encontrar motif
 * @author Nicol�s Espejo
 *
 */
public class Lector {
	//Funci�n para mostrar la secuencia
	public void Imprimir() {
		try {
			FileReader fr = new FileReader ("secuencia.txt"); //Lee el archivo .txt
			BufferedReader br = new BufferedReader (fr);
			
			String line = br.readLine();
			while (line != null) //Mientras la la l�nea no sea nula, no contenga nada.
			{
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch (Exception ex) {}
	}
	public void motif(int motif) {
		try {
			FileReader fr = new FileReader("secuencia.txt"); //Leer archivo
			BufferedReader br = new BufferedReader(fr);//Almacena la lectura del archivo
			String line = br.readLine();//Se crea un string donde se almacena una l�nea del archivo
			int contador = 0;
			int auxiliar = 0;
			String repetido = "";
			while (line != null) {
			String [] datos = line.split(",");
			String [] secuencias = new String [datos [0].length() - motif];//Se almacenan las secuencias en un vector.
			for (int i=0; i< datos[0].length() - motif; i++) { 
				secuencias [i] =(datos [0].substring(i, i+motif));
				System.out.println(secuencias [i]);
			}
			for (int j=0; j<= datos[0].length() - motif; j++) { //Se empiezan a comparar las secuencias.
				
				for (int k = 0; k<datos[0].length() - motif; k++) {
						if (secuencias[k].equals(secuencias[j])) {
							contador ++;
							
							if (auxiliar>contador) {
								repetido = secuencias[k];
							}
							else
								repetido = "No hay";
						}
						auxiliar = contador;
				}
				System.out.println(secuencias[j] + " " + contador);
				contador =0;
				System.out.println("Es: " + repetido);
			}
			}
			
		}
		catch (Exception ex) {}	
	}
	public static void main(String[] args) throws IOException {
		
	}

}
