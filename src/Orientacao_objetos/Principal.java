package Orientacao_objetos;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Principal {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		Scanner input = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		
		System.out.println("Informe o nome: ");
		pessoa.setNome(input.next());
		
		System.out.println("Informe o sobrenome: ");
		pessoa.setSobrenome(input.next());
		
		System.out.println("Informe a idade: ");
		pessoa.setIdade(input.nextInt());
		
		System.out.println("Informe a altura: ");
		pessoa.setAltura(input.nextDouble());
		
		System.out.println("Informe o peso: ");
		pessoa.setPeso(input.nextDouble());
		
		pessoa.setIMC(pessoa.CalculaIMC());
		
		System.out.println("IMC: " + df.format(pessoa.getIMC()));
		pessoa.InformaObesidade();
		
		
	}

}