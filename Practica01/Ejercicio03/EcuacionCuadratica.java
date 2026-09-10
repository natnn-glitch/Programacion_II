package Ejercicio03;

/**
 * Clase EcuacionCuadratica.
 *
 * @author Natalia Tambo
 * @version 1.0 01/09/2026
 */
public class EcuacionCuadratica {
    /* Atributos de los coeficientes */
    private double a, b, c;
    
    /* Construye un objeto EcuacionCuadratica */
    public EcuacionCuadratica(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    /* Devuelve el discriminante b^2 - 4ac */
    double getDiscriminante() {
        return (this.b * this.b) - (4 * this.a * this.c);
    }
    
    /* Retorna la primera raíz */
    double getRaiz1() {
        if (getDiscriminante() < 0) return 0;
        return (-this.b + Math.sqrt(getDiscriminante())) / (2 * this.a);
    }
    
    /* Retorna la segunda raíz */
    double getRaiz2() {
        if (getDiscriminante() < 0) return 0;
        return (-this.b - Math.sqrt(getDiscriminante())) / (2 * this.a);
    }
}