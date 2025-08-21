import java.util.Scanner;

public class ConversionSegundos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese el número de segundos
        System.out.print("Ingresa el número de segundos: ");
        int totalSegundos = scanner.nextInt();

        // Convertir segundos a minutos y segundos restantes
        int minutos = totalSegundos / 60;
        int segundosRestantes = totalSegundos % 60;

        // Mostrar el resultado
        System.out.println(totalSegundos + " segundos equivalen a: " + minutos + " minutos y " + segundosRestantes + " segundos.");

        scanner.close();
    }
}