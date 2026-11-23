import java.io.*;
public class Main {
    static String categoria;
    static double dinero;
    static String[] categorias = {"D", "A", "M", "I", "C"};
    static String[] nombrescategorias = {"DESAYUNOS", "COMIDAS", "MERIENDAS", "CENAS", "COPAS"};
    static int contadorVentas;
    static int contadorVentasComida;
    static double dineroT;
    static double media;
    static double mediaC;
    static double[] dineroCategoria = {0, 0, 0, 0, 0};
    static int categoriaMax = 0;
    static int categoriaMin = 0;
    static double guardar;
    static double guardar2;
    static String nombreCategoriaMax;
    static String nombreCategoriaMin;
    static boolean empateMax;
    static boolean empateMin;
    static String mediaSupera;
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            String linea;
        while (!(linea = read.readLine().toUpperCase()).equals("N 0")) {
            linea = linea.trim();
            String[] entrada = linea.split(" ");
            categoria = entrada[0];
            dinero = Double.parseDouble(entrada[1]);
            contadorDinero();
        }
        hacerMedia();
        writer.write(nombreCategoriaMax + "#" + nombreCategoriaMin + "#" + mediaSupera);
        writer.flush();
    }
    static void contadorDinero() {
        for (int i = 0; i < categorias.length; i++) {
            if (categoria.equals(categorias[1])) {
                contadorVentasComida++;
                contadorVentas++;
                dineroCategoria[1] += dinero;
                break;
            } else if (categoria.equals(categorias[i])) {
                contadorVentas++;
                dineroCategoria[i] += dinero;
            }
        }
    }
    static void hacerMedia() {
        for (int i = 0; i < dineroCategoria.length; i++) {
            dineroT += dineroCategoria[i];
        }
        media = dineroT / contadorVentas;
        mediaC = dineroCategoria[1] / contadorVentasComida;
        if (mediaC > media) {
            mediaSupera = "SI";
        } else {
            mediaSupera = "NO";
        }
        guardar = dineroCategoria[0];
        guardar2 = dineroCategoria[0];
        for (int i = 0; i < dineroCategoria.length; i++) {
            if (dineroCategoria[i] > guardar) {
                guardar = dineroCategoria[i];
                categoriaMax = i;
            }
            if (dineroCategoria[i] < guardar2) {
                guardar2 = dineroCategoria[i];
                categoriaMin = i;
            }
        }
        for (int i = 0; i < dineroCategoria.length; i++) {
            if (dineroCategoria[categoriaMax] == dineroCategoria[i] && i != categoriaMax) {
                empateMax = true;
            }
            if (dineroCategoria[categoriaMin] == dineroCategoria[i] && i != categoriaMin) {
                empateMin = true;
            }
        }
        nombreCategoriaMax = nombrescategorias[categoriaMax];
        nombreCategoriaMin = nombrescategorias[categoriaMin];
        if (empateMax) {
            nombreCategoriaMax = "EMPATE";
        }
        if (empateMin) {
            nombreCategoriaMin = "EMPATE";
        }
    }
}