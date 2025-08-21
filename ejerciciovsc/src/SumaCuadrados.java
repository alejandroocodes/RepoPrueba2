import java.util.Scanner;

public class SumaCuadrados {
    
    // Subrutina que calcula la suma de los cuadrados de dos números
    public static int sumaDeCuadrados(int n1, int n2) {
        return (n1 * n1) + (n2 * n2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Ingrese el primer número: ");
        int num1 = sc.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int num2 = sc.nextInt();

        // Llamada a la subrutina
        int resultado = sumaDeCuadrados(num1, num2);

        // Mostrar el resultado
        System.out.println("La suma de los cuadrados de " + num1 + " y " + num2 + " es: " + resultado);

        sc.close();
    }
}
