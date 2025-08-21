import java.util.Scanner;

public class ConversionDistancia {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de millas:");
        double millas = scanner.nextDouble();

        double km = millas * 1.60934;

        System.out.println(millas+"millas son"+km+"kilómetros.");

        scanner.close();

    }
    
}
