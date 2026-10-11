// JuegoAdivinaNumero.java
import java.util.Scanner;

public class JuegoAdivinaNumero extends Juego {
  // Atributos
  private int numeroAAdivinar;

  // Metodos
  public JuegoAdivinaNumero(int numeroDeVidas) {
    super(numeroDeVidas);   // se lo pasa al constructor de la clase padre
  }

  public void juega() {
    // No se cierra el Scanner a proposito: cerrarlo cerraria System.in
    Scanner teclado = new Scanner(System.in);

    // 1) Llama al metodo heredado
    this.reiniciaPartida();

    // 2) Genera aleatoriamente el numero a adivinar (entre 0 y 10)
    this.numeroAAdivinar = (int) (Math.random() * 11);

    // 3) Pide al usuario que adivine el numero
    System.out.println("Adivina un numero entre 0 y 10");

    // 4) Lee un entero y lo compara con el numero generado
    while (true) {
      int numero = teclado.nextInt();

      if (numero == this.numeroAAdivinar) {
        // 4.a) Es igual
        System.out.println("Acertaste!!");
        this.actualizaRecord();
        return;
      }

      // 4.b) Es diferente: se quita una vida
      if (this.quitaVida()) {
        // 4.c) Aun le quedan vidas
        if (this.numeroAAdivinar > numero) {
          System.out.println("El numero a adivinar es mayor");
        } else {
          System.out.println("El numero a adivinar es menor");
        }
        System.out.println("Vidas restantes: " + this.numeroDeVidas + ". Intentalo de nuevo:");
      } else {
        // 4.d) Ya no le quedan vidas
        System.out.println("Te quedaste sin vidas. El numero era " + this.numeroAAdivinar);
        return;
      }
    }
  }
}
