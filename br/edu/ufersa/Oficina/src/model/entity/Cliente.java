package model.entity;

import Exceptions.InfoNaoCompativelException;

public class Cliente extends Pessoa{

    private Automovel auto;
    
    public Cliente(){};
    public Cliente(String nome, String cpf, Automovel auto) throws InfoNaoCompativelException {
        super.setNome(nome);
        super.setCPF(cpf);
        setAuto(auto);
    }


    public void setAuto (Automovel auto) {
        this.auto = auto;
    }
    public Automovel getAuto() {
        return auto;
    }

}




========================================SEGUNDA OPCAO =====================================

package entity;

import exceptions.InformacaoInvalida;
import java.util.ArrayList;

public class Cliente extends Pessoa{
	private Automovel[] automovel = new Automovel[10];
	private ArrayList<Automovel> automoveis = new ArrayList<Automovel>();

	
	
	
	// =========== construtores =========
	public Cliente() {};
	
	public Cliente(String nome, String cpf, String endereco) throws InformacaoInvalida {
		super(nome, cpf, endereco);
	}
	
	public Cliente(String nome, String cpf, String endereco, Automovel []automovel) throws InformacaoInvalida{
		super(nome, cpf, endereco);
		setAutomovel(automovel);
	}
	
	//===================== get e set =======================
	public Automovel[] getAutomovel() {
		return this.automovel;
	}

	public void setAutomovel(Automovel[] automovel) throws InformacaoInvalida {
		for(int i = 0; i <10; i++) {
			if(automovel[i] != null)
				this.automoveis.add(automovel[i]);
			else
				throw new InformacaoInvalida("");
		}
	}
}
