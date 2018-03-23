import java.io.*;
import java.util.Scanner;

/**
 * Esta clase lee la cadena genética para encontrar motif
 * @author Nicolás Espejo
 *
 */
public class Lector {
	//Función para mostrar la secuencia
	public void Imprimir() {
		try {
			FileReader fr = new FileReader ("secuencia.txt"); //Lee el archivo .txt
			BufferedReader br = new BufferedReader (fr);
			
			String line = br.readLine();
			while (line != null) //Mientras la la línea no sea nula, no contenga nada.
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
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
			String line = br.readLine();//Se crea un string donde se almacena una línea del archivo
			int contador = 0;
			int auxiliar = 0;
			String repetido = "";
			
			String [] datos = line.split(",");//Se apartan los datos por comas y se guardan en vectores.
			String [] secuencias = new String [datos [0].length() - motif];//Se almacenan las secuencias en un vector.
			/*while (line != null) {*/
			for (int i=0; i< datos[0].length() - motif; i++) { 
				bw.write (datos [0].substring(i, i+motif));
				bw.newLine();
				}
			/*}*/
			 
			for (int j=0; j<= datos[0].length() - motif; j++) //Se empiezan a comparar las secuencias.
			{ 
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
		catch (Exception ex) {}	
	}
	public static void main(String[] args) throws IOException {
		
	}

}
