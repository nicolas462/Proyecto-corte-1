import java.util.Random;
import java.util.Scanner;
import Lectura.Lector;
import java.io.*;

/**
 * Esta clase genera secuencias genéticas aleatorias
 * @author Nicolás Espejo
 *
 */
public class GenSecuencia {
//Función que retorna un valor String (A,C,G,T)
public static String secuencia () {
	Random rd = new Random();
	switch (rd.nextInt(4)) {
		case 1: return "A";
		case 2: return "C";
		case 3: return "G";
		case 0: return "T";
			default: return " ";
	}
}
//Función que crea la secuencia
public static String seq(int num) {
	if (num ==1)
		return secuencia();
	else
		return secuencia() + seq(num-1);
}
//Función que genera "chr" + número random
public static String cromosomas() {
	Random rd = new Random();
	return "chr" + rd.nextInt(23) + 1;
}
//Función que retorna un número aleatorio 1-1000
public static int inicio(int ri) {
	return ri;
}
//Función que crea el archivo .txt
public static void createfile() throws IOException{
	FileWriter fl = new FileWriter("secuencia.txt"); //Escritor del archivo
	BufferedWriter bw = new BufferedWriter(fl); //Buffer del escritor
	int n=1000;
	Random rd = new Random();
	Random rdi = new Random();
	try {
		for(int i=0; i<1000; i++) {
			int num = rd.nextInt(46)+5;
			int ri = rdi.nextInt(1000)+1;
			int fin = ri+num-1;
			bw.write(seq(num) + "," + cromosomas() + "," + inicio(ri)+","+ fin + "\n");
		}
		bw.flush();	//Guarda la secuencia en el buffer
	}
	catch (Exception ex) {}
}
public static void main(String[] args) throws IOException {
	GenSecuencia cf = new GenSecuencia(); 
	cf.createfile();
	Lector lctr = new Lector();
	lctr.Imprimir();
	}
}
