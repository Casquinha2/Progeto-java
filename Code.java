import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Code {
    public Code() throws IOException {


        Json json = new Json();
        Texto textoincio = new Texto();
        List<Passageiros> listapessoas = (List<Passageiros>) json.ler_passageiros();
        List<Voos> listavoos = (List<Voos>) json.ler_voos();
        Aviao aviaoboieng737 = new Aviao(126, "Boeing 737");
        Aviao aviaoa320 = new Aviao(180, "A320");
        List<Assento> boiengassento1 = (List<Assento>) aviaoboieng737.gerarAssentos();
        List<Assento> boiengassento2 = boiengassento1;
        List<Assento> a320assento1 = (List<Assento>) aviaoa320.gerarAssentos();
        List<Assento> a320assento2 = a320assento1;

        for (int i = 1; i <= listavoos.size(); i++){
            if (i==1) {
                List<Assento> reservado1 = Voos.Reserva(boiengassento1);
                boiengassento1.removeAll(reservado1);
                List<Assento> livre1 = boiengassento1;
            } else if (i==2) {
                List<Assento> reservado2 = Voos.Reserva(boiengassento2);
                boiengassento2.removeAll(reservado2);
                List<Assento> livre2 = boiengassento2;
            }else if(i==3) {

                List<Assento> reservado3 = Voos.Reserva(a320assento1);
                a320assento1.removeAll(reservado3);
                List<Assento> livre3 = a320assento1;
            }else {
                    List<Assento> reservado4 = Voos.Reserva(a320assento2);
                    a320assento2.removeAll(reservado4);
                    List<Assento> livre4 = a320assento2;
            }
        }

        textoincio.MensagemEntrada(listapessoas,listavoos);
        while (true) {
            textoincio.ExibirMenu(listapessoas, listavoos);
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
