import java.util.Scanner; 

public class AumentarSueldo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        System.out.print("Ingrese el sueldo actual: ");
        double sueldo = scanner.nextDouble(); 

        double aumento = sueldo * 0.05;
        double nuevoSueldo = sueldo + aumento;

        System.out.println("El nuevo sueldo con el 5% de aumento es: $" + nuevoSueldo);

        scanner.close(); 
    }
}
