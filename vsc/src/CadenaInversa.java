import java.util.Scanner;

public class CadenaInversa {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese una cadena de 5 letras:");
        String cadena = scanner.nextLine();

        if (cadena.length() !=5) {
            
            System.out.println("La cadena debe tener exactamente 5 caracteres");
        
        } else{

            String alReves = new StringBuilder(cadena).reverse().toString();
            System.out.println("Cadena al reves:"+alReves);

        }
    scanner.close();
    }
    
}
