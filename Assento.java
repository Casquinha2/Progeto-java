import java.awt.*;

class Assento { // Renomeando a classe para Assento
    private String numero;
    private int fila;
    private char coluna;
    private String local;
    private String classe;
    public Assento(String numero, int fila, char coluna, String tipo, String classe) {
        this.numero = numero;
        this.fila = fila;
        this.coluna = coluna;
        this.local = tipo;
        this.classe = classe;
    }

    public String toString() {
        return "Assento " + numero + ": Fila " + fila + ", Coluna " + coluna + ", Local " + local + ", Classe " + classe;
    }


}