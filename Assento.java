import java.util.List;

// A classe Assento representa informações sobre os assentos disponíveis em voos.
class Assento {
    private String numero; // Número do assento.
    private int fila; // Número da fila do assento.
    private char coluna; // Letra da coluna do assento.
    private String local; // Localização do assento (por exemplo, janela, corredor).
    private String classe; // Classe do assento (por exemplo, econômica, executiva).
    private boolean reservado; // Indica se o assento está reservado ou não.

    // Construtor da classe Assento para inicializar os atributos.
    public Assento(String numero, int fila, char coluna, String local, String classe) {
        this.numero= numero;
        this.fila = fila; // Você pode definir a fila como o número
        this.coluna = coluna;
        this.local = local;
        this.classe = classe;
        this.reservado = false;
    }

    // Métodos getters e setters para os atributos da classe Assento.
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

    // Método toString para representar um objeto Assento como uma string formatada.
    @Override
    public String toString() {
        // Implemente o método toString para representar os assentos como desejar
        // Retorne uma string com informações relevantes do assento
        return "Assento: " + numero + ", Fila: " + fila + ", Coluna: " + coluna + ", Local: " + local + ", Classe: " + classe;
    }

    // Métodos adicionais para obter a fila e a coluna do assento.
    public int getFila() {
        return fila;
    }public int getColuna() {
        return coluna;
    }

    // Método estático para verificar a classe de um assento com base no número do voo e no lugar escolhido.
    public static String verificarClasseAssento(int numeroVooEscolhido, List<Assento> voo1, List<Assento> voo2, List<Assento> voo3, List<Assento> voo4, String lugarEscolhido) {
        String classeAssento = "";
        List<Assento> listaAssentos = null;

        // Seleciona a lista de assentos com base no número do voo escolhido.
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

        // Verifica a classe do assento com base no lugar escolhido.
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

