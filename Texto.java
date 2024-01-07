import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Texto {
    public void MensagemEntrada(){
        System.out.println("Bem-vindo à WingWays, a sua passagem para aventuras pelo céu!");
        System.out.println("Aqui, você pode reservar seu assento para voos incríveis ao redor do mundo.");
        System.out.println("Prepare-se para decolar para novos destinos e experiências inesquecíveis.");
        System.out.println("Vamos começar a planejar sua próxima jornada juntos!");


    }

    public void ExibirMenu(List<Passageiros> listapessoas, List<Voos> listavoos, List<Assento>voo1, List<Assento>voo2, List<Assento>voo3, List<Assento>voo4 ) throws IOException {
        Json json = new Json();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            {
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

                        System.out.println("Escolha o método de pagamento:");
                        System.out.println("4. Cartão de Crédito");
                        System.out.println("5. Dinheiro");
                        System.out.println("6. PayPal");
                        System.out.print("Opção de método de pagamento:(escolha o numero) ");
                        int opcaoPagamento = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer do scanner

                        String metodoPagamento = "";

                        // Converter a opção numérica para o método de pagamento correspondente
                        switch (opcaoPagamento) {
                            case 4:
                                metodoPagamento = "Cartão de Crédito";
                                break;
                            case 5:
                                metodoPagamento = "Dinheiro";
                                break;
                            case 6:
                                metodoPagamento = "PayPal";
                                break;
                            default:
                                System.out.println("Opção inválida. Método de pagamento definido como 'Não especificado'.");
                                metodoPagamento = "Não especificado";
                                break;
                        }

                        Passageiros novoPassageiro = new Passageiros(nome, pais, seguro, bagagemExtra, checkInAutomatico, metodoPagamento);



                        // Exibir os voos disponíveis
                        System.out.println("Voos Disponíveis:");
                        Voos.exibirVoos(listavoos);

                        // Permitir que o usuário selecione um voo
                        System.out.print("\nEscolha o número do voo desejado: ");
                        int numeroVooEscolhido = scanner.nextInt();

                        // Obter o voo selecionado pelo usuário
                        Voos vooSelecionado = listavoos.get(numeroVooEscolhido - 1);


                        // Atualizar o número de lugares reservados no voo selecionado
                        vooSelecionado.setLugaresReservados(vooSelecionado.getLugaresReservados() + 1);

                        // Atualizar o número de lugares reservados no voo selecionado
                        vooSelecionado.setLugaresLivres(vooSelecionado.getLugaresLivres() + 1);

                        // Adicionar o novo passageiro à lista de passageiros do voo
                        listapessoas.add(novoPassageiro);

                        // Utilize o voo selecionado, não o primeiro voo da lista original
                        double precoFinal = novoPassageiro.calcularPrecoVoo(vooSelecionado);
                        System.out.println("Novo passageiro adicionado com sucesso: " + novoPassageiro);
                        System.out.println("Preço do voo: " + precoFinal + "€");
                        break;
                    case 3:
                        System.out.println("Esta funcionalidade atualmente não se encontra \n");
                        break;
                    case 4:
                        System.out.println("Obrigado por voar conosco! Até a próxima.\n");
                        json.salvar_passageiros(listapessoas);
                        json.salvar_voos(listavoos);
                        Json.salvarAssentosJSON(listavoos,voo1,voo2,voo3,voo4);
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Escolha uma opção válida.\n");
                        break;
                }
            }
            while (opcao > 4) ;
        }
    }
}
