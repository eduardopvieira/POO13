package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import view.Telas;

public class CadastrarPecasController {

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
    private TextField textfieldValorPeça;

    @FXML
    void cadastrarPeca(ActionEvent event) throws Exception {
    	Telas.telaCadastrarPecas();
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
    	Telas.telaMenuPecas();
    }

}
