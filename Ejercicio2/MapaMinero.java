import java.util.HashMap;

public class MapaMinero {

    private Zona[][] matriz;
    private int filas;
    private int columnas;

    public MapaMinero(Zona[][] matriz, int filas, int columnas) {
        this.matriz = matriz;
        this.filas = filas;
        this.columnas = columnas;
    }

    public void analizarRegion(int k) {

        double maxValor = 0;
        int mejorFila = 0;
        int mejorColumna = 0;

        for (int i = 0; i <= filas - k; i++) {
            for (int j = 0; j <= columnas - k; j++) {

                double suma = 0;

                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        suma += matriz[x][y].calcularValor();
                    }
                }

                if (suma > maxValor) {
                    maxValor = suma;
                    mejorFila = i;
                    mejorColumna = j;
                }
            }
        }

        mostrarResultado(mejorFila, mejorColumna, k, maxValor);
    }

    private void mostrarResultado(int fila, int col, int k, double valor) {

        System.out.println("\nRegión más valiosa encontrada:");
        System.out.println("Posición inicial: (" + fila + "," + col + ")");
        System.out.println("Tamaño de la región: " + k + " x " + k);

        HashMap<String, Integer> contadorMinerales = new HashMap<>();

        System.out.println("\nZonas analizadas:");

        for (int i = fila; i < fila + k; i++) {
            for (int j = col; j < col + k; j++) {

                Zona z = matriz[i][j];
                System.out.println("[ " + z + " ]");

                contadorMinerales.put(
                        z.getMineral(),
                        contadorMinerales.getOrDefault(z.getMineral(), 0) + 1
                );
            }
        }

        String predominante = "";
        int max = 0;

        for (String mineral : contadorMinerales.keySet()) {
            if (contadorMinerales.get(mineral) > max) {
                max = contadorMinerales.get(mineral);
                predominante = mineral;
            }
        }

        System.out.println("\nValor total estimado: " + valor);
        System.out.println("Mineral predominante en la región: " + predominante);
    }
}