import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.temporal.ChronoUnit;

public class Voos {
    private String pais_saida;
    private String pais_chegada;
    private LocalDateTime horario_de_partida;
    private LocalDateTime horario_de_chegada;
    private double preco;
    private int lugares_reservados;
    private int lugares_livres;
    private int numeroVoo;
    private List<Assento> assentos;

    public int getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(int numeroVoo) {
        this.numeroVoo = numeroVoo;
    }
    // ...

    public String getPaisSaida() {
        return this.pais_saida;
    }

    public static String obterPaisAleatorio(Random random) {
        List<String> paises = List.of(
                "Portugal", "Brasil", "EUA", "Canadá", "Reino Unido", "Alemanha", "França", "Japão", "Austrália", "China", "Índia", "Espanha", "Croácia"
        );
        int indiceAleatorio = random.nextInt(paises.size());
        return paises.get(indiceAleatorio);

    }

    public static List<Voos> criarListaDeVoosAleatorios() {
        List<Voos> listaVoos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            Voos voo = new Voos();
            voo.setPaisSaida(obterPaisAleatorio(random));
            voo.setPaisChegada(obterPaisAleatorio(random));
            voo.setHorarioDePartida(LocalDateTime.now().plus(random.nextInt(365), ChronoUnit.DAYS));
            voo.setHorarioDeChegada(voo.getHorarioDePartida().plus(random.nextInt(24) + 1, ChronoUnit.HOURS));
            voo.setPreco(50 * i + 100);
            voo.setLugaresReservados(random.nextInt(30));
            voo.setLugaresLivres(126 - voo.getLugaresReservados());

            listaVoos.add(voo);
        }
        return listaVoos;
    }

    public static void exibirVoos(List<Voos> listaVoos) {
        for (Voos voo : listaVoos) {
            System.out.println("Informações do voo exibidas: " + voo.getPaisSaida() + " para " + voo.getPaisChegada());
            voo.informacoesDoVoo();
            voo.exibirAssentosDisponiveis(); // Exibir os assentos disponíveis
            System.out.println(); // Adicionar linha em branco entre informações dos voos
            System.out.println(); // Adicionar linha em branco entre informações dos voos
        }
    }

    public void setPaisSaida(String paisSaida) {
        this.pais_saida = paisSaida;
    }

    public String getPaisChegada() {
        return this.pais_chegada;
    }

    public void setPaisChegada(String paisChegada) {
        this.pais_chegada = paisChegada;
    }

    public LocalDateTime getHorarioDePartida() {
        return this.horario_de_partida;
    }

    public void setHorarioDePartida(LocalDateTime horarioDePartida) {
        this.horario_de_partida = horarioDePartida;
    }

    public LocalDateTime getHorarioDeChegada() {
        return this.horario_de_chegada;
    }

    public void setHorarioDeChegada(LocalDateTime horarioDeChegada) {
        this.horario_de_chegada = horarioDeChegada;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getLugaresReservados() {
        return this.lugares_reservados;
    }

    public void setLugaresReservados(int lugaresReservados) {
        this.lugares_reservados = lugaresReservados;
    }

    public int getLugaresLivres() {
        return this.lugares_livres;
    }

    public void setLugaresLivres(int lugaresLivres) {
        this.lugares_livres = lugaresLivres;
    }

    public String informacoesDoVoo() {
        System.out.println("País de Saída: " + this.pais_saida);
        System.out.println("País de Chegada: " + this.pais_chegada);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Horário de Partida: " + this.horario_de_partida.format(dateTimeFormatter));
        System.out.println("Horário de Chegada: " + this.horario_de_chegada.format(dateTimeFormatter));
        System.out.println("Preço: " + this.preco + "€");
        System.out.println("Lugares Reservados: " + this.lugares_reservados);
        System.out.println("Lugares Livres: " + this.lugares_livres);
        return "Informações do voo exibidas: " + this.getPaisSaida() + " para " + this.getPaisChegada();

    }

    public boolean podeSerReservado() {
        return lugares_livres > 0;
    }

    // ...
    public void reservarVoo() {
        if (podeSerReservado()) {
            lugares_reservados++;
            lugares_livres--;
        } else {
            System.out.println("Este voo não pode ser reservado, todos os lugares estão ocupados.");
        }
    }

    public Voos() {
        assentos = new ArrayList<>();
        for (int i = 1; i <= 126; i++) {
            Assento assento = new Assento(i); // Cria um novo assento com base no número de assento
            assentos.add(assento); // Adiciona o assento à lista de assentos do voo
        }
    }

    public List<Assento> getAssentos() {
        return assentos;
    }

    public void exibirAssentosDisponiveis() { // Exibindo os assentos disponíveis  eric rosario
        System.out.println("Assentos disponíveis:");

        for (Assento assento : assentos) {
            if (!assento.isReservado()) {
                System.out.println(assento.toString());
            }
        }
    }

    public Assento escolherAssento(int fila, char coluna, String descricaoAssento) { // Escolhendo um assento   eric rosario
        for (Assento assento : assentos) {
            if (!assento.isReservado() && assento.getFila() == fila && assento.getColuna() == coluna) {
                return assento;
            }
        }
        return null; // Retorna null se o assento não estiver disponível
    }

    public void reservarAssento(Assento assento) { //Reservando um assento escolhido
        if (assento != null) {
            if (!assento.isReservado()) {
                assento.setReservado(true);
                System.out.println("Assento reservado com sucesso!");
            } else {
                System.out.println("Este assento já está reservado.");
            }
        } else {
            // Informa ao usuário que o assento não está disponível
            System.out.println("Assento escolhido não está disponível.");
        }


    }
}