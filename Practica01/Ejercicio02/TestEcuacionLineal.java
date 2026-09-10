package Ejercicio02;

import java.util.Scanner;

/**
 * TestEcuacionLineal.java
 * Clase principal. Cuyo objetivo es probar la ejecución de la clase EcuacionLineal.
 *
 * @author Natalia Tambo
 * @version 1.0 01/09/2026
 */
public class TestEcuacionLineal {
    /** Método Principal */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese a, b, c, d, e, f: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();
        
        // Crea una ecuación lineal
        EcuacionLineal ecuacion = new EcuacionLineal(a, b, c, d, e, f);
        
        if (ecuacion.tieneSolucion()) {
            System.out.println("x=" + ecuacion.getX() + ", y=" + ecuacion.getY());
        } else {
            System.out.println("La ecuación no tiene solución");
        }
        input.close();
    }
}