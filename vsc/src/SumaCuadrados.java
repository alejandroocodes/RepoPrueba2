import java.util.Scanner;

public class SumaCuadrados {
    
    // Subrutina que calcula la suma de los cuadrados de dos números
    public static int sumaDeCuadrados(int a, int b) {
        return (a * a) + (b * b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Ingrese el primer número: ");
        int num1 = scanner.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int num2 = scanner.nextInt();

        // Llamada a la subrutina
        int resultado = sumaDeCuadrados(num1, num2);

        // Mostrar el resultado
        System.out.println("La suma de los cuadrados de " + num1 + " y " + num2 + " es: " + resultado);

        scanner.close();
    }
}