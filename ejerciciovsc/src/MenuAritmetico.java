import java.util.Scanner;
public class MenuAritmetico {
 
    public static int menu(Scanner sc){
         System.out.println("********** MENU MATH***********");
         System.out.println("1. Add");
         System.out.println("2. Subtract");
         System.out.println("3. Multiplicar");
         System.out.println("4. Dividir");
         System.out.println("5. Residuo ");
         System.out.println("6. Exit");
         int x=sc.nextInt();
         return x;
    }
 
    public static void sumar(int x, int y){
        int resultado = x + y;
        System.out.println("La suma de " + x + " + " + y + " es " + resultado);
    }
 
    public static void restar(int x, int y){
        int resultado= x - y;
        System.out.println("La resta de " + x + "-" + y + "es "+ resultado);
    }
 
    public static void multiplicar(int x,int y) {
        int resultado =0;
        for (int i = 0; i < y; i++) {
            resultado = resultado + x;
        }
        System.out.println("La multiplicación de "+ x + " * "+ y + " es: "+ resultado);
    }
 
    public static void dividir(int x,int y) {
        int restador = x;
        int contador = 0;
 
        while (restador >= y) {
            restador = restador - y;
            contador ++;
        }
        System.out.println("La división de " + x + " ÷ " + y + " es: " + contador);
    }
 
    public static void main(String[] args){
        /*  menu matematico
        */
       Scanner read=new Scanner(System.in);
       int option=0;
       System.out.println("Operando 1 (valor entero):");
       int ope1=read.nextInt();
       System.out.println("Operando 2 (valor entero):");
       int ope2=read.nextInt();
 
       do{
         option=menu(read);
         switch(option){
            case 1: sumar(ope1,ope2);
                    break;
            case 2: restar(ope1,ope2);
                    break;
            case 3: multiplicar(ope1,ope2);
                    break;
            case 4: dividir(ope1,ope2);
                    break;
         }
       }while(option!=6);
 
    }
}