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
            System.out.println(func.getSenha());
        }
        catch (InfoNaoCompativelException e)
        {
        	Alerts.showAlert("Error", "Erro de autenticação", e.getMessage(), AlertType.WARNING);
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
            	ger.setSenha(autenticado.getSenha());
            	ger.setEndereco(autenticado.getEndereco());
            	UsuarioAutenticado.setGerenteAutenticado(ger);
            	Telas.telaMenuClientes();
            }
            else
            {
                Funcionario funcionario = new Funcionario();
                funcionario.setCPF(autenticado.getCPF());
                funcionario.setNome(autenticado.getNome());
                funcionario.setSenha(autenticado.getSenha());
                funcionario.setEndereco(autenticado.getEndereco());
            	UsuarioAutenticado.setFuncAutenticado(funcionario);
            	Telas.telaMenuClientes();
            }
        }
        catch(Exception e)
        {
        	Alerts.showAlert("Error", "Erro de autenticação", e.getMessage(), AlertType.WARNING);
            e.printStackTrace();
        }
    }


}
