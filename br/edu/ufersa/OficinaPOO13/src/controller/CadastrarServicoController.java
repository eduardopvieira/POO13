package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.VO.Servico;

public class CadastrarServicoController {

    @FXML
    private Button botaoConcluir;

    @FXML
    private Button botaoConcluir1;

    @FXML
    private TextField descServico;

    @FXML
    private TextField nomeServico;

    @FXML
    private TextField precoServico;

    @FXML
    void cadastrarServico(ActionEvent event) throws Exception {
    	Servico s = new Servico();
    	s.setServicoNome(nomeServico.getText());
    	s.setServicoPreco(Double.parseDouble(precoServico.getText()));
    	s.setServicoDescricao(descServico.getText());
    	System.out.println("Informações do serviço: Nome:" + s.getServicoNome() + " Preco: " + s.getServicoPreco() + " Descricao: " + s.getServicoDescricao());
    	    	
    }

}
