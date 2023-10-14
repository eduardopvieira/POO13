package model.VO;
import Exceptions.*;

public class Gerente extends Funcionario{
    public Gerente () {};
    
    public Gerente(String cpf) throws InfoNaoCompativelException {
    	setCPF(cpf);
    }
    public Gerente (String nome, String endereco, String cpf, String senha) throws InfoNaoCompativelException{
        super(nome, endereco, cpf, senha);
        setIsGerente(true);
    }
    public Gerente (String nome, String endereco, String cpf, String senha, boolean isGerente) throws InfoNaoCompativelException{
        super(nome, endereco, cpf, senha);
        setIsGerente(isGerente);
        
    }
}
