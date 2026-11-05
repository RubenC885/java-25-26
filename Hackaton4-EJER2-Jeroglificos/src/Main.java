import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static final char[] SIMBOLO = {'T', 'G', 'C', 'F', 'D', 'R', 'H'};
    private static String convJeroglifico(String numero) {
        StringBuilder out = new StringBuilder();
        int n = numero.length(); // 2
        for (int i = 0; i < n; i++) {
            char ch = numero.charAt(i);
            int veces = Integer.parseInt(String.valueOf(ch));
            if (veces == 0) continue;
            int potencia = n - 1 - i; // 2 - 1 - 0 = 1
            char simbolo = SIMBOLO[potencia];
            for (int k = 0; k < veces; k++) {
                out.append(simbolo);
            }
        }
        return out.toString();
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String linea;
        while ((linea = br.readLine()) != null) {
            linea = linea.trim();
            if (linea.isEmpty()) continue;
            if (linea.equals("0")) break;
            String res = convJeroglifico(linea);
            bw.write(res);
            bw.newLine();
        }
        bw.flush();
    }
}