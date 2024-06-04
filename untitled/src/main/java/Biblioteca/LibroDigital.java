package Biblioteca;

public class LibroDigital extends Libro {
    private double pesoArchivo; // en MB

    public LibroDigital(String titulo, String autor, int fecha, double pesoArchivo) {
        super(titulo, autor, fecha);
        this.pesoArchivo = pesoArchivo;
    }

    public double getPesoArchivo() {
        return pesoArchivo;
    }

    public void setPesoArchivo(double pesoArchivo) {
        this.pesoArchivo = pesoArchivo;
    }

    @Override
    public String getInfo() {
        return "LibroDigital{" +
                "titulo='" + getTitulo() + '\'' +
                ", autor='" + getAutor() + '\'' +
                ", fecha=" + getFecha() +
                ", pesoArchivo=" + pesoArchivo + "MB" +
                '}';
    }
}

