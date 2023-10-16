package controller;

import Exceptions.InfoNaoCompativelException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.BO.FuncionarioBO;
import model.BO.GerenteBO;
import model.VO.Funcionario;
import model.VO.Gerente;
import model.VO.UsuarioAutenticado;
import view.Telas;
import view.util.Alerts;

public class TelaLoginController {

    @FXML
    private Button botaoLogin;

    @FXML
    private TextField campoCPF;

    @FXML
    private Button botaoOutrasFUncoes;
    
    @FXML
    private PasswordField campoSenha;
    
	FuncionarioBO funcBO = new FuncionarioBO();
	GerenteBO gerBO = new GerenteBO();
	
	
	@FXML
	void logar(ActionEvent event) {
	    Funcionario func = new Funcionario();

	    try {
	        func.setCPF(campoCPF.getText());
	        func.setSenha(campoSenha.getText());
	    } catch (InfoNaoCompativelException e) {
	        Alerts.showAlert("Error", "Erro de autenticação", e.getMessage(), AlertType.WARNING);
	        e.printStackTrace();
	    }

	    try {
	        Funcionario autenticado = funcBO.autenticar(func);

	            if (autenticado.getIsGerente()) {
	                // Navegue para a tela do gerente
	                
	            	
	            	Gerente gerenteAutenticado = new Gerente();
	            	gerenteAutenticado.setCPF(autenticado.getCPF());
	            	gerenteAutenticado.setNome(autenticado.getNome());
	            	gerenteAutenticado.setEndereco(autenticado.getEndereco());
	            	gerenteAutenticado.setSenha(autenticado.getSenha());
	            	UsuarioAutenticado.setGerenteAutenticado(gerenteAutenticado);
	            	
	                Telas.telaMenuClientes();
	                System.out.println("Entrou gerente");


	            } else {
	                // Navegue para a tela do funcionário
	            	UsuarioAutenticado.setFuncAutenticado(autenticado);
	                Telas.telaMenuClientes();
	                System.out.println("Entrou func");

	            }	        
	           
	        }catch (Exception e) {
		        Alerts.showAlert("Error", "Erro de autenticação", e.getMessage(), AlertType.WARNING);
		        e.printStackTrace(); 

	    }
	}
	
	@FXML
	void irTelaOutrasFuncoes(ActionEvent event) throws Exception{
		Telas.telaTodosCadastrados();
	}
}
