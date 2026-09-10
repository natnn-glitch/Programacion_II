package Ejercicio01;

/**
 * TestCronometro.java
 * Clase principal. Cuyo objetivo es probar la ejecución de la clase Cronometro.
 *
 * @author Natalia Tambo
 * @version 1.0 01/09/2026
 */
public class TestCronometro {
    /** Método Principal */
    public static void main(String[] args) {
        // Crea un cronómetro
        Cronometro cronometro = new Cronometro();
        
        // Arreglo de 100.000 números
        int[] numeros = new int[100000];
        for(int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random() * 100000);
        }
        
        cronometro.inicia();
        
        // Ordenación por selección
        for (int i = 0; i < numeros.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[j] < numeros[min]) {
                    min = j;
                }
            }
            int temp = numeros[min];
            numeros[min] = numeros[i];
            numeros[i] = temp;
        }
        
        cronometro.detener();
        System.out.println("El tiempo de ejecución es " + cronometro.lapsoDeTiempo() + " milisegundos");
    }
}