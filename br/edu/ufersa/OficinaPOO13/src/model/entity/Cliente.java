package model.entity;

import Exceptions.InfoNaoCompativelException;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{

    private List <Automovel> ListaAuto;
    
    public Cliente(){};
    public Cliente(String nome, String cpf) throws InfoNaoCompativelException {
        super.setNome(nome);
        super.setCPF(cpf);
        ListaAuto = new ArrayList<Automovel>();
    }


    public void setAuto (List<Automovel> ListaAuto) {
        this.ListaAuto = ListaAuto;
 
    }
    public List<Automovel> getAuto() {
        return ListaAuto;
    }

    public void addAuto(Automovel auto){
        if (auto != null) {
        this.ListaAuto.add(auto);
        }
    }

}