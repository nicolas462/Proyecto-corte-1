import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
			String line = br.readLine();//Se crea un string donde se almacena una línea del archivo
			System.out.println(line);
			
			String [] datos = line.split(",");
			System.out.println(datos[0]);
			System.out.println(datos[1]);
			System.out.println(datos[2]);
			System.out.println(datos[3]);

			for (int i=0; i< datos[0].length() - motif; i++) {
				System.out.println(datos [0].substring(i, i+motif));
			}
		}
		catch (Exception ex) {}
		
	}
	public static void main(String[] args) throws IOException {
		
	}

}
