package model.VO;

import Exceptions.InfoNaoCompativelException;

public class Cliente{
    
	private String cpf;
    private String nome;
    private String endereco;

    public Cliente(){};
    
    public Cliente(String cpf) throws InfoNaoCompativelException {
    	setCPF(cpf);
    }
    
    public Cliente (String cpf, String nome) throws InfoNaoCompativelException{
    	setCPF(cpf);
    	setNome(nome);
    	
    }
    public Cliente(String cpf,String nome, String endereco) throws InfoNaoCompativelException {
    	setCPF(cpf);
    	setNome(nome);
    	setEndereco(endereco);
    }

    
    //========================SET GET CPF=========================================
    public void setCPF(String cpf) {
        if (cpf.isEmpty() == false && cpf.length() == 11) {
            this.cpf = cpf;
        }
    }
    
    public String getCPF(){
    	return cpf;
    }
   //===============================SET GET ENDERECO ===================================
    
    public void setEndereco(String endereco) throws InfoNaoCompativelException{
        if (endereco.isEmpty() == false) {
            this.endereco = endereco;
        } else {
            throw new InfoNaoCompativelException("Endereço vazio. Digite alguma informação.");
        }
    }

    public String getEndereco(){return endereco;}
   
    //============================SET GET NOME==========================================
    public void setNome(String nome) throws InfoNaoCompativelException{
        if (nome != null && nome.isEmpty() == false) {
            this.nome = nome;
        } else {
            throw new InfoNaoCompativelException("Nome vazio.");
        }
    }
    
    public String getNome() {
        return nome;
    }
}
