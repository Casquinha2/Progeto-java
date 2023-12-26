import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Voos {
    private String paisSaida;
    private String paisChegada;
    private LocalDateTime HorarioDePartida;
    private LocalDateTime HorarioDeChegada;
    private double preco;
    private int lugaresReservados;
    private int lugaresLivres;

    public Voos() {
        this.paisSaida = "País de Saída Padrão";
        this.paisChegada = "País de Chegada Padrão";
        this.HorarioDePartida = LocalDateTime.now();
        this.HorarioDeChegada = LocalDateTime.now();
        this.preco = 0.0;
        this.lugaresReservados = 0;
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

    public LocalDateTime getHorarioDePartida() {
        return this.HorarioDePartida;
    }

    public void setHorarioDePartida(LocalDateTime HorarioDePartida) {
        this.HorarioDePartida = HorarioDePartida;
    }
    public LocalDateTime getHorarioDeChegada() {
        return this.HorarioDeChegada;
    }

    public void setHorarioDeChegada(LocalDateTime HorarioDeChegada) {
        this.HorarioDeChegada = HorarioDeChegada;
    }
    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getLugaresReservados() {
        return this.lugaresReservados;
    }

    public void setLugaresReservados(int lugaresReservados) {
        this.lugaresReservados = lugaresReservados;
    }

    public int getLugaresLivres() {
        return this.lugaresLivres;
    }

    public void setLugaresLivres(int lugaresLivres) {
        this.lugaresLivres = lugaresLivres;
    }

    public void informacoesDoVoo() {
        System.out.println("País de Saída: " + this.paisSaida);
        System.out.println("País de Chegada: " + this.paisChegada);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");;
        System.out.println("Horário de Partida: " + this.HorarioDePartida.format(dateTimeFormatter));
        System.out.println("Horário de Chegada: " + this.HorarioDeChegada.format(dateTimeFormatter));
        System.out.println("Preço: " + this.preco + "€");
        System.out.println("Lugares Reservados: " + this.lugaresReservados);
        System.out.println("Lugares Livres: " + this.lugaresLivres);
    }
}
