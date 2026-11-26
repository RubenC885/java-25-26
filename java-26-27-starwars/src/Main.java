import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    static final char libre = 'L';
    static final char fin = 'F';
    static final char[] letras = {'Y', 'V', 'M', 'P', 'D', 'R'};
    static final int[] cantidades = {1, 7, 10, 5, 1, 7};
    static final int maxF = 10;
    static final int maxC = 10;
    static int vidas = 3;
    static boolean activo = true;
    static int filaAl;
    static int colAL;
    static boolean puedeSaltar;
    static int filaY;
    static int colY;
    static int filaD;
    static int colD;
    static int filaAY;
    static int colAY;
    static int filaAD;
    static int colAD;
    static String mov;
    static int cooldownSaltos;
    static boolean ganar = false;
    static char[][] tableroActivo = new char[maxF][maxC];
    static char[][] tableroYoda = new char[maxF][maxC];
    static char[][] tableroVader = new char[maxF][maxC];

    static void movimientoTablero(char[][] tableroActivo) {
        if (activo) {
            filaAY = filaY;
            colAY = colY;
            switch (mov) {
                case "W":
                    filaY--;
                    break;
                case "A":
                    colY--;
                    break;
                case "S":
                    filaY++;
                    break;
                case "D":
                    colY++;
                    break;
                case "WW":
                    if (puedeSaltar) {
                        filaY -= 2;
                    } else {
                        System.out.println("No puedes saltar");
                    }
                    break;
                case "AA":
                    if (puedeSaltar) {
                        colY -= 2;
                    } else {
                        System.out.println("No puedes saltar");
                    }
                    break;
                case "DD":
                    if (puedeSaltar) {
                        colY += 2;
                    } else {
                        System.out.println("No puedes saltar");
                    }
                    break;
                case "SS":
                    if (puedeSaltar) {
                        filaY += 2;
                    } else {
                        System.out.println("No puedes saltar");
                    }
                    break;
            }
            if (filaY < 0 || filaY > 9 || colY < 0 || colY > 9) {
                System.out.println("EHHHHHHHH!!!!!!!!!!!!");
                System.out.println("LÍMITE DE TABLERO!!!!!!");
                filaY = filaAY;
                colY = colAY;
            } else {
                if (tableroActivo[filaY][colY] == letras[2]) {
                    System.out.println("NO PUEDES PASAR!!!!!");
                    filaY = filaAY;
                    colY = colAY;
                } else if (tableroActivo[filaY][colY] == letras[3]) {
                    System.out.println("Has recuperado una vida");
                    tableroActivo[filaY][colY] = letras[0];
                    tableroActivo[filaAY][colAY] = libre;
                    vidas++;
                } else if (tableroActivo[filaY][colY] == letras[1]) {
                    System.out.println("Has perdido una vida");
                    tableroActivo[filaY][colY] = letras[0];
                    tableroActivo[filaAY][colAY] = libre;
                    vidas--;
                } else if (tableroActivo[filaY][colY] == libre) {
                    tableroActivo[filaY][colY] = letras[0];
                    tableroActivo[filaAY][colAY] = libre;
                } else if (tableroActivo[filaY][colY] == fin) {
                    System.out.println("Has ganado");
                    tableroActivo[filaY][colY] = letras[0];
                    tableroActivo[filaAY][colAY] = libre;
                    ganar = true;
                }
            }
        } else {
            filaAD = filaD;
            colAD = colD;
            switch (mov) {
                case "W":
                    filaY--;
                    break;
                case "A":
                    colY--;
                    break;
                case "S":
                    filaY++;
                    break;
                case "D":
                    colY++;
                    break;
                case "WW":
                    if (puedeSaltar) {
                        filaY -= 2;
                    } else {
                        System.out.println("No puedes saltar");
                    }
                    break;
                case "AA":
                    if (puedeSaltar) {
                        colY -= 2;
                    } else {
                        System.out.println("No puedes saltar");
                    }
                    break;
                case "DD":
                    if (puedeSaltar) {
                        colY += 2;
                    } else {
                        System.out.println("No puedes saltar");
                    }
                    break;
                case "SS":
                    if (puedeSaltar) {
                        filaY += 2;
                    } else {
                        System.out.println("No puedes saltar");
                    }
                    break;
            }
        }
        if (filaD < 0 || filaD > 9 || colD < 0 || colD > 9) {
            System.out.println("EHHHHHHHH!!!!!!!!!!!!");
            System.out.println("LÍMITE DE TABLERO!!!!!!");
            filaD = filaAD;
            colD = colAD;
        } else {
            if (tableroActivo[filaD][colD] == letras[2]) {
                System.out.println("NO PUEDES PASAR!!!!!");
                filaD = filaAD;
                colD = colAD;
            } else if (tableroActivo[filaD][colD] == letras[3]) {
                System.out.println("Has recuperado una vida");
                tableroActivo[filaD][colD] = letras[4];
                tableroActivo[filaAD][colAD] = libre;
                vidas++;
            } else if (tableroActivo[filaD][colD] == letras[5]) {
                System.out.println("Has perdido una vida");
                tableroActivo[filaD][colD] = letras[4];
                tableroActivo[filaAD][colAD] = libre;
                vidas--;
            } else if (tableroActivo[filaD][colD] == libre) {
                tableroActivo[filaD][colD] = letras[4];
                tableroActivo[filaAD][colAD] = libre;
            } else if (tableroActivo[filaY][colY] == fin) {

                System.out.println("Has ganado");
                tableroActivo[filaD][colD] = letras[4];
                tableroActivo[filaAD][colAD] = libre;
                ganar = true;
            }
        }
    }
    static void colocarTablero(char[][] tablero) {
        Random dice = new Random();
        if (activo) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < cantidades[i]; j++) {
                    do {
                        filaAl = dice.nextInt(maxF);
                        colAL = dice.nextInt(maxC);
                    } while (tablero[filaAl][colAL] != libre);
                    tablero[filaAl][colAL] = letras[i];
                    if (i == 0) {
                        filaY = filaAl;
                        colY = colAL;
                    }
                }
            }
        } else {
            for (int i = 2; i < cantidades.length; i++) {
                for (int j = 0; j < cantidades[i]; j++) {
                    do {
                        filaAl = dice.nextInt(maxF);
                        colAL = dice.nextInt(maxC);
                    } while (tablero[filaAl][colAL] != libre);
                    tablero[filaAl][colAL] = letras[i];
                    if (i == 4) {
                        filaD = filaAl;
                        colD = colAL;
                    }
                }
            }
        }
        tablero[9][9] = fin;
    }
    static void rellenarTablero(char[][] tablero) {
        for (char[] chars : tablero) {
            Arrays.fill(chars, libre);
        }
    }
    static void imprimirTablero(char[][] tablero) {
        for (char[] chars : tablero) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rellenarTablero(tableroYoda);
        colocarTablero(tableroYoda);
        activo = false;
        rellenarTablero(tableroVader);
        colocarTablero(tableroVader);
        activo = true;
        System.out.println("EMPIEZA EL JUEGO!!");
        System.out.println("Te mueves en WASD");
        tableroActivo = tableroYoda;
        imprimirTablero(tableroActivo);
        do {
            System.out.println("Dime una letra de movimiento !!");
            mov = sc.next().toUpperCase();
            String[] saltos = mov.split("");
            if (saltos.length == 2 && cooldownSaltos == 0) {
                puedeSaltar = true;
                cooldownSaltos = 5;
            } else if (cooldownSaltos != 0) {
                puedeSaltar = false;
                cooldownSaltos--;
            }
            movimientoTablero(tableroActivo);
            imprimirTablero(tableroActivo);
            System.out.println("Vidas: " + vidas);
        } while (vidas > 0 && !ganar);
        if (!ganar) {
            System.out.println("Has muerto y pasado al lado oscuro");
            vidas = 3;
            activo = false;
            tableroActivo = tableroVader;
            imprimirTablero(tableroActivo);
            do {
                System.out.println("Dime una letra de movimiento !!");
                mov = sc.next().toUpperCase();
                movimientoTablero(tableroActivo);
                imprimirTablero(tableroActivo);
                System.out.println("Vidas: " + vidas);
            } while (vidas > 0 && !ganar);
        }
    }
}