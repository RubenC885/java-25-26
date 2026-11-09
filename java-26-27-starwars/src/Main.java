import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int maxF = 10;
        int maxC = 10;
        char yoda = 'Y';
        char libre = 'L';
        char dm = 'D';
        char r2 = 'R';
        char vader = 'V';
        char fin ='F';
        char muro = 'M';
        int vidas = 3;
        int filaAl;
        int colAL;
        boolean activo = true;
        Random dice = new Random();
        Scanner sc = new Scanner(System.in);
        char[][] tableroActivo;
        char[][] tableroYoda = new char[maxF][maxC];
        char[][] tableroVader = new char[maxF][maxC];
        //preparacion tableros
        for (int i = 0; i <= 1; i++) {
            if (activo) {
                tableroActivo = tableroYoda;
                activo = false;
            } else {
                tableroActivo = tableroVader;
                activo = true;
            }
            for (int j = 0; j < maxF; j++) {
                for (int k = 0; k < maxC; k++) {
                    tableroActivo[j][k] = libre;
                }
            }
            tableroActivo[9][9] = fin;
            for (int j = 0; j < 5; j++) {
                do {
                    filaAl = dice.nextInt(maxF);
                    colAL = dice.nextInt(maxC);
                } while (tableroActivo[filaAl][colAL] != libre);
                tableroActivo[filaAl][colAL] = muro;
            }
            if (activo) {
                for (int j = 0; j < 5; j++) {
                    do {
                        filaAl = dice.nextInt(maxF);
                        colAL = dice.nextInt(maxC);
                    } while (tableroActivo[filaAl][colAL] != libre);
                    tableroActivo[filaAl][colAL] = dm;
                }
                do {
                    filaAl = dice.nextInt(maxF);
                    colAL = dice.nextInt(maxC);
                } while (tableroActivo[filaAl][colAL] != libre);
                tableroActivo[filaAl][colAL] = yoda;
            } else {
                for (int j = 0; j < 5; j++) {
                    do {
                        filaAl = dice.nextInt(maxF);
                        colAL = dice.nextInt(maxC);
                    } while (tableroActivo[filaAl][colAL] != libre);
                    tableroActivo[filaAl][colAL] = r2;
                }
                do {
                    filaAl = dice.nextInt(maxF);
                    colAL = dice.nextInt(maxC);
                } while (tableroActivo[filaAl][colAL] != libre);
                tableroActivo[filaAl][colAL] = vader;
            }
        }
        //juego
        do {
            System.out.println("EMPIEZA EL JUEGO!!");
            System.out.println("Te mueves en WASD");
            System.out.println("Dime una letra de movimiento !!");

        } while (vidas > 0);
    }
}
