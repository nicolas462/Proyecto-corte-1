import java.io.*;
import java.util.Scanner;

/**
 * Esta clase lee la cadena gen�tica para encontrar motif
 * @author Nicol�s Espejo
 *
 */
public class Lector {
	public int contador = 0, auxiliar = 0;
	public String repetido= "";
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
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
			String line = br.readLine();//Se crea un string donde se almacena una l�nea del archivo			
			String [] datos = line.split(",");//Se apartan los datos por comas y se guardan en vectores.
			String [] secuencias = new String [datos [0].length() - motif];//Se almacenan las secuencias en un vector.
			/*while (line != null) {*/
			for (int i=0; i< datos[0].length() - motif; i++)
			{ 
				secuencias[i]=datos[0].substring(i, i+motif);
				/*bw.write (datos [0].substring(i, i+motif));
				bw.newLine();*/
			}
			//}
			 
			for (int j=0; j<datos[0].length() - motif; j++) //Se empiezan a comparar las secuencias.
			{ 
				for (int k = 0; k<datos[0].length() - motif; k++) 
				{
						if (secuencias[k].equals(secuencias[j])) //Se comparan las secuencias.
						{
							contador ++;
							if (contador >= auxiliar)
								if (contador > 1) {
								auxiliar = contador; //Se almacena el mayor n�mero de repeticiones.
								repetido = secuencias[k];
								}	
						}
	
				}
				//System.out.println(secuencias[j] + " " + contador);
				
				contador =0;
				
				
			
			}
			System.out.println("La subcadena " + repetido + " se repite " + auxiliar + " veces");
		}
		catch (Exception ex) {}	
	}
	public static void main(String[] args) throws IOException {
		
	}

}
