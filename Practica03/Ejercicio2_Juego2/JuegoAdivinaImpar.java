// JuegoAdivinaImpar.java
public class JuegoAdivinaImpar extends JuegoAdivinaNumero {
  // Metodos
  public JuegoAdivinaImpar(int numeroDeVidas) {
    super(numeroDeVidas);
  }

  // true si es impar y esta entre 0 y 10. Si es par muestra un error y devuelve false
  @Override
  public boolean validaNumero(int numero) {
    if (numero % 2 == 0) {
      System.out.println("Error: el numero debe ser impar");
      return false;
    }
    return super.validaNumero(numero);   // es impar: solo falta ver que este entre 0 y 10
  }

  // Genera uno de los impares: 1, 3, 5, 7, 9
  @Override
  public int generaNumero() {
    return ((int) (Math.random() * 5)) * 2 + 1;
  }
}
