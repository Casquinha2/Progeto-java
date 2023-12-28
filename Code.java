import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Code {
    public Code() throws IOException {


        Json json = new Json();
        List<Passageiros> listapessoas = (List<Passageiros>) json.ler();


        Texto TextoIncio = new Texto();
        TextoIncio.MensagemEntrada(listapessoas);
        Aviao aviaoboieng737 = new Aviao(126,"Boeing 737");
        aviaoboieng737.setNumeroDeLugares(120);
        aviaoboieng737.setModelo("Bruh Moment");

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
        VooSeiLa.setLugaresLivres(aviaoboieng737.getNumeroDeLugares() - VooSeiLa.getLugaresReservados());
        aviaoboieng737.informacoesDoAviao();
        VooSeiLa.informacoesDoVoo();




        aviaoboieng737.informacoesDosAssentos();



        Passageiros pessoa1 = new Passageiros("Tiago","Portugal");
        Passageiros pessoa2 = new Passageiros("Hugo","Espanha");
        //Salvar os passageiros em um json
        //listapessoas.add(pessoa1);
        //listapessoas.add(pessoa2);
        json.salvar(listapessoas);


    }
}
