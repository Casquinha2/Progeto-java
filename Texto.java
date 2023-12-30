import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Texto {
    public void MensagemEntrada(List<Passageiros> listapessoas, List<Voos> listavoos) throws IOException {
        System.out.println("Bem-vindo à WingWays, a sua passagem para aventuras pelo céu!");
        System.out.println("Aqui, você pode reservar seu assento para voos incríveis ao redor do mundo.");
        System.out.println("Prepare-se para decolar para novos destinos e experiências inesquecíveis.");
        System.out.println("Vamos começar a planejar sua próxima jornada juntos!");

        exibirMenu(listapessoas, listavoos);
    }

    private void exibirMenu(List<Passageiros> listapessoas, List<Voos> listavoos) throws IOException {
        Json json = new Json();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Verificar Voos");
            System.out.println("2. Reservar");
            System.out.println("3. Ajuda");
            System.out.println("4. Sair");

            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("Aqui pode verificar os voos atualmente em vigor\n");
                    Voos.exibirVoos(listavoos);
                    break;
                case 2:
                    System.out.println("Escolha o voo onde deseja reservar o seu lugar\n");
                    break;
                case 3:
                    System.out.println("Esta funcionalidade atualmente não se encontra \n");
                    break;
                case 4:
                    System.out.println("Obrigado por voar conosco! Até a próxima.\n");
                    json.salvar_passageiros(listapessoas);
                    json.salvar_voos(listavoos);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.\n");
                    break;
            }
        } while (opcao > 4);
    }
}
