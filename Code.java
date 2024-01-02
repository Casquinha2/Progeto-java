import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Code {
    public Code() throws IOException {


        Json json = new Json();
        List<Passageiros> listapessoas = (List<Passageiros>) json.ler_passageiros();
        List<Voos> listavoos = (List<Voos>) json.ler_voos();

        for (Voos voo : listavoos) {
            voo.informacoesDoVoo();
            System.out.println(); // Adicionar linha em branco entre informações dos voos
        }

        Texto TextoIncio = new Texto();
        TextoIncio.MensagemEntrada(listapessoas, listavoos);
        Aviao aviaoboieng737 = new Aviao(126,"Boeing 737");
        aviaoboieng737.setNumeroDeLugares(120);
        aviaoboieng737.setModelo("Bruh Moment");

        Voos VooSeiLa = new Voos();
        VooSeiLa.setPaisSaida("Tu casa");
        VooSeiLa.setPaisChegada("MI CASA");

        listavoos.add(VooSeiLa);

        System.out.println(VooSeiLa.toString());

        // Definindo horário de partida para 1 de janeiro de 2024, às 9h
        LocalDateTime horarioPartida = LocalDateTime.of(2024, 1, 1, 9, 0);
        VooSeiLa.setHorarioDePartida(horarioPartida);

        // Definindo horário de chegada para 2 de janeiro de 2024, às 11h
        LocalDateTime horarioChegada = LocalDateTime.of(2024, 1, 2, 11, 0);
        VooSeiLa.setHorarioDeChegada(horarioChegada);

        VooSeiLa.setPreco(10000);
        VooSeiLa.setLugaresReservados(5);
        VooSeiLa.setLugaresLivres(aviaoboieng737.getNumeroDeLugares() - VooSeiLa.getLugaresReservados());
        aviaoboieng737.informacoesDoAviao();
        VooSeiLa.informacoesDoVoo();




        aviaoboieng737.informacoesDosAssentos();



        Passageiros pessoa1 = new Passageiros("Tiago","Portugal", false,false,false);
        Passageiros pessoa2 = new Passageiros("Hugo","Espanha",false,false,false);
        //Salvar os passageiros em um json
        listapessoas.add(pessoa1);
        listapessoas.add(pessoa2);
        json.salvar_passageiros(listapessoas);

        json.salvar_voos(listavoos);


    }
}
