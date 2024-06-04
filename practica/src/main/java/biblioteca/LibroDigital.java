package biblioteca;

public class LibroDigital extends Libro{
    private double tamanoArchivo;

    public LibroDigital(String titulo, String autor, int fecha, double tamanoArchivo) {
        super(titulo, autor, fecha);
        this.tamanoArchivo = tamanoArchivo;
    }

    public double getTamanoArchivo() {
        return tamanoArchivo;
    }

    public void setTamanoArchivo(double tamanoArchivo) {
        this.tamanoArchivo = tamanoArchivo;
    }

    @Override
    public void getInfo() {
        System.out.println("El libro digital se llama "+getTitulo()+" y pesa "+getTamanoArchivo());
    }
}
