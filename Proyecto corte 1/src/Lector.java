import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	public static void main(String[] args) throws IOException {
		Lector lctr = new Lector();
		lctr.Imprimir();
		FileReader fr = new FileReader("secuencia.txt"); //Leer archivo
		BufferedReader br = new BufferedReader(fr);//Almacena la lectura del archivo
		String line = br.readLine();//Se crea un string donde se traslada lo almacenado en el b�ffer
		System.out.println(line);
		
		String [] datos = line.split(",");
		System.out.println(datos[0]);
		System.out.println(datos[1]);
		System.out.println(datos[2]);
		System.out.println(datos[3]);
		
	}

}
