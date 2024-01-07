import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aviao {
    private int numeroDeLugares;
    private String modelo;

    private List<Assento> assentos;

    public Aviao(int lugares, String modelo) {
        this.numeroDeLugares = lugares;
        this.modelo = modelo;
    }

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

    public void informacoesDoAviao() {
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Número de lugares: " + this.numeroDeLugares);
    }

    public List<Assento> getAssentosDisponiveis() {
        List<Assento> assentosDisponiveis = new ArrayList<>();
        for (Assento assento : this.assentos) {
            if (!assento.isReservado()) {
                assentosDisponiveis.add(assento);
            }
        }
        return assentosDisponiveis;
    }

    public List<Assento> gerarAssentos(String a) {
        List<Assento> assentos = new ArrayList<>();
        if(Objects.equals(a, "Boeing 737")) {
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

    public void informacoesDosAssentos() {
        for (Assento assento : assentos) {
            System.out.println(assento);
        }
    }
}
