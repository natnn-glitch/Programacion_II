// JuegoAdivinaPar.java
public class JuegoAdivinaPar extends JuegoAdivinaNumero {
  // Metodos
  public JuegoAdivinaPar(int numeroDeVidas) {
    super(numeroDeVidas);
  }

  // true si es par y esta entre 0 y 10. Si es impar muestra un error y devuelve false
  @Override
  public boolean validaNumero(int numero) {
    if (numero % 2 != 0) {
      System.out.println("Error: el numero debe ser par");
      return false;
    }
    return super.validaNumero(numero);   // es par: solo falta ver que este entre 0 y 10
  }

  // Genera uno de los pares: 0, 2, 4, 6, 8, 10
  @Override
  public int generaNumero() {
    return ((int) (Math.random() * 6)) * 2;
  }
}
