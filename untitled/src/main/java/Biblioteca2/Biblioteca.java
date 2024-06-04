package Biblioteca2;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro.getInfo());
        }
    }

    public Libro buscarLibroPorTitulo(String titulo) throws Exception {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        throw new Exception("Libro con título '" + titulo + "' no encontrado.");
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        try {
            LibroDigital libroDigital = new LibroDigital("Digital Fortress", "Dan Brown", 1998, 1.5);
            LibroImpreso libroImpreso = new LibroImpreso("The Da Vinci Code", "Dan Brown", 2003, 689);

            biblioteca.agregarLibro(libroDigital);
            biblioteca.agregarLibro(libroImpreso);

            biblioteca.mostrarLibros();

            // Buscar un libro que no existe
            biblioteca.buscarLibroPorTitulo("Inferno");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
