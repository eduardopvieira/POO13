package model.entity;
import Exceptions.*;

public class Gerente extends Funcionario{
    public Gerente () {};
    public Gerente (String cpf, String senha) throws InfoNaoCompativelException{
        super.setCPF(cpf);
        super.setSenha(senha);
    }

    public Gerente (String cpf, String nome, String endereco, String senha) throws InfoNaoCompativelException {
        super.setCPF(cpf);
        super.setNome(nome);
        super.setEndereco(endereco);
        super.setSenha(senha);

    }
}
