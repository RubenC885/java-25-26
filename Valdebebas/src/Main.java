import java.io.*;
public class Main {
    static BufferedReader lector;
    static BufferedWriter escritor;
    static int numAscensores = 0;
    static int pisoLlamada = 0;
    static int[] pisosAscensores;
    static int distanciaMinima = -1;
    static int posicionElegidaPorCercania = -1;
    static boolean respondioElDelCero;
    static int indiceBajaAlCero;
    static int mejorDistancia;
    public static void main(String[] args) throws IOException {
        lector = new BufferedReader(new InputStreamReader(System.in));
        escritor = new BufferedWriter(new OutputStreamWriter(System.out));
        String linea;
        while (!(linea = lector.readLine()).isEmpty()) {
            linea = linea.trim();
            if (linea.isEmpty()) continue;
            String[] cabecera = linea.split(" ");
            numAscensores = Integer.parseInt(cabecera[0]);
            pisoLlamada = Integer.parseInt(cabecera[1]);
            String segunda = lector.readLine();
            if (segunda == null) break;
            String[] partes = segunda.trim().split(" ");
            pisosAscensores = new int[numAscensores];
            for (int i = 0; i < partes.length; i++) {
                pisosAscensores[i] = Integer.parseInt(partes[i]);
            }
            elegirAscensorYCumplirCero();
            for (int i = 0; i < numAscensores; i++) {
                escritor.write(Integer.toString(pisosAscensores[i]));
            }
            escritor.newLine();
        }
        escritor.flush();
    }
    static void elegirAscensorYCumplirCero() {
        posicionElegidaPorCercania = -1;
        distanciaMinima = Math.abs(pisosAscensores[0] - pisoLlamada);
        for (int i = 1; i < numAscensores; i++) {
            int d = Math.abs(pisosAscensores[i] - pisoLlamada);
            if (d < distanciaMinima) {
                distanciaMinima = d;
                posicionElegidaPorCercania = i;
            }
        }
        if (pisosAscensores[posicionElegidaPorCercania] == 0) {
            respondioElDelCero = true;
        } else {
            respondioElDelCero = false;
        }
        pisosAscensores[posicionElegidaPorCercania] = pisoLlamada;
        if (respondioElDelCero) {
            indiceBajaAlCero = -1;
            mejorDistancia = 1000;
            for (int i = 0; i < numAscensores; i++) {
                if (i == posicionElegidaPorCercania) continue;
                int distanciaActual = Math.abs(pisosAscensores[i]);
                if (distanciaActual < mejorDistancia) {
                    mejorDistancia = distanciaActual;
                    indiceBajaAlCero = i;
                }
            }
            pisosAscensores[indiceBajaAlCero] = 0;
        }
    }
}