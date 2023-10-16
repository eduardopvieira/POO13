package model.VO;

public class OrcIJ {
	private String cpf;
	private String nome;
	private int id;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public OrcIJ(String cpf, String nome, int id) {
		setCpf(cpf);
		setNome(nome);
		setId(id);
	}
	
	public OrcIJ() {}
	
}
