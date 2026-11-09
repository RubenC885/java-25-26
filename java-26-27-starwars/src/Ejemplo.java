import java.util.Random;
import java.util.Scanner;

public class Ejemplo {
    public static void main(String[] args) {
        int MAX_FIL_YODA = 10;
        int MAX_COL_YODA = 10;
        int MAX_FIL_DM = 10;
        int MAX_COL_DM = 10;
        char YODA = 'Y';
        char LIBRE = 'L';
        char DM = 'D';
        boolean yodaActive = true;
        // NO VOY A UTILIZAR FUNCIONES/PROCEDIMIENTOS
        char[][] tableroYoda = new char[MAX_FIL_YODA][MAX_COL_YODA];
        char[][] tableroDM = new char[MAX_FIL_DM][MAX_COL_DM];
        // tableroYoda
        char[][] tableroACTIVO = null;
        int filaAl = -1;
        int colAl = -1;
        Random aleat = new Random();
        char VADER = 'V';
        char POCIMA = 'P';
        char MURO = 'M';
        for (int k = 0; k <= 1; k++) {
            if (yodaActive) {
                tableroACTIVO = tableroYoda;
                yodaActive = false;
            } else {
                tableroACTIVO = tableroDM;
                yodaActive = true;
            }
            for (int i = 0; i < MAX_FIL_YODA; i++) {
                for (int j = 0; j < MAX_COL_YODA; j++) {
                tableroACTIVO[i][j] = LIBRE;
            }
            }
            for (int i = 0; i < 10; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_YODA);
                colAl = aleat.nextInt(MAX_COL_YODA);
            } while (tableroACTIVO[filaAl][colAl] != LIBRE);
            tableroACTIVO[filaAl][colAl] = MURO;
        }
            for (int i = 0; i < 7; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_YODA);
                colAl = aleat.nextInt(MAX_COL_YODA);
            } while (tableroACTIVO[filaAl][colAl] != LIBRE);
            tableroACTIVO[filaAl][colAl] = VADER;
        }
        for (int i = 0; i < 5; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_YODA);
                colAl = aleat.nextInt(MAX_COL_YODA);
            } while (tableroACTIVO[filaAl][colAl] != LIBRE);
            tableroACTIVO[filaAl][colAl] = POCIMA;
        }
    }
        int filaOficialYoda = -1;
        int filaOficialDM = -1;
        int columnaOficialYoda = -1;
        int columnaOficialDM = -1;
        do {
            filaAl = aleat.nextInt(MAX_FIL_YODA);
            colAl = aleat.nextInt(MAX_COL_YODA);
        } while (tableroDM[filaAl][colAl] != LIBRE);
        tableroDM[filaAl][colAl] = DM;
        filaOficialDM = filaAl;
        columnaOficialDM = colAl;
        do{
            filaAl = aleat.nextInt(MAX_FIL_YODA);
            colAl = aleat.nextInt(MAX_COL_YODA);
        }while(tableroACTIVO[filaAl][colAl]!=LIBRE);
        tableroACTIVO[filaAl][colAl] = YODA;
        // OFICIALIZO LAS POSICIONES DE MI YODA
        filaOficialYoda = filaAl;
        columnaOficialYoda = colAl;
        // EMPIEZA EL JUEGO !!!
        int vidas = 10;
        Scanner lector = new Scanner(System.in);
        for (int i = 0; i < MAX_FIL_YODA; i++) {
            for (int j = 0; j < MAX_COL_YODA; j++) {
                System.out.print(tableroACTIVO[i][j] + " ");
            }
            System.out.println();
        }
        if (yodaActive) {
            tableroACTIVO = tableroYoda;
            yodaActive = false;
        } else {
            tableroACTIVO = tableroDM;
            yodaActive = true;
        }
        do {
            System.out.println("EMPIEZA EL JUEGO!!");
            System.out.println("Te mueves en WASD");
            System.out.println("Dime una letra de movimiento !!");
            char mov = lector.next().charAt(0);
            int filaAnteriorYoda = filaOficialYoda;
            int colAnteriorYoda = columnaOficialYoda;
            switch (mov){ // W, A, S o D
                case 'W':
                    filaOficialYoda = filaOficialYoda - 1;
                    break;
                case 'A':
                    columnaOficialYoda = columnaOficialYoda - 1;
                    break;
                case 'S':
                    filaOficialYoda = filaOficialYoda + 1;
                    break;
                case 'D':
                    columnaOficialYoda = columnaOficialYoda + 1;
                    break;
            }
            // Y SI YODA SE SALE DEL TABLERO ??????????????????
            if(
                    filaOficialYoda < 0 ||
                            filaOficialYoda > 9 ||
                            columnaOficialYoda < 0 ||
                            columnaOficialYoda > 9
            ){
                System.out.println("EHHHHHHHH!!!!!!!!!!!!");
                System.out.println("LÍMITE DE TABLERO!!!!!!");
                filaOficialYoda = filaAnteriorYoda;
                columnaOficialYoda = colAnteriorYoda;
            }else{
                if(tableroACTIVO[filaOficialYoda][columnaOficialYoda] == MURO){
                    System.out.println("NO PUEDES PASAR!!!!!");
                    filaOficialYoda = filaAnteriorYoda;
                    columnaOficialYoda = colAnteriorYoda;
                }else if(tableroACTIVO[filaOficialYoda][columnaOficialYoda] == POCIMA){
                    tableroACTIVO[filaOficialYoda][columnaOficialYoda] = YODA;
                    tableroACTIVO[filaAnteriorYoda][colAnteriorYoda] = LIBRE;
                    vidas++;
                }else if(tableroACTIVO[filaOficialYoda][columnaOficialYoda] == VADER){
                    tableroACTIVO[filaOficialYoda][columnaOficialYoda] = YODA;
                    tableroACTIVO[filaAnteriorYoda][colAnteriorYoda] = LIBRE;
                    vidas--;
                }else if(tableroACTIVO[filaOficialYoda][columnaOficialYoda] == LIBRE){
                    tableroACTIVO[filaOficialYoda][columnaOficialYoda] = YODA;
                    tableroACTIVO[filaAnteriorYoda][colAnteriorYoda] = LIBRE;
                }

            }
            for (int i = 0; i < MAX_FIL_YODA; i++) {
                for (int j = 0; j < MAX_COL_YODA; j++) {
                    System.out.print(tableroACTIVO[i][j] + " ");
                }
                System.out.println();
            }
        }while(vidas>0);










    }
}