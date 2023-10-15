	package model.VO;
	
	import Exceptions.*;
	
	public abstract class Pessoa {
	    private String nome;
	    private String endereco;
	    private String cpf;
	    
	    public Pessoa () {};
	   
	    public Pessoa(String cpf) throws InfoNaoCompativelException {
	    	setCPF(cpf);
	    }
	    
	    public Pessoa (String cpf, String nome) throws InfoNaoCompativelException {
	    	setNome(nome);
	    	setCPF(cpf);
	    }
	   
	    public Pessoa(String cpf, String nome, String endereco) throws InfoNaoCompativelException {
	    	setCPF(cpf);
	    	setNome(nome);
	        setEndereco(endereco);  
	    }

	    
	    //======================SET E GET NOME===================================
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
	    
	    //=========================SET E GET CPF================================
	
	    public void setCPF(String cpf) throws InfoNaoCompativelException {
	        if (cpf.isEmpty() == false && cpf.length() == 11) {
	            this.cpf = cpf;
	        } else {
	           throw new InfoNaoCompativelException("CPF vazio ou com pontuação. Digite o CPF apenas com números.");
	        }
	    }
	    
	    public String getCPF(){
	    	return cpf;
	    }
	    
	    //========================set e get endereço=============================
	    public void setEndereco(String endereco) throws InfoNaoCompativelException{
	        if (endereco.isEmpty() == false) {
	            this.endereco = endereco;
	        } else {
	            throw new InfoNaoCompativelException("Endereço vazio. Digite alguma informação.");
	        }
	    }
	
	    public String getEndereco(){return endereco;}
	    
	}
