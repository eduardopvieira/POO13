package model.VO;

import Exceptions.InfoNaoCompativelException;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{

    private List <Automovel> ListaAuto;
    
    public Cliente(){};
    
    public Cliente(String cpf) throws InfoNaoCompativelException {
    	setCPF(cpf);
    }
    
    public Cliente (String cpf, String nome) throws InfoNaoCompativelException{
    	super(nome, cpf);
    }
    public Cliente(String cpf,String nome, String endereco) throws InfoNaoCompativelException {
        super(nome, endereco, cpf);
        //ListaAuto = new ArrayList<Automovel>();
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