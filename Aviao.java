import java.util.ArrayList;
import java.util.List;

public class Aviao {
    private int numeroDeLugares;
    private String modelo;

    private List<Assento> assentos; // Corrigindo o tipo de lista para Assento

    public Aviao() {
        this.numeroDeLugares = 108;
        this.modelo = "Modelo";
        this.assentos = gerarAssentos(); // Inicializando os assentos
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

    private List<Assento> gerarAssentos() {
        List<Assento> assentos = new ArrayList<>();

        for (int fila = 1; fila <= 20; fila++) {
            String classe;
            if (fila >= 1 && fila <= 6) {
                classe = "Business";
            } else {
                classe = "Econômico";
            }

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

        return assentos;
    }

    public void informacoesDosAssentos() {
        for (Assento assento : assentos) {
            System.out.println(assento);
        }
    }
}