import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//---------------------------------------------------------
// Herencia: Persona (abstracta) <- Estudiante, Docente
//---------------------------------------------------------
abstract class Persona {
  private final String nombre;
  private final String ci;

  protected Persona(String nombre, String ci) {
    this.nombre = nombre;
    this.ci = ci;
  }

  public String getNombre() {
    return nombre;
  }

  public String getCi() {
    return ci;
  }

  public abstract String toString();
}

class Estudiante extends Persona {
  private final String codigo;
  // Asociación: el estudiante conoce sus inscripciones
  private final List<Inscripcion> inscripciones = new ArrayList<>();

  public Estudiante(String nombre, String ci, String codigo) {
    super(nombre, ci);
    this.codigo = codigo;
  }

  public String getCodigo() {
    return codigo;
  }

  public Inscripcion inscribirse(Materia materia) {
    // CORRECCION caso 1: no se permite inscribirse dos veces a la misma materia
    for (Inscripcion i : inscripciones) {
      if (i.getMateria() == materia) {
        throw new IllegalStateException(getNombre() + " ya esta inscrito en " + materia.getCodigo());
      }
    }
    Inscripcion inscripcion = new Inscripcion(this, materia, LocalDate.now());
    inscripciones.add(inscripcion);
    materia.registrarInscripcion(inscripcion);
    return inscripcion;
  }

  public List<Inscripcion> getInscripciones() {
    return Collections.unmodifiableList(inscripciones);
  }

  @Override
  public String toString() {
    return "Estudiante " + getNombre() + " (código " + codigo + ")";
  }
}

//---------------------------------------------------------
// Herencia: Ayudante ES UN Estudiante (punto 7)
// Asociación: el Ayudante colabora con UN Docente
//---------------------------------------------------------
class Ayudante extends Estudiante {
  private Docente docente; // a quien ayuda

  public Ayudante(String nombre, String ci, String codigo) {
    super(nombre, ci, codigo);
  }

  public Docente getDocente() {
    return docente;
  }

  void setDocente(Docente docente) {
    this.docente = docente;
  }

  @Override
  public String toString() {
    String ayuda = (docente != null) ? docente.getNombre() : "nadie";
    return "Ayudante " + getNombre() + " (código " + getCodigo() + ") colabora con " + ayuda;
  }
}

class Docente extends Persona {
  private final String especialidad;
  // Asociación: el docente conoce las materias que dicta
  private final List<Materia> materias = new ArrayList<>();
  // Asociación: el docente conoce a sus ayudantes (punto 7)
  private final List<Ayudante> ayudantes = new ArrayList<>();
  // CORRECCION caso 4: el docente sabe a que carrera pertenece
  private Universidad.Carrera carrera;

  public Docente(String nombre, String ci, String especialidad) {
    super(nombre, ci);
    this.especialidad = especialidad;
  }

  public void dictar(Materia materia) {
    // CORRECCION caso 2: una materia tiene un solo docente
    if (materia.getDocente() != null && materia.getDocente() != this) {
      throw new IllegalStateException(materia.getCodigo() + " ya la dicta " + materia.getDocente().getNombre());
    }
    if (!materias.contains(materia)) {
      materias.add(materia);
      materia.setDocente(this);
    }
  }

  // Método para agregar un ayudante (mantiene la bidireccionalidad)
  public void agregarAyudante(Ayudante ayudante) {
    if (!ayudantes.contains(ayudante)) {
      ayudantes.add(ayudante);
      // Establece la relación inversa
      if (ayudante.getDocente() != this) {
        ayudante.setDocente(this);
      }
    }
  }

  // Dependencia: Acta se crea y se devuelve, pero NO se guarda como atributo
  public Acta generarActa(Materia materia) {
    return new Acta(materia);
  }

  public List<Materia> getMaterias() {
    return Collections.unmodifiableList(materias);
  }

  public List<Ayudante> getAyudantes() {
    return Collections.unmodifiableList(ayudantes);
  }

  public Universidad.Carrera getCarrera() {
    return carrera;
  }

  void setCarrera(Universidad.Carrera carrera) {
    this.carrera = carrera;
  }

  @Override
  public String toString() {
    return "Docente " + getNombre() + " (" + especialidad + ")";
  }
}

//---------------------------------------------------------
// Composición: Universidad -> Carrera
//---------------------------------------------------------
class Universidad {
  private final String nombre;
  private final List<Carrera> carreras = new ArrayList<>();

  public Universidad(String nombre) {
    this.nombre = nombre;
  }

  // La Universidad CREA a las partes (carreras: no existen fuera de la Universidad)
  public Carrera crearCarrera(String nombreCarrera) {
    Carrera d = new Carrera(nombreCarrera);
    carreras.add(d);
    return d;
  }

  public String getNombre() {
    return nombre;
  }

  public List<Carrera> getCarreras() {
    return Collections.unmodifiableList(carreras);
  }

  //---------------------------------------------------------
  // Agregación: Carrera -> Docente
  // CORRECCION caso 5: Carrera es una clase interna con constructor privado,
  // asi solo la Universidad puede crearla (composicion estricta)
  //---------------------------------------------------------
  public static class Carrera {
    private final String nombre;
    private final List<Docente> docentes = new ArrayList<>();

    private Carrera(String nombre) {
      this.nombre = nombre;
    }

    // La Carrera AGREGA a las partes ya existentes
    public void agregarDocente(Docente docente) {
      // CORRECCION caso 4: un docente pertenece a una sola carrera (y no se repite)
      if (docente.getCarrera() != null) {
        throw new IllegalStateException(docente.getNombre() + " ya pertenece a " + docente.getCarrera().getNombre());
      }
      docentes.add(docente);
      docente.setCarrera(this);
    }

    public String getNombre() {
      return nombre;
    }

    public List<Docente> getDocentes() {
      return Collections.unmodifiableList(docentes);
    }
  }
}

//---------------------------------------------------------
// Composición: Materia -> Horario
//---------------------------------------------------------
class Materia {
  private final String codigo;
  private final int creditos;
  private Docente docente;
  private final List<Horario> horarios = new ArrayList<>();
  private final List<Inscripcion> inscripciones = new ArrayList<>();

  public Materia(String codigo, int creditos) {
    this.codigo = codigo;
    this.creditos = creditos;
  }

  public Horario agregarHorario(LocalDate fecha, String aula) {
    Horario s = new Horario(fecha, aula);
    horarios.add(s);
    return s;
  }

  void registrarInscripcion(Inscripcion inscripcion) {
    inscripciones.add(inscripcion);
  }

  void setDocente(Docente docente) {
    this.docente = docente;
  }

  public String getCodigo() {
    return codigo;
  }

  public int getCreditos() {
    return creditos;
  }

  public Docente getDocente() {
    return docente;
  }

  public List<Horario> getHorarios() {
    return Collections.unmodifiableList(horarios);
  }

  public List<Inscripcion> getInscripciones() {
    return Collections.unmodifiableList(inscripciones);
  }

  // CORRECCION caso 5: Horario es una clase interna con constructor privado,
  // asi solo la Materia puede crearlo (igual que Procesador dentro de Computador)
  public static class Horario {
    private final LocalDate fecha;
    private final String aula;

    private Horario(LocalDate fecha, String aula) {
      this.fecha = fecha;
      this.aula = aula;
    }

    public LocalDate getFecha() {
      return fecha;
    }

    public String getAula() {
      return aula;
    }
  }
}

//---------------------------------------------------------
// Inscripcion implementa Calificable
// Asociación: el estudiante conoce sus inscripciones
// Asociación: la materia tiene sus inscripciones
//---------------------------------------------------------
interface Calificable {
  double calcularNota();
}

class Inscripcion implements Calificable {
  private final Estudiante estudiante;
  private final Materia materia;
  private final LocalDate fecha;
  private double nota;
  private boolean conNota = false; // CORRECCION caso 3: sabemos si ya tiene nota

  Inscripcion(Estudiante estudiante, Materia materia, LocalDate fecha) {
    this.estudiante = estudiante;
    this.materia = materia;
    this.fecha = fecha;
  }

  public void registrarNota(double nota) {
    if (nota < 0 || nota > 100) {
      throw new IllegalArgumentException("La nota debe estar entre 0 y 100");
    }
    this.nota = nota;
    this.conNota = true;
  }

  public boolean tieneNota() {
    return conNota;
  }

  @Override
  public double calcularNota() {
    if (!conNota) {
      throw new IllegalStateException("La inscripcion aun no tiene nota");
    }
    return nota;
  }

  public Estudiante getEstudiante() {
    return estudiante;
  }

  public Materia getMateria() {
    return materia;
  }

  public LocalDate getFecha() {
    return fecha;
  }
}

//---------------------------------------------------------
// Dependencia: Docente usa Acta de forma temporal
//---------------------------------------------------------
class Acta {
  private final LocalDate fecha = LocalDate.now();
  private final String contenido;

  Acta(Materia materia) {
    StringBuilder sb = new StringBuilder();
    sb.append("ACTA ").append(materia.getCodigo()).append(" - ").append(fecha).append('\n');
    for (Inscripcion i : materia.getInscripciones()) {
      sb.append("  ").append(i.getEstudiante().getNombre()).append(": ");
      if (i.tieneNota()) {
        sb.append(i.calcularNota());
      } else {
        sb.append("SIN NOTA");
      }
      sb.append('\n');
    }
    this.contenido = sb.toString();
  }

  @Override
  public String toString() {
    return contenido;
  }
}

/**
 * Sistema académico: ejemplo de relaciones entre clases en UML/Java.
 *
 */
public class SistemaAcademico {

  public static void main(String[] args) {
    // Composición: la Universidad crea sus Carreras
    Universidad umsa = new Universidad("UMSA");
    Universidad.Carrera informatica = umsa.crearCarrera("Informática");

    // Agregación: los Docentes existen antes e independientemente de la Materia
    Docente docente = new Docente("Ana Alba", "1234567", "Ingeniería de Software");
    informatica.agregarDocente(docente);

    // Asociación: el Docente dicta una Materia
    Materia poo = new Materia("INF-121", 6);
    docente.dictar(poo);

    // Composición: la Materia crea sus Horarios
    poo.agregarHorario(LocalDate.of(2026, 7, 2), "Aula 101");
    poo.agregarHorario(LocalDate.of(2026, 7, 9), "Aula 101");

    // Asociación entre Estudiante e Inscripcion
    Estudiante e1 = new Estudiante("Carlos Flores", "7654321", "E-001");
    Estudiante e2 = new Estudiante("Maria Salas", "7654322", "E-002");
    Inscripcion i1 = e1.inscribirse(poo);
    Inscripcion i2 = e2.inscribirse(poo);
    i1.registrarNota(85);
    i2.registrarNota(92);

    // Punto 7: el Ayudante es un Estudiante y colabora con un Docente
    Ayudante ayudante = new Ayudante("Luis Rojas", "7654323", "E-003");
    docente.agregarAyudante(ayudante);
    ayudante.inscribirse(poo); // como es Estudiante, tambien se puede inscribir

    // Herencia + polimorfismo
    List<Persona> personas = Arrays.asList(docente, e1, e2, ayudante);
    personas.forEach(p -> System.out.println(p));

    // La inscripcion se usa a través de la interfaz Calificable
    Calificable c = i1;
    System.out.println("Nota de " + e1.getNombre() + ": " + c.calcularNota());

    // Dependencia: el Docente usa Acta solo dentro de un método
    Acta acta = docente.generarActa(poo);
    System.out.println(acta);
  }
}
