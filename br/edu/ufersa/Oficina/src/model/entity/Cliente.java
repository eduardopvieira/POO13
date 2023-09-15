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


    @Override
    public void cadastrar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }

    @Override
    public void excluir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    @Override
    public void editar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editar'");
    }



}