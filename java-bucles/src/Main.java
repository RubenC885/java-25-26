import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num = 5;
        Scanner scan = new Scanner(System.in);
//        System.out.println("Vamos a practicar leer");
//        int numUsuario = scan.nextInt();
        System.out.println("Vamos a practicar leer una cadena");
        String cadena = scan.next();
        char cadCaract[] = cadena.toCharArray();
        for (int i = 0; i < cadCaract.length; i++) {
            System.out.println("Caracter pos: " + i + " -> " + cadCaract[i]);
        }
        System.out.println(cadena.charAt(2));
    }
}