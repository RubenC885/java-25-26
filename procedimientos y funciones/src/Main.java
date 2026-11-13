import java.util.Arrays;

public class Main {
    static int sumar(int a, int b) {
        return a + b;
    }
    static void mostrarTotal(int total) {
        System.out.println("Total: " + total);
    }

    static String leer(String a, String b) {
        return a + ", " + b;
    }
    static char[][] tablero = new char[10][10];
    static void rellenarTablero(char a) {
        for (int i = 0; i < tablero.length; i++) {
            Arrays.fill(tablero[i], a);
        }
    }
    static void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int suma = sumar(3, 5);
        mostrarTotal(suma);
        String prueba = leer("Ruben", "Juan");
        System.out.println(prueba);
        rellenarTablero('*');
        mostrarTablero();
    }
}