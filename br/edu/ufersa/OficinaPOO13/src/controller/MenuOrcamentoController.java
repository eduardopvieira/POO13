package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class MenuOrcamentoController {

    @FXML
    private TextField botaoBuscar;

    @FXML
    private Button botaoCadastrarOrcamento;

    @FXML
    private Button botaoClientes;

    @FXML
    private Button botaoGerarRelatorio;

    @FXML
    private Button botaoPecas;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoServicos;

    @FXML
    private TextField dataFinal;

    @FXML
    private TextField dataInicial;

    @FXML
    private TableColumn<?, ?> tableColumnCliente;

    @FXML
    private TableColumn<?, ?> tableColumnID;

    @FXML
    private TableColumn<?, ?> tableColumnPeca;

    @FXML
    private TableColumn<?, ?> tableColumnPlaca;

    @FXML
    private TableColumn<?, ?> tableColumnServico;

    @FXML
    private TableColumn<?, ?> tableColumnValorTotal;

    @FXML
    void buscarOrcamento(ActionEvent event) {

    }

    @FXML
    void cadastrarOrcamento(ActionEvent event) {

    }

    @FXML
    void irTelaGerarRelatorio(ActionEvent event) {

    }

    @FXML
    void mudarParaTelaLogin(ActionEvent event) {

    }

    @FXML
    void mudarParaTelaMenuClientes(ActionEvent event) {

    }

    @FXML
    void mudarParaTelaMenuPecas(ActionEvent event) {

    }

    @FXML
    void mudarParaTelaMenuServicos(ActionEvent event) {

    }

}
