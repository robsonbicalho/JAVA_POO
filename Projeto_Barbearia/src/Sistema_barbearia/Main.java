package Sistema_barbearia;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		GestaoClientes gestor = new GestaoClientes();
		Scanner input = new Scanner(System.in);
		int opção = 0;
		int contador = 1;
	
		while (opção != 5) {
			System.out.println("Menu:");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Editar cliente");
			System.out.println("3 - Deletar cliente");
			System.out.println("4 - Listar todos os clientes");
			System.out.println("5 - Encerrar programa");
			System.out.print("Selecione uma opção: ");
			opção = input.nextInt();

			switch (opção) {
			case 1:
				System.out.print("Informe o nome do cliente: ");
				input.nextLine(); // Limpa o buffer do scanner apos o input.nextint
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
				Cliente novoCliente = new Cliente(codigo, nome, especialidade, telefone, endereco);
				gestor.cadastrarCliente(novoCliente);
				contador++;
				break;
			case 2:
				System.out.print("Informe o código do cliente a ser editado: ");
				int codigoEditar = input.nextInt();
				Cliente clienteEditar = gestor.buscarCodigo(codigoEditar);

				System.out.println("Qual informação você gostaria de alterar:");
				System.out.println("1 - Nome");
				System.out.println("2 - Endereço");
				System.out.println("3 - Telefone");
				System.out.println("4 - Classe");
				System.out.println("5 - Voltar ao menu");
				System.out.print("Selecione uma opção: ");
				int opcao2 = input.nextInt();

				switch (opcao2) {
				case 1:
					System.out.print("Informe o novo nome do cliente: ");
					String novoNome = input.next();
					gestor.editarCliente(codigoEditar, clienteEditar.getEspecialidade(), novoNome, clienteEditar.getEndereco(),
							clienteEditar.getTelefone());
					break;

				case 2:
					System.out.print("Informe o novo endereço do cliente: ");
					String novoEndereco = input.next();
					gestor.editarCliente(codigoEditar, clienteEditar.getNome(), clienteEditar.getEspecialidade(), novoEndereco,
							clienteEditar.getTelefone());
					break;

				case 3:
					System.out.print("Informe o novo telefone do cliente: ");
					String novoTelefone = input.next();
					gestor.editarCliente(codigoEditar, clienteEditar.getNome(), clienteEditar.getEspecialidade(), clienteEditar.getEndereco(),
							novoTelefone);
					break;
				case 4:
					System.out.print("Informe o novo sexo do cliente: ");
					String novoSexo = input.next();
					gestor.editarCliente(codigoEditar, clienteEditar.getNome(), novoSexo, clienteEditar.getEndereco(),
							clienteEditar.getTelefone());
					break;
				default:
					System.out.println("Opção inválida. Voltando ao menu...");
					break;
					
				}
				break;
			case 3:
				System.out.println("Informe o codigo do cliente que será removido");
				int codigoExcluir = input.nextInt();
				Cliente clienteExcluir = gestor.buscarCodigo(codigoExcluir);
				gestor.deletarCliente(clienteExcluir);
				break;
			case 4:
				System.out.println("Clientes registrados: ");
				System.out.println("-------------------------------");
				List<Cliente> clientes = gestor.listarClientes();
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
				System.out.println("Encerrando o programa");
				break;
			default:
				System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
				break;
			}
		}

	}

}
