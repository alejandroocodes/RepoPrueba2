import java.util.Scanner;

public class PorcentajeGenero {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de hombre:");
        int hombres = scanner.nextInt();

        System.out.println("Ingrese la cantidad de mujeres:");
        int mujeres = scanner.nextInt();

        int total = hombres + mujeres;

        double porcentajehombres = (double) hombres / total * 100;
        double porcentajemujeres = (double) mujeres / total * 100;

        System.out.println("El porcentaje de hombres en el curso es:"+porcentajehombres+ "%");
        System.out.println("El porcentaje de mujeres en el curso es:"+porcentajemujeres+ "%");

        scanner.close();

    }

}
