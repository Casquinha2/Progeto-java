import java.util.List;

class Assento { // Renomeando a classe para Assento
    private String numero;
    private int fila;
    private char coluna;
    private String local;
    private String classe;
    private boolean reservado; // Adicionado atributo reservado

    public Assento(String numero, int fila, char coluna, String local, String classe) {
        this.numero= numero;
        this.fila = fila; // Você pode definir a fila como o número
        this.coluna = coluna;
        this.local = local;
        this.classe = classe;
        this.reservado = false;
    }

    public String getNumero() {
        return numero;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        // Implemente o método toString para representar os assentos como desejar
        // Retorne uma string com informações relevantes do assento
        return "Assento: " + numero + ", Fila: " + fila + ", Coluna: " + coluna + ", Local: " + local + ", Classe: " + classe;
    }
    public int getFila() {
        return fila;
    }public int getColuna() {
        return coluna;
    }
    public static String verificarClasseAssento(int numeroVooEscolhido, List<Assento> voo1, List<Assento> voo2, List<Assento> voo3, List<Assento> voo4, String lugarEscolhido) {
        String classeAssento = "";
        List<Assento> listaAssentos = null;

        switch (numeroVooEscolhido) {
            case 1:
                listaAssentos = voo1;
                break;
            case 2:
                listaAssentos = voo2;
                break;
            case 3:
                listaAssentos = voo3;
                break;
            case 4:
                listaAssentos = voo4;
                break;
            default:
                System.out.println("Número do voo inválido.");
                break;
        }

        if (listaAssentos != null) {
            for (Assento assento : listaAssentos) {
                if (assento.getNumero().equals(lugarEscolhido)) {
                    classeAssento = assento.getClasse();
                    break;
                }
            }
        }

        return classeAssento;
    }

}

