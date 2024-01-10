public class Passageiros {
    private String nome;
    private int id;
    private static int nextid = 0;
    private String pais;
    private boolean seguro;
    private boolean bagagemExtra;
    private boolean checkInAutomatico;
    private String metodoPagamento ;
    private String dadosLugar;
    private int vooReservado;



    public Passageiros(String nome, String pais, boolean seguro, boolean bagagemExtra, boolean checkInAutomatico, String metodoPagamento, String dadosLugar, int vooReservado) {
        this.nome = nome;
        this.pais = pais;
        this.id = nextid++;
        this.seguro = seguro;
        this.bagagemExtra = bagagemExtra;
        this.checkInAutomatico = checkInAutomatico;
        this.vooReservado = vooReservado;
        this.dadosLugar = dadosLugar ;
        this.metodoPagamento = metodoPagamento ;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public boolean isBagagemExtra() {
        return bagagemExtra;
    }

    public void setBagagemExtra(boolean bagagemExtra) {
        this.bagagemExtra = bagagemExtra;
    }

    public boolean isCheckInAutomatico() {
        return checkInAutomatico;
    }

    public void setCheckInAutomatico(boolean checkInAutomatico) {
        this.checkInAutomatico = checkInAutomatico;
    }

    public int getId() {
        return this.id;
    }

    public String getMetodoPagamento() {
        return this.metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public int getVooReservado() {
        return vooReservado;
    }

    public void setVooReservado(int vooReservado) {
        this.vooReservado = vooReservado;
    }

    public String getDadosLugar() {
        return this.dadosLugar;
    }
    public void setDadosLugar(String dadosLugar) {
        this.dadosLugar = dadosLugar;
    }


    @Override
    public String toString() {
        return "Passageiros{" +
                "nome='" + nome + '\'' +
                ", Id=" + id +
                ", Pais='" + pais + '\'' +
                ", Seguro=" + seguro +
                ", Bagagem Extra=" + bagagemExtra +
                ", CheckIn Automatico=" + checkInAutomatico +
                ", Voo Reservado=" + vooReservado +
                ", Dados do Lugar=" + dadosLugar +
                ", Metodo de Pagamento=" + metodoPagamento +
        '}';
    }

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
}
