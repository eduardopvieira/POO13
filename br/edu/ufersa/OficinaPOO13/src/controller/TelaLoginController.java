package controller;

import Exceptions.InfoNaoCompativelException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.BO.FuncionarioBO;
import model.VO.Funcionario;
import model.VO.Gerente;
import view.Telas;

public class TelaLoginController {

    @FXML
    private Button botaoLogin;

    @FXML
    private TextField campoCPF;

    @FXML
    private TextField campoSenha;
    
	FuncionarioBO funcBO = new FuncionarioBO();

    @FXML
    void logar(ActionEvent event) {

    	Funcionario func = new Funcionario();

        try
        {
            func.setCPF(campoCPF.getText());
            func.setSenha(campoSenha.getText());
        }
        catch (InfoNaoCompativelException e)
        {
            //colocar o alert dizendo que deu erro
        	System.out.println("Campo nao pode ser vazio!");
        	e.printStackTrace();
        }
        try
        {
            Funcionario autenticado = funcBO.autenticar(func);
            if(autenticado.getIsGerente() == true)
            {
            	Gerente ger = new Gerente();
            	ger.setCPF(autenticado.getCPF());
            	ger.setNome(autenticado.getNome());
                Telas.telaMenuClientesGerente(ger);
            }
            else
            {
                //TODO
                Telas.telaMenuClientesFuncionario(autenticado);
            }
        }
        catch(Exception e)
        {
            //colocar o alert
        	System.out.println("Usuário ou senha inválidos");
            e.printStackTrace();
        }
    }

}
