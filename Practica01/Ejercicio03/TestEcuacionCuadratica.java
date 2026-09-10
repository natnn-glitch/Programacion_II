package Ejercicio03;

import java.util.Scanner;

/**
 * TestEcuacionCuadratica.java
 * Clase principal. Cuyo objetivo es probar la ejecución de la clase EcuacionCuadratica.
 *
 * @author Natalia Tambo
 * @version 1.0 01/09/2026
 */
public class TestEcuacionCuadratica {
    /** Método Principal */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese a, b, c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        
        // Crea una ecuación cuadrática
        EcuacionCuadratica ecuacion = new EcuacionCuadratica(a, b, c);
        double discriminante = ecuacion.getDiscriminante();
        
        if (discriminante > 0) {
            System.out.println("La ecuación tiene dos raíces " + ecuacion.getRaiz1() + " y " + ecuacion.getRaiz2());
        } else if (discriminante == 0) {
            System.out.println("La ecuación tiene una raíz " + ecuacion.getRaiz1());
        } else {
            System.out.println("La ecuación no tiene raíces reales");
        }
        input.close();
    }
}