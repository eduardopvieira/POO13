package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import model.VO.Funcionario;
import model.VO.Gerente;
import model.VO.UsuarioAutenticado;
import view.Telas;

public class MenuServicoGerenteController {

    @FXML
    private TextField botaoBuscar;

    @FXML
    private Button botaoCadastrarServico;

    @FXML
    private Button botaoClientes;

    @FXML
    private Button botaoOrcamentos;

    @FXML
    private Button botaoPecas;

    @FXML
    private Button botaoSair;

    @FXML
    private TableColumn<?, ?> tableColumnDeletar;

    @FXML
    private TableColumn<?, ?> tableColumnDescricaoServico;

    @FXML
    private TableColumn<?, ?> tableColumnEditar;

    @FXML
    private TableColumn<?, ?> tableColumnIDServico;

    @FXML
    private TableColumn<?, ?> tableColumnNomeServico;

    @FXML
    private TableColumn<?, ?> tableColumnValorServico;

    @FXML
    void buscarServico(ActionEvent event) {
    
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
