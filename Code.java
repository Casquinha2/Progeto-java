import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// A classe Code é a classe principal que inicia a execução do programa.
public class Code {
    public Code() throws IOException {
        Json json = new Json(); // Cria uma instância da classe Json para manipular arquivos JSON.
        Texto textoincio = new Texto(); // Cria uma instância da classe Texto para exibir mensagens.

        // Carregar dados de passageiros e voos do arquivo JSON.
        List<Passageiros> listapessoas = (List<Passageiros>) json.ler_passageiros();
        List<Voos> listavoos = (List<Voos>) json.ler_voos();

        // Criar aviões com informações de capacidade e modelo.
        Aviao aviaoboieng737 = new Aviao(126, "Boeing 737");
        Aviao aviaoa320 = new Aviao(166, "A320");

        // Gerar assentos para os aviões
        List<Assento> boiengassento1 = aviaoboieng737.gerarAssentos("Boeing 737");
        List<Assento> boiengassento2 = new ArrayList<>(boiengassento1); // Cópia dos assentos
        List<Assento> a320assento1 = aviaoa320.gerarAssentos("A320");
        List<Assento> a320assento2 = new ArrayList<>(a320assento1); // Cópia dos assentos
        // Salvar os assentos associados aos voos no arquivo JSON

        // Inicia a exibição do menu e interação com o usuário.
        textoincio.MensagemEntrada();
        while (true) {
            textoincio.ExibirMenu(json.ler_passageiros(), listavoos,boiengassento1,boiengassento2,a320assento1,a320assento2);
        }
    }
}
