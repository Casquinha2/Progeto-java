
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
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
            "Portugal", "Brasil", "EUA", "Canadá", "Reino Unido", "Alemanha", "França", "Japão", "Austrália", "China", "Índia"
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

    private static final double[][] matrizDistancias = {
            // Portugal, Brasil, EUA, Canadá, Reino Unido, Alemanha, França, Japão, Austrália, China, Índia
            {0, 7000, 8000, 7500, 2000, 2500, 2200, 11000, 16000, 12000, 9500}, // Portugal
            {7000, 0, 5000, 4500, 6000, 6500, 7200, 18000, 7500, 16000, 14000}, // Brasil
            {8000, 5000, 0, 1500, 3500, 4000, 3800, 9000, 17000, 11000, 12000}, // EUA
            {7500, 4500, 1500, 0, 4000, 4500, 4200, 8500, 16500, 10500, 11000}, // Canadá
            {2000, 6000, 3500, 4000, 0, 500, 900, 11000, 17000, 11000, 8000},   // Reino Unido
            {2500, 6500, 4000, 4500, 500, 0, 600, 12000, 17500, 11500, 9000},  // Alemanha
            {2200, 7200, 3800, 4200, 900, 600, 0, 13000, 18000, 12000, 9500},  // França
            {11000, 18000, 9000, 8500, 11000, 12000, 13000, 0, 9000, 7000, 5000}, // Japão
            {16000, 7500, 17000, 16500, 17000, 17500, 18000, 9000, 0, 5000, 5500}, // Austrália
            {12000, 16000, 11000, 10500, 11000, 11500, 12000, 7000, 5000, 0, 2500}, // China
            {9500, 14000, 12000, 11000, 8000, 9000, 9500, 5000, 5500, 2500, 0}     // Índia
    };


    public static List<Voos> criarListaDeVoosAleatorios() {
        List<Voos> listaVoos = new ArrayList<>();
        Random random = new Random();
        // Gerar 2 voos com 126 lugares livres
        for (int i = 0; i < 2; i++) {
            Voos voo = new Voos();
            voo.setLugaresLivres(27);
            voo.setLugaresReservados(99);
            // Definir outras propriedades do voo aleatoriamente
            String paisSaida = voo.getPaisSaida();
            String paisChegada = voo.getPaisChegada();
            int indexPaisSaida = paises.indexOf(paisSaida);
            int indexPaisChegada = paises.indexOf(paisChegada);
            if (!paisSaida.equals(paisChegada)) {
                LocalDateTime horarioPartida = LocalDateTime.now().plus(random.nextInt(365), ChronoUnit.DAYS)
                        .plusHours(random.nextInt(5)).plusMinutes(random.nextInt(60));
                LocalDateTime horarioChegada;
                do {
                    horarioChegada = horarioPartida.plus(random.nextInt(1), ChronoUnit.DAYS).plusHours(random.nextInt(5)).plusMinutes(random.nextInt(60));
                } while (ChronoUnit.DAYS.between(horarioPartida, horarioChegada) > 1);

                voo.setHorarioDePartida(horarioPartida);
                voo.setHorarioDeChegada(horarioChegada);
                double distancia = matrizDistancias[indexPaisSaida][indexPaisChegada];
                voo.setPreco(distancia * 0.065); // Ajuste da fórmula para o preço com base na distância
                listaVoos.add(voo);
            }
        }

        // Gerar 2 voos com 180 lugares livres
        for (int i = 0; i < 2; i++) {
            Voos voo = new Voos();
            voo.setLugaresLivres(35);
            voo.setLugaresReservados(131);

            // Definir outras propriedades do voo aleatoriamente
            String paisSaida = voo.getPaisSaida();
            String paisChegada = voo.getPaisChegada();
            int indexPaisSaida = paises.indexOf(paisSaida);
            int indexPaisChegada = paises.indexOf(paisChegada);
            if (!paisSaida.equals(paisChegada)) {
                LocalDateTime horarioPartida = LocalDateTime.now().plus(random.nextInt(365), ChronoUnit.DAYS)
                        .plusHours(random.nextInt(5)).plusMinutes(random.nextInt(60));
                LocalDateTime horarioChegada;
                do {
                    horarioChegada = horarioPartida.plus(random.nextInt(1), ChronoUnit.DAYS).plusHours(random.nextInt(5)).plusMinutes(random.nextInt(60));
                } while (ChronoUnit.DAYS.between(horarioPartida, horarioChegada) > 1);

                voo.setHorarioDePartida(horarioPartida);
                voo.setHorarioDeChegada(horarioChegada);
                double distancia = matrizDistancias[indexPaisSaida][indexPaisChegada];
                voo.setPreco(distancia * 0.065); // Ajuste da fórmula para o preço com base na distância
                listaVoos.add(voo);
            }
        }

        return listaVoos;
    }

    public static List<String> Reserva(List<Assento> assentos) {
        Random random = new Random();
        List<String> listareservados = new ArrayList<>();
        String l;
        List<String> temporario = new ArrayList<>();

        for (Assento assento: assentos){
            l = assento.getNumero();
            temporario.add(l);
        }
        int i = (int) (temporario.size() * 0.8);
        for (int j = 0; j < +i - 1; j++) {
            int k = random.nextInt(temporario.size());
            String temp = temporario.remove(k);
            listareservados.add(temp);
        }
        return listareservados;
    }




    public static void exibirVoos(List<Voos> listaVoos) {
        int i = 1;
        for (Voos voo : listaVoos) {
            System.out.print("\n" + i + "- ");
            voo.informacoesDoVoo();
            // Adicionar linha em branco entre informações dos voos
            i++;
        }
    }

}
