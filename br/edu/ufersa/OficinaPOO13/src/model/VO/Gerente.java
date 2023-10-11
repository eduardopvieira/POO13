package model.VO;
import Exceptions.*;

public class Gerente extends Funcionario{
    public Gerente () {};
    public Gerente (String nome, String endereco, String cpf, String senha) throws InfoNaoCompativelException{
        super(nome, endereco, cpf, senha);
        setIsGerente(true);
    }
}
