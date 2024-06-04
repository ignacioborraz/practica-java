package Biblioteca2;

public class LibroImpreso extends Libro {
    private int numeroPaginas;

    public LibroImpreso(String titulo, String autor, int fecha, int numeroPaginas) {
        super(titulo, autor, fecha);
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String getInfo() {
        return "LibroImpreso{" +
                "titulo='" + getTitulo() + '\'' +
                ", autor='" + getAutor() + '\'' +
                ", fecha=" + getFecha() +
                ", numeroPaginas=" + numeroPaginas +
                '}';
    }
}
