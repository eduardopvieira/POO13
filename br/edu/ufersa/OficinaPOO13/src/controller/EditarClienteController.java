package controller;

import Exceptions.InfoNaoCompativelException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.BO.ClienteBO;
import model.VO.Cliente;
import view.Telas;
import view.util.Alerts;

public class EditarClienteController {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoEditar;

    @FXML
    private TextField enderecoCliente;

    @FXML
    private TextField nomeCliente;

    @FXML
    private Label textoCPF;

    
    public void Initialize(Cliente cli)
    {
        try {
            nomeCliente.setText(cli.getNome());
            textoCPF.setText(cli.getCPF());
            enderecoCliente.setText(cli.getEndereco());        
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FXML
    void cancelarEdicao(ActionEvent event) throws Exception {
    	Telas.telaMenuClientes();
    }

    @FXML
    void editar(ActionEvent event) throws Exception {
    	Cliente cl = new Cliente();
    	try {
    	cl.setCPF(textoCPF.getText());
    	cl.setNome(nomeCliente.getText());
    	cl.setEndereco(enderecoCliente.getText());
    	
    	ClienteBO cliBO = new ClienteBO();
    	cliBO.alterar(cl);
    	Alerts.showAlert("Sucesso", "Alteração bem sucedida", "O cliente foi alterado com sucesso.", AlertType.INFORMATION);
    	Telas.telaMenuClientes();
    	} catch (InfoNaoCompativelException e) {
    		Alerts.showAlert("Erro", "Campo não compatível", "Certifique-se de preencher todos os campos", AlertType.ERROR);
    	} 
    }

}
