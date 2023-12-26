import java.time.LocalDateTime;

public class Code {
    public Code() {
        Aviao AviaoLMAO = new Aviao();
        AviaoLMAO.setNumeroDeLugares(150);
        AviaoLMAO.setModelo("Bruh Moment");

        Voos VooSeiLa = new Voos();
        VooSeiLa.setPaisSaida("Tu casa");
        VooSeiLa.setPaisChegada("MI CASA");

        // Definindo horário de partida para 1 de janeiro de 2024, às 9h
        LocalDateTime horarioPartida = LocalDateTime.of(2024, 1, 1, 9, 0);
        VooSeiLa.setHorarioDePartida(horarioPartida);

        // Definindo horário de chegada para 2 de janeiro de 2024, às 11h
        LocalDateTime horarioChegada = LocalDateTime.of(2024, 1, 2, 11, 0);
        VooSeiLa.setHorarioDeChegada(horarioChegada);

        VooSeiLa.setPreco(10000);
        VooSeiLa.setLugaresReservados(5);
        VooSeiLa.setLugaresLivres(AviaoLMAO.getNumeroDeLugares() - VooSeiLa.getLugaresReservados());

        AviaoLMAO.InformacoesDoAviao();
        VooSeiLa.informacoesDoVoo();
    }
}
