import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println(voo1);
        Json json = new Json();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        List<List<String>> dadosAssentos = json.carregarAssentosDoArquivo(voo1,voo2,voo3,voo4);
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

                        System.out.println("Voos Disponíveis:");
                        Voos.exibirVoos(listavoos);

                        // Permitir que o usuário selecione um voo
                        System.out.print("\nEscolha o número do voo desejado: ");
                        int numeroVooEscolhido = scanner.nextInt();
                        scanner.nextLine();


                        int indiceVoo = (numeroVooEscolhido - 1) * 2;

                        if (numeroVooEscolhido < 1 || numeroVooEscolhido > listavoos.size()) {
                            System.out.println("Número do voo inválido.");
                            break;
                        }

                        List<String> lugaresLivres = dadosAssentos.get(indiceVoo + 1);

                        System.out.println("Voo " + numeroVooEscolhido + ":");
                        System.out.println("Lugares Livres: " + lugaresLivres);

                        System.out.print("\nEscolha o seu Lugar : ");
                        String lugarEscolhido = scanner.next().trim().toUpperCase();
                        String classeAssento = Assento.verificarClasseAssento(numeroVooEscolhido, voo1, voo2, voo3, voo4, lugarEscolhido);

                        if (!classeAssento.isEmpty()) {
                            System.out.println("Este lugar é da classe " + classeAssento + ". Tem a certeza que quer reservá-lo? (sim/não)");
                            String resposta = scanner.next().trim().toLowerCase();

                            if (resposta.equals("sim")) {

                            } else if (resposta.equals("não")) {
                                System.out.println("Reserva cancelada. Voltando ao início.");
                                continue; // Isso volta ao início do loop ou ao início da seção de código onde está.
                            }
                        }
                        if (lugaresLivres.stream().anyMatch(lugar -> lugar.equalsIgnoreCase(lugarEscolhido))) {
                            lugaresLivres.removeIf(lugar -> lugar.equalsIgnoreCase(lugarEscolhido));
                            List<String> lugaresReservados = dadosAssentos.get(indiceVoo);

                            if (!lugaresReservados.contains(lugarEscolhido)) {
                                lugaresReservados.add(lugarEscolhido);

                                // Atualize a lista de dadosAssentos com os lugares reservados e livres atualizados
                                dadosAssentos.set(indiceVoo, lugaresReservados);
                                dadosAssentos.set(indiceVoo + 1, lugaresLivres);

                                // Chame um método para salvar essas alterações no arquivo JSON
                                json.salvarAssentosAtualizados(dadosAssentos);

                                Voos vooSelecionado = listavoos.get(numeroVooEscolhido - 1);

                                vooSelecionado.setLugaresReservados(vooSelecionado.getLugaresReservados() + 1);


                                vooSelecionado.setLugaresLivres(vooSelecionado.getLugaresLivres() - 1);

                                System.out.println("Escolha o método de pagamento:");
                                System.out.println("1. Cartão de Crédito");
                                System.out.println("2. Dinheiro");
                                System.out.println("3. PayPal");
                                System.out.print("Opção de método de pagamento: ");
                                int opcaoPagamento = scanner.nextInt();
                                scanner.nextLine();

                                String metodoPagamento = "";

                                // Converter a opção numérica para o método de pagamento correspondente
                                switch (opcaoPagamento) {
                                    case 1:
                                        metodoPagamento = "Cartão de Crédito";
                                        break;
                                    case 2:
                                        metodoPagamento = "Dinheiro";
                                        break;
                                    case 3:
                                        metodoPagamento = "PayPal";
                                        break;
                                    default:
                                        System.out.println("Opção inválida. Método de pagamento definido como 'Não especificado'.");
                                        metodoPagamento = "Não especificado";
                                        break;
                                }

                                Passageiros novoPassageiro = new Passageiros(nome, pais, seguro, bagagemExtra, checkInAutomatico, metodoPagamento,lugarEscolhido, numeroVooEscolhido);
                                // Adicionar o novo passageiro à lista de passageiros do voo
                                listapessoas.add(novoPassageiro);

                                double precoFinal = novoPassageiro.calcularPrecoVoo(vooSelecionado,classeAssento);
                                System.out.println("Novo passageiro adicionado com sucesso ao voo número " + numeroVooEscolhido + " com origem em "+ vooSelecionado.getPaisSaida() + " e chegada em " + vooSelecionado.getPaisChegada() + ".");
                                System.out.println("Preço do voo: " + precoFinal + "€");

                            } else {
                                System.out.println("Este lugar já se encontra reservado");
                            }
                        } else {
                            System.out.println("Lugar escolhido não está disponível.");
                        }

                        break;
                    case 3:
                        System.out.println("Bem-vindo à seção de Ajuda!");
                        System.out.println("Para utilizar a WingWays, siga estas etapas:");
                        System.out.println("1. Verificar Voos: Selecione a opção 1 para visualizar os voos disponíveis.");
                        System.out.println("2. Reservar: Escolha a opção 2 para registrar-se em um voo.");
                        System.out.println("3. Ajuda: Esta seção que você está acessando agora.");
                        System.out.println("4. Sair: Para encerrar o programa, selecione a opção 4.");
                        System.out.println("\nAo reservar um voo:");
                        System.out.println("- Preencha as informações solicitadas, como nome, país, bagagem extra, etc.");
                        System.out.println("- Escolha um voo disponível e selecione um lugar livre para reservar.");
                        System.out.println("- Selecione o método de pagamento desejado.");

                        System.out.println("\nSe precisar de assistência adicional ou informações específicas,");
                        System.out.println("entre em contato conosco pelo email support@wingways.com.");

                        System.out.println("\nLembre-se: Aproveite suas aventuras pelo céu com WingWays!");
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
            }
            while (opcao > 4) ;
        }
    }
}
