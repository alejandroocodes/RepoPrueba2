import java.util.*;


public class concursoPasteleria {

    // Define los nombres de los chefs
    private static final String[] NOMBRES_CHEFS = {"Marina", "Carlos", "Sofia"};
    private static final int NUM_CHEFS = NOMBRES_CHEFS.length;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. Solicita y valida el número de platos
        int numPlatos = pedirNumPlatos(sc);

        // Arreglos para almacenar las calificaciones de cada chef
        int[] puntajesChef1 = new int[numPlatos];
        int[] puntajesChef2 = new int[numPlatos];
        int[] puntajesChef3 = new int[numPlatos];

        // Registra las calificaciones
        System.out.println("--- REGISTRO DE CALIFICACIONES ---");
        registrarCalificaciones(sc, puntajesChef1, NOMBRES_CHEFS[0]);
        registrarCalificaciones(sc, puntajesChef2, NOMBRES_CHEFS[1]);
        registrarCalificaciones(sc, puntajesChef3, NOMBRES_CHEFS[2]);

        // Calcula el total y el promedio de cada chef
        int total1 = calcularPuntajeTotal(puntajesChef1);
        int total2 = calcularPuntajeTotal(puntajesChef2);
        int total3 = calcularPuntajeTotal(puntajesChef3);

        double promedio1 = calcularPuntajePromedio(total1, numPlatos);
        double promedio2 = calcularPuntajePromedio(total2, numPlatos);
        double promedio3 = calcularPuntajePromedio(total3, numPlatos);

        // Muestra los resultados
        System.out.println("--- RESULTADOS DEL CONCURSO ---");
        mostrarResultados(NOMBRES_CHEFS[0], total1, promedio1);
        mostrarResultados(NOMBRES_CHEFS[1], total2, promedio2);
        mostrarResultados(NOMBRES_CHEFS[2], total3, promedio3);

        // Identifica y muestra al ganador
        identificarGanador(total1, total2, total3);
        sc.close();
    }
    public static int pedirNumPlatos(Scanner sc) {
        int numPlatos = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("Ingrese la cantidad de platos (1-5): ");
                numPlatos = sc.nextInt();
                
                // Valida si el número está en el rango correcto
                if (numPlatos >= 1 && numPlatos <= 5) {
                    entradaValida = true;
                } else {
                    System.out.println("El número de platos debe ser entre 1 y 5. Inténtelo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                sc.next(); // Consume la entrada incorrecta para evitar un bucle infinito
            }
        } while (!entradaValida);
        return numPlatos;
    }
    public static void registrarCalificaciones(Scanner sc, int[] puntajes, String nombreChef) {
        System.out.println("Registro de calificaciones para " + nombreChef + ":");
        for (int i = 0; i < puntajes.length; i++) {
            boolean calificacionValida = false;
            do {
                try {
                    System.out.print("Ingrese la calificación para el plato " + (i + 1) + " (0-100): ");
                    int calificacion = sc.nextInt();
                    if (calificacion >= 0 && calificacion <= 100) {
                        puntajes[i] = calificacion;
                        calificacionValida = true;
                    } else {
                        System.out.println("La calificación debe ser entre 0 y 100. Inténtelo de nuevo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                    sc.next(); // Limpia la entrada no válida
                }
            } while (!calificacionValida);
        }
    }
    public static int calcularPuntajeTotal(int[] puntajes) {
        int total = 0;
        for (int puntaje : puntajes) {
            total += puntaje;
        }
        return total;
    }
    public static double calcularPuntajePromedio(int totalPuntaje, int numPlatos) {
        return (double) totalPuntaje / numPlatos;
    }
    public static void mostrarResultados(String nombreChef, int total, double promedio) {
        System.out.printf("%s: Total = %d, Promedio = %.2f\n", nombreChef, total, promedio);
    }
    public static void identificarGanador(int total1, int total2, int total3) {
        int[] totales = {total1, total2, total3};
        int maxPuntaje = 0;
        String nombreGanador = "";
        // Encontrar el puntaje máximo
        for (int i = 0; i < NUM_CHEFS; i++) {
            if (totales[i] > maxPuntaje) {
                maxPuntaje = totales[i];
            }
        }
        // Identificar al ganador
        for (int i = 0; i < NUM_CHEFS; i++) {
            if (totales[i] == maxPuntaje) {
                nombreGanador = NOMBRES_CHEFS[i];
                break; // Se muestra solo el primer ganador en caso de empate
            }
        }
        System.out.println("¡El chef con la mayor calificación total es " + nombreGanador + " con " + maxPuntaje + " puntos!");
    }
}