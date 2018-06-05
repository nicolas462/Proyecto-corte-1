import java.io.*;
import java.util.Scanner;



/**
 * Esta clase lee la cadena gen�tica para encontrar motif
 * @author Nicol�s Espejo
 *
 */
public class Lector {

	int max_occurrences = Integer.MIN_VALUE; //
	String motif_winner = ""; //
	
	/**
	 * 
	 */
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
	
	/**
	 * Cu�ntas veces se repite el motif
	 * @param motif - Secuencia elegida
	 * @return - Cantidad de veces que se encontr�
	 */
	public int counterOcurrences (String motif)
	{
		int counter =0;
		try 
		{
			FileReader file = new FileReader("secuencia.txt");
			BufferedReader br = new BufferedReader(file);
			
			String line = br.readLine();
			
			while (line != null) // Hasta que no haya nada en l�nea
		    {
				for (int i = 0; i < line.length() - motif.length() ; i++)
				{
					if (line.substring(i, i + motif.length()).equals(motif))  // Si es igual al motif el substring elegido
					{
						counter += 1;
						i+= motif.length() - 1;
					}	
				}
				
				line=br.readLine(); // Siguiente l�nea
		    }
		}    
		catch(Exception ex){}	
		return counter;
   }
	/**
	 * Genera las variaciones con repetici�n, o combinaciones
	 * @param subsequence
	 * @param size - Tama�o del motif
	 */
	public void generateCombinations(String subsequence, int size)
	{
		if(size == 1)
		{
			compareMotif(subsequence + "A");
			compareMotif(subsequence + "C");
			compareMotif(subsequence + "G");
			compareMotif(subsequence + "T");
		}
		else
		{
			generateCombinations(subsequence + "A", size - 1);
			generateCombinations(subsequence + "C", size - 1);
			generateCombinations(subsequence + "G", size - 1);
			generateCombinations(subsequence + "T", size - 1);
		}
	}
	
	/**
	 * 
	 * @param motif_candidate
	 */
	public void compareMotif(String motif_candidate)
	{
		int counter = counterOcurrences(motif_candidate);
		if(counter > max_occurrences)
		{
			max_occurrences = counter;
			motif_winner = motif_candidate;
		}
	}	
}
