package controller;

import Exceptions.InfoNaoCompativelException;
import model.VO.UsuarioAutenticado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.BO.FuncionarioBO;
import model.VO.Funcionario;
import model.VO.Gerente;
import view.Telas;
import view.util.Alerts;

public class TelaLoginController {

    @FXML
    private Button botaoLogin;

    @FXML
    private TextField campoCPF;

    @FXML
    private PasswordField campoSenha;
    
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
            	UsuarioAutenticado.setGerenteAutenticado(ger);
            	Telas.telaMenuClientesGerente(ger);
            }
            else
            {
                UsuarioAutenticado.setFuncAutenticado(autenticado);
            	Telas.telaMenuClientesFuncionario(autenticado);
            }
        }
        catch(Exception e)
        {
            //colocar o alert
        	System.out.println("Usuário ou senha inválidos");
        	Alerts.showAlert("Error", "Erro de autenticação", e.getMessage(), AlertType.WARNING);
            e.printStackTrace();
        }
    }


}
