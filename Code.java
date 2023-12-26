public class Code {
    public Code(){
        Aviao AviaoLMAO = new Aviao();

        AviaoLMAO.setNumeroDeLugares(150);
        AviaoLMAO.setModelo("Bruh Moment");

        Voos VooSeiLa = new Voos();

        VooSeiLa.setPaisSaida("Tu casa");
        VooSeiLa.setPaisChegada("MI CASA");
        VooSeiLa.setHorario("Ainda nao pus configuracoes de horario por isso fica assim lmao");
        VooSeiLa.setPreco(10000);
        VooSeiLa.setLugaresReservados(5);
        VooSeiLa.setLugaresLivres(AviaoLMAO.getNumeroDeLugares() - VooSeiLa.getLugaresReservados());
        AviaoLMAO.InformacoesDoAviao();
        VooSeiLa.InformacoesDoVoo();

    }
}
