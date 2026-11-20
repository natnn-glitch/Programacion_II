// Punto 6: los mismos 5 casos, ahora contra el codigo CORREGIDO
public class Casos {

  public static void main(String[] args) {

    System.out.println("=== Caso 1: doble inscripcion ===");
    {
      Materia poo = new Materia("INF-121", 6);
      Estudiante e1 = new Estudiante("Carlos Flores", "7654321", "E-001");
      e1.inscribirse(poo);
      try {
        e1.inscribirse(poo); // otra vez a la misma materia
      } catch (IllegalStateException e) {
        System.out.println("Rechazado: " + e.getMessage());
      }
      System.out.println("Inscripciones de Carlos: " + e1.getInscripciones().size());
      System.out.println("Inscripciones de la materia: " + poo.getInscripciones().size());
    }

    System.out.println("=== Caso 2: dos docentes en un curso ===");
    {
      Materia poo = new Materia("INF-121", 6);
      Docente d1 = new Docente("Ana Alba", "1234567", "Ingenieria de Software");
      Docente d2 = new Docente("Pedro Rios", "2345678", "Bases de Datos");
      d1.dictar(poo);
      try {
        d2.dictar(poo);
      } catch (IllegalStateException e) {
        System.out.println("Rechazado: " + e.getMessage());
      }
      System.out.println("Docente de la materia: " + poo.getDocente().getNombre());
      System.out.println("Materias de Ana: " + d1.getMaterias().size());
      System.out.println("Materias de Pedro: " + d2.getMaterias().size());
    }

    System.out.println("=== Caso 3: nota sin registrar ===");
    {
      Materia poo = new Materia("INF-121", 6);
      Docente d = new Docente("Ana Alba", "1234567", "Ingenieria de Software");
      Estudiante e1 = new Estudiante("Carlos Flores", "7654321", "E-001");
      Inscripcion i = e1.inscribirse(poo);
      try {
        System.out.println("Nota antes de registrarla: " + i.calcularNota());
      } catch (IllegalStateException e) {
        System.out.println("Rechazado: " + e.getMessage());
      }
      System.out.println(d.generarActa(poo));
    }

    System.out.println("=== Caso 4: docente en dos carreras ===");
    {
      Universidad umsa = new Universidad("UMSA");
      Universidad.Carrera informatica = umsa.crearCarrera("Informatica");
      Universidad.Carrera matematica = umsa.crearCarrera("Matematica");
      Docente d = new Docente("Ana Alba", "1234567", "Ingenieria de Software");
      informatica.agregarDocente(d);
      try {
        matematica.agregarDocente(d);
      } catch (IllegalStateException e) {
        System.out.println("Rechazado: " + e.getMessage());
      }
      try {
        informatica.agregarDocente(d); // repetido en la misma carrera
      } catch (IllegalStateException e) {
        System.out.println("Rechazado: " + e.getMessage());
      }
      System.out.println("Docentes en Informatica: " + informatica.getDocentes().size());
      System.out.println("Docentes en Matematica: " + matematica.getDocentes().size());
    }

    System.out.println("=== Caso 5: composicion no estricta ===");
    {
      // Estas dos lineas YA NO COMPILAN (constructor privado):
      //   Materia.Horario suelto = new Materia.Horario(LocalDate.of(2026, 7, 2), "Aula 101");
      //   Universidad.Carrera fantasma = new Universidad.Carrera("Fantasma");
      // La unica forma es por medio del todo:
      Materia poo = new Materia("INF-121", 6);
      poo.agregarHorario(java.time.LocalDate.of(2026, 7, 2), "Aula 101");
      System.out.println("Horarios que conoce la materia: " + poo.getHorarios().size());
    }
  }
}
