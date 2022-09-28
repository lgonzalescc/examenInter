package com.intercorp.examen.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class MatrizService {
	
	
	public String[][] convertirStringAMatriz(String matrizStr){
		
		// "[[1,2,3],[4,5,6],[7,8,9]]"
		try {
		
			matrizStr.replaceAll(" ", "");
			System.out.println("Matriz:" + matrizStr);
			String[] filas = matrizStr.split(Pattern.quote("],["));
			int dim_n = filas.length;
			
			String[][] matriz = new String[dim_n][dim_n];
			
			for(int m=0; m<filas.length; m++) {
				String filaLimpia = filas[m].replaceAll("\\[", "").replaceAll("\\]", "");
				String[] columnas = filaLimpia.split(",");
				for(int n=0; n<columnas.length; n++) {
					matriz[m][n] = columnas[n];
				}
			}
			imprimirMatriz(matriz);
			
			return matriz;
		}catch(Exception ex) {
			System.out.println("Error al convertir matriz");
			return null;
		}
		
	}
	
	public String rotarMatrizAntihorario(String[][] matriz) {
		try {
			String[][] nuevaMatriz = new String[matriz.length][matriz.length];
			int longitud = matriz.length - 1;
			for(int m=0; m<matriz.length; m++) {
				for(int n=0; n<matriz[0].length; n++) {
					nuevaMatriz[longitud - n][m] = matriz[m][n];
				}
			}
			
			imprimirMatriz(nuevaMatriz);
			
			String cadenaMatriz = "";
			for(int i=0; i<nuevaMatriz.length; i++) {
				String subconjunto = "";
				for(int j=0; j<nuevaMatriz[0].length; j++) {
					subconjunto += (subconjunto.length()>0?",":"") + nuevaMatriz[i][j];
				}
				cadenaMatriz += (cadenaMatriz.length()>0?",":"") + ("["+subconjunto+"]");
			}
			cadenaMatriz = "{\"matriz\":\"[" + cadenaMatriz + "]\"}";
			return cadenaMatriz;
		}catch(Exception ex) {
			System.out.println("Error al girar matriz");
			return null;
		}
	}
	
	private void imprimirMatriz(String[][] matriz) {
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[0].length; j++) {
				System.out.print(matriz[i][j] + "   ");
			}
			System.out.println("");
		}
	}
	
}
