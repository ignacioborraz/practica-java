package biblioteca;

public class LibroImpreso extends Libro{
    public LibroImpreso(String titulo, String autor, int fecha, int paginas) {
        super(titulo, autor, fecha);
        this.paginas = paginas;
    }

    private int paginas;

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public void getInfo() {
        System.out.println("El libro impreso se llama "+getTitulo()+" y tiene "+getPaginas());
    }
}
