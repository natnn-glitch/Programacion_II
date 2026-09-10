package Ejercicio01;

/**
 * Clase Cronometro.
 *
 * @author Natalia Tambo
 * @version 1.0 01/09/2026
 */
public class Cronometro {
    /* Hora de inicio en milisegundos */
    private long inicia;
    
    /* Hora de finalizacion en milisegundos */
    private long finaliza;
    
    /* Construye un objeto cronómetro e inicializa inicia con la hora actual */
    public Cronometro() {
        this.inicia = System.currentTimeMillis();
    }
    
    /* Retorna el valor de inicia */
    public long getInicia() {
        return this.inicia;
    }
    
    /* Retorna el valor de finaliza */
    public long getFinaliza() {
        return this.finaliza;
    }
    
    /* Restablece inicia a la hora actual */
    public void inicia() {
        this.inicia = System.currentTimeMillis();
    }
    
    /* Establece finaliza a la hora actual */
    public void detener() {
        this.finaliza = System.currentTimeMillis();
    }
    
    /* Retorna el tiempo transcurrido del cronómetro en milisegundos */
    public long lapsoDeTiempo() {
        return this.finaliza - this.inicia;
    }
}