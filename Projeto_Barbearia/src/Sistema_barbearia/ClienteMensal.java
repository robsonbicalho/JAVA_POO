package Sistema_barbearia;

public class ClienteMensal extends Cliente {

	private double valorAssinatura = 90.00;
    public ClienteMensal(int codigo, String nome, String especialidade, String telefone, String endereco) {
        super(codigo, nome, especialidade, telefone, endereco);
    }

    public double getValorAssinatura() {
    	return valorAssinatura;
    }
}