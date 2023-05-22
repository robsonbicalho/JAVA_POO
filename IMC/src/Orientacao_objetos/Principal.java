package Orientacao_objetos;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Calendar;

public class Principal {

	public static void main(String[] args) {
		Data data = new Data(00, 0, 0000);
		Scanner input = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		Calendar c = Calendar.getInstance();
		String nomeCompletoAnterior = "";
		int pessoasCadastradas = 0;
		Pessoa[] pessoas = new Pessoa[10];

		for (int i = 0; i < pessoas.length; i++) {
			pessoas[i] = new Pessoa();
			pessoasCadastradas++;
			System.out.println("\n" + "Pessoa " + (i + 1));
			System.out.println("Informe o nome: ");
			pessoas[i].setNome(input.next());

			System.out.println("Informe o sobrenome: ");
			pessoas[i].setSobrenome(input.next());
			String nomeCompletoAtual = (pessoas[i].getNome() + pessoas[i].getSobrenome());

			if (nomeCompletoAtual.equalsIgnoreCase(nomeCompletoAnterior)) {
				System.out.println("Nome já cadastrado. O programa será encerrado.");
				break;
			}
			nomeCompletoAnterior = nomeCompletoAtual;

			System.out.println("Informe a altura: ");
			pessoas[i].setAltura(input.nextDouble());

			System.out.println("Informe o peso: ");
			pessoas[i].setPeso(input.nextDouble());

			System.out.print("Digite a data de nascimento no formato dd/MM/yyyy: ");
			String datadigitada = input.next();
			String[] dataSplit = datadigitada.split("/");
			data.setDia(Integer.parseInt(dataSplit[0]));
			data.setMes(Integer.parseInt(dataSplit[1]));
			data.setAno(Integer.parseInt(dataSplit[2]));
			c.set(Calendar.YEAR, data.getAno());
			c.set(Calendar.MONTH, data.getMes()-1);
			c.set(Calendar.DAY_OF_MONTH, data.getDia());
			pessoas[i].setDataNascimento(c);
			pessoas[i].setIMC(pessoas[i].calculaIMC());
			pessoas[i].setidadeAtual(pessoas[i].calculaIdade());

		}
		if (pessoasCadastradas != 10) {
			for (int i = 0; i < (pessoasCadastradas); i++) {
				Pessoa pessoa = pessoas[i];
				System.out.println("\n" + "Dados da pessoa " + (i + 1) + ":");
				String nomeCompleto = pessoa.getNome() + " " + pessoa.getSobrenome();
				String nomeRef = pessoa.getSobrenome() + ", " + pessoa.getNome().toUpperCase();
				System.out.println("Nome completo: " + nomeCompleto);
<<<<<<< Updated upstream
				System.out.println("Nome de referência: " + nomeRef);
=======
				System.out.println("Nome de refer�ncia: " + nomeRef);
>>>>>>> Stashed changes
				System.out.println("Idade: " + pessoa.getidadeAtual());
				System.out.println("Peso: " + pessoa.getPeso());
				System.out.println("Altura: " + pessoa.getAltura());
				System.out.println("IMC: " + df.format(pessoa.getIMC()));
				pessoa.InformaObesidade();
			}
		} else {
			for (int i = 0; i == pessoas.length; i++) {
				Pessoa pessoa = pessoas[i];
				System.out.println("\n" + "Dados da pessoa " + (i + 1) + ":");
				String nomeCompleto = pessoa.getNome() + " " + pessoa.getSobrenome();
				String nomeRef = pessoa.getSobrenome() + ", " + pessoa.getNome().toUpperCase();
				System.out.println("Nome completo: " + nomeCompleto);
<<<<<<< Updated upstream
				System.out.println("Nome de referência: " + nomeRef);
=======
				System.out.println("Nome de refer�ncia: " + nomeRef);
>>>>>>> Stashed changes
				System.out.println("Idade: " + pessoa.getidadeAtual());
				System.out.println("Peso: " + pessoa.getPeso());
				System.out.println("Altura: " + pessoa.getAltura());
				System.out.println("IMC: " + df.format(pessoa.getIMC()));
				pessoa.InformaObesidade();
			}

		}
	}
}
