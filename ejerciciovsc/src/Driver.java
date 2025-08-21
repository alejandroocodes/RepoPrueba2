import java.util.Scanner;

public class Driver{

    public static final int MAX = 3;

    public static Scanner sc = new Scanner(System.in);

    public static void readKms(String[] nameDrivers, double[] kilometers, int day){
        String nameDay = "";
        switch (day) {
            case 1: nameDay = "Lunes";
                break;
            case 2: nameDay = "Martes";
                break;
            case 3: nameDay = "Miercoles"
                break;
            case 4: nameDay = "jueves"
                break;
        }
        for(int = 0; i < MAX; i++){
            System.out.println("Ingrese los kilometros de" + nameDriver[i] +"para el dia"+NameDay);
            double km = sc.nextDouble();
            kilometers[i] = km;
        }
    }
    public static double[] calculateTotalKms(double[] mo, double[] th){
        double[] total = new double[MAX];
        for(i = 0; i < MAX; i i++){
            total[i] = mo[i] + th[i];
        }
        return total
    }
    public static double calculateAverage(double mo){
        double average = 0;
        double total = 0;

        for(i = 0; i < MAX; i i++){
            total += mo[i];
        }
        average = total / MAX;
        return total
    }
    public static void main(String[] args) {

    String[] drivers = ["Juan","Jose","Alan"];

    double[] monday = new double{MAX};
    double[] tuesday = new double{MAX};

    readKms(drivers, monday, 1);
    readKms(drivers, tuesday, 2);
    readKms(drivers, wednesday, 3);
    readKms(drivers, thursday, 4);

    double[] totalKms = calculateTotalKms(monday, thursday);
    double averageKms = calculateAverage(totalKms);
    }
}