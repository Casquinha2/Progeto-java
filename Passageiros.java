public class Passageiros {
    private String nome;
    private int id;
    private static int nextid = 0;
    private int lugarreservado;
    private String pais;
    private boolean seguro;
    private boolean bagagemExtra;
    private boolean checkInAutomatico;
    private String metodoPagamento ;
    private String dadosLugar;
    private int lugarReservado;


    public Passageiros(String nome, String pais, boolean seguro, boolean bagagemExtra, boolean checkInAutomatico, String metodoPagamento, String dadosLugar) {
        this.nome = nome;
        this.pais = pais;
        this.id = nextid++;
        this.lugarreservado = 0;
        this.seguro = seguro;
        this.bagagemExtra = bagagemExtra;
        this.checkInAutomatico = checkInAutomatico;
        this.metodoPagamento = metodoPagamento ;
        this.dadosLugar = dadosLugar ;
        this.lugarReservado = lugarReservado;
    }

    // Getters and setters for the new attributes
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
                ", id=" + id +
                ", lugarreservado=" + lugarreservado +
                ", pais='" + pais + '\'' +
                ", seguro=" + seguro +
                ", bagagemExtra=" + bagagemExtra +
                ", checkInAutomatico=" + checkInAutomatico +
                ", metodoPagamento=" + metodoPagamento +
                ", dadosLugar=" + dadosLugar +
        '}';
    }

    public double calcularPrecoVoo(Voos voo) {
        double precoFinal = voo.getPreco(); // Preço base do voo

        // Adiciona 20€ se o passageiro escolher segur
        if (this.seguro) {
            precoFinal += 20;
        }

        // Adiciona 50€ se o passageiro tiver bagagem extra
        if (this.bagagemExtra) {
            precoFinal += 50;
        }

        return precoFinal;
    }
}
