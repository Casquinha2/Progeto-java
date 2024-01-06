import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Code {
    public Code() throws IOException {
        Json json = new Json();
        Texto textoincio = new Texto();

        // Carregar voos do arquivo JSON
        List<Voos> listavoos = (List<Voos>) json.ler_voos();

        // Criar aviões
        Aviao aviaoboieng737 = new Aviao(126, "Boeing 737");
        Aviao aviaoa320 = new Aviao(180, "A320");

        // Gerar assentos para os aviões
        List<Assento> boiengassento1 = aviaoboieng737.gerarAssentos();
        List<Assento> boiengassento2 = new ArrayList<>(boiengassento1); // Cópia dos assentos
        List<Assento> a320assento1 = aviaoa320.gerarAssentos();
        List<Assento> a320assento2 = new ArrayList<>(a320assento1); // Cópia dos assentos

        // Salvar os assentos associados aos voos no arquivo JSON
        Json.salvarAssentosJSON(listavoos,boiengassento1,boiengassento2,a320assento1,a320assento2);

        textoincio.MensagemEntrada();
        while (true) {
            textoincio.ExibirMenu(json.ler_passageiros(), listavoos,boiengassento1,boiengassento2,a320assento1,a320assento2);
        }
    }


//Voos VooSeiLa = new Voos();
        //VooSeiLa.setPaisSaida("Tu casa");
        //VooSeiLa.setPaisChegada("MI CASA");

        //listavoos.add(VooSeiLa);

        //System.out.println(VooSeiLa.toString());

        // Definindo horário de partida para 1 de janeiro de 2024, às 9h
        //LocalDateTime horarioPartida = LocalDateTime.of(2024, 1, 1, 9, 0);
        //VooSeiLa.setHorarioDePartida(horarioPartida);

        // Definindo horário de chegada para 2 de janeiro de 2024, às 11h
        //LocalDateTime horarioChegada = LocalDateTime.of(2024, 1, 2, 11, 0);
        //VooSeiLa.setHorarioDeChegada(horarioChegada);

        //VooSeiLa.setPreco(10000);
        //VooSeiLa.setLugaresReservados(5);
        //VooSeiLa.setLugaresLivres(aviaoboieng737.getNumeroDeLugares() - VooSeiLa.getLugaresReservados());
        //aviaoboieng737.informacoesDoAviao();
        //VooSeiLa.informacoesDoVoo();




        //aviaoboieng737.informacoesDosAssentos();



        //Passageiros pessoa1 = new Passageiros("Tiago","Portugal", false,false,false);
        //Passageiros pessoa2 = new Passageiros("Hugo","Espanha",false,false,false);
        //Salvar os passageiros em um json
        //listapessoas.add(pessoa1);
        //listapessoas.add(pessoa2);
        //json.salvar_passageiros(listapessoas);

        //json.salvar_voos(listavoos);



}
