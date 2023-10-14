package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import view.Telas;

public class MenuServicoGerenteController {

    @FXML
    private Button botaoAutomovel;

    @FXML
    private ImageView botaoBuscar;

    @FXML
    private Button botaoCadastrarServico;

    @FXML
    private Button botaoClientes;

    @FXML
    private Button botaoDeletar;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoOrcamentos;

    @FXML
    private Button botaoPecas;

    @FXML
    private Button botaoSair;

    @FXML
    private ChoiceBox<?> choiceboxBusca;

    @FXML
    private TableView<?> tabelaServicos;

    @FXML
    private TableColumn<?, ?> tableColumnDescricaoServico;

    @FXML
    private TableColumn<?, ?> tableColumnIDServico;

    @FXML
    private TableColumn<?, ?> tableColumnNomeServico;

    @FXML
    private TableColumn<?, ?> tableColumnValorServico;

    @FXML
    private TextField textfieldBuscar;

    @FXML
    void deletar(ActionEvent event) {

    }

    @FXML
    void editar(ActionEvent event) {

    }

    @FXML
    void irParaMenuAuto(ActionEvent event) throws Exception{
    	Telas.telaMenuAutos();
    }

 

    @FXML
    void realizarBusca(MouseEvent event) {

    }


    @FXML
    void irParaMenuClientes(ActionEvent event) throws Exception {
    	Telas.telaMenuClientes();

    }

    @FXML
    void irParaMenuOrcamentos(ActionEvent event) throws Exception {
    	Telas.telaMenuOrcamentos();
    }

    @FXML
    void irParaMenuPecas(ActionEvent event) throws Exception {
    	Telas.telaMenuPecas();
    }

    @FXML
    void irParaTelaCadastrarServico(ActionEvent event) throws Exception {
    	Telas.telaCadastrarServicoGerente();
    }

    @FXML
    void irParaTelaLogin(ActionEvent event) throws Exception {
    	Telas.telaLogin();
    }

}
