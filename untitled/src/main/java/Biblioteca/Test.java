package Biblioteca;

public class Test {
    public static void main(String[] args) {
        LibroDigital libroDigital = new LibroDigital("Digital Fortress", "Dan Brown", 1998, 1.5);
        LibroImpreso libroImpreso = new LibroImpreso("The Da Vinci Code", "Dan Brown", 2003, 689);

        System.out.println(libroDigital.getInfo());
        System.out.println(libroImpreso.getInfo());
    }
}
