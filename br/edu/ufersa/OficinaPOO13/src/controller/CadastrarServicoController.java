package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.VO.Servico;

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
    	Servico s = new Servico();
    	s.setServicoNome(textfieldNomeServico.getText());
    	s.setServicoPreco(Double.parseDouble(textfieldPrecoServico.getText()));
    	s.setServicoDescricao(textfieldDescricaoServico.getText());
    	System.out.println("Informações do serviço: Nome:" + s.getServicoNome() + " Preco: " + s.getServicoPreco() + " Descricao: " + s.getServicoDescricao());
    	    	
    }

    @FXML
    void voltar(ActionEvent event) {

    }

}
