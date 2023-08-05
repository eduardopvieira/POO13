public class Funcionario {

	private String nome;
	private Endereço endereço;
	private String cpf;
	private String senha;
	
	public Funcionario () {};
	
	public Funcionario (String nome, Endereço endereço, String cpf, String senha) {}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null) {
		this.nome = nome;
		}
	}

	public Endereço getEndereço() {
		return endereço;
	}

	public void setEndereço(Endereço endereço) {
		this.endereço = endereço;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpf != null) {
		this.cpf = cpf;
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha != null) {
		this.senha = senha;
		}
	};
	
	
}
	

