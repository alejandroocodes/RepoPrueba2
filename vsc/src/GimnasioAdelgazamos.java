import java.util.Scanner;
// ej: peso ideal: 170 -100 = 70 kg
// peso act de la persona, estatura en metros, No. de sesiones 
// 1 sesion -> 45 min
// 1 hora -> 450 calorias
// 3500 calorias -> 1 kg menos

//calorias por sesion: 45 min -> o.75 horas -> 0.75 * 450 = 337.5 calorias
//calorias por semana: 37.5 * sesiones
//kilos bajados por semana: (calorias por semana) /350
//Semanas necesaras: (pesoactual - pesoideal) / kilos por semana


public class GimnasioAdelgazamos {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //ENTRADAS  
        System.out.println("Ingrese su peso actual en kg:");
        double pesoActual = scanner.nextDouble();

        System.out.println("Ingrese su estatura actual en cm(ej 160):");
        double estaturaActual = scanner.nextDouble();

        System.out.println("Ingrese el numero de sesiones por semana");
        int sesionesPorSemana = scanner.nextInt();

        //CALCULAR EL PESO IDEAL
        double pesoIdeal = estaturaActual - 100;

        //CALORIAS QUEMADAS POR SESION
        double caloriasPorSesion = 0.75 * 450;

        //CALORIAS QUEMADAS POR SESION
        double caloriasPorSemana = caloriasPorSesion * sesionesPorSemana;

        //KILOS BAJADOS POR SEMANA
        double kilosPorSemana = caloriasPorSemana / 3500;

        //PESO QUE NECESITA PERDER
        double kilosPorPerder = pesoActual - pesoIdeal;

        if (kilosPorPerder <= 0){

            System.out.println("Ya estas en tu peso ideal o por debajo");

        } else if (kilosPorPerder == 0){

            System.out.println("Debe hacer una sesion más para bajar de peso");

        } else {
            double semanasNecesarias = kilosPorPerder / kilosPorSemana;
            System.out.println("Necesitarás aproximadamente" + semanasNecesarias+" semanas para alcanzar tu peso ideal.");
        }
        scanner.close();

    }
    
}
