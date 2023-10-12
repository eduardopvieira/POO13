package model.VO;

import Exceptions.*;

public class Funcionario extends Pessoa {
    
    private String senha;
    private boolean isGerente;
    
    public Funcionario(){}
    public Funcionario (String cpf, String nome, String endereco, String senha) throws InfoNaoCompativelException {
        super(nome, endereco, cpf);
        setSenha(senha);
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
        if (senha.length() >= 6 && senha != null && senha.isEmpty() == false) {
            this.senha = senha;
        } else {throw new InfoNaoCompativelException ("Senha vazia ou muito curta. Digite pelo menos 6 caracteres.");}
    }

    public String getSenha() {return senha;}
}
