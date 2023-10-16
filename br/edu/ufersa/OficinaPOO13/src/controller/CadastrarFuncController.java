package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.BO.FuncionarioBO;
import model.BO.GerenteBO;
import model.DAO.FuncionarioDAO;
import model.VO.Funcionario;
import model.VO.Gerente;
import view.Telas;
import view.util.Alerts;

public class CadastrarFuncController {

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private TextField cpfFunc;

    @FXML
    private TextField enderecoFunc;

    @FXML
    private CheckBox isGerente;

    @FXML
    private TextField nomeFunc;

    @FXML
    private PasswordField passfieldSenha;
    
    @FXML
    private TextField textfieldCPFDeletar;

    @FXML
    void cadastrarFunc(ActionEvent event) throws Exception {
    	
    	Funcionario func = new Funcionario();
        FuncionarioBO funcBO = new FuncionarioBO();
        Gerente ger = new Gerente();
        GerenteBO gerBO = new GerenteBO();
    	
        if(isGerente.isSelected()) {
        	ger.setCPF(cpfFunc.getText());
        	ger.setEndereco(enderecoFunc.getText());
        	ger.setNome(nomeFunc.getText());
        	ger.setSenha(passfieldSenha.getText());
        	ger.setIsGerente(true);
        	
        	gerBO.cadastrar(ger);
        	
        } else {
        	func.setCPF(cpfFunc.getText());
        	func.setEndereco(enderecoFunc.getText());
        	func.setNome(nomeFunc.getText());
        	func.setSenha(passfieldSenha.getText());
        	func.setIsGerente(false);
        	
        	funcBO.cadastrar(func);
        }
        
    	Alerts.showAlert("Sucesso", "Funcionario cadastrado com sucesso"," " ,AlertType.INFORMATION);
    	Telas.telaLogin();
    	
    }

    @FXML
    void voltarTelaLogin(ActionEvent event) throws Exception {
    	Telas.telaLogin();
    }
    
    @FXML
    void deletar(ActionEvent event) throws Exception {
    	Funcionario func = new Funcionario();
        FuncionarioDAO funcDAO = new FuncionarioDAO();
    	func.setCPF(textfieldCPFDeletar.getText());
    	funcDAO.deletar(func);
    	Telas.telaLogin();
    }
}
