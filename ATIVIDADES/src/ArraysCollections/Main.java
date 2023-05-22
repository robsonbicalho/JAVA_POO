package ArraysCollections;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Produto produto1 = new Produto("Chinelo", 1, 10.00);
		Produto produto2 = new Produto("Blusa", 2, 15.00);
		Produto produto3 = new Produto("Cal�a", 3, 20.00);

		List<Produto> produtos = Arrays.asList(produto1, produto2, produto3);

		Fatura fatura = new Fatura();
		Scanner input = new Scanner(System.in);
		int opcao = 0;

		while (opcao != 3) {
			System.out.println("Menu:");
			System.out.println("1 - Comprar");
			System.out.println("2 - Ver Fatura");
			System.out.println("3 - Encerrar Programa");
			System.out.print("Selecione uma op��o: ");
			opcao = input.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("\n" + "Produtos dispon�veis:");
				for (int i = 0; i < produtos.size(); i++) {
					Produto produto = produtos.get(i);
					System.out.println("C�digo " + produto.getCodigo() + " -> Nome: " + produto.getNome() + " | Pre�o: R$"
							+ produto.getPreco());
				}

				System.out.print("\n" + "Digite o c�digo do produto: ");
				int codigo = input.nextInt();

				Produto produtoSelecionado = null;
				for (int i = 0; i < produtos.size(); i++) {
					Produto produto = produtos.get(i);
					if (produto.getCodigo() == codigo) {
						produtoSelecionado = produto;
						break;
					}
				}

				if (produtoSelecionado != null) {
					System.out.print("Digite a quantidade: ");
					int quantidade = input.nextInt();

					Item item = new Item(produtoSelecionado, quantidade);
					fatura.adicionarItem(item);

					System.out.println("Item adicionado � fatura." + "\n");
				} else {
					System.out.println("C�digo de produto inv�lido." + "\n");
				}
				break;
			case 2:
				System.out.println("\n" + "Fatura:");
				List<Item> itens = fatura.getItens();
				for (int i = 0; i < itens.size(); i++) {
					Item item = itens.get(i);
					Produto produto = item.getProduto();
					System.out.println("Produto: " + produto.getNome() + " -> Quantidade: " + item.getQuantidade()+ " | Valor Total: R$" + item.getValorTotal());
				}
				System.out.println("Valor Total da Fatura: R$" + fatura.getValorTotal() + "\n");
				break;
			case 3:
				System.out.println("\n" + "O programa ser� encerrado.");
				break;
			default:
				System.out.println("Op��o inv�lida. Digite novamente." + "\n");
				break;
			}
		}
	}
}