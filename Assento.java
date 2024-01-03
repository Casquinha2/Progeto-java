
class Assento { // Renomeando a classe para Assento
    private String numero;
    private int fila;
    private char coluna;
    private String local;
    private String classe;
    private boolean reservado; // Adicionado atributo reservado

    public Assento(int numer) {
        this.numero = Integer.toString(numer);
        this.fila = numer; // Você pode definir a fila como o número
        this.coluna = 'A'; // Por exemplo, definir a coluna como 'A' inicialmente
        this.local = "Indefinido"; // Definir o local como "Indefinido" inicialmente
        this.classe = "Indefinido"; // Definir a classe como "Indefinido" inicialmente
        this.reservado = false; // Inicializado como não reservado
    }
    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public String toString() {
        return "Assento " + numero + ": Fila " + fila + ", Coluna " + coluna + ", Local " + local + ", Classe " + classe;
    }
    public int getFila() {
        return fila;
    }public int getColuna() {
        return coluna;
    }


}

