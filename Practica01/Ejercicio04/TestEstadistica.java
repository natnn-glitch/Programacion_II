package Ejercicio04;

import java.util.Scanner;

/**
 * TestEstadistica.java
 * Clase principal. Cuyo objetivo es probar la ejecución de la clase Estadistica.
 *
 * @author Natalia Tambo
 * @version 1.0 01/09/2026
 */
public class TestEstadistica {
    /** Método Principal */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese 10 números: ");
        double[] datos = new double[10];
        
        for(int i = 0; i < 10; i++) {
            datos[i] = input.nextDouble();
        }
        
        // Crea un objeto estadística
        Estadistica estadistica = new Estadistica(datos);
        
        System.out.println("El promedio es " + estadistica.promedio());
        System.out.println("La desviación estandard es " + estadistica.desviacion());
        
        input.close();
    }
}