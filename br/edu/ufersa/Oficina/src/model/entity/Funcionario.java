package model.entity;

import Exceptions.*;

public class Funcionario extends Pessoa {
    
    private String senha;

    public Funcionario(){}
    public Funcionario (String cpf, String nome, String endereco, String senha) throws InfoNaoCompativelException {
        super.setCPF(cpf);
        super.setNome(nome);
        super.setEndereco(endereco);
        setSenha(senha);

    }
    public Funcionario (String cpf, String senha) throws InfoNaoCompativelException {
        super.setCPF(cpf);
        setSenha(senha);
    }

    public void setSenha(String senha) throws InfoNaoCompativelException {
        if (senha.length() < 6 && senha != null && senha.isEmpty() == false) {
            this.senha = senha;
        } else {throw new InfoNaoCompativelException ("Senha inválida. Coloque mais caracteres.");}
    }

    public String getSenha() {return senha;}

    public void logar (String cpf, String senha) {
        if (super.getCPF() == cpf && getSenha() == senha) {
            System.out.println("Logou com sucesso.");
        } else {
            System.out.println("Login ou senha incorretos.");
        }
    }
}





=======================================SEGUNDA OPCAO =============================================

package entity;

import exceptions.InformacaoInvalida;

public class Funcionario extends Pessoa{
	private String senha;
	
	
	// =========CONSTRUTORES ============
	public Funcionario() {}
	public Funcionario(String nome, String cpf, String endereco, String senha) throws InformacaoInvalida{
		super(nome, cpf, endereco);
		setSenha(senha);
	}
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String senha) throws InformacaoInvalida{
		if(senha != null && !senha.isEmpty())
			this.senha = senha;
		else
			throw new InformacaoInvalida("Sua senha não pode ser vazia");
	}
}

