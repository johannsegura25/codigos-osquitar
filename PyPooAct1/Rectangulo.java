public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;
    // Constructor
    public Rectangulo(Coordenada c1, Coordenada c2) {
        this.esquina1 = new Coordenada(c1); // copia
        this.esquina2 = new Coordenada(c2); // copia
    }
    // Getters
    public Coordenada getEsquina1() {
        return esquina1;
    }
    public Coordenada getEsquina2() {
        return esquina2;
    }
    // Setters
    public void setEsquina1(Coordenada c) {
        this.esquina1 = new Coordenada(c); // copia para encapsulamiento
    }
    public void setEsquina2(Coordenada c) {
        this.esquina2 = new Coordenada(c); // copia
    }
    // toString
    public String toString() {
        return "(" + esquina1 + ", " + esquina2 + ")";
    }
    // Calcular área
    public double calcularArea() {
        double base = Math.abs(esquina1.getX() - esquina2.getX());
        double altura = Math.abs(esquina1.getY() - esquina2.getY());
        return base * altura;
    }
}