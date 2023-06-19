package Sistema_barbearia;

import java.util.ArrayList;

public class GestaoServicos {

	// ATRIBUTOS DA CLASSE
	private ArrayList<Servico> servicos;

	// CONSTRUTOR
	public GestaoServicos() {
		this.servicos = new ArrayList<>();

	}

	// CADASTRO DOS SERVI�OS
	public void cadastraServico(Servico servico) {

		servicos.add(servico);
		System.out.println("Novo servi�o cadastrado !\n");

	}

	// REMOVENDO SERVI�OS
	public void removeServico(Servico servico) {

		servicos.remove(servico);
		System.out.println("Servi�o removido com sucesso !!");

	}

	// EDITAR SERVI�OS
	public void editarServico(int codigo,  String novoNome, double novoPreco) {

		Servico servicoEditado = buscarServico(codigo);

		if (servicoEditado != null) {
			servicoEditado.setNome(novoNome);
			servicoEditado.setPreco(novoPreco);

			System.out.println("servi�o editado com sucesso!\n");
		} else {
			System.out.println("servi�o n�o encontrado!\n");
		}
	}

	// MOSTRAR A LISTA DE SERVI�OS
	public ArrayList<Servico> mostrarServicos() {
		return servicos;
	}

	// IDENTIFICAR O SERVI�O
	public Servico buscarServico(int codigo) {
		for (Servico servico : servicos) {
			if (servico.getCodigo() == codigo) {
				return servico;
			}
		}
		return null;
	}
}