import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        char caballero = 'C';
        char rocas = 'B';
        char criaturas = 'E';
        char energia = 'P';
        char sellos = 'T';
        char estacion = 'F';
        char libre = 'L';
        int maxF = 10;
        int maxC = 10;
        Random dice = new Random();
        Scanner sc = new Scanner(System.in);
        int filaAl;
        int colAl;
        int vidas = 10;
        char mov;
        char[][] tablero = new char[maxF][maxC];
        for (int i = 0; i < maxF; i++) {
            for (int j = 0; j < maxC; j++) {
                tablero[i][j] = libre;
            }
        }
        tablero[9][9] = estacion;
        do {
            filaAl = dice.nextInt(maxF);
            colAl = dice.nextInt(maxC);
        } while (tablero[filaAl][colAl] != libre);
        tablero[filaAl][colAl] = caballero;
        int filaAnt = filaAl;
        int filaC = filaAl;
        int colC = colAl;
        int colAnt = colAl;
        for (int i = 0; i < 10; i++) {
            do {
                filaAl = dice.nextInt(maxF);
                colAl = dice.nextInt(maxC);
            } while (tablero[filaAl][colAl] != libre);
            tablero[filaAl][colAl] = rocas;
        }
        for (int i = 0; i < 7; i++) {
            do {
                filaAl = dice.nextInt(maxF);
                colAl = dice.nextInt(maxC);
            } while (tablero[filaAl][colAl] != libre);
            tablero[filaAl][colAl] = criaturas;
        }
        for (int i = 0; i < 5; i++) {
            do {
                filaAl = dice.nextInt(maxF);
                colAl = dice.nextInt(maxC);
            } while (tablero[filaAl][colAl] != libre);
            tablero[filaAl][colAl] = energia;
        }
        for (int i = 0; i < 3; i++) {
            do {
                filaAl = dice.nextInt(maxF);
                colAl = dice.nextInt(maxC);
            } while (tablero[filaAl][colAl] != libre);
            tablero[filaAl][colAl] = sellos;
        }
        System.out.println("Te mueves con WASD");
        int cont = 0;
        int fin = 0;
        do {
            for (int i = 0; i < maxF; i++) {
                for (int j = 0; j < maxC; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Vidas: " + vidas);
            System.out.println("Sellos: " + cont + "/3");
            System.out.println();
            System.out.print("Escribe una letra --> ");
            mov = sc.next().toUpperCase().charAt(0);
            switch (mov) {
                case 'W':
                    filaAnt = filaC;
                    colAnt = colC;
                    tablero[filaC][colC] = libre;
                    filaC--;
                    if (filaC < 0) {
                        System.out.println("No puedes moverte en esa dirección");
                        filaC++;
                    }
                    break;
                case 'S':
                    colAnt = colC;
                    filaAnt = filaC;
                    tablero[filaC][colC] = libre;
                    filaC++;
                    if (filaC >= maxF) {
                        System.out.println("No puedes moverte en esa dirección");
                        filaC--;
                    }
                    break;
                case 'A':
                    filaAnt = filaC;
                    colAnt = colC;
                    tablero[filaC][colC] = libre;
                    colC--;
                    if (colC < 0) {
                        System.out.println("No puedes moverte en esa dirección");
                        colC++;
                    }
                    break;
                case 'D':
                    filaAnt = filaC;
                    colAnt = colC;
                    tablero[filaC][colC] = libre;
                    colC++;
                    if (colC >= maxC) {
                        System.out.println("No puedes moverte en esa dirección");
                        colC--;
                    }
                    break;
            }
            if (tablero[filaC][colC] == rocas) {
                System.out.println("No puedes avanzar");
                filaC = filaAnt;
                colC = colAnt;
                tablero[filaAnt][colAnt] = caballero;
            } else if (tablero[filaC][colC] == criaturas) {
                System.out.println("¡Te has hecho daño!");
                tablero[filaC][colC] = caballero;
                vidas--;
            } else if (tablero[filaC][colC] == energia) {
                System.out.println("!Has recuperado vida!");
                tablero[filaC][colC] = caballero;
                vidas++;
            } else if (tablero[filaC][colC] == sellos) {
                System.out.println("!Has obtenido un sello!");
                tablero[filaC][colC] = caballero;
                cont++;
            } else if (tablero[filaC][colC] == estacion) {
                if (cont == 3) {
                    System.out.println("!Has ganado!");
                    tablero[filaC][colC] = caballero;
                    fin++;
                } else {
                    System.out.println("Necesitas los 3 sellos para ganar");
                    filaC = filaAnt;
                    colC = colAnt;
                    tablero[filaAnt][colAnt] = caballero;
                }
            } else {
                tablero[filaC][colC] = caballero;
            }
        } while (vidas > 0 && fin == 0);
        if (vidas == 0) {
            System.out.println("Has muerto");
        }
    }
}