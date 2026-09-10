package Ejercicio04;

import java.util.Scanner;

/**
 * Obtiene el promedio y la desviación estándar de un conjunto de datos.
 *
 * @author Natalia Tambo
 * @version 1.0 01/09/2026
 */
public class Modular_Estructurado_Estadistica {
    /* Arreglo de datos numéricos */
    static double[] valores = new double[10];

    /* Retorna el promedio */
    public static double promedio() {
        double suma = 0;
        for (int i = 0; i < valores.length; i++) {
            suma += valores[i];
        }
        return suma / valores.length;
    }

    /* Retorna la desviación estándar */
    public static double desviacion() {
        double prom = promedio();
        double sumaDiferencias = 0;
        for (int i = 0; i < valores.length; i++) {
            sumaDiferencias += Math.pow(valores[i] - prom, 2);
        }
        return Math.sqrt(sumaDiferencias / (valores.length - 1));
    }

    /** Método Principal */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese 10 números: ");
        
        for (int i = 0; i < 10; i++) {
            valores[i] = input.nextDouble();
        }

        System.out.println("El promedio es " + promedio());
        System.out.println("La desviación estandard es " + desviacion());
        input.close();
    }
}