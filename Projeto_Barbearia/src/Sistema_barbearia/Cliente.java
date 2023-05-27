package Sistema_barbearia;


public class Cliente {

	private String nome;
	private String endereco;
	private String telefone;
	private int codigo;
	private String sexo;

	public Cliente(int codigo, String nome, String sexo, String telefone, String endereco) {
		this.nome = nome;
		this.sexo = sexo;
		this.telefone = telefone;
		this.endereco = endereco;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}