package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import model.VO.UsuarioAutenticado;
import view.Telas;

public class MenuServicoFuncionarioController {

	    @FXML
	    private TextField botaoBuscar;

	    @FXML
	    private Button botaoClientes;

	    @FXML
	    private Button botaoOrcamentos;

	    @FXML
	    private Button botaoPecas;

	    @FXML
	    private Button botaoSair;

	    @FXML
	    private TableColumn<?, ?> tableColumnDescricaoServico;

	    @FXML
	    private TableColumn<?, ?> tableColumnIDServico;

	    @FXML
	    private TableColumn<?, ?> tableColumnNomeServico;

	    @FXML
	    private TableColumn<?, ?> tableColumnVIsualizar;

	    @FXML
	    private TableColumn<?, ?> tableColumnValorServico;

	   

    @FXML
    void irParaMenuClienteFuncionario(ActionEvent event) throws Exception {
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
    void irParaTelaLogin(ActionEvent event) throws Exception {
    	Telas.telaLogin();
    }
    
    @FXML
    void buscarServico(ActionEvent event) throws Exception {
    	
    }

}
