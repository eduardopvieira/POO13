package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.BO.ServicoBO;
import model.VO.Servico;
import model.VO.UsuarioAutenticado;
import view.Telas;
import view.util.Alerts;

public class CadastrarServicoController {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConcluir;

    @FXML
    private TextField textfieldDescricaoServico;

    @FXML
    private TextField textfieldNomeServico;

    @FXML
    private TextField textfieldPrecoServico;

    @FXML
    void cadastrarServico(ActionEvent event) throws Exception {
    	ServicoBO servBO = new ServicoBO();
    	Servico serv = new Servico();
    	
    	serv.setServicoNome(textfieldNomeServico.getText());
    	serv.setServicoDescricao(textfieldDescricaoServico.getText());
    	Double preco = Double.parseDouble(textfieldPrecoServico.getText());
    	serv.setServicoPreco(preco);
    	
    	servBO.cadastrar(serv);
    	
    	Alerts.showAlert("Sucesso", "Servico cadastrado com sucesso"," " ,AlertType.INFORMATION);
    	Telas.telaMenuServicoGerente(UsuarioAutenticado.getGerenteAutenticado());
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
    	Telas.telaMenuServicoGerente(UsuarioAutenticado.getGerenteAutenticado());
    }

}
