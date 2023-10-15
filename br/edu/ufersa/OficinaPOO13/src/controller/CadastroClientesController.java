package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.BO.ClienteBO;
import model.VO.Cliente;
import view.Telas;
import view.util.Alerts;

public class CadastroClientesController {

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private TextField cpfCliente;

    @FXML
    private TextField enderecoCliente;

    @FXML
    private TextField nomeCliente;
    
    @FXML    
    void cadastrarCliente(ActionEvent event) throws Exception {
        
    	Cliente cli = new Cliente();
        ClienteBO cliBO = new ClienteBO();
    	cli.setCPF(cpfCliente.getText());
    	cli.setNome(nomeCliente.getText());
    	cli.setEndereco(enderecoCliente.getText());
    	cliBO.cadastrar(cli);
    	
    	Alerts.showAlert("Sucesso", "Cliente cadastrado com sucesso"," " ,AlertType.INFORMATION);
    	Telas.telaMenuClientes();
    	
    }

    @FXML
    void cancelarCadastro(ActionEvent event) throws Exception {
    	Telas.telaMenuClientes();
    }

}
