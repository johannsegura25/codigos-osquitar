import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            Scanner archivo = new Scanner(new File("zonas.txt"));

            int filas = archivo.nextInt();
            int columnas = archivo.nextInt();

            Zona[][] matriz = new Zona[filas][columnas];

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {

                    String mineral = archivo.next();
                    double cantidad = archivo.nextDouble();
                    double pureza = archivo.nextDouble();

                    matriz[i][j] = new Zona(mineral, cantidad, pureza);
                }
            }

            archivo.close();

            Scanner teclado = new Scanner(System.in);

            System.out.print("Ingrese el tamaño de la subregión k: ");
            int k = teclado.nextInt();

            MapaMinero mapa = new MapaMinero(matriz, filas, columnas);

            mapa.analizarRegion(k);

        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}