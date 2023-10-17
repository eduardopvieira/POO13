package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.BO.PecasBO;
import model.VO.Pecas;
import view.Telas;
import view.util.Alerts;

public class CadastrarPecasOrcamentoController {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConcluir;

    @FXML
    private TextField textfieldEstoquePeca;

    @FXML
    private TextField textfieldFabricantePeca;

    @FXML
    private TextField textfieldNomePeca;

    @FXML
    private TextField textfieldValorPeca;
    
    @FXML
    private TextField textfieldID;

    @FXML
    void cadastrarPeca(ActionEvent event) throws Exception {
    	Pecas cli = new Pecas();
        PecasBO cliBO = new PecasBO();
    	int id = Integer.valueOf(textfieldID.getText());
    	cli.setIdItem(id);
        cli.setDescricaoItem(textfieldNomePeca.getText());
    	cli.setFabricante(textfieldFabricantePeca.getText());
    	int estoque = Integer.parseInt(textfieldEstoquePeca.getText());
    	cli.setEstoqueItem(estoque);
    	double preco = Double.parseDouble(textfieldValorPeca.getText());
    	cli.setPrecoItem(preco);
    	cliBO.cadastrar(cli);
    	Alerts.showAlert("Sucesso", "Peça cadastrada com sucesso"," " ,AlertType.INFORMATION);
    	Telas.telaMenuPecas();
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
    	Telas.telaMenuPecas();
    }

}
