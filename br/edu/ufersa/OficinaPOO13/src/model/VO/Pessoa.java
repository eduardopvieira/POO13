package model.VO;

import Exceptions.*;

public abstract class Pessoa {
    private String nome;
    private String endereco;
    private String cpf;
    
    public Pessoa () {};
    public Pessoa (String cpf, String nome) throws InfoNaoCompativelException {
    	setNome(nome);
    	setCPF(cpf);
    }
    public Pessoa(String nome, String endereco, String cpf) throws InfoNaoCompativelException {
        setNome(nome);
        setEndereco(endereco);
        setCPF(cpf);
    }

    public void setNome(String nome) throws InfoNaoCompativelException{
        if (nome != null && nome.isEmpty() == false) {
            this.nome = nome;
        } else {
            throw new InfoNaoCompativelException("Nome vazio.");
        }
    }

    public void setCPF(String cpf) throws InfoNaoCompativelException {
        if (cpf != null && cpf.isEmpty() == false && cpf.length() == 11) {
            this.cpf = cpf;
        } else {
            throw new InfoNaoCompativelException("CPF vazio ou com pontuação. Digite o CPF apenas com números.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCPF(){
    	return cpf;
    }

    public void setEndereco(String endereco) throws InfoNaoCompativelException{
        if (nome != null && nome.isEmpty() == false) {
            this.endereco = endereco;
        } else {
            throw new InfoNaoCompativelException("Endereço vazio. Digite alguma informação.");
        }
    }

    public String getEndereco(){return endereco;}
    
}
