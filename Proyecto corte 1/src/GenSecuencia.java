import java.util.Random;
import java.util.Scanner;
import java.io.*;

/**
 * Esta clase genera secuencias genéticas aleatorias
 * @author Nicolás Espejo
 *
 */
public class GenSecuencia {
	/**
	 * Genera aleatoriamente un nucleótido
	 * @return A, C, G T, sea el caso
	 */
	public static String nucletoide ()
	{
		Random rd = new Random();
		switch(rd.nextInt(4))
		{
		case 0: return "A";
		case 1: return "C";
		case 2: return "G";
		case 3: return "T";
		default: return "";
		}
	}
	
	/**
	 * Recursión para generar secuencia
	 * @param length
	 * @return Secuencia junta
	 */
	public static String sequence(int length)
	{
		if (length == 1)
			return nucletoide();
		else
			return nucletoide() + sequence(length - 1);
	}
	
	/**
	 * Genera cromosomas
	 * @return Número del 1 - 24
	 */
	public static String chromosome() 
	{
		Random rd = new Random();
		return "chr" + rd.nextInt(23) + 1;
	}
	
	/**
	 * Crea el archivo. txt
	 */
	public static void createFile() 
	{
		try 
		{
			FileWriter fl = new FileWriter("secuencia.txt"); //Escritor del archivo
			BufferedWriter bw = new BufferedWriter(fl); //Buffer del escritor
			Random rd = new Random();
			int length, start, datasize = 100; // datasize = Cuántas líneas tendrá
			String experimental_read; // Se almacenarán los datos aleatorios para posteriormente escribirlos con un buffer
		
			for(int i=0; i< datasize; i++) 
			{
				length = rd.nextInt(46) + 5;
				start = rd.nextInt(1000) + 1;
				experimental_read = (sequence(length) + "," + chromosome() + "," + start + "," + (start + length - 1));
				bw.write(experimental_read + "\n");
			}
			
			bw.flush();	//Guarda la secuencia en el buffer
			bw.close();
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		try {
			BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
			createFile();
			Lector lctr = new Lector();
			//lctr.Imprimir();
			bw.write("Ingrese el tamaño del motif:");
			bw.flush();
			int size = Integer.parseInt(br.readLine());
			lctr.generateCombinations("", size);
			bw.write("Motif ganador: " + lctr.motif_winner + "\t" + "Ocurrencias: " + lctr.max_occurrences);
			bw.flush();
		}
		catch (Exception ex) {}
	}
}
