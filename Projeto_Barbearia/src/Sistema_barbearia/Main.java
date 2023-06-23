package Sistema_barbearia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GestaoClientes gc = new GestaoClientes();
		GestaoServicos gs = new GestaoServicos();
		GestaoFinaceira gf= new GestaoFinaceira();
		Scanner input = new Scanner(System.in);

		int opção = 0;
		int contador = 1;
		int contadorServico = 1;
		int resposta = 0;

		while (resposta != 4) { 
			System.out.println("1 - Gestão de Clientes\n2 - Gestão de Serviços\n3 - Registrar e consultar entrada\n4 - Encerrar programa");
			resposta = input.nextInt();

			if (resposta == 1) {
				opção = 0; 

				while (opção != 5) {
					System.out.println("Menu:");
					System.out.println("1 - Cadastrar cliente");
					System.out.println("2 - Editar cliente");
					System.out.println("3 - Deletar cliente");
					System.out.println("4 - Listar todos os clientes");
					System.out.println("5 - Retornar ao menu");
					System.out.print("Selecione uma opção: ");
					opção = input.nextInt();

					switch (opção) {

					case 1:
						System.out.print("Informe o nome do cliente: ");
						input.nextLine();
						String nome = input.nextLine();
						System.out.print("Informe o endereço do cliente: ");
						String endereco = input.nextLine();
						System.out.print("Informe o telefone do cliente: ");
						String telefone = input.next();
						System.out.println("Informe a classe do cliente (R ou M): ");
						String especialidade = input.nextLine();

						while (!especialidade.equalsIgnoreCase("R") && !especialidade.equalsIgnoreCase("M")) {
							especialidade = input.nextLine();

							if (!especialidade.equalsIgnoreCase("R") && !especialidade.equalsIgnoreCase("M")) {
								System.out.println("Classe inválida! Informe apenas R ou M.");
							}
						}

						int codigo = contador;
						if (especialidade.equals("M")) {
							ClienteMensal novoClienteMensal = new ClienteMensal(codigo, nome, especialidade, telefone,
									endereco);
						}

						Cliente novoCliente = new Cliente(codigo, nome, especialidade, telefone, endereco);
						gc.cadastrarCliente(novoCliente);
						contador++;
						break;

					case 2:
						System.out.print("Informe o código do cliente a ser editado: ");
						int codigoEditar = input.nextInt();

						Cliente clienteEditar = gc.buscarCodigo(codigoEditar);
						System.out.println("Qual informação você gostaria de alterar:");
						System.out.println("1 - Nome");
						System.out.println("2 - Endereço");
						System.out.println("3 - Telefone");
						System.out.println("4 - Classe");
						System.out.println("5 - Retornar ao menu");
						System.out.print("Selecione uma opção: ");
						int opcao2 = input.nextInt();

						switch (opcao2) {

						case 1:
							System.out.print("Informe o novo nome do cliente: ");
							String novoNome = input.next();
							gc.editarCliente(codigoEditar, clienteEditar.getEspecialidade(), novoNome,
									clienteEditar.getEndereco(), clienteEditar.getTelefone());
							break;

						case 2:
							System.out.print("Informe o novo endereço do cliente: ");
							String novoEndereco = input.next();
							gc.editarCliente(codigoEditar, clienteEditar.getNome(), clienteEditar.getEspecialidade(),
									novoEndereco, clienteEditar.getTelefone());
							break;

						case 3:
							System.out.print("Informe o novo telefone do cliente: ");
							String novoTelefone = input.next();
							gc.editarCliente(codigoEditar, clienteEditar.getNome(), clienteEditar.getEspecialidade(),
									clienteEditar.getEndereco(), novoTelefone);
							break;
						case 4:
							System.out.print("Informe o novo sexo do cliente: ");
							String novoSexo = input.next();
							gc.editarCliente(codigoEditar, clienteEditar.getNome(), novoSexo,
									clienteEditar.getEndereco(), clienteEditar.getTelefone());
							break;
						default:
							System.out.println("Opção inválida. Voltando ao menu...");
							break;

						}
						break;
					case 3:
						System.out.println("Informe o codigo do cliente que será removido");
						int codigoExcluir = input.nextInt();
						Cliente clienteExcluir = gc.buscarCodigo(codigoExcluir);
						gc.deletarCliente(clienteExcluir);
						break;
					case 4:
						System.out.println("Clientes registrados: ");
						System.out.println("-------------------------------");
						List<Cliente> clientes = gc.listarClientes();
						for (Cliente cliente : clientes) {
							System.out.println("Codigo: " + cliente.getCodigo());
							System.out.println("Nome: " + cliente.getNome());
							System.out.println("Classe: " + cliente.getEspecialidade());
							System.out.println("Endereço: " + cliente.getEndereco());
							System.out.println("Telefone: " + cliente.getTelefone());
							System.out.println("-------------------------------");
						}
						break;
					case 5:
						System.out.println("Retornando ao menu...");
						break;

					default:
						System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
						break;
					}
				}
			} else if (resposta == 2) { // COPIAR
				opção = 0; // COPIAR

				while (opção != 5) {
					System.out.println("Menu:");
					System.out.println("1 - Cadastrar serviço");
					System.out.println("2 - Editar serviço");
					System.out.println("3 - Deletar serviço");
					System.out.println("4 - Listar todos os serviço");
					System.out.println("5 - Retornar ao menu");
					System.out.print("Selecione uma opção: ");
					opção = input.nextInt();

					switch (opção) {

					case 1:

						int codigo = contadorServico;

						System.out.print("\nInforme o nome do serviço: ");
						String nome = input.next();

						System.out.print("Informe o preço: ");
						double preco = input.nextDouble();

						Servico novoServico = new Servico(codigo, nome, preco);
						gs.cadastraServico(novoServico);

						contadorServico++;
						break;

					case 2:

						System.out.print("\nInforme o codigo do serviço que deseja editar: ");
						int codigoEditar = input.nextInt();
						Servico servicoEditar = gs.buscarServico(codigoEditar);

						System.out.println("\nQual informação você gostaria de alterar:");
						System.out.println("1 - Nome");
						System.out.println("2 - Preço");
						System.out.println("3 - Voltar ao menu");
						System.out.print("Selecione uma opção: ");
						int opcao2 = input.nextInt();

						switch (opcao2) {

						case 1:
							System.out.print("Informe o novo nome do serviço: ");
							String novoNome = input.next();
							gs.editarServico(codigoEditar, novoNome, servicoEditar.getPreco());
							break;

						case 2:
							System.out.printf("Informe o novo preço do serviço: ");
							double novoPreco = input.nextDouble();
							gs.editarServico(codigoEditar, servicoEditar.getNome(), novoPreco);

							break;

						default:
							System.out.println("Voltando para o Menu...");
							break;

						}
						break;

					case 3:
						System.out.printf("Informe o codigo do serviço que deseja remover: ");
						int codigoExcluir = input.nextInt();
						Servico serviçoExcluir = gs.buscarServico(codigoExcluir);
						gs.removeServico(serviçoExcluir);

						contadorServico--;
						break;

					case 4:
						System.out.println("Serviços cadastrados: ");
						System.out.println("------------------------------------");
						ArrayList<Servico> servicos = gs.mostrarServicos();

						for (Servico Servico : servicos) {
							System.out.println("Codigo: " + Servico.getCodigo());
							System.out.println("Nome: " + Servico.getNome());
							System.out.println("Preço: " + Servico.getPreco());
							System.out.println("-------------------------------");
						}
						break;

					case 5:
						System.out.println("Retornando ao menu...");
						break;

					default:
						System.out.println("Opção inválida. Por favor, selecione uma opção válida.");

					}

				}
			} else if (resposta == 3) {
				opção = 0;
				while (opção != 4) {
					System.out.println(
							"1 - Registrar serviços realizados\n2 - Registrar clientes mensais que ja pagaram\n3 - Olhar valor total recebido no mês\n4 - Retornar ao menu");
					opção = input.nextInt();
					switch (opção) {
					case 1:
						System.out.println("código do cliente:");
						int codigo = input.nextInt();
						for (int i = 0; i < gc.listarClientes().size(); i++) {
							if (codigo == gc.listarClientes().get(i).getCodigo()) {
								System.out.println("código do serviço:");
								int codigoServico = input.nextInt();
								for (int j = 0; j < gs.mostrarServicos().size(); j++) {
									if (codigoServico == gs.mostrarServicos().get(i).getCodigo()) {
										Feitos pedidofeito = new Feitos();
										gf.AddServicosPrestados(pedidofeito);
									}
								}
							}
						}
						break;
					case 2:
						System.out.println("Digite o Código do Cliente mensal:");
						int codigoMensal = input.nextInt();
						for (int i = 0; i < gc.listarClientes().size(); i++) {
							if (codigoMensal == gc.listarClientes().get(i).getCodigo()) {
								ClienteMensal novoMensal = new ClienteMensal(codigoMensal,
										gc.listarClientes().get(i).getNome(),
										gc.listarClientes().get(i).getEspecialidade(),
										gc.listarClientes().get(i).getTelefone(),
										gc.listarClientes().get(i).getEndereco());
								gf.AddClienteMensal(novoMensal);
							}
						}
						break;
					case 3:
						gf.somaEntrada();
						break;
					case 4:
						System.out.println("Retornando ao menu...");
						break;
					}
				}

			} else if (resposta == 4) { 
				System.out.println("Encerrando o programa...");
			} else {
				System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
			}
		}

	}
}