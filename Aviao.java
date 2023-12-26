public class Aviao {
    private int numeroDeLugares;
    private String modelo;

    public Aviao() {
        this.numeroDeLugares = 120;
        this.modelo = "Modelo";
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

    public void InformacoesDoAviao() {
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Número de lugares: " + this.numeroDeLugares);
    }
}
