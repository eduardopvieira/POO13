package model.VO;

import Exceptions.InfoNaoCompativelException;

public class Cadastrado extends Pessoa {
	
	 private String funcao;
	 
	 public Cadastrado () {};
	 public Cadastrado (String cpf, String nome, String endereco, String funcao) throws InfoNaoCompativelException {
		 super(cpf, nome, endereco);
		 setFuncao(funcao);
	 }
	 
	 public void setFuncao(String f) {
		 if (!f.isEmpty()) {
			 this.funcao = f;
		 }
	 }
	 
	 public String getFuncao() {return funcao;}
}
