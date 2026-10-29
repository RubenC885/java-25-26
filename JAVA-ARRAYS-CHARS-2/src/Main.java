import java.util.Random;

public class Main {
    public static void main(String[] args) {
        char arrayUser[] = new char[10];
        char matrizUser[][] = new char[10][10];
        char arrayCaracts[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Random dice = new Random();
        int posNumAleatorio = dice.nextInt();
        for (int i = 0; i < arrayUser.length; i++) {
            posNumAleatorio = dice.nextInt(27);
            arrayUser[i] = arrayCaracts[posNumAleatorio];
        }
        for (int i = 0; i < matrizUser.length; i++) {
            for (int j = 0; j < matrizUser[i].length; j++) {
                posNumAleatorio = dice.nextInt(27);
                matrizUser[i][j] = arrayCaracts[posNumAleatorio];
            }
        }
        System.out.println("Bienvenidoa a la sopa de letras (Versión Arrays");
        for (int i = 0; i < arrayUser.length; i++) {
            System.out.print(arrayUser[i] + " ");
        }
        System.out.println();
        System.out.println("/////////////////////////////////////////////////");
        System.out.println("Bienvenidoa a la sopa de letras (Versión Matrices");
        for (int i = 0; i < matrizUser.length; i++) {
            for (int j = 0; j < matrizUser[i].length; j++) {
                System.out.print(matrizUser[i][j] + " ");
            }
            System.out.println();
        }
    }
}