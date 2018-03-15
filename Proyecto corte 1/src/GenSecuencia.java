import java.util.Random;
import java.util.Scanner;
import java.io.*;
/*
* Solution for a class project.
*
* Created by Nicolás David Espejo on Marcho 2018.
* Copyright (c) 2018 Nicolás David Espejo. All rights reserved.
*
* Proyecto FF.EE.DD is free software: you can redistribute it and/or modify it under the terms of the
* GNU General Public License as published by the Free Software Foundation, version 3.
*/

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
	}
}
