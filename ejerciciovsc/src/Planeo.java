import java.util.Scanner;

public class Planeo {

    // Datos del curso 
    static String codigoNurso = "";
    static String nombreCurso = "";
    static int creditosCurso = 0;
    static String profesorCurso = "";
    static String salonCurso = "";

    // Número de actividades
    static int MAX_ACTIVIDADES = 5;
    static int actCount = 0;
    static String[] actNombre = new String[MAX_ACTIVIDADES];
    // COMO SE HACE LA FECHA
    static double[] actPorcentaje = new double[MAX_ACTIVIDADES]; //0 - 100
    static double[] actNota = new double[MAX_ACTIVIDADES]; // 0.0 - 5.0
    
    public static int menu(){
        System.out.println("*****Menú*****");
        System.out.println("1. Registrar curso");
        System.out.println("2. Asociar actividades (hasta 5)");
        System.out.println("3. Cargar notas por actividad (0.0 - 5.0)");
        System.out.println("4. Visualizar actividades");
        System.out.println("5. Consultar promedio del curso");
        System.out.println(". salir");

    }
    public static void main(String[] args){
        for(int i = 0; i < MAX_ACTIVIDADES; i++) actNota[i] = Double;

        Scanner sc = new Scanner(System.in);
        int option;

        System.out.println("Selecciona lo que quieres hacer");
        option = read.nextInt();


 
    }
}
    }
    
}
