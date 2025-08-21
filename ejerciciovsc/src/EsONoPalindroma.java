import java.util.Scanner;
public class EsONoPalindroma {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Este programa verificará si la palabra ingresada es o no Palindroma");

        System.out.println("Ingrese una palabra en minúscula: ");

        String word = scanner.nextLine();
        String palabra = word.toUpperCase();

        if(esPalindromo(palabra)){
            System.out.println("La palabra" + word + "es palindroma");
        }else{
            System.out.println("La palabra " + word + "no es palindroma");
        }

        scanner.close();
    }
    public static boolean esPalindromo(String palabra) {
        int n = palabra.length();

        for (int i = 0; i < n / 2; i++) {
            if (palabra.charAt(i) != palabra.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}