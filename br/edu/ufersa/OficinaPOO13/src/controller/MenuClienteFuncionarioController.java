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

public class MenuClienteFuncionarioController {

    @FXML
    private TextField botaoBuscar;

    @FXML
    private Button botaoCadastrarCliente;

    @FXML
    private Button botaoOrcamentos;

    @FXML
    private Button botaoPecas;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoServicos;

    @FXML
    private TableColumn<?, ?> tableColumnAuto;

    @FXML
    private TableColumn<?, ?> tableColumnCPF;

    @FXML
    private TableColumn<?, ?> tableColumnCliente;

    @FXML
    private TableColumn<?, ?> tableColumnDeletar;

    @FXML
    private TableColumn<?, ?> tableColumnEditar;

    @FXML
    private TableColumn<?, ?> tableColumnPlaca;

    
    @FXML
    void abrirCadastroCliente(ActionEvent event) throws Exception {
    	Telas.telaCadastroCliente();
    }

    @FXML
    void buscarCliente(ActionEvent event)throws Exception {
    	
    }

    @FXML
    void trocarParaMenuOrcamentos(ActionEvent event)throws Exception {
    	Telas.telaMenuOrcamento();
    }

    @FXML
    void trocarParaMenuPecas(ActionEvent event) throws Exception{
    	Telas.telaMenuPecas();
    }

    @FXML
    void trocarParaMenuServicos(ActionEvent event) throws Exception{
    	Gerente ger = UsuarioAutenticado.getGerenteAutenticado();
    	if (ger != null) {
    		Telas.telaMenuServicoGerente(ger);
    	} else {
    		Funcionario func = UsuarioAutenticado.getFuncAutenticado();
    		Telas.telaMenuServicoFuncionario(func);
    	}
    }

    @FXML
    void trocarParaTelaLogin(ActionEvent event) throws Exception{
    	Telas.telaLogin();
    }

}
