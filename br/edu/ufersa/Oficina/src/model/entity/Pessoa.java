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
