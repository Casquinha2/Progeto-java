import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// A classe Aviao representa informações sobre um avião, incluindo o modelo, o número de lugares e os assentos disponíveis.
public class Aviao {
    private int numeroDeLugares; // Número total de lugares no avião.
    private String modelo; // Modelo do avião.

    private List<Assento> assentos; // Lista de assentos disponíveis no avião.

    // Construtor da classe Aviao para inicializar o número de lugares e o modelo do avião.
    public Aviao(int lugares, String modelo) {
        this.numeroDeLugares = lugares;
        this.modelo = modelo;
    }

    // Métodos getters e setters para os atributos da classe Aviao.
    public int getNumeroDeLugares() {
        return this.numeroDeLugares;
    }

    public void setNumeroDeLugares(int numeroDeLugares) {
        this.numeroDeLugares = numeroDeLugares;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Método para exibir informações sobre o avião, incluindo o modelo e o número de lugares.
    public void informacoesDoAviao() {
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Número de lugares: " + this.numeroDeLugares);
    }

    // Método para obter a lista de assentos disponíveis no avião.
    public List<Assento> getAssentosDisponiveis() {
        List<Assento> assentosDisponiveis = new ArrayList<>();
        for (Assento assento : this.assentos) {
            if (!assento.isReservado()) {
                assentosDisponiveis.add(assento);
            }
        }
        return assentosDisponiveis;
    }

    // Método para gerar a lista de assentos com base no modelo do avião.
    public List<Assento> gerarAssentos(String a) {
        List<Assento> assentos = new ArrayList<>();
        if(Objects.equals(a, "Boeing 737")) {
            // Gera assentos para o modelo Boeing 737.
            // Os assentos são divididos em Business e Econômico.
            for (int fila = 1; fila <= 3; fila++) {
                String classe = "Business";

                for (char coluna = 'A'; coluna <= 'D'; coluna++) {
                    String local;
                    if (coluna == 'A' || coluna == 'D') {
                        local = "Janela";
                    } else{
                        local = "Corredor";
                    }
                    Assento assento = new Assento("" + fila + coluna, fila, coluna, local, classe);
                    assentos.add(assento);
                }
            }
            for (int fila = 4; fila <=22 ; fila++) {
                String classe = "Económico";

                for (char coluna = 'A'; coluna <= 'F'; coluna++) {
                    String Local;
                    if (coluna == 'A' || coluna == 'F') {
                        Local = "Janela";
                    } else if (coluna == 'C' || coluna == 'D') {
                        Local = "Corredor";
                    } else {
                        Local = "Meio";
                    }
                    Assento assento = new Assento("" + fila + coluna, fila, coluna, Local, classe);
                    assentos.add(assento);
                }
            }
        }
        else{
            // Gera assentos para outros modelos de avião.
            // Os assentos são divididos em Business e Econômico.
            for(int fila = 1; fila <= 7; fila++){
                String classe = "Business";
                for(char coluna = 'A'; coluna <= 'D';coluna++){
                    String local;
                    if (coluna == 'A' || coluna == 'D'){
                        local = "Janela";
                    } else{
                        local = "Corredor";
                    }
                    Assento assento = new Assento("" + fila + coluna, fila, coluna, local, classe);
                    assentos.add(assento);
                }
            }
            for(int fila = 8; fila <= 30; fila++){
                String classe = "Económico";
                for (char coluna = 'A'; coluna <= 'F'; coluna++) {
                    String Local;
                    if (coluna == 'A' || coluna == 'F') {
                        Local = "Janela";
                    } else if (coluna == 'C' || coluna == 'D') {
                        Local = "Corredor";
                    } else {
                        Local = "Meio";
                    }
                    Assento assento = new Assento("" + fila + coluna, fila, coluna, Local, classe);
                    assentos.add(assento);
                }
            }
        }
        return assentos;
    }

    // Método para exibir informações detalhadas de todos os assentos do avião.
    public void informacoesDosAssentos() {
        for (Assento assento : assentos) {
            System.out.println(assento);
        }
    }
}
