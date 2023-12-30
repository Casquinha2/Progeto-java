import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.temporal.ChronoUnit;

public class Voos {
    private String paisSaida;
    private String paisChegada;
    private LocalDateTime HorarioDePartida;
    private LocalDateTime HorarioDeChegada;
    private double preco;
    private int lugaresReservados;
    private int lugaresLivres;

    public Voos() {
        Random random = new Random();
        this.paisSaida = obterPaisAleatorio(random);
        this.paisChegada = obterPaisAleatorio(random);
        this.HorarioDePartida = LocalDateTime.now().plus(random.nextInt(365), ChronoUnit.DAYS);
        this.HorarioDeChegada = this.HorarioDePartida.plus(random.nextInt(15), ChronoUnit.DAYS);
        this.preco = 0.0;
        this.lugaresReservados = 0;
        this.lugaresLivres = 0;
    }

    @Override
    public String toString() {
        return "Voos{" +
                "paisSaida='" + paisSaida + '\'' +
                ", paisChegada='" + paisChegada + '\'' +
                ", HorarioDePartida=" + HorarioDePartida +
                ", HorarioDeChegada=" + HorarioDeChegada +
                ", preco=" + preco +
                ", lugaresReservados=" + lugaresReservados +
                ", lugaresLivres=" + lugaresLivres +
                '}';
    }

    private static final List<String> paises = List.of(
            "Portugal","Brasil", "EUA", "Canadá", "Reino Unido", "Alemanha", "França", "Japão", "Austrália", "China", "Índia"
    );
    private String obterPaisAleatorio(Random random) {
        return paises.get(random.nextInt(paises.size()));
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
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Horário de Partida: " + this.HorarioDePartida.format(dateTimeFormatter));
        System.out.println("Horário de Chegada: " + this.HorarioDeChegada.format(dateTimeFormatter));
        System.out.println("Preço: " + this.preco + "€");
        System.out.println("Lugares Reservados: " + this.lugaresReservados);
        System.out.println("Lugares Livres: " + this.lugaresLivres);
    }

    public static List<Voos> criarListaDeVoosAleatorios() {
        List<Voos> listaVoos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            Voos voo = new Voos();
            voo.setHorarioDePartida(LocalDateTime.now().plus(random.nextInt(365), ChronoUnit.DAYS));
            voo.setHorarioDeChegada(voo.getHorarioDePartida().plus(random.nextInt(15), ChronoUnit.DAYS));
            voo.setPreco(50*i+100);
            voo.setLugaresReservados(random.nextInt(30));
            voo.setLugaresLivres(126-voo.getLugaresReservados());

            listaVoos.add(voo);
        }

        return listaVoos;
    }

    public static void exibirVoos(List<Voos> listaVoos) {
        for (Voos voo : listaVoos) {
            voo.informacoesDoVoo();
            System.out.println(); // Adicionar linha em branco entre informações dos voos
        }
    }
}
