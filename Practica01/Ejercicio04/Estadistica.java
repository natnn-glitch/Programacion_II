package Ejercicio04;

/**
 * Clase Estadistica.
 *
 * @author Natalia Tambo
 * @version 1.0 01/09/2026
 */
public class Estadistica {
    /* Arreglo que almacena los valores */
    private double[] valores;
    
    /* Construye un objeto Estadistica */
    public Estadistica(double[] valores) {
        this.valores = valores;
    }
    
    /* Obtiene el promedio de los valores en punto flotante */
    double promedio() {
        double suma = 0;
        for (int i = 0; i < this.valores.length; i++) {
            suma += this.valores[i];
        }
        return suma / this.valores.length;
    }
    
    /* Devuelve la desviación estándar de los valores en punto flotante */
    double desviacion() {
        double prom = promedio();
        double sumaDiferencias = 0;
        for (int i = 0; i < this.valores.length; i++) {
            sumaDiferencias += Math.pow(this.valores[i] - prom, 2);
        }
        return Math.sqrt(sumaDiferencias / (this.valores.length - 1));
    }
}