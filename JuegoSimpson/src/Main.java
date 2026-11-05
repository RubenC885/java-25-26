import java.util.Random;

public class Main {
    private static char[][] tablero;
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static void imprimitTablero() {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    private void asignarCaracterACasillasLibres(char caracter) {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                tablero[i][j] = 'L';
            }
        }
    }
    public static void main(String[] args) {
        tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
        Random dice = new Random();
        int filaAleatoria = dice.nextInt(MAX_FILA_TABLERO);
        int columnaAleatoria = dice.nextInt(MAX_COLUMNA_TABLERO);
        tablero[filaAleatoria][columnaAleatoria] = 'B';
        int filaAleatoriaHomer;
        int columnaAleatoriaHomer;
        for (int i = 0; i < 10; i++) {
            do {
                filaAleatoriaHomer = dice.nextInt(MAX_FILA_TABLERO);
                columnaAleatoriaHomer = dice.nextInt(MAX_COLUMNA_TABLERO);
            } while (tablero[filaAleatoriaHomer][columnaAleatoriaHomer] != 'L');
            tablero[filaAleatoriaHomer][columnaAleatoriaHomer] = 'H';
        }
        int filaAleatoriaMuro;
        int columnaAleatoriaMuro;
        for (int i = 0; i < 10; i++) {
            do {
                filaAleatoriaMuro = dice.nextInt(MAX_FILA_TABLERO);
                columnaAleatoriaMuro = dice.nextInt(MAX_COLUMNA_TABLERO);
            } while (tablero[filaAleatoriaMuro][columnaAleatoriaMuro] != 'L');
            tablero[filaAleatoriaMuro][columnaAleatoriaMuro] = 'M';
        }
        tablero[MAX_FILA_TABLERO - 1][MAX_COLUMNA_TABLERO - 1] = 'F';
        imprimitTablero();
    }
}