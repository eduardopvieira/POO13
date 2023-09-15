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