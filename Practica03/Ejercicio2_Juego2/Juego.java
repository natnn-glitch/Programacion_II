// Juego.java
public class Juego {
  // Atributos (protected: las subclases los pueden usar directamente)
  protected int numeroDeVidas;   // vidas que le quedan al jugador
  protected int vidasIniciales;  // vidas con las que empieza cada partida
  protected int record;          // mayor numero de vidas que sobraron al ganar

  // Metodos
  public Juego(int numeroDeVidas) {
    this.numeroDeVidas = numeroDeVidas;
    this.vidasIniciales = numeroDeVidas;
    this.record = 0;
  }

  // Deja las vidas como al inicio de la partida
  public void reiniciaPartida() {
    this.numeroDeVidas = this.vidasIniciales;
  }

  // Si las vidas que sobraron superan al record, se actualiza el record
  public void actualizaRecord() {
    if (this.numeroDeVidas > this.record) {
      this.record = this.numeroDeVidas;
      System.out.println("Nuevo record: " + this.record);
    }
  }

  // Quita una vida. Devuelve true si aun le quedan vidas, false si ya no le quedan
  public boolean quitaVida() {
    this.numeroDeVidas--;
    return this.numeroDeVidas > 0;
  }
}
