public class Passageiros {
    private String nome;
    private int id;
    private static int nextid=0;

    private int lugarreservado;
    private String pais;



    public Passageiros(String nome, String pais) {
        this.nome = nome;
        this.pais = pais;
        this.id=nextid++;
        this.lugarreservado = 0;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Passageiros{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", lugarreservado=" + lugarreservado +
                ", pais='" + pais + '\'' +
                '}';
    }
}
