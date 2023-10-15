package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private TextField textfieldID;
    
    @FXML
    private TextField textfieldPrecoServico;

    @FXML
    void cadastrarServico(ActionEvent event) throws Exception {
    try {
    	ServicoBO servBO = new ServicoBO();
    	Servico serv = new Servico();
    	int id = Integer.parseInt(textfieldID.getText());
    	serv.setServicoId(id);
    	serv.setServicoNome(textfieldNomeServico.getText());
    	serv.setServicoDescricao(textfieldDescricaoServico.getText());
    	Double preco = Double.parseDouble(textfieldPrecoServico.getText());
    	serv.setServicoPreco(preco);
    	servBO.cadastrar(serv);
    	
    	Telas.telaMenuServicoGerente(UsuarioAutenticado.getGerenteAutenticado());
    	}catch (Exception e) {
    		Alerts.showAlert("ERRO", "Falha ao cadastrar serviço", "Erro ao cadastrar serviço. Nada foi cadastrado.", AlertType.ERROR);
    	}
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
    	Telas.telaMenuServicoGerente(UsuarioAutenticado.getGerenteAutenticado());
    }

}
