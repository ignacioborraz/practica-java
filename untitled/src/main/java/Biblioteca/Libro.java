package Biblioteca;

import java.util.Objects;

public abstract class Libro {
    private String titulo;
    private String autor;
    private int fecha;

    public Libro() {}

    public Libro(String titulo, String autor, int fecha) {
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Libro libro = (Libro) obj;
        return fecha == libro.fecha &&
                titulo.equals(libro.titulo) &&
                autor.equals(libro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, fecha);
    }

    @Override
    public String toString() {
        return "Libro{titulo='" + titulo + "', autor='" + autor + "', fecha=" + fecha + '}';
    }

    public abstract String getInfo();
}

