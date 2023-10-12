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
    private TableColumn<?, ?> dataOrcamento;

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
    void irTelaCadastrarOrcamento(ActionEvent event) {

    }

    @FXML
    void mudarParaTelaLogin(ActionEvent event) throws Exception {
    	Telas.telaLogin();
    }

    @FXML
    void mudarParaTelaMenuClientes(ActionEvent event) throws Exception {
    	Gerente ger = UsuarioAutenticado.getGerenteAutenticado();
    	if (ger != null) {
    		Telas.telaMenuClientesGerente(ger);
    	} else {
    		Funcionario func = UsuarioAutenticado.getFuncAutenticado();
    		Telas.telaMenuClientesFuncionario(func);
    	}
    }

    @FXML
    void mudarParaTelaMenuPecas(ActionEvent event) throws Exception {
    	Telas.telaMenuPecas();
    }

    @FXML
    void mudarParaTelaMenuServicos(ActionEvent event) throws Exception {
    	Gerente ger = UsuarioAutenticado.getGerenteAutenticado();
    	if (ger != null) {
    		Telas.telaMenuServicoGerente(ger);
    	} else {
    		Funcionario func = UsuarioAutenticado.getFuncAutenticado();
    		Telas.telaMenuServicoFuncionario(func);
    	}
    }

}
