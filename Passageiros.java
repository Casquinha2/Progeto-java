public class Passageiros {
    private String nome;
    private int id;
    private static int nextid=0;

    private String pais;

    private int lugarreservado;

    public Passageiros(String nome, String pais) {
        this.nome = nome;
        this.pais = pais;
        this.id=nextid++;

    }

    public int getId() {
        return id;
    }
}
