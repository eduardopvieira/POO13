package model.VO;

import Exceptions.*;

public class Funcionario extends Pessoa {
    
    private String senha;
    private boolean isGerente;
    
    public Funcionario(){}
    
    public Funcionario (String cpf) throws InfoNaoCompativelException {
    	setCPF(cpf);
    }
    public Funcionario (String nome, String cpf, String endereco, String senha) throws InfoNaoCompativelException {
        super(cpf, nome, endereco);
        setSenha(senha);
    }
    
    public Funcionario (String nome, String cpf, String endereco, String senha, boolean isGerente) throws InfoNaoCompativelException {
        super(cpf, nome, endereco);
        setSenha(senha);
        setIsGerente(isGerente);
    }
  
    public Funcionario (String cpf, String senha) throws InfoNaoCompativelException {
        super.setCPF(cpf);
        setSenha(senha);
        setIsGerente(false);
    }

    public void setIsGerente(boolean isGerente) {
    	this.isGerente = isGerente;
    }
    
    public boolean getIsGerente() {
    	return this.isGerente;
    }
    
    public void setSenha(String senha) throws InfoNaoCompativelException {
        if (senha != null && senha.isEmpty() == false) {
            this.senha = senha;
        } else {throw new InfoNaoCompativelException ("Senha vazia. Digite algum caractere.");}
    }

    public String getSenha() {return senha;}
}
