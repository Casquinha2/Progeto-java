import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Texto {
    public void MensagemEntrada(List<Passageiros> listapessoas, List<Voos> listavoos) throws IOException {
        System.out.println("Bem-vindo à WingWays, a sua passagem para aventuras pelo céu!");
        System.out.println("Aqui, você pode reservar seu assento para voos incríveis ao redor do mundo.");
        System.out.println("Prepare-se para decolar para novos destinos e experiências inesquecíveis.");
        System.out.println("Vamos começar a planejar sua próxima jornada juntos!");

        ExibirMenu(listapessoas, listavoos);
    }

    public void ExibirMenu(List<Passageiros> listapessoas, List<Voos> listavoos) throws IOException {
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
                    System.out.println("Aqui pode verificar os voos atualmente em vigor");
                    Voos.exibirVoos(listavoos);
                    break;
                case 2:
                    System.out.println("Registe-se num voo!");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("País: ");
                    String pais = scanner.nextLine();


                    System.out.print("Possui bagagem extra? (sim/não): ");
                    boolean bagagemExtra = scanner.nextLine().equalsIgnoreCase("sim");

                    System.out.print("Quer usufruir de um seguro? (sim/não): ");
                    boolean seguro = scanner.nextLine().equalsIgnoreCase("sim");

                    System.out.print("Check-in automático ativado? (sim/não): ");
                    boolean checkInAutomatico = scanner.nextLine().equalsIgnoreCase("sim");
                    System.out.print("Click no botão enter para prosseguir");



                    Passageiros novoPassageiro = new Passageiros(nome, pais, seguro, bagagemExtra, checkInAutomatico);
                    listapessoas.add(novoPassageiro);
                    Voos vooSelecionado = listavoos.get(0); // Apenas para exemplo, seleção do primeiro voo
                    scanner.nextLine();

                    for (int i = 0; i < listavoos.size(); i++) { // adiciona os voos criados a uma lista para que o utilizador possa escolher qual ele quer viajar
                        Voos voo = listavoos.get(i);
                        System.out.println(i + 1 + ". " + voo.informacoesDoVoo()); // Mostra informações do voo
                    }
                    System.out.print("Escolha um voo para reservar (digite o número do voo): ");
                    int escolhaVoo = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()

                    Voos vooselecionados = listavoos.get(escolhaVoo - 1);
                    vooselecionados.ExibirAssentosDisponiveis();

                    System.out.print("Escolha uma fila (digite o número da fila): ");
                    int numeroFila = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.println("Escolha a classe do assento:");
                    System.out.println("1. Econômica");
                    System.out.println("2. Executiva");
                    System.out.println("3. Primeira Classe");
                    System.out.print("Opção: ");
                    int classeAssentoOpcao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    char coluna = 'A'; // Declarar a variável coluna apenas uma vez
                    String tipoAssento = "";
                    String classeAssento = "";

// Definir o tipo de assento com base na escolha do passageiro
                    System.out.print("Escolha o tipo de assento (1 para Janela, 2 para Corredor, 3 para Meio): ");
                    int tipoAssentoOpcao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner


                    switch (tipoAssentoOpcao) {
                        case 1:
                            tipoAssento = "Janela";
                            break;
                        case 2:
                            tipoAssento = "Corredor";
                            break;
                        case 3:
                            tipoAssento = "Meio";
                            break;
                        default:
                            System.out.println("Opção de tipo de assento inválida. Usando tipo padrão 'Janela'.");
                            tipoAssento = "Janela";
                            break;
                    }
// Definir a classe do assento com base na escolha do passageiro
                    switch (classeAssentoOpcao) {
                        case 1:
                            classeAssento = "Econômica";
                            break;
                        case 2:
                            classeAssento = "Executiva";
                            break;
                        case 3:
                            classeAssento = "Primeira Classe";
                            break;
                        default:
                            System.out.println("Opção de classe de assento inválida. Usando classe padrão 'Econômica'.");
                            break;
                    }

                    String descricaoAssento = tipoAssento + " - " + classeAssento;
                    Assento assentoEscolhido = vooSelecionado.escolherAssento(numeroFila, coluna, descricaoAssento);




                    if (assentoEscolhido != null) {
                        if (!assentoEscolhido.isReservado()) {
                            // Reservar o assento aqui
                            assentoEscolhido.setReservado(true);
                            System.out.println("Voo reservado com sucesso!");
                        } else {
                            System.out.println("Assento escolhido não está disponível.");
                        }
                    } else {
                        System.out.println("Assento escolhido não existe.");
                    }
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
        } while (opcao != 4);
    }
}
