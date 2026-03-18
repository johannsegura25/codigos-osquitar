public class Verificador {
    // Caso sobreposición
    public static boolean esSobrePos(Rectangulo A, Rectangulo B) {
        double ax1 = Math.min(A.getEsquina1().getX(), A.getEsquina2().getX());
        double ax2 = Math.max(A.getEsquina1().getX(), A.getEsquina2().getX());
        double ay1 = Math.min(A.getEsquina1().getY(), A.getEsquina2().getY());
        double ay2 = Math.max(A.getEsquina1().getY(), A.getEsquina2().getY());
        double bx1 = Math.min(B.getEsquina1().getX(), B.getEsquina2().getX());
        double bx2 = Math.max(B.getEsquina1().getX(), B.getEsquina2().getX());
        double by1 = Math.min(B.getEsquina1().getY(), B.getEsquina2().getY());
        double by2 = Math.max(B.getEsquina1().getY(), B.getEsquina2().getY());
        return (ax1 < bx2 && ax2 > bx1 && ay1 < by2 && ay2 > by1);
    }
    // Caso juntos (tocan)
    public static boolean esJunto(Rectangulo A, Rectangulo B) {
        double ax1 = Math.min(A.getEsquina1().getX(), A.getEsquina2().getX());
        double ax2 = Math.max(A.getEsquina1().getX(), A.getEsquina2().getX());
        double ay1 = Math.min(A.getEsquina1().getY(), A.getEsquina2().getY());
        double ay2 = Math.max(A.getEsquina1().getY(), A.getEsquina2().getY());

        double bx1 = Math.min(B.getEsquina1().getX(), B.getEsquina2().getX());
        double bx2 = Math.max(B.getEsquina1().getX(), B.getEsquina2().getX());
        double by1 = Math.min(B.getEsquina1().getY(), B.getEsquina2().getY());
        double by2 = Math.max(B.getEsquina1().getY(), B.getEsquina2().getY());
        return (ax2 == bx1 || ax1 == bx2 || ay2 == by1 || ay1 == by2);
    }
    // Caso disjuntos
    public static boolean esDisjunto(Rectangulo A, Rectangulo B) {
        return !esSobrePos(A, B) && !esJunto(A, B);
    }
}