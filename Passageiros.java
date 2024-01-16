// Classe que representa um passageiro de voo
public class Passageiros {
    private String nome;
    private int id;
    private static int nextid = 0; // Usado para atribuir IDs exclusivos automaticamente
    private String pais;
    private boolean seguro;
    private boolean bagagemExtra;
    private boolean checkInAutomatico;
    private String metodoPagamento;
    private String dadosLugar;
    private int vooReservado;

    // Construtor da classe Passageiros
    public Passageiros(String nome, String pais, boolean seguro, boolean bagagemExtra, boolean checkInAutomatico, String metodoPagamento, String dadosLugar, int vooReservado) {
        this.nome = nome;
        this.pais = pais;
        this.id = nextid++; // Atribui um ID único e incrementa o próximo ID disponível
        this.seguro = seguro;
        this.bagagemExtra = bagagemExtra;
        this.checkInAutomatico = checkInAutomatico;
        this.vooReservado = vooReservado;
        this.dadosLugar = dadosLugar;
        this.metodoPagamento = metodoPagamento;
    }

    // Método para verificar se o passageiro escolheu seguro
    public boolean isSeguro() {
        return seguro;
    }

    // Método para definir se o passageiro escolheu seguro
    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    // Método para verificar se o passageiro escolheu bagagem extra
    public boolean isBagagemExtra() {
        return bagagemExtra;
    }

    // Método para definir se o passageiro escolheu bagagem extra
    public void setBagagemExtra(boolean bagagemExtra) {
        this.bagagemExtra = bagagemExtra;
    }

    // Método para verificar se o passageiro escolheu check-in automático
    public boolean isCheckInAutomatico() {
        return checkInAutomatico;
    }

    // Método para definir se o passageiro escolheu check-in automático
    public void setCheckInAutomatico(boolean checkInAutomatico) {
        this.checkInAutomatico = checkInAutomatico;
    }

    // Método para obter o ID do passageiro
    public int getId() {
        return this.id;
    }

    // Método para obter o método de pagamento do passageiro
    public String getMetodoPagamento() {
        return this.metodoPagamento;
    }

    // Método para definir o método de pagamento do passageiro
    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    // Método para obter o número do voo reservado pelo passageiro
    public int getVooReservado() {
        return vooReservado;
    }

    // Método para definir o número do voo reservado pelo passageiro
    public void setVooReservado(int vooReservado) {
        this.vooReservado = vooReservado;
    }

    // Método para obter os dados do lugar do passageiro
    public String getDadosLugar() {
        return this.dadosLugar;
    }

    // Método para definir os dados do lugar do passageiro
    public void setDadosLugar(String dadosLugar) {
        this.dadosLugar = dadosLugar;
    }

    // Método para calcular o preço final do voo com base nas opções do passageiro
    public double calcularPrecoVoo(Voos voo, String classeAssento) {
        double precoFinal = voo.getPreco(); // Preço base do voo
        // Adiciona 20€ se o passageiro escolher seguro
        if (this.seguro) {
            precoFinal += 20;
        }
        // Adiciona 50€ se o passageiro tiver bagagem extra
        if (this.bagagemExtra) {
            precoFinal += 50;
        }

        // Se o assento for da classe Business, aumenta o preço em 1.9 vezes
        if (classeAssento.equalsIgnoreCase("Business")) {
            precoFinal *= 1.9;
        }
        return precoFinal;
    }

    // Sobrescrita do método toString para representar os dados do passageiro em forma de string
    @Override
    public String toString() {
        return "Passageiros{" +
                "nome='" + nome + '\'' +
                ", Id=" + id +
                ", Pais='" + pais + '\'' +
                ", Seguro=" + seguro +
                ", Bagagem Extra=" + bagagemExtra +
                ", Check-In Automático=" + checkInAutomatico +
                ", Voo Reservado=" + vooReservado +
                ", Dados do Lugar='" + dadosLugar + '\'' +
                ", Método de Pagamento='" + metodoPagamento + '\'' +
                '}';
    }
}
