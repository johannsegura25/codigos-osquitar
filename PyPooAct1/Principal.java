import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear Rectángulo A
        System.out.println("Ingrese esquina 1 A:");
        Coordenada a1 = new Coordenada(sc.nextDouble(), sc.nextDouble());

        System.out.println("Ingrese esquina 2 A:");
        Coordenada a2 = new Coordenada(sc.nextDouble(), sc.nextDouble());
        Rectangulo A = new Rectangulo(a1, a2);

        // Crear Rectángulo B
        System.out.println("Ingrese esquina 1 B:");
        Coordenada b1 = new Coordenada(sc.nextDouble(), sc.nextDouble());

        System.out.println("Ingrese esquina 2 B:");
        Coordenada b2 = new Coordenada(sc.nextDouble(), sc.nextDouble());
        Rectangulo B = new Rectangulo(b1, b2);

        // Mostrar información
        mostrarRectangulo("A", A);
        mostrarRectangulo("B", B);

        // Verificar casos
        if (Verificador.esSobrePos(A, B)) {
            System.out.println("Rectangulos A y B se sobreponen.");
            Rectangulo inter = rectanguloSobre(A, B);
            System.out.println("Area de sobreposicion = " + inter.calcularArea());
        } else if (Verificador.esJunto(A, B)) {
            System.out.println("Rectangulos A y B se juntan.");
        } else {
            System.out.println("Rectangulos A y B son disjuntos.");
        }
    }

    // Método para mostrar rectángulo
    public static void mostrarRectangulo(String nombre, Rectangulo r) {
        System.out.println("Rectangulo " + nombre + " = " + r);
    }

    // Método que devuelve rectángulo de sobreposición
    public static Rectangulo rectanguloSobre(Rectangulo A, Rectangulo B) {
        double ax1 = Math.min(A.getEsquina1().getX(), A.getEsquina2().getX());
        double ax2 = Math.max(A.getEsquina1().getX(), A.getEsquina2().getX());
        double ay1 = Math.min(A.getEsquina1().getY(), A.getEsquina2().getY());
        double ay2 = Math.max(A.getEsquina1().getY(), A.getEsquina2().getY());

        double bx1 = Math.min(B.getEsquina1().getX(), B.getEsquina2().getX());
        double bx2 = Math.max(B.getEsquina1().getX(), B.getEsquina2().getX());
        double by1 = Math.min(B.getEsquina1().getY(), B.getEsquina2().getY());
        double by2 = Math.max(B.getEsquina1().getY(), B.getEsquina2().getY());

        double x1 = Math.max(ax1, bx1);
        double y1 = Math.max(ay1, by1);
        double x2 = Math.min(ax2, bx2);
        double y2 = Math.min(ay2, by2);

        Coordenada c1 = new Coordenada(x1, y1);
        Coordenada c2 = new Coordenada(x2, y2);

        return new Rectangulo(c1, c2);
    }
}