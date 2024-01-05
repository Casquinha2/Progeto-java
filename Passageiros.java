public class Passageiros {
    private String nome;
    private int id;
    private static int next_id = 0;
    private int lugar_reservado;
    private String pais;
    private boolean seguro;
    private boolean bagagem_extra;
    private boolean check_in_automatico;

    public Passageiros(String nome, String pais, boolean seguro, boolean bagagemExtra, boolean checkInAutomatico) {
        this.nome = nome;
        this.pais = pais;
        this.id = next_id++;
        this.lugar_reservado = 0;
        this.seguro = seguro;
        this.bagagem_extra = bagagemExtra;
        this.check_in_automatico = checkInAutomatico;
    }

    // Getters and setters for the new attributes
    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public boolean isBagagemExtra() {
        return bagagem_extra;
    }

    public void setBagagemExtra(boolean bagagemExtra) {
        this.bagagem_extra = bagagemExtra;
    }

    public boolean isCheckInAutomatico() {
        return check_in_automatico;
    }

    public void setCheckInAutomatico(boolean checkInAutomatico) {
        this.check_in_automatico = checkInAutomatico;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Passageiros{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", lugar_reservado=" + lugar_reservado +
                ", pais='" + pais + '\'' +
                ", seguro=" + seguro +
                ", bagagem_extra=" + bagagem_extra +
                ", check_in_automatico=" + check_in_automatico +
                '}';
    }

    public double calcularPrecoVoo(Voos voo) {
        double precoFinal = voo.getPreco(); // Preço base do voo

        // Adiciona 20€ se o passageiro escolher seguro
        if (this.seguro) {
            precoFinal += 20;
        }

        // Adiciona 50€ se o passageiro tiver bagagem extra
        if (this.bagagem_extra) {
            precoFinal += 50;
        }

        return precoFinal;
    }
}