public class Voos {
    private String paisSaida;
    private String paisChegada;
    private String horario;
    private double preco;
    private int LugaresReservados;
    private int lugaresLivres;



    public Voos() {
        // inicializa os valores padrão ou define-os conforme necessário
        this.paisSaida = "País de Saída Padrão";
        this.paisChegada = "País de Chegada Padrão";
        this.horario = "Horário Padrão";
        this.preco = 0.0;
        this.LugaresReservados = 0;
        this.lugaresLivres = 0;
    }

    public String getPaisSaida() {
        return this.paisSaida;
    }

    public void setPaisSaida(String paisSaida) {
        this.paisSaida = paisSaida;
    }

    public String getPaisChegada() {
        return this.paisChegada;
    }

    public void setPaisChegada(String paisChegada) {
        this.paisChegada = paisChegada;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getLugaresReservados() {
        return this.LugaresReservados;
    }

    public void setLugaresReservados(int LugaresReservados) {
        this.LugaresReservados = LugaresReservados;
    }

    public int getLugaresLivres() {
        return this.lugaresLivres;
    }

    public void setLugaresLivres(int lugaresLivres) {
        this.lugaresLivres = lugaresLivres;
    }

    public void InformacoesDoVoo() {
        System.out.println("País de Saída: " + this.paisSaida);
        System.out.println("País de Chegada: " + this.paisChegada);
        System.out.println("Horário: " + this.horario);
        System.out.println("Preço: " + this.preco + "€");
        System.out.println("Lugares Reservados: " + this.LugaresReservados);
        System.out.println("Lugares Livres: " + this.lugaresLivres);
    }
}
