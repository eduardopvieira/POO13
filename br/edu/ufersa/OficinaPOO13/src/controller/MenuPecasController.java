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

public class MenuPecasController {

    @FXML
    private TextField botaoBuscar;

    @FXML
    private Button botaoCadastrarPeca;

    @FXML
    private Button botaoClientes;

    @FXML
    private Button botaoOrcamentos;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoServicos;

    @FXML
    private TableColumn<?, ?> tableColumnDeletar;

    @FXML
    private TableColumn<?, ?> tableColumnEditar;

    @FXML
    private TableColumn<?, ?> tableColumnEstoquePeca;

    @FXML
    private TableColumn<?, ?> tableColumnFabricantePeca;

    @FXML
    private TableColumn<?, ?> tableColumnIDPeca;

    @FXML
    private TableColumn<?, ?> tableColumnNomePeca;

    @FXML
    private TableColumn<?, ?> tableColumnValorPeca;

    @FXML
    void buscarPeca(ActionEvent event)throws Exception {

    }

    @FXML
    void irParaMenuClientes(ActionEvent event)throws Exception {
    	Telas.telaMenuClientes();
    }

    @FXML
    void irParaMenuOrcamento(ActionEvent event)throws Exception {
    	Telas.telaMenuOrcamentos();
    }

    @FXML
    void irParaMenuServico(ActionEvent event) throws Exception {
    	Gerente ger = UsuarioAutenticado.getGerenteAutenticado();
    	if (ger != null) {
    		Telas.telaMenuServicoGerente(ger);
    	} else {
    		Funcionario func = UsuarioAutenticado.getFuncAutenticado();
    		Telas.telaMenuServicoFuncionario(func);
    	}
    }

    @FXML
    void irParaTelaLogin(ActionEvent event)throws Exception {
    	Telas.telaLogin();
    }

    @FXML
    void irTelaCadastrarPeca(ActionEvent event)throws Exception {
    	Telas.telaCadastrarPecas();
    }

}
