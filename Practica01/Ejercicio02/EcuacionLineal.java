package Ejercicio02;

/**
 * Clase EcuacionLineal.
 *
 * @author Natalia Tambo
 * @version 1.0 01/09/2026
 */
public class EcuacionLineal {
    /* Atributos de los coeficientes y resultados */
    private double a, b, c, d, e, f;
    
    /* Construye un objeto EcuacionLineal */
    public EcuacionLineal(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    /* Devuelve true si ad - bc no es cero */
    boolean tieneSolucion() {
        return (this.a * this.d - this.b * this.c) != 0;
    }
    
    /* Retorna la solución de x */
    double getX() {
        return (this.e * this.d - this.b * this.f) / (this.a * this.d - this.b * this.c);
    }
    
    /* Retorna la solución de y */
    double getY() {
        return (this.a * this.f - this.e * this.c) / (this.a * this.d - this.b * this.c);
    }
}