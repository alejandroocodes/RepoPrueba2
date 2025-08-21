import java.util.Scanner;

public class DescuentoCelular {
    public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingrese el valor del Celular:");
    double valor = scanner.nextDouble();

    System.out.println("Ingrese el descuento del Celular: (ej 10 para el 10%)");
    double descuento = scanner.nextDouble();

    double cantidaddescontada = valor * descuento / 100;
    double precioFinal = valor - cantidaddescontada;
    
    System.out.println("El valor del celular con el descuento es:"+precioFinal);

    scanner.close();


    }
}
