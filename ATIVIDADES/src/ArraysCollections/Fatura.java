package ArraysCollections;

import java.util.ArrayList;
import java.util.List;

public class Fatura {
	private List<Item> itens;
	private double valorTotal;

	public Fatura() {
		this.itens = new ArrayList<>();
		this.valorTotal = 0.0;
	}

	public void adicionarItem(Item item) {
		itens.add(item);
		valorTotal += item.getValorTotal();
	}

	public List<Item> getItens() {
		return itens;
	}

	public double getValorTotal() {
		return valorTotal;
	}
}
