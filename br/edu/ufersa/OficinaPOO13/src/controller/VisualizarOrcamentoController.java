package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import view.Telas;

public class VisualizarOrcamentoController {

    @FXML
    private Button botaoConcluir;

    @FXML
    private Button botaoDeletar;

    @FXML
    private Button botaoPagar;

    @FXML
    private Label dataOrc;

    @FXML
    private Label nomeCliente;

    @FXML
    private TableColumn<?, ?> nomePecasOrc;

    @FXML
    private TableColumn<?, ?> nomeServicoOrc;

    @FXML
    private Label placaAutoOrc;

    @FXML
    private TableColumn<?, ?> precoPecaOrc;

    @FXML
    private TableColumn<?, ?> precoServicoOrc;

    @FXML
    private Label precoTotalOrc;

    @FXML
    private TableColumn<?, ?> qtdPecaOrc;

    @FXML
    private TableColumn<?, ?> qtdServicoOrc;

    @FXML
    void deletarOrcamento(ActionEvent event) {

    }

    @FXML
    void irParaTelaMenuOrcamento(ActionEvent event) throws Exception {
    	Telas.telaMenuOrcamento();
    }

    @FXML
    void pagarOrcamento(ActionEvent event) {

    }

}
