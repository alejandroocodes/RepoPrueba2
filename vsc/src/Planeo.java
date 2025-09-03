import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Planeo {
    public static final Scanner sc = new Scanner(System.in);
    static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

/**
 * @param cursoRegistrado Variable que verifica si el curso está registrado.
 * @param codCurso Variable que guarda el código del curso.
 * @param nomCurso Variable que guarda el nombre del curso.
 * @param creditosCurso Variable que guarda los créditos del curso.
 * @param profesorCurso Variable que guarda el nombre del profesor que dicta el curso. 
 * @param salonCurso Variable que guarda el salón en donde va se realizará el curso.
*/ 
    
    boolean cursoRegistrado = false;
    String codCurso;
    String nomCurso;
    int creditosCurso;
    String profesorCurso;
    String salonCurso;

/**
 * @param MAX_ACT máximo número de actividades.
 * @param actCount Contador de actividades.
 * @param actNombre Arreglo que guarda los nombres de cada actividad.
 * @param actFecha Arreglo que guarda la fecha de cada actividad.
 * @param actPorcentaje Arreglo que guarda los porcentuales de cada actividad.
 * @param actNota Arreglo que guarda las notas registradas para cada actividad.
*/ 
    // --- Actividades (hasta 5) ---
    final int MAX_ACT = 5;
    int actCount = 0;
    String[] actNombre = new String[MAX_ACT];
    LocalDate[] actFecha = new LocalDate[MAX_ACT];
    double[] actPorcentaje = new double[MAX_ACT]; // 0..100
    double[] actNota = new double[MAX_ACT];

/**
 * Metodo: mostrarMenu.
 * Este metodo muestra el menu al usuario.
 * Pre: ninguna
 * Pos: Se imprimen en la consola las opciones de menu.
 */
    public static void mostrarMenu() {
        System.out.println("...... Menú ......");
        System.out.println("1. Registrar curso");
        System.out.println("2. Asociar actividades (hasta 5)");
        System.out.println("3. Cargar notas por actividad (0.0 - 5.0)");
        System.out.println("4. Visualizar actividades");
        System.out.println("5. Consultar promedio del curso");
        System.out.println("6. Salir");
        System.out.println("..................");
    }
/**
 * Metodo: registrarCurso
 * Este metodo permite registrar y almacenar los datos de un curso.
 * Pre: El usuario ha elegido la opción.
 * Pos: 
 * - Las variables estaicas "codCurso", "nomCurso", "creditosCurso", "profesorCurso", "salonCurso" se actualizan con los valores ingresados por el usuario.
 * - La variable cursoResgistrado se establece en "true".
 * - Se muestra mensaje de exito.
 */
    public void registrarCurso() {
        System.out.println("... Registro de Curso ...");
        codCurso = leerTexto("Ingrese el código del curso: ");
        nomCurso = leerTexto("Ingrese el nombre del curso: ");
        creditosCurso = leerEntero("Ingrese el número de créditos: ");
        profesorCurso = leerTexto("Ingrese el profesor asignado: ");
        salonCurso = leerTexto("Ingrese el salón: ");
        cursoRegistrado = true;
        System.out.println("Curso registrado exitosamente.");
    }
/**
* Metodo: asociarActividades
* Este metodo permite asociar maximo 5 actividades con su respectivo nombre, fecha y porcentaje.
* Pre: La variable cursoRegistrado debe ser "true", de lo contrario se muestra un mensaje de error.
* Pos: 
* - Los arreglos staticos "actNombre", "actFecha", "actPorcentaje", "actNota", se van llenando con los datos ingresados.
* - La variable "actCount" se actualiza con el numero total de actividades registradas .
* - Si la suma de actividades de los porcentajes no supera el 100%, si lo hace, muestra un mensaje de error.
* - Cada posicion en el arreglo "actNota" se inicializa con el valor -1.0 para indicar que la nota aun no ha sido cargada.
*/ 
    public void asociarActividades() {
        if (!cursoRegistrado) {
            System.out.println("Debe registrar un curso primero.");
            return;
        }
        System.out.println("--- Asociación de actividades ---");
        System.out.println("Ingrese hasta " + MAX_ACT + " actividades. Formato fecha: yyyy-MM-dd.");
        System.out.println("Escriba vacío en el nombre para terminar antes.");

        actCount = 0;
        double totalPorcentaje = 0.0;

        while (actCount < MAX_ACT) {
            String nombre = leerTexto("Nombre de la actividad " + (actCount + 1) + ": ");
            if (nombre.isEmpty()) {
                break;
            }
            LocalDate fecha = leerFecha("Fecha de entrega (yyyy-MM-dd): ");
            double porcentaje = leerDouble("Porcentaje (0-100): ");
            if (porcentaje <= 0 || porcentaje > 100) {
                System.out.println("Porcentaje inválido. Debe estar en (0, 100].");
                continue;
            }
            if (totalPorcentaje + porcentaje > 100) {
                System.out.println("¡Advertencia! El acumulado supera 100%. No se registrará esta actividad.");
                break;
            }
            actNombre[actCount] = nombre;
            actFecha[actCount] = fecha;
            actPorcentaje[actCount] = porcentaje;
            actNota[actCount] = -1.0; // Inicializar nota como no cargada
            totalPorcentaje += porcentaje;
            actCount++;
            System.out.println("Acumulado temporal: " + totalPorcentaje + "%");
        }
        System.out.println("Actividades asociadas exitosamente.");
    }
/**
 * Metodo:cargarNotas
 * Permite al usuario ingresar las notas para cada una de las actividades registradas.
 * Pre: 
 * - La variable actCount debe ser mayor que (0). si no hay actividades.
 * - Las actividades deben haber sido asociadas previamente.
 * Pos:
 * - El arreglo actNota se actualiza con las notas ingresadas por el usuario por cada actividad.
 * - Se valida que cada nota este en el rango de 0.0 a 5.0.
 * - Se muestra un mensaje de "éxito".
 */
    public void cargarNotas() {
        if (actCount == 0) {
            System.out.println("No hay actividades asociadas para cargar notas.");
            return;
        }
        System.out.println("--- Carga de notas por actividad ---");
        System.out.println("Ingrese las notas de 0.0 a 5.0.");
        for (int i = 0; i < actCount; i++) {
            boolean notaValida = false;
            double nota;
            while (!notaValida) {
                System.out.println("Ingrese la nota para '" + actNombre[i] + "' (" + actPorcentaje[i] + "%): ");
                nota = leerDouble("");
                if (nota >= 0.0 && nota <= 5.0) {
                    actNota[i] = nota;
                    notaValida = true;
                } else {
                    System.out.println("Error: La nota debe estar en el rango de 0.0 a 5.0. Intente de nuevo.");
                }
            }
        }
        System.out.println("Notas cargadas exitosamente.");
    }
/**
 * Metodo: visualizarActividades
 * Muestra un resumen detallado de todas las actividades registradas para el curso, incluyendo su nombre, fecha, porcentaje y nota.
 * Pre:
 * - La variable actCount debe ser mayor que (0). si no hay actividades.
 * - La variable nomCurso debe tener un valor asignado.
 * Pos:
 * - Se imprimen en los detalles de cada actividad.
 * - Si una nota no ha sido cargada su valor es -1.0, se muestra "no cargada".
 */
    public void visualizarActividades() {
        if (actCount == 0) {
            System.out.println("No hay actividades registradas.");
            return;
        }
        System.out.println("--- Lista de actividades ---");
        System.out.println("Curso: " + nomCurso);
        System.out.println("------------------------------------");
        
        for (int i = 0; i < actCount; i++) {
            System.out.println("Actividad: " + actNombre[i]);
            System.out.println("  - Fecha de entrega: " + actFecha[i]);
            System.out.println("  - Porcentaje: " + actPorcentaje[i] + "%");
            System.out.println("  - Nota: " + (actNota[i] == -1.0 ? "No cargada" : actNota[i]));
            System.out.println("------------------------------------");
        }
    }
/**
 * Metodo: consultarPromedio
 * Calcula y muestra el promedio ponderado del curso basandose en las notas y porcentajes de las actividades.
 * Pre:
 * - La variable actCount debe ser mayor que (0), si no hay actividades el metodo termina
 * Pos:
 * - Si todas las actividades tienen una nota cargada, se calcula el promedio ponderado y se muestra se muestra un mensaje de advertencia y el cálculo no se realiza.
 * */ 
    public void consultarPromedio() {
        if (actCount == 0) {
            System.out.println("No hay actividades registradas para calcular el promedio.");
            return;
        }
        System.out.println("--- Cálculo del Promedio del Curso ---");
        System.out.println("Curso: " + nomCurso);
        System.out.println("------------------------------------");

        double promedioPonderado = 0.0;
        boolean notasIncompletas = false;

        for (int i = 0; i < actCount; i++) {
            if (actNota[i] == -1.0) {
                System.out.println("Aún no se ha cargado la nota para la actividad: " + actNombre[i]);
                notasIncompletas = true;
                break;
            }
            double notaPonderada = actNota[i] * (actPorcentaje[i] / 100.0);
            System.out.println("Actividad: " + actNombre[i]);
            System.out.println("  - Peso: " + actPorcentaje[i] + "%");
            System.out.println("  - Nota Registrada: " + actNota[i]);
            System.out.println("  - Contribución al promedio: " + notaPonderada);
            System.out.println("------------------------------------");
            promedioPonderado += notaPonderada;
        }

        if (!notasIncompletas) {
            System.out.println("El promedio ponderado final del curso es: " + promedioPonderado);
        }
    }
/**
 * Metodos: (leerTexto, leerFecha, leerDouble, leerEntero)
 * Estos métodos se encargan de manejar la entrada de datos del usuario, validando y manejando posibles errores de formato
 * Pre:
 * - El Scanner debe estar abierto, le debe pasar una instruccion como argmento para guiar al usuario.
 * Pos:
 * - Cada metodo retorna un valor del tipo de dato correspondient (String, LocalDate, double, int).
*/ 

    public static String leerTexto(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
    public static LocalDate leerFecha(String mensaje) {
        LocalDate fecha = null;
        while (fecha == null) {
            System.out.print(mensaje);
            try {
                fecha = LocalDate.parse(sc.nextLine(), FMT);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Inténtelo de nuevo.");
            }
        }
        return fecha;
    }
    public static double leerDouble(String mensaje) {
        double valor = 0.0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                valor = Double.parseDouble(sc.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número.");
            }
        }
        return valor;
    }
    public static int leerEntero(String mensaje) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(sc.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }
        return numero;
    }
/**
 * Metodo: main
 * Es la entrada principal del programa. Controla el flujo de la aplicación mostrando un menú y llamando a otros métodos según la opción del usuario.
 * 
 */
    public static void main(String[] args) {
        Planeo app = new Planeo();
        int option;
        do {
            mostrarMenu();
            option = leerEntero("Elija una opción: ");
            switch (option) {
                case 1:
                    app.registrarCurso();
                    break;
                case 2:
                    app.asociarActividades();
                    break;
                case 3:
                    app.cargarNotas();
                    break;
                case 4:
                    app.visualizarActividades();
                    break;
                case 5:
                    app.consultarPromedio();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 6);
        sc.close();
    }
}