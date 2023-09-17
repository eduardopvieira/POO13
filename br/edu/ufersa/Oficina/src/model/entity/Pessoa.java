package model.entity;

import Exceptions.*;

public abstract class Pessoa {
    private String nome;
    private String endereco;

    private String cpf;
    
    public void setNome(String nome) throws InfoNaoCompativelException{
        if (nome != null && nome.isEmpty() == false) {
            this.nome = nome;
        } else {
            throw new InfoNaoCompativelException("Nome nao compativel.");
        }
    }

    public void setCPF(String cpf) throws InfoNaoCompativelException {
        if (cpf != null && cpf.isEmpty() == false) {
            this.cpf = cpf;
        } else {
            throw new InfoNaoCompativelException("CPF nao compativel.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCPF(){return cpf;}

    public void setEndereco(String endereco) throws InfoNaoCompativelException{
        if (nome != null && nome.isEmpty() == false) {
            this.endereco = endereco;
        } else {
            throw new InfoNaoCompativelException("Nome nao compativel.");
        }
    }

    public String getEndereco(){return endereco;}
    
}






========================SEGUNDA OPCAO =================================


package entity;

import exceptions.InformacaoInvalida;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String endereco;
	
	//construtores
	public Pessoa() {};
	public Pessoa(String nome, String cpf, String endereco) throws InformacaoInvalida{
		setNome(nome);
		setCpf(cpf);
		setEndereco(endereco);
	}
	
	//===============gets e sets=============
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) throws InformacaoInvalida {
		if(nome !=null && !nome.isEmpty())
			this.nome = nome;
		else
			throw new InformacaoInvalida("O nome não pode ser vazio");
	}
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) throws InformacaoInvalida{
		if(cpf != null && cpf.length() == 11)	
			this.cpf = cpf;
		else
			throw new InformacaoInvalida("CPF inválido");
	}
	public String getEndereco() {
		return this.endereco;
	}
	public void setEndereco(String endereco) throws InformacaoInvalida{
		if(endereco != null && !endereco.isEmpty())
			this.endereco = endereco;
		else
			throw new InformacaoInvalida("Endereço inválido");
	}
	//=========== MÉTODOS ABSTRATOS ================= 
}

