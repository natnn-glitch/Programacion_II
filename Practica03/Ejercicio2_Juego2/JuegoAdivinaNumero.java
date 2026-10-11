// JuegoAdivinaNumero.java
import java.util.Scanner;

public class JuegoAdivinaNumero extends Juego {
  // Atributos
  private int numeroAAdivinar;

  // Metodos
  public JuegoAdivinaNumero(int numeroDeVidas) {
    super(numeroDeVidas);   // se lo pasa al constructor de la clase padre
  }

  // Devuelve true si el numero esta entre 0 y 10, en otro caso false
  public boolean validaNumero(int numero) {
    return numero >= 0 && numero <= 10;
  }

  // Genera el numero a adivinar (entre 0 y 10).
  // Las subclases lo redefinen para generar solo pares o solo impares,
  // de lo contrario el jugador podria no tener forma de ganar.
  public int generaNumero() {
    return (int) (Math.random() * 11);
  }

  public void juega() {
    // No se cierra el Scanner a proposito: cerrarlo cerraria System.in
    // y los siguientes juegos ya no podrian leer del teclado
    Scanner teclado = new Scanner(System.in);

    this.reiniciaPartida();
    this.numeroAAdivinar = this.generaNumero();

    System.out.println("Adivina un numero entre 0 y 10");

    while (true) {
      int numero = teclado.nextInt();

      if (!this.validaNumero(numero)) {
        // Numero no valido: no se quita ninguna vida
        System.out.println("Numero no valido. Intentalo de nuevo (no pierdes ninguna vida):");
      } else if (numero == this.numeroAAdivinar) {
        System.out.println("Acertaste!!");
        this.actualizaRecord();
        return;
      } else if (this.quitaVida()) {
        if (this.numeroAAdivinar > numero) {
          System.out.println("El numero a adivinar es mayor");
        } else {
          System.out.println("El numero a adivinar es menor");
        }
        System.out.println("Vidas restantes: " + this.numeroDeVidas + ". Intentalo de nuevo:");
      } else {
        System.out.println("Te quedaste sin vidas. El numero era " + this.numeroAAdivinar);
        return;
      }
    }
  }
}
